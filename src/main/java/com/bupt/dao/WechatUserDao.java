package com.bupt.dao;


import com.bupt.pojo.WechatUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WechatUserDao {

    @Select("select * from wechatusers")
    List<WechatUser> selectAll();

    @Select("select * from wechatusers where openid= #{openID} ")
    WechatUser selectUserByOpenID(String openID);

    @Insert("insert into wechatusers values (null, #{username}, #{openid},#{avatarName},#{weekMenu})")
    @Options(keyColumn="id",keyProperty="id",useGeneratedKeys=true)
    void InsertUser(WechatUser user);

    @Delete("delete from wechatusers where openid=#{openID}")
    void deleteUserbyOpenID(String openID);

    @Update("update wechatusers set username=#{username} where openid=#{openID}")
    void UpdateUsernameByOpenID(String openID, String username);

    @Select("select * from wechatusers where id=#{id}")
    WechatUser selectUserByID(int id);

    @Update("update wechatusers set username=#{username},avatarName=#{avatarName} where id=#{id}")
    void updateUser(WechatUser user);


}
