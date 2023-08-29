package com.bupt.service.imp;

import com.bupt.dao.UserDao;
import com.bupt.pojo.User;
import com.bupt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User SelectUserByName(String username) {
        return userDao.selectByUsername(username);
    }
}
