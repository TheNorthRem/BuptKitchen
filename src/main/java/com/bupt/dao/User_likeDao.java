package com.bupt.dao;

import com.bupt.pojo.User_like;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface User_likeDao {

    @Select("select * from user_like where  userid=#{id}")
    List<User_like> getlikes(int id);

    @Insert("insert into user_like values (#{userid}, #{menuid})")
    void InsertLike(User_like user_like);

    @Delete("delete  from  user_like where userid=#{userid}&&menuid=#{menuid}")
    void deleteByID(int userid, int menuid);

    @Select("select * from user_like where  userid=#{userid}&&menuid=#{menuid}")
    User_like getLike(int userid, int menuid);
}
