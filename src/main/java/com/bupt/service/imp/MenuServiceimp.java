package com.bupt.service.imp;

import com.bupt.dao.MenuDao;
import com.bupt.pojo.Menu;
import com.bupt.pojo.WechatUser;
import com.bupt.service.MenuService;

import com.bupt.service.WechatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceimp implements MenuService {

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private WechatUserService userService;

    @Override
    public List<Menu> getAll() {
        return menuDao.selectALL();
    }

    @Override
    public void AddMenu(Menu menu) {
        WechatUser user = userService.getUserByID(menu.getUploaderID());
        menu.setUploader(user.getUsername());
        menuDao.InsertMenu(menu);
    }

    @Override
    public List<Menu> getTop() {
        return menuDao.selectTop();
    }

    @Override
    public void UpdateMenu(Menu menu) {
        menuDao.update(menu);
    }

    @Override
    public void deleteMenu(Menu menu) {
        menuDao.DeleteByID(menu.getId());
    }

    @Override
    public List<Menu> GetMenuByUploader(int uploader) {
        return menuDao.selectByUploader(uploader);
    }

    @Override
    public Menu SelectMenuByID(int id) {
        return menuDao.selectByID(id);
    }

    @Override
    public List<Menu> selectMenuByName(String Name) {
        Name="%"+Name+"%";
        return menuDao.selectByName(Name);
    }

    @Override
    public List<Menu> SearchComplete(String Name) {
        Name=Name+"%";
        return menuDao.selectByName(Name);
    }
}
