package com.bupt.service;

import com.bupt.pojo.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface MenuService {

    List<Menu> getAll();

    void AddMenu(Menu menu);

    List<Menu> getTop();

    void UpdateMenu(Menu menu);

    void deleteMenu(Menu menu);

    List<Menu> GetMenuByUploader(int uploader);

    Menu SelectMenuByID(int id);

    List<Menu> selectMenuByName(String Name);

    List<Menu> SearchComplete(String Name);
}
