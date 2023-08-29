package com.bupt.service;

import com.bupt.pojo.WeekMenu;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WeekMenuService {

    WeekMenu getWeekMenuByID(int id);

    void UpdateWeekMenu(WeekMenu weekMenu);

    void InsertWeekMenu(WeekMenu weekMenu);

}
