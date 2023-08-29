package com.bupt;

import com.bupt.dao.MenuDao;
import com.bupt.dao.WechatUserDao;
import com.bupt.pojo.Menu;
import com.bupt.pojo.WechatUser;
import com.bupt.utils.WechatUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BuptKitchenApplicationTests {
    @Autowired
    private WechatUserDao userdao;
    @Autowired
    private MenuDao menuDao;

    @Test
    void WechatUserTest() {
        WechatUser user=new WechatUser();
        user.setId(1);
        user.setUsername("root");
        user.setOpenid("23123123");
        userdao.deleteUserbyOpenID("23123123");
    }

    @Test

    void MenuDaoTest(){
        Menu menu=new Menu();
        menu.setId(1);
        menu.setName("辣椒炒蛋");
        menu.setUploader("李烨辉");
        menu.setDescription("先放辣椒再炒蛋");
        List<Menu> menus = menuDao.selectTop();
        menuDao.InsertMenu(menu);
        menuDao.update(menu);
        System.out.println(menus);
    }


    @Test
    void WechatUtilTest(){
        WechatUtil util=new WechatUtil();

    }

}
