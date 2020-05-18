package com.etf.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.etf.sql.UserDao;
import com.etf.adapter.SearchAdapter;
import com.etf.adapter.dto.ResponseDto;
import com.etf.adapter.dto.SearchRequestDto;
import com.etf.meta.User;
import com.etf.vo.ReqeustVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author etf
 */
@Controller
public class AnnotationController {

    @Resource
    private SearchAdapter searchAdapter;

    @Resource
    private UserDao userDao;


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
    @RequestMapping(value = "/api/demo/add", method = RequestMethod.GET)
    public String addUser() {

        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(data);
        User u = userDao.save(new User("aa", "aa123456", "aa@126.com", "aa", formattedDate));

        return JSONUtils.toJSONString(u);
    }

}
