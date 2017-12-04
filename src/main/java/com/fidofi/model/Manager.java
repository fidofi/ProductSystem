package com.fidofi.model;

/**
 * Created by fido on 2017/9/30.
 * 后台管理员类
 * 负责商品的增删改查
 */
public class Manager {
    private Integer rootId;//管理员编号
    private String rootName;//管理员名字
    private String rootPassword;//管理员密码

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public String getRootPassword() {
        return rootPassword;
    }

    public void setRootPassword(String rootPassword) {
        this.rootPassword = rootPassword;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "rootId=" + rootId +
                ", rootName='" + rootName + '\'' +
                ", rootPassword='" + rootPassword + '\'' +
                '}';
    }

    public Manager(String rootName, String rootPassword) {
        this.rootName = rootName;
        this.rootPassword = rootPassword;
    }

    public Manager() {
    }
}
