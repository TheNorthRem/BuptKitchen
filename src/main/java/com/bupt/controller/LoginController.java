package com.bupt.controller;


import com.alibaba.fastjson2.JSONObject;
import com.bupt.controller.mes.Result;
import com.bupt.pojo.WechatUser;
import com.bupt.service.WechatUserService;
import com.bupt.utils.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/WechatUsers")
public class LoginController {
    @Autowired
    private WechatUserService wechatUserService;

    @PostMapping
    public Result Login(@RequestBody JSONObject data){
        System.out.println(data);
        String openID=null;
        try {
            openID = WechatUtil.GetOpenIDByCode(data.getString("code"));
        } catch (IOException e) {
            openID =null;
            e.printStackTrace();
        }

        Result result=new Result();

        System.out.println(openID);

        if(openID!=null){
            WechatUser user=new WechatUser();
            user.setOpenid(openID);
            user.setUsername("default");
            if(wechatUserService.getUserByOpenID(openID)==null) {
                result.setMes("new");
            }else{
                result.setMes("old");
            }
            WechatUser login = wechatUserService.Login(user);
            result.setCode(200);
            result.setData(login);
        }else{
            result.setCode(400);
            result.setMes("fail");
        }
        return result;
    }
    @GetMapping
    public void Test(){
        System.out.println("Test Getting...");
    }

}
