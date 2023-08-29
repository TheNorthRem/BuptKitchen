package com.bupt.controller;

import com.bupt.controller.mes.Result;
import com.bupt.pojo.Menu;
import com.bupt.pojo.WechatUser;
import com.bupt.service.MenuService;
import com.bupt.service.WechatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
public class UploadController {
    @Autowired
    private WechatUserService wechatUserService;
    @Autowired
    private MenuService menuService;

    @PostMapping("/UploadAvatar")

    public Result UploadAvatar(@RequestParam("image") MultipartFile file, @RequestParam("token") Integer token, @RequestParam("username") String nickname){

        String name=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        WechatUser user=wechatUserService.getUserByID(token);
        name= token+name;
        File newfile=new File("D:\\Programing\\Java\\BuptKitchenResource\\avatar\\"+name);
        try {
            file.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(user==null) return null;
        user.setAvatarName(name);
        user.setUsername(nickname);
        wechatUserService.UpdateUser(user);
        Result result=new Result();
        result.setMes("success");
        result.setCode(200);
        result.setData(user);
        return result;
    }

    @PostMapping("/UploadMenu")

    public Result UploadMenu(@RequestParam("image") MultipartFile file, @RequestParam("menuid") Integer menuid, @RequestParam("token") Integer token){

        String name=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        Menu menu = menuService.SelectMenuByID(menuid);

        Result result=new Result();

        if(menu.getUploaderID()!=token ) {
            result.setMes("fail");
            return result;
        }
        name= menuid+name;
        File newfile=new File("D:\\Programing\\Java\\BuptKitchenResource\\images\\"+name);

        try {
            file.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu.setImageName(name);
        menuService.UpdateMenu(menu);
        result.setMes("success");
        result.setCode(200);
        result.setData(name);
        return result;
    }




}
