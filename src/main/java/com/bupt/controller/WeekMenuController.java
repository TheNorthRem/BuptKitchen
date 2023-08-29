package com.bupt.controller;

import com.alibaba.fastjson2.JSONObject;
import com.bupt.pojo.DayMenu;
import com.bupt.pojo.Menu;

import com.bupt.pojo.WechatUser;
import com.bupt.pojo.WeekMenu;
import com.bupt.service.DayMenuService;
import com.bupt.service.MenuService;
import com.bupt.service.WechatUserService;
import com.bupt.service.WeekMenuService;
import com.bupt.utils.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/WeekMenuController")
public class WeekMenuController {

    @Autowired
    private WeekMenuService weekMenuService;
    @Autowired
    private WechatUserService wechatUserService;
    @Autowired
    private DayMenuService dayMenuService;
    @Autowired
    private MenuService menuService;
    @Autowired
    WechatUtil wechatUtil;
    @GetMapping("/GetWeekMenu")
    public Collection<Map<String,Menu>> getWeekMenu(@RequestParam("token") int token){
        Collection<Map<String, Menu>> weekMenu = WechatUtil.getWeekMenu(token, wechatUserService, weekMenuService, dayMenuService, menuService);
        return weekMenu;
    }

    @PostMapping("/SetWeekMenu")

    public boolean SetWeekMenu(@RequestBody JSONObject mes){
        System.out.println(mes);

        Integer token = mes.getInteger("token");

        WechatUser user = wechatUserService.getUserByID(token);

        Integer weekMenuID = user.getWeekMenu();

        WeekMenu weekMenu = weekMenuService.getWeekMenuByID(weekMenuID);

        Integer day = weekMenu.get(mes.getString("day"));

        if(day==null){
            DayMenu dayMenu=new DayMenu();
            dayMenu.set(mes.getString("time"),mes.getInteger("menuid"));
            dayMenuService.updateDayMenu(dayMenu);
            weekMenu.set(mes.getString("day"),dayMenu.getId());
            weekMenuService.UpdateWeekMenu(weekMenu);
            return true;
        }
        DayMenu dayMenu = dayMenuService.getDayMenuByID(day);
        dayMenu.set(mes.getString("time"),mes.getInteger("menuid"));
        dayMenuService.updateDayMenu(dayMenu);
        return true;
    }


}
