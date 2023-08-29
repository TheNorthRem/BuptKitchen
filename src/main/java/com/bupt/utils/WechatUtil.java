package com.bupt.utils;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.bupt.pojo.DayMenu;
import com.bupt.pojo.Menu;
import com.bupt.pojo.WechatUser;
import com.bupt.pojo.WeekMenu;
import com.bupt.service.DayMenuService;
import com.bupt.service.MenuService;
import com.bupt.service.WechatUserService;
import com.bupt.service.WeekMenuService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class WechatUtil {
    private static Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        WechatUtil.environment = environment;
    }


    public static String GetOpenIDByCode(String code)  throws  IOException {
        String APPID=environment.getProperty("WechatSetting.AppID");
        String Secret=environment.getProperty("WechatSetting.AppSecret");

        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid="+APPID+"&secret="+Secret+"&js_code="+code+"&grant_type=authorization_code";

        OkHttpClient client = new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        Response response=client.newCall(request).execute();
        String body=null;
        if (response.isSuccessful()){
            body=response.body().string();
        }

        if(body!=null) {
            JSONObject userData = JSON.parseObject(body);
            String openid = userData.getString("openid");
            return openid;
        }

        return null;
    }

    public static Collection<Map<String,Menu>> getWeekMenu(Integer token, WechatUserService wechatUserService, WeekMenuService weekMenuService
    , DayMenuService dayMenuService, MenuService menuService
    ){
        WechatUser wechatUser=wechatUserService.getUserByID(token);
        WeekMenu weekMenu = weekMenuService.getWeekMenuByID(wechatUser.getWeekMenu());
        Collection<Map<String,Menu>> col=new ArrayList<>();
        col.add(getDayMenuMap(weekMenu.getMonday(),dayMenuService,menuService));
        col.add(getDayMenuMap(weekMenu.getTuesday(),dayMenuService,menuService));
        col.add(getDayMenuMap(weekMenu.getWednesday(),dayMenuService,menuService));
        col.add(getDayMenuMap(weekMenu.getThursday(),dayMenuService,menuService));
        col.add(getDayMenuMap(weekMenu.getFriday(),dayMenuService,menuService));
        col.add(getDayMenuMap(weekMenu.getSaturday(),dayMenuService,menuService));
        col.add(getDayMenuMap(weekMenu.getSunday(),dayMenuService,menuService));
        return col;
    }

    public static Map<String,Menu> getDayMenuMap(Integer DayID,DayMenuService dayMenuService,MenuService menuService){
        if(DayID==null) return null;
        DayMenu day=dayMenuService.getDayMenuByID(DayID);
        Map<String,Menu> map=new HashMap<>();
        Menu breakfast = menuService.SelectMenuByID(day.getBreakfast());
        map.put("breakfast",breakfast);
        Menu lunch = menuService.SelectMenuByID(day.getLunch());
        map.put("lunch",lunch);
        Menu dinner= menuService.SelectMenuByID(day.getDinner());
        map.put("dinner",dinner);
        return map;
    }


}
