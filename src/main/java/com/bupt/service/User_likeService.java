package com.bupt.service;

import com.bupt.pojo.Menu;
import com.bupt.pojo.User_like;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface User_likeService {

    List<Menu> getLikesByID(int ID);

    void AddLike(User_like user_like);

    void deleteLike(int userID, int menuID);

    boolean isliked(int userId, int menuID);
}
