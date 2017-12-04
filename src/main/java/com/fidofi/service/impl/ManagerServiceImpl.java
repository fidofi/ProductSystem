package com.fidofi.service.impl;

import com.fidofi.model.Manager;
import com.fidofi.repository.ManagerRepository;
import com.fidofi.repository.impl.ManagerRepositoryImpl;
import com.fidofi.service.ManagerService;

/**
 * Created by fido on 2017/10/12.
 */
public class ManagerServiceImpl implements ManagerService {
    private ManagerRepository managerRepository = new ManagerRepositoryImpl();

    public boolean findUser(Manager manager) {
        Manager findManager = managerRepository.login(manager.getRootName(), manager.getRootPassword());
        if (findManager == null) {
            return false;
        } else
            return true;
    }

    public Manager update(Manager manager) {
        return null;
    }
}
