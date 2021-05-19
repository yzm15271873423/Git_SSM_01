package com.yzm.mapper;

import com.yzm.pojo.User;

import java.util.List;

/**
 * @Auther: yzm
 * @Date: 2021/5/19 - 05 - 19 - 16:57
 * @Description: com.yzm.mapper
 * @version: 1.0
 */
public interface UserMapper {
    User findUser(String uname, String password);

    List<User> findAllUser();
}
