package com.etf.convert;

import com.etf.meta.User;
import com.etf.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangfei1@corp.netease.com
 * @date 2020/5/18 15:49
 */
@Component
@Slf4j
public class UserConvertor {

    public List<UserVo> covertToUserVo(List<User> userList) {
        if (CollectionUtils.isEmpty(userList)) {
            return Collections.emptyList();
        }
        ArrayList<UserVo> userVos = new ArrayList<>();
        BeanUtils.copyProperties(userList, userVos);
        return userVos;
    }
}
