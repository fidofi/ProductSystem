package com.fidofi.constant;

/**
 * Created by fido on 2017/9/30.
 * 相关的常量信息
 */
public class DBConstant {
    /**
     * 数据库的用户名
     */
    public static final String USERNAME = "root";
    /**
     * 数据库的密码
     */
    public static final String PASSWORD = "090448";
    /**
     * 数据库的驱动信息
     */
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    /**
     * 访问数据库的地址
     */
    public static final String URL = "jdbc:mysql://localhost:3306/productsystem";
    /**
     * 图片放置的路径
     * 这里不知道要怎么获取..不应该这样写死的
     */
    public static final String location="F://ProductSystem/src/main/webapp/imag/";

//    public static final String location=DBConstant.class.getResource("/").getPath().substring(1);
}
