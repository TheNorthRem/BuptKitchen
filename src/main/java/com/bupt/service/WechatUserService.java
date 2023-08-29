package com.bupt.service;



import com.bupt.pojo.WechatUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface WechatUserService {
    WechatUser Login(WechatUser user);
    void deleteUserByOpenID(String openID);
    void changeUserName(String OpenID, String userName);
    WechatUser getUserByID(int ID);
    WechatUser getUserByOpenID(String openID);

    void UpdateUser(WechatUser user);
}
