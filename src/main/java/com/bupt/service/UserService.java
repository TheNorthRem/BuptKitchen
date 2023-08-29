package com.bupt.service;

import com.bupt.dao.UserDao;
import com.bupt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {

    User SelectUserByName(String username);


}
