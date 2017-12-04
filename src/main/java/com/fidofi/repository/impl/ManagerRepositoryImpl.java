package com.fidofi.repository.impl;

import com.fidofi.model.Manager;
import com.fidofi.repository.ManagerRepository;
import com.fidofi.utils.DB.impl.BeanHandler;
import com.fidofi.utils.DBUtils;

/**
 * Created by fido on 2017/11/28.
 */
public class ManagerRepositoryImpl implements ManagerRepository {

    public void update(Manager manager) {
        String sql = "update manager set rootName=?,rootPassword=? where rootId=?";
        Object[] args = {manager.getRootName(), manager.getRootPassword(), manager.getRootId()};
        DBUtils.update(sql, args);
    }

    public Manager login(String rootName, String rootPassword) {
        String sql = "select rootId,rootName,rootPassword from manager where rootName=? and rootPassword=?";
        Object[] args = {rootName, rootPassword};
        Manager manager = (Manager) DBUtils.select(new BeanHandler(Manager.class), sql, args);
        return manager;
    }
}
