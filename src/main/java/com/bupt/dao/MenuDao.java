package com.bupt.dao;

import com.bupt.pojo.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuDao {
    @Select("select * from menu")
    List<Menu> selectALL();

    @Select("select * from menu where uploaderID=#{uploaderID}")
    List<Menu> selectByUploader(int uploaderID);

    @Select("select  * from menu where name like #{Name} order by count desc")
    List<Menu> selectByName(String Name);

    @Select("select * from menu where id= #{id}")
    Menu selectByID(int id);

    @Delete("delete from menu where id=#{id}")
    void DeleteByID(int id);

    @Insert("insert into menu values (null,#{name},#{updatetime},#{description},#{uploader},0,#{uploaderID},#{step},#{ImageName},0)")
    @Options(keyColumn="id",keyProperty="id",useGeneratedKeys=true)
    void InsertMenu(Menu menu);

    @Update("update menu set name=#{name},updatetime=#{updatetime},description=#{description},count= #{count},step=#{step},ImageName=#{ImageName},likecount=#{likecount} where id=#{id}")
    void update(Menu menu);

    @Select("select * from menu order by count desc limit 5")
    List<Menu> selectTop();
}
