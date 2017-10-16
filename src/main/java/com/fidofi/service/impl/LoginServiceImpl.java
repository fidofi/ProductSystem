package com.fidofi.service.impl;

import com.fidofi.model.User;
import com.fidofi.repository.LoginRepository;
import com.fidofi.repository.impl.LoginRepositoryImpl;
import com.fidofi.service.LoginService;

/**
 * Created by fido on 2017/10/12.
 */
public class LoginServiceImpl implements LoginService {
    private LoginRepository loginRepository=new LoginRepositoryImpl();
    public boolean findUser(User user) {
        return loginRepository.findUser(user);
    }
}
