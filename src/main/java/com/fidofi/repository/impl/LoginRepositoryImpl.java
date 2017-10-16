package com.fidofi.repository.impl;

import com.fidofi.constant.UserConstant;
import com.fidofi.model.User;
import com.fidofi.repository.LoginRepository;

/**
 * Created by fido on 2017/10/12.
 */
public class LoginRepositoryImpl implements LoginRepository {
    /**
     * 因为是小小demo，故没有存入数据库
     *
     * @param user
     * @return
     */
    public boolean findUser(User user) {
        String name = user.getUserName();
        String password = user.getUserPassword();
        boolean login = false;
        if (UserConstant.userName.equals(name)) {
            if (UserConstant.password.equals(password)) {
                login = true;
            }
        }
        return login;
    }


}
