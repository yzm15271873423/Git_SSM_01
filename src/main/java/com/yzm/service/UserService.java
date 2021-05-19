package com.yzm.service;

import com.yzm.pojo.User;

import java.util.List;

/**
 * @Auther: yzm
 * @Date: 2021/5/19 - 05 - 19 - 16:59
 * @Description: com.yzm.service
 * @version: 1.0
 */
public interface UserService {
    User findUser(String uname, String password);

    List<User> findAllUser();
}
