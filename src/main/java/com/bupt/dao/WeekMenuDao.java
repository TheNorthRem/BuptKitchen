package com.bupt.dao;

import com.bupt.pojo.WeekMenu;
import org.apache.ibatis.annotations.*;

@Mapper
public interface WeekMenuDao {

    @Select("select * from weekmenu where id=#{id}")
    WeekMenu getWeekMenu(int id);


    @Insert("insert into weekmenu values (null,#{Monday},#{Tuesday},#{Wednesday},#{Thursday},#{Friday},#{Saturday},#{Sunday})")
    @Options(keyColumn="id",keyProperty="id",useGeneratedKeys=true)
    void InsertWeekMenu(WeekMenu weekMenu);

    @Update("update weekmenu set Monday=#{Monday},Tuesday=#{Tuesday},Wednesday=#{Wednesday},Thursday= #{Thursday}," +
            "Friday=#{Friday},Saturday=#{Saturday},Sunday=#{Sunday} where id=#{id}")
    void UpdateWeekMenu(WeekMenu weekMenu);
}
