package com.etf.sql;

import com.etf.meta.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: etf
 * @Date: 2020-05-15 17:18
 * @Description:
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUserNameOrEmail(String userName, String email);

    User findByUserName(String userName);

    List<User> getUsersByStatus(Integer status);

}
