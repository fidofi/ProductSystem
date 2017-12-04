package com.fidofi.service;

import com.fidofi.model.Manager;

/**
 * Created by fido on 2017/10/12.
 */
public interface ManagerService {
    /**
     * 登录
     * @param manager
     * @return
     */
    boolean findUser(Manager manager);

    /**
     * 更新个人资料
     * @param manager
     * @return
     */
    Manager update(Manager manager);
}
