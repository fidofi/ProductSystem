package com.fidofi.service;

import com.fidofi.model.Page;
import com.fidofi.model.User;
import com.fidofi.vo.ResultVO;

import javax.xml.transform.Result;
import java.util.List;

/**
 * Created by fido on 2017/11/28.
 * 用户模块
 */
public interface UserService {
    /**
     * 检查用户名密码是否正确
     * 还需要检查登录状态
     * @param userName
     * @param userPassword
     * @return
     */
    public ResultVO<User> login(String userName, String userPassword);

    /**
     * 用户注册
     * @param user
     * @return
     */
    public ResultVO<String> register(User user);

    /**
     * 用户更新
     * @param user
     * @return
     */
    public ResultVO<User> update(User user);

    /**
     * 管理员冻结用户
     * @param userId
     * @return
     */
    public ResultVO<User> freezeUser(Integer userId);

    /**
     * 管理员解冻用户
     * @param userId
     * @return
     */
    public ResultVO<User> releaseUser(Integer userId);

    /**
     * 查看所有被冻结的用户
     * @param page
     * @return
     */
    public ResultVO<List<User>> findFreezeUser(Page page);

    /**
     * 查看所有正常的用户
     * @param page
     * @return
     */
    public ResultVO<List<User>> findNormalUser(Page page);

    /**
     * 查看所有用户
     * @param page
     * @return
     */
    public ResultVO<List<User>> findAllUser(Page page);

    /**
     * 得到用户数
     * @return
     */
    public Integer userCount();
}
