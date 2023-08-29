package com.bupt.service.imp;

import com.bupt.dao.WeekMenuDao;
import com.bupt.pojo.WeekMenu;
import com.bupt.service.WeekMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeekMenuServiceImp implements WeekMenuService {
    @Autowired
    private WeekMenuDao weekMenuDao;


    @Override
    public WeekMenu getWeekMenuByID(int id) {
        return weekMenuDao.getWeekMenu(id);
    }

    @Override
    public void UpdateWeekMenu(WeekMenu weekMenu) {
        weekMenuDao.UpdateWeekMenu(weekMenu);
    }

    @Override
    public void InsertWeekMenu(WeekMenu weekMenu) {
        weekMenuDao.InsertWeekMenu(weekMenu);
    }
}
