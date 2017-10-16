package com.fidofi.service;

import com.fidofi.model.User;

/**
 * Created by fido on 2017/10/12.
 */
public interface LoginService {
    boolean findUser(User user);
}
