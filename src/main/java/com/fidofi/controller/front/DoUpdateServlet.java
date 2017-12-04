package com.fidofi.controller.front;

import com.fidofi.model.User;
import com.fidofi.service.UserService;
import com.fidofi.service.impl.UserServiceImpl;
import com.fidofi.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by fido on 2017/11/30.
 * 用户更新资料
 */
public class DoUpdateServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String userName=request.getParameter("userName");
          String confirmPassword=request.getParameter("confirmPassword");
          String Id=request.getParameter("userId");
          Integer userId=Integer.valueOf(Id);
          String userPassword=request.getParameter("userPassword");
          if(userName==null||confirmPassword==null||userPassword==null){
               request.setAttribute("updateMesg","请填好信息！");
               request.getRequestDispatcher("/WEB-INF/front/user_update.jsp").forward(request,response);
          }
          if(!confirmPassword.equals(userPassword)){
              request.setAttribute("updateMesg","两次密码输入不相同！");
              request.getRequestDispatcher("/WEB-INF/front/user_update.jsp").forward(request,response);
          }
          User user=new User();
          user.setUserId(userId);
          user.setUserName(userName);
          user.setUserPassword(userPassword);
          ResultVO<User> resultVO=userService.update(user);
          if(resultVO.getData()==null){
              request.setAttribute("updateMesg",resultVO.getMessage());
              request.getRequestDispatcher("/WEB-INF/front/user_update.jsp").forward(request,response);
          }
          //更新成功
          else{
              request.setAttribute("user",resultVO.getData());
              request.setAttribute("updateMesg","更改成功,请重新登录");
              request.setAttribute("ifUpdate",true);
              request.getRequestDispatcher("/WEB-INF/front/user_update.jsp").forward(request,response);
          }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
