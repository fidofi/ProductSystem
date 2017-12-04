package com.fidofi.repository;

import com.fidofi.model.Page;
import com.fidofi.model.User;

import java.util.List;

/**
 * Created by fido on 2017/11/28.
 */
public interface UserRepository {

    /**
     * 注册
     * @param user
     * @return
     */
    void register(User user);

    /**
     * 登录
     * @param userName
     * @param userPassword
     * @return
     */
    User login(String userName,String userPassword);

    /**
     * 判断是否存在该用户
     * @param userName
     * @return
     */
    boolean exist(String userName,Integer userId);


    /**
     * 更新用户资料
     * @param user
     * @return
     */
    User update(User user);

    /**
     * 根据id查找用户
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 冻结用户
     * @param userId
     */
    public void freezeUser(Integer userId);

    /**
     * 取消冻结用户
     * @param userId
     */
    public void releaseUser(Integer userId);

    /**
     * 查找所有被冻结的用户
     * @param page
     * @return
     */
    public List<User> findAllFreezeUser(Page page);

    /**
     * 查找所有状态正常的用户
     * @param page
     * @return
     */
    public List<User> findAllNormalUser(Page page);

    /**
     * 查找是否已存在邮箱
     * @param userEmail
     * @return
     */
    public boolean existEmail(String userEmail);

    /**
     * 查找所有的用户
     * @param page
     * @return
     */
    public List<User> findUser(Page page);

    /**
     * 用户总数，分页需要使用到
     * @return
     */
    public Integer userCount();
}
