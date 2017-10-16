package com.fidofi.repository;

import com.fidofi.model.User;

/**
 * Created by fido on 2017/10/12.
 * 登录
 */
public interface LoginRepository {
    //判断用户名密码是否正确
     boolean findUser(User user);
}
