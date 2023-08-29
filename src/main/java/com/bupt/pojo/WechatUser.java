package com.bupt.pojo;

public class WechatUser {
    private int id;
    private String username;
    private String openid;
    private String avatarName;
    private Integer weekMenu;

    public Integer getWeekMenu() {
        return weekMenu;
    }

    public void setWeekMenu(Integer weekMenu) {
        this.weekMenu = weekMenu;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "WechatUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", openid='" + openid + '\'' +
                '}';
    }
}
