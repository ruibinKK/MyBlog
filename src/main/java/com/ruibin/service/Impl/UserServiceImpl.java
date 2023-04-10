package com.ruibin.service.Impl;
import com.ruibin.dao.UserMapper;
import com.ruibin.pojo.User;
import com.ruibin.service.UserService;
import com.ruibin.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User checkUser(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
