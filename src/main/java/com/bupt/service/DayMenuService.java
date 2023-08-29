package com.bupt.service;

import com.bupt.pojo.DayMenu;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DayMenuService {
    DayMenu getDayMenuByID(int id);
    void updateDayMenu(DayMenu menu);
}
