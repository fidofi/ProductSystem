<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>用户注册界面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                天天淘用户注册界面
            </h3>
            <div style="width: 250px;margin: 100px auto">
                <form class="form-horizontal" role="form" action="/user/doRegister" method="post" style="text-align: center;margin: 0 auto">
                    <div class="form-group">
                        <div class="col-sm-10">
                            <label> UserName:</label><input type="text" class="form-control" name="userName" placeholder=".col-xs-5" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10">
                            <label> Email:</label> <input type="email" class="form-control" name="userEmail" placeholder=".col-xs-5"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10">
                            <label> Password:</label> <input type="password" class="form-control" name="userPassword" placeholder=".col-xs-5" value="${userPassword}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" onclick="register()">提交</button>
                        </div>
                    </div>
                </form>
                <c:if test="${registerMesg!=null}">
                    <div class="alert alert-dismissable alert-warning">
                        <h4>
                            注意!
                        </h4>
                            ${registerMesg}
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
