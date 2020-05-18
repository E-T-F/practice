package com.etf.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.etf.adapter.SearchAdapter;
import com.etf.adapter.dto.ResponseDto;
import com.etf.adapter.dto.SearchRequestDto;
import com.etf.convert.UserConvertor;
import com.etf.meta.User;
import com.etf.sql.UserDao;
import com.etf.vo.ReqeustVo;
import com.etf.vo.UserVo;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author etf
 */
@Slf4j
@Controller
public class AnnotationController {

    @Resource
    private SearchAdapter searchAdapter;

    @Resource
    private UserDao userDao;

    @Resource
    private UserConvertor userConvertor;

    private static LoadingCache<Integer, List<UserVo>> userStatusCache = null;


    @PostConstruct
    public void init() {
        userStatusCache = CacheBuilder.newBuilder().maximumSize(100)
                .refreshAfterWrite(1, TimeUnit.MINUTES).build(
                        new CacheLoader<Integer, List<UserVo>>() {
                            @Override
                            public List<UserVo> load(Integer status) throws Exception {

                                if (status < NumberUtils.INTEGER_ZERO) {
                                    return Collections.emptyList();
                                }
                                List<User> usersByStatus = userDao.getUsersByStatus(status);
                                return userConvertor.covertToUserVo(usersByStatus);
                            }
                        });
    }


    @ResponseBody
    @RequestMapping(value = "/api/demo/annotation")
    public Map<String, Object> test(@RequestBody ReqeustVo reqeustVo) {

        SearchRequestDto searchRequestDto = convert(reqeustVo);


        ResponseDto responseDto = searchAdapter.searchResult(searchRequestDto);

        Map<String, Object> res = new HashMap<>();
        res.put("success", "success");
        res.put("code", 200);
        res.put("data", responseDto);

        return res;
    }

    private SearchRequestDto convert(ReqeustVo reqeustVo) {

        if (reqeustVo == null) {
            return null;
        }
        SearchRequestDto searchRequestDto = new SearchRequestDto();
        if (reqeustVo.getUserId() != null) {
            String userIds = reqeustVo.getUserId();
            String[] userIdArray = StringUtils.split(userIds, ",");
            searchRequestDto.setUserId(userIdArray);
        }
        BeanUtils.copyProperties(reqeustVo, searchRequestDto);
        return searchRequestDto;
    }

    @ResponseBody
    @RequestMapping(value = "/api/demo/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/api/demo/user/add", method = RequestMethod.GET)
    public String addUser(@RequestBody UserVo userVo) {


        if (userVo == null || userVo.getUserName() == null) {
            throw new RuntimeException("wrong param");
        }

        User user = userDao.findByUserName(userVo.getUserName());
        if (user != null) {
            log.info("the user has existed");
        } else {
            user = userDao.save(buildUserInfo(userVo));
        }
        return JSONUtils.toJSONString(user);
    }


    /**
     * 首页人气作品榜，随机6个展示
     *
     * @param status
     * @return
     */
    @RequestMapping("/api/demo/user/query")
    public List<UserVo> userList(@RequestParam Integer status) {
        if (status == null) {
            throw new RuntimeException("参数异常");
        }

        try {
            List<UserVo> userVos = userStatusCache.get(status);
            if (CollectionUtils.isEmpty(userVos)) {
                return Collections.emptyList();
            }

            Collections.shuffle(userVos);
            return userVos;
        } catch (ExecutionException e) {
            log.error("本地缓存获取失败 type:{}", status);
        }

        return Collections.emptyList();
    }

    private User buildUserInfo(UserVo userVo) {
        User user = new User();
        user.setEmail(userVo.getEmail());
        user.setNickName(userVo.getNickName());
        user.setRegTime(LocalDateTime.now());
        user.setUserName(userVo.getUserName());
        user.setPassWord(userVo.getUserName() + "123");
        user.setStatus(userVo.getStatus());
        return user;
    }

}
