package com.bupt.service.imp;

import com.bupt.dao.MenuDao;
import com.bupt.dao.User_likeDao;
import com.bupt.pojo.Menu;
import com.bupt.pojo.User_like;
import com.bupt.service.User_likeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class User_likeServiceImp implements User_likeService {
    @Autowired
    private User_likeDao user_likeDao;
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getLikesByID(int ID) {
        List<Menu> list=new ArrayList<>();

        List<User_like> getlikes = user_likeDao.getlikes(ID);


        for(User_like user_like :getlikes){
            Menu menu = menuDao.selectByID(user_like.getMenuid());
            list.add(menu);
        }

        return list;
    }

    @Override
    public void AddLike(User_like user_like) {
        user_likeDao.InsertLike(user_like);
    }

    @Override
    public void deleteLike(int id,int menuid) {
        User_like like = user_likeDao.getLike(id,menuid);
        if(like==null) return;
        user_likeDao.deleteByID(id,menuid);
    }

    @Override
    public boolean isliked(int userId, int menuID) {
        return user_likeDao.getLike(userId,menuID)!=null;
    }
}
