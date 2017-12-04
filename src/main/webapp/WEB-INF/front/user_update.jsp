<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>用户更新</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                天天淘用户更新资料界面
            </h3>
            <div style="float: right">
                <a href="/user/index">返回主页</a>
            </div>
            <div style="width: 250px;margin: 100px auto">
                <form class="form-horizontal" role="form" action="/user/doUpdate?userId=${user.userId}" method="post" style="text-align: center;margin: 0 auto">
                    <div class="form-group">
                        <div class="col-sm-10">
                            <label> 用户名:</label><input type="text" class="form-control" name="userName" value="${user.userName}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10">
                            <label> 邮箱:</label> <input type="email" class="form-control" name="userEmail" value="${user.userEmail}" disabled="disabled"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10">
                            <label> 新的密码:</label> <input type="password" class="form-control" name="userPassword"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10">
                            <label> 确认密码:</label> <input type="password" class="form-control" name="confirmPassword"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" onclick="register()">提交</button>
                        </div>
                    </div>
                </form>
                <c:if test="${updateMesg!=null}">
                    <div class="alert alert-dismissable alert-warning">
                        <h4>
                            注意!
                        </h4>
                            ${updateMesg}
                    </div>
                </c:if>
                <c:if test="${ifUpdate}">
                    <%
                        session.invalidate();
                        response.sendRedirect("/user/forwardLogin");
                    %>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
