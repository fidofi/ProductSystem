<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>后台用户管理</title>
    <meta charset="utf-8">
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function doFreeze(userId) {
            window.location.href= "/product/doFreeze?dofreeze=freeze&userId="+userId;

        }
        function unFreeze(userId) {
            window.location.href = "/product/doFreeze?dofreeze=unfreeze&userId="+userId;
        }

    </script>
</head>
<body>

<h3 style="text-align: center">
    天天淘后台用户管理
</h3>
<div style="float: right">
    <a href="/product">返回后台管理主页</a>
</div>
<table class="table table-bordered table-hover" style="text-align: center" width="300px">
    <thead>
    <tr style="text-align: center">
        <th>
            用户编号
        </th>
        <th>
            用户名
        </th>
        <th>
            用户邮箱
        </th>
        <th>
            状态
        </th>
        <th colspan="2" style="align: center">
            操作
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user">

        <tr>
            <td>
                    ${user.userId}
            </td>
            <td>
                    ${user.userName}
            </td>
            <td>
                    ${user.userEmail}
            </td>
            <td>
                <c:choose>
                    <c:when test="${user.userStatus}">
                        正常
                    </c:when>
                    <c:otherwise>
                        冻结
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${user.userStatus}">
                        <button type="button" class="btn btn-xs" disabled="disabled">解冻</button>
                    </c:when>
                    <c:otherwise>
                        <button type="button" class="btn btn-xs" onclick="unFreeze('${user.userId}')">解冻</button>
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${user.userStatus}">
                        <button type="button" class="btn btn-xs" onclick="doFreeze('${user.userId}')">冻结</button>
                    </c:when>
                    <c:otherwise>
                        <button type="button" class="btn btn-xs" disabled="disabled">冻结</button>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
<nav id="pageStyle" style="text-align: center">
    <ul class="pagination">
        <c:choose>
            <c:when test="${page.index==1}">
                <li class="disabled">
                    <a href="JavaScript:void(0)" class="disabled">首页</a>
                </li>
            </c:when>

            <c:otherwise>
                <li>
                    <a href="/product/managerUser?pageIndex=1">首页</a>
                </li>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${page.index==1}">
                <li class="disabled">
                    <a href="JavaScript:void(0)" class="disabled">上一页</a>
                </li>
            </c:when>
            <c:otherwise>
                <li>
                    <a href="/product/managerUser?pageIndex=${page.index-1}">上一页</a>
                </li>
            </c:otherwise>
        </c:choose>
        <c:forEach begin="1" end="${page.total}" var="i">
            <c:choose>
                <c:when test="${i==page.index}">
                    <li class="disabled">
                        <a href="JavaScript:void(0)" class="disabled">${i}</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="/product/managerUser?pageIndex=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${page.index==page.total||page.total==1}">
                <li class="disabled">
                    <a href="JavaScript:void(0)" class="disabled">下一页</a>
                </li>
            </c:when>
            <c:otherwise>
                <li>
                    <a href="/product/managerUser?pageIndex=${page.index+1}">下一页</a>
                </li>
            </c:otherwise>

        </c:choose>
        <c:choose>
            <c:when test="${page.total==1||page.index==page.total}">
                <li class="disabled">
                    <a href="JavaScript:void(0)" class="disabled">尾页</a>
                </li>
            </c:when>

            <c:otherwise>
                <li>
                    <a href="/product/managerUser?pageIndex=${page.total}">尾页</a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>

</body>
</html>
