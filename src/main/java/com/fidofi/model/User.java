package com.fidofi.model;

/**
 * Created by fido on 2017/9/30.
 * 后台管理员类
 * 负责商品的增删改查
 */
public class User {
    private String userName; //用户名
    private String userPassword;//密码

    public User() {

    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
