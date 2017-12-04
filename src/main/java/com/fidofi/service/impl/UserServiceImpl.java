package com.fidofi.service.impl;

import com.fidofi.constant.ResponseCode;
import com.fidofi.model.Page;
import com.fidofi.model.User;
import com.fidofi.repository.UserRepository;
import com.fidofi.repository.impl.UserRepositoryImpl;
import com.fidofi.service.UserService;
import com.fidofi.vo.ResultVO;

import java.util.List;

/**
 * Created by fido on 2017/11/28.
 */
public class UserServiceImpl implements UserService {
    private UserRepository userRepository=new UserRepositoryImpl();
    public ResultVO<User> login(String userName, String userPassword) {
        User user=userRepository.login(userName,userPassword);
        ResultVO<User> resultVO=new ResultVO<User>();
        if(user==null){
            resultVO.setCode(ResponseCode.ILLEGAL_ARGUMENT.getCode());
            resultVO.setMessage("用户名或密码错误，请检查!");
            return resultVO;
        }
        //被冻结无法登录
        if(user.getUserStatus()==false){
            resultVO.setCode(ResponseCode.ERROR.getCode());
            resultVO.setMessage("用户被冻结，请联系管理员!");
        }
        else {
            resultVO.setCode(ResponseCode.SUCCESS.getCode());
            resultVO.setData(user);
        }
        return  resultVO;
    }

    public ResultVO<String> register(User user) {
        if (userRepository.exist(user.getUserName(),user.getUserId())) {
            ResultVO<String> resultVO = ResultVO.createByError("用户名已经存在!");
            return resultVO;
        }
        if (userRepository.existEmail(user.getUserEmail())) {
            ResultVO<String> resultVO = ResultVO.createByError("电子邮箱已经存在!");
            return resultVO;
        }
        userRepository.register(user);
        ResultVO<String> resultVO = ResultVO.createBySuccess("注册成功");
        //将用户名传过去，便于跳转到登录界面的时候用
        resultVO.setData(user.getUserName());
        return resultVO;
    }

    public ResultVO<User> update(User user) {
        if(userRepository.exist(user.getUserName(),user.getUserId())){
            ResultVO<User> resultVO = ResultVO.createByError("用户名已经存在!请重新修改");
            return resultVO;
        }
        userRepository.update(user);
        User newUser=userRepository.findById(user.getUserId());
        ResultVO<User> resultVO=ResultVO.createBySuccess(newUser);
        return resultVO;
    }
    public ResultVO<User> freezeUser(Integer userId) {
        userRepository.freezeUser(userId);
        User user=userRepository.findById(userId);
        ResultVO<User> resultVO=ResultVO.createBySuccess(user);
        return resultVO;
    }

    public ResultVO<User> releaseUser(Integer userId) {
        userRepository.releaseUser(userId);
        User user=userRepository.findById(userId);
        ResultVO<User> resultVO=ResultVO.createBySuccess(user);
        return resultVO;
    }

    public ResultVO<List<User>> findFreezeUser(Page page) {
        List<User> userList=userRepository.findAllFreezeUser(page);
        if(userList==null){
            return ResultVO.createByError("没有找到被冻结用户");
        }
        else {
            ResultVO resultVO=ResultVO.createBySuccess(userList);
            return resultVO;
        }
    }

    public ResultVO<List<User>> findNormalUser(Page page) {
        List<User> userList=userRepository.findAllNormalUser(page);
        if(userList==null){
            return ResultVO.createByError("没有找到用户");
        }
        else {
            ResultVO resultVO=ResultVO.createBySuccess(userList);
            return resultVO;
        }
    }

    public ResultVO<List<User>> findAllUser(Page page) {
        List<User> userList=userRepository.findUser(page);
        if(userList==null){
            return ResultVO.createByError("没有用户");
        }
        else {
            ResultVO resultVO=ResultVO.createBySuccess(userList);
            return resultVO;
        }
    }

    public Integer userCount() {
        return userRepository.userCount();
    }
}
