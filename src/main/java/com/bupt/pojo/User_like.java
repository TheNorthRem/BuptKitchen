package com.bupt.pojo;

public class User_like {
    private  Integer userid;
    private Integer menuid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    @Override
    public String toString() {
        return "User_like{"  +
                ", userid=" + userid +
                ", menuid=" + menuid +
                '}';
    }
}
