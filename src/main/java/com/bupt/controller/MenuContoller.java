package com.bupt.controller;


import com.alibaba.fastjson2.JSONObject;
import com.bupt.controller.mes.Result;
import com.bupt.pojo.Menu;
import com.bupt.pojo.User_like;
import com.bupt.service.MenuService;
import com.bupt.service.User_likeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Menu")
public class MenuContoller {
    @Autowired
    private MenuService menuService;
    @Autowired
    private User_likeService user_likeService;

    @PutMapping
    public Result UploadMenu(@RequestBody JSONObject MES){
        Result result=new Result();

        if(MES.getInteger("menuID")!=null){
            Menu menu = menuService.SelectMenuByID(MES.getInteger("menuID"));
            menu.setName(MES.getString("name"));
            menu.setDescription(MES.getString("description"));
            menu.setUploaderID(MES.getInteger("id"));
            menu.setStep(MES.getString("step"));
            menu.setId(MES.getInteger("menuID"));
            menuService.UpdateMenu(menu);
            result.setMes("success");
            result.setCode(200);
            result.setData(menu);
            return result;
        }

        Menu menu = new Menu();
        menu.setName(MES.getString("name"));
        menu.setDescription(MES.getString("description"));
        menu.setUploaderID(MES.getInteger("id"));
        menu.setStep(MES.getString("step"));

        if(MES.getInteger("id")!=null){
            menuService.AddMenu(menu);
            result.setMes("success");
            result.setCode(200);
            result.setData(menu);
        }else{
            result.setMes("fail");
            result.setCode(400);
        }
        System.out.println(menu);

        return result;
    }

    @PostMapping("/SelectByID")
    public Result GetMenuByUser(@RequestBody JSONObject MES){
        List<Menu> list=menuService.GetMenuByUploader(MES.getInteger("token"));
        Result result=new Result();
        System.out.println(list);
        result.setCode(200);
        if (list.size()==0){
            result.setMes("none");
        }else{
            result.setMes("success");
            result.setData(list);
        }
        return result;
    }

    @PostMapping("/Search")
    public Result GetMenuByName(@RequestBody JSONObject MES){
        List<Menu> list=menuService.selectMenuByName(MES.getString("keyword"));
        Result result=new Result();
        System.out.println(list);
        result.setCode(200);
        if (list.size()==0){
            result.setMes("none");
        }else{
            result.setMes("success");
            result.setData(list);
        }
        return result;
    }


    @GetMapping
    public Result GetSingleMenu(int id){
        Menu menu = menuService.SelectMenuByID(id);
        menu.setCount(menu.getCount()+1);
        menuService.UpdateMenu(menu);
        Result res=new Result();
        if(menu == null){
            res.setMes("none");
            res.setCode(404);
        }else {
            System.out.println(menu.getUpdatetime().toString());
            res.setMes(menu.getUpdatetime().toString());
            res.setCode(200);
            res.setData(menu);
        }
        return res;
    }

    @GetMapping("/GetTopMenus")
    public List<Menu> getTopMenus(){
        return menuService.getTop();
    }

    @GetMapping("/CheckLikes")
    public boolean checkLike(@RequestParam("token") Integer token,@RequestParam("menuid") Integer menuid){
        return user_likeService.isliked(token,menuid);
    }

    @PostMapping("/like")

    public String addlike(@RequestBody JSONObject mes){
        Integer token = mes.getInteger("token");
        Integer menuid = mes.getInteger("menuid");

        System.out.println("like working :token:" +token + "menu:"+menuid);
        Menu menu = menuService.SelectMenuByID(menuid);
        menu.setLikecount(menu.getLikecount()+1);
        menuService.UpdateMenu(menu);
        User_like user_like=new User_like();
        user_like.setUserid(token);
        user_like.setMenuid(menuid);
        if (!user_likeService.isliked(token,menuid))
            user_likeService.AddLike(user_like);
        return "success";
    }

    @PostMapping("/dislike")
    public String dislike(@RequestBody JSONObject mes){
        Integer token = mes.getInteger("token");
        Integer menuid = mes.getInteger("menuid");
        Menu menu = menuService.SelectMenuByID(menuid);
        menu.setLikecount(menu.getLikecount()-1);
        menuService.UpdateMenu(menu);
        System.out.println("dislike working : token:" +token + "menu:"+menuid);
        User_like user_like=new User_like();
        user_like.setUserid(token);
        user_like.setMenuid(menuid);
        user_likeService.deleteLike(token,menuid);
        return "success";
    }

    @PostMapping("/getLikes")

    public List<Menu> getLikes(@RequestBody JSONObject mes){
        Integer token = mes.getInteger("token");
        List<Menu> likesByID = user_likeService.getLikesByID(token);
        return likesByID;
    }

}
