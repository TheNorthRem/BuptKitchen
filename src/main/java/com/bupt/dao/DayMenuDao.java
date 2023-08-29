package com.bupt.dao;

import com.bupt.pojo.DayMenu;
import org.apache.ibatis.annotations.*;


@Mapper
public interface DayMenuDao {
    @Select("select * from daymenu where id=#{id}")
    DayMenu getMenu(int id);

    @Insert("insert into daymenu values (null,#{Breakfast},#{Lunch},#{Dinner}) ")
    @Options(keyColumn="id",keyProperty="id",useGeneratedKeys=true)
    void InsertDayMenu(DayMenu menu);

    @Update("update daymenu set Breakfast=#{Breakfast},Lunch=#{Lunch},Dinner=#{Dinner} where id=#{id}")
    void UpdateMenu(DayMenu menu);

    @Delete("delete from daymenu where id=#{id}")
    void deleteDayMenu(int id);

}
