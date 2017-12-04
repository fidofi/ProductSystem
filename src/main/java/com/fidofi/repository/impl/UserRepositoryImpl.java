package com.fidofi.repository.impl;

import com.fidofi.constant.PageConstant;
import com.fidofi.model.Page;
import com.fidofi.model.User;
import com.fidofi.repository.UserRepository;
import com.fidofi.utils.DB.impl.BeanHandler;
import com.fidofi.utils.DB.impl.BeanListHandler;
import com.fidofi.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by fido on 2017/11/28.
 */
public class UserRepositoryImpl implements UserRepository {
    private String InsertFields="userName,userPassword,userEmail,userStatus";//插入属性
    private String SelectFields="userId,userName,userPassword,userEmail,userStatus";//查询属性

    public void register(User user) {
        String sql="insert into user ("+InsertFields+") values (?,?,?,?)";
        Object[] args={user.getUserName(),user.getUserPassword(),user.getUserEmail(),user.getUserStatus()};
        DBUtils.update(sql,args);
    }

    public User login(String userName, String userPassword) {
        String sql="select "+SelectFields+" from user where userName=? and userPassword=? ";
        Object[] args={userName,userPassword};
        User user=(User)DBUtils.select(new BeanHandler(User.class),sql,args);
        return user;
    }

    public boolean exist(String userName,Integer userId) {
        if(userId==null){
            String sql = "select " + SelectFields + " from user where userName=? ";
            Object[] args = {userName};
            User user = (User) DBUtils.select(new BeanHandler(User.class), sql, args);
            if (user == null) {
                return false;
            } else
                return true;
        }
        else{
            String sql = "select " + SelectFields + " from user where userName=? and userId!=?";
            Object[] args = {userName,userId};
            User user = (User) DBUtils.select(new BeanHandler(User.class), sql, args);
            if (user == null) {
                return false;
            } else
                return true;
        }
    }

    public User update(User user) {
        String sql="update user set userName=?,userPassword=? where userId=? ";
        Object[] args={user.getUserName(),user.getUserPassword(),user.getUserId()};
        DBUtils.update(sql,args);
        User newUser=this.findById(user.getUserId());
        return newUser;
    }

    public User findById(Integer userId) {
        String sql="select "+SelectFields+" from user where userId=? ";
        Object[] args={userId};
        User user=(User)DBUtils.select(new BeanHandler(User.class),sql,args);
        return user;
    }

    public void freezeUser(Integer userId) {
        String sql="update user set userStatus=0 where userId=? ";
        Object[]args={userId};
        DBUtils.update(sql,args);
    }

    public void releaseUser(Integer userId) {
        String sql="update user set userStatus=1 where userId=? ";
        Object[]args={userId};
        DBUtils.update(sql,args);
    }

    public List<User> findAllFreezeUser(Page page) {
        String sql="select "+SelectFields+" from user where userStatus = 0 order by userName DESC limit ?,?";
        Object[] args={(page.getIndex()-1)*PageConstant.size,PageConstant.size};
        List<User> userList=(List<User>)DBUtils.select(new BeanListHandler(User.class),sql,args);
        return userList;
    }

    public List<User> findAllNormalUser(Page page) {
        String sql="select "+SelectFields+" from user where userStatus = 1 order by userName DESC limit ?,?";
        Object[] args={(page.getIndex()-1)*PageConstant.size,PageConstant.size};
        List<User> userList=(List<User>)DBUtils.select(new BeanListHandler(User.class),sql,args);
        return userList;
    }

    public boolean existEmail(String userEmail) {
        String sql = "select " + SelectFields + " from user where userEmail=? ";
        Object[] args = {userEmail};
        User user = (User) DBUtils.select(new BeanHandler(User.class), sql, args);
        if (user == null) {
            return false;
        } else
            return true;
    }

    public List<User> findUser(Page page) {
        String sql="select "+SelectFields+" from user order by userName DESC limit ?,?";
        Object[] args={(page.getIndex()-1)*PageConstant.size,PageConstant.size};
        List<User> userList=(List<User>)DBUtils.select(new BeanListHandler(User.class),sql,args);
        return userList;
    }

    public Integer userCount() {
        String sql = "select count(userId) from user";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                count=rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.release(conn, ps, rs);
        }
        return count;
    }
}
