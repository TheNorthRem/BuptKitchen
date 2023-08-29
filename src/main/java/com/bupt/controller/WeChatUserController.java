package com.bupt.controller;

import com.alibaba.fastjson2.JSONObject;
import com.bupt.controller.mes.Result;
import com.bupt.pojo.WechatUser;
import com.bupt.service.WechatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/WeChatUserController")
public class WeChatUserController {
    @Autowired
    private WechatUserService wechatUserService;


    @PostMapping
    public Result UpdateUserName(@RequestBody JSONObject json){
        String username = json.getString("username");
        Integer token = json.getInteger("token");
        WechatUser user = wechatUserService.getUserByID(token);
        user.setUsername(username);
        wechatUserService.UpdateUser(user);
        Result result=new Result();
        result.setMes("success");
        result.setCode(200);
        return result;
    }

    @GetMapping
    public WechatUser getUserByToken(@RequestParam("token") Integer token){
        WechatUser user = wechatUserService.getUserByID(token);
        return  user;
    }


}
