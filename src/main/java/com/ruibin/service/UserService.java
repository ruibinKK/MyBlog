package com.ruibin.service;
import com.ruibin.pojo.User;

public interface UserService {
    User checkUser(String username,String password);
}
