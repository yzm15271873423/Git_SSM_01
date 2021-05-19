package com.yzm.service.impl;

import com.yzm.mapper.UserMapper;
import com.yzm.pojo.User;
import com.yzm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: yzm
 * @Date: 2021/5/19 - 05 - 19 - 16:59
 * @Description: com.yzm.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUser(String uname, String password) {
        return userMapper.findUser(uname,password);
    }
}
