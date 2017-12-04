package com.fidofi.repository;

import com.fidofi.model.Manager;

/**
 * Created by fido on 2017/10/12.
 * 管理员模块
 */
public interface ManagerRepository {
    /**
     * 更新用户名和密码
     * @param manager
     */
    public void update(Manager manager);

    /**
     * 管理员登录
     * @param rootName
     * @param rootPassword
     * @return
     */
    public Manager login(String rootName,String rootPassword);

}
