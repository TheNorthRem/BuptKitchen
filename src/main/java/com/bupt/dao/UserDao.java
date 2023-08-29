package com.bupt.dao;

import com.bupt.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    List<User> getAll();
    @Select("select * from user where username =#{username}")
    User selectByUsername(String username);
}
