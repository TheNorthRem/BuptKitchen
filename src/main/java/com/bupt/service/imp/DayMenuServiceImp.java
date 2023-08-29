package com.bupt.service.imp;

import com.bupt.dao.DayMenuDao;
import com.bupt.pojo.DayMenu;
import com.bupt.service.DayMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DayMenuServiceImp implements DayMenuService {
    @Autowired
    private DayMenuDao dayMenuDao;

    @Override
    public DayMenu getDayMenuByID(int id) {
        return dayMenuDao.getMenu(id);
    }

    @Override
    public void updateDayMenu(DayMenu menu) {
        Integer id = menu.getId();
        if(id==null){
            dayMenuDao.InsertDayMenu(menu);
            return;
        }

        DayMenu menu1 = dayMenuDao.getMenu(id);

        if(menu1==null){
            dayMenuDao.InsertDayMenu(menu);
        }else{
            dayMenuDao.UpdateMenu(menu);
        }

    }
}
