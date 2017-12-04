<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>天天淘商城主页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
        //选择类别和排序方式
        function orderBy() {
            var categoryName = document.getElementById("categoryName").value;
            var role = document.getElementById("role").value;
            var start = document.getElementById("start").value;
            var end = document.getElementById("end").value;
            window.location.href = "/user/order?role=" + role + "&categoryName=" + categoryName + "&start=" + start + "&end=" + end;
        }
        //商品名称模糊查询
        function orderByName() {
            var productName = document.getElementById("productName").value;
            window.location.href = "/user/index/selectByName?productName=" + productName;
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <c:choose>
                <c:when test="${user!=null}">
                    欢迎您，${user.userName}<a href="/user/buy"> 查看购物车</a>
                    <div style="float: right">
                        <a href="/user/update?userId=${user.userId}">更改个人资料</a>
                        <a href="/user/out">退出登录</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <a href="/user/forwardLogin" style="margin-right:20px">登录</a>
                    <a href="/user/register">注册</a>
                </c:otherwise>
            </c:choose>


            <div class="row">
                <h3>新品推荐：</h3>
                <c:forEach items="${newProduct}" var="newproduct">
                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img alt="300x200" src="../${fn:substringAfter(newproduct.productPhoto,'/webapp/')}"
                                 width="100px" height="100px"/>
                            <div class="caption">
                                <h3>
                                        ${newproduct.productName}
                                </h3>
                                <p>
                                        ${newproduct.productDescription}
                                </p>
                                <p>
                                    <c:choose>
                                        <c:when test="${newproduct.productStock>0}">
                                            <a class="btn btn-primary"
                                               href="/user/buy?type=add&productBarCode=${newproduct.productBarCode}">加入购物车</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="btn btn-primary" href="JavaScript:void(0)">加入购物车</a>
                                        </c:otherwise>
                                    </c:choose>
                                    <span>价格：¥${newproduct.productPrice}，库存：${newproduct.productStock}件</span>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="row">
                <h3>特价商品推荐：</h3>
                <c:forEach items="${discountProduct}" var="discountproduct">
                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img alt="300x200" src="../${fn:substringAfter(discountproduct.productPhoto,'/webapp/')}"
                                 width="100px" height="100px"/>
                            <div class="caption">
                                <h3>
                                        ${discountproduct.productName}
                                </h3>
                                <p>
                                        ${discountproduct.productDescription}
                                </p>
                                <p>
                                    <c:choose>
                                        <c:when test="${discountproduct.productStock>0}">
                                            <a class="btn btn-primary"
                                               href="/user/buy?type=add&productBarCode=${discountproduct.productBarCode}">加入购物车</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="btn btn-primary" href="JavaScript:void(0)">加入购物车</a>
                                        </c:otherwise>
                                    </c:choose>
                                    <span>价格：¥${discountproduct.productPrice}，库存：${discountproduct.productStock}件</span>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>


            <div style="margin: 10px">
                <label>商品类别：</label>
                <select id="categoryName">
                    <c:forEach items="${categoryName}" var="category">
                        <c:choose>
                            <c:when test="${category eq currentName}">
                                <option value="${category}" selected>${category}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${category}">${category}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <label>排序方式：</label>
                <select id="role">
                    <option value="1">按价格从高到低</option>
                    <option value="2">按价格从低到高</option>
                </select>
                <label>价格区间：</label>
                <input type="text" id="start">
                <label>—</label>
                <input type="text" id="end">
                <button type="button" class="btn btn-sm" onclick="orderBy()">查询</button>
                <label>商品名称：</label>
                <input type="text" id="productName" name="productName">
                <button type="button" class="btn btn-sm" onclick="orderByName()">搜索商品</button>
            </div>
            <div class="row">
                <c:forEach items="${productList}" var="product">
                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img alt="300x200" src="../${fn:substringAfter(product.productPhoto,'/webapp/')}"
                                 width="100px" height="100px"/>
                            <div class="caption">
                                <h3>
                                        ${product.productName}
                                </h3>
                                <p>
                                        ${product.productDescription}
                                </p>
                                <p>
                                    <c:choose>
                                        <c:when test="${product.productStock>0}">
                                            <a class="btn btn-primary"
                                               href="/user/buy?type=add&productBarCode=${product.productBarCode}">加入购物车</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="btn btn-primary" href="JavaScript:void(0)">加入购物车</a>
                                        </c:otherwise>
                                    </c:choose>
                                    <span>价格：¥${product.productPrice}，库存：${product.productStock}件</span>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
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
                            <a href="/user/index?pageIndex=1">首页</a>
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
                            <a href="/user/index?pageIndex=${page.index-1}">上一页</a>
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
                                <a href="/user/index?pageIndex=${i}">${i}</a>
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
                            <a href="/user/index?pageIndex=${page.index+1}">下一页</a>
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
                            <a href="/user/index?pageIndex=${page.total}">尾页</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
