<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>用户登录界面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
        //注册函数
        function register() {
            window.location.href="/user/register";
        }
        
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                天天淘商城登录界面
            </h3>
         <div style="width: 250px;margin: 100px auto">
             <form class="form-horizontal" role="form" action="/user/login" method="post" style="text-align: center;margin: 0 auto">
                 <div class="form-group">
                     <div class="col-sm-10">
                     <label> UserName:</label><input type="text" class="form-control" name="userName" placeholder=".col-xs-5" value="${userName}"/>
                     </div>
                 </div>
                 <div class="form-group">
                     <div class="col-sm-10">
                  <label> Password:</label> <input type="password" class="form-control" name="userPassword" placeholder=".col-xs-5" value="${userPassword}"/>
                     </div>
                 </div>
                 <div class="form-group">
                     <div class="col-sm-offset-2 col-sm-10">
                         <div class="checkbox">
                             <label><input type="checkbox" name="remember"/>Remember me</label>
                         </div>
                     </div>
                 </div>
                 <div class="form-group">
                     <div class="col-sm-offset-2 col-sm-10">
                         <button type="submit" class="btn btn-default">登录</button>
                         <button type="button" class="btn btn-default" onclick="register()">注册</button>
                     </div>
                 </div>
             </form>
             <c:if test="${loginMesg!=null}">
                 <div class="alert alert-dismissable alert-warning">
                     <h4>
                         注意!
                     </h4>
                         ${loginMesg}
                 </div>
             </c:if>
         </div>
        </div>
    </div>
</div>
</body>
</html>
