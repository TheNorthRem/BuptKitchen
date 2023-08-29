package com.bupt.service.imp;

import com.bupt.dao.WechatUserDao;
import com.bupt.dao.WeekMenuDao;
import com.bupt.pojo.WechatUser;
import com.bupt.pojo.WeekMenu;
import com.bupt.service.WechatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WechatUserServiceimp implements WechatUserService {
    @Autowired
    private WechatUserDao wechatUserDao;
    @Autowired
    private WeekMenuDao weekMenuDao;
    @Override
    public WechatUser Login(WechatUser user) {
        WechatUser wechatUser = wechatUserDao.selectUserByOpenID(user.getOpenid());
        if(wechatUser==null){
            WeekMenu weekMenu=new WeekMenu();
            weekMenuDao.InsertWeekMenu(weekMenu);
            user.setWeekMenu(weekMenu.getId());
            wechatUserDao.InsertUser(user);
        }
        wechatUser=wechatUserDao.selectUserByOpenID(user.getOpenid());
        return wechatUser;
    }

    @Override
    public void deleteUserByOpenID(String openID) {
        wechatUserDao.deleteUserbyOpenID(openID);
    }

    @Override
    public void changeUserName(String OpenID, String userName) {
        wechatUserDao.UpdateUsernameByOpenID(OpenID,userName);
    }

    @Override
    public WechatUser getUserByID(int ID) {
        return wechatUserDao.selectUserByID(ID);
    }

    @Override
    public WechatUser getUserByOpenID(String openID) {
        return wechatUserDao.selectUserByOpenID(openID);
    }

    @Override
    public void UpdateUser(WechatUser user) {
        wechatUserDao.updateUser(user);
    }


}
