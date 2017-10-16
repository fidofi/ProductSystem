<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>商品展示首页</title>
    <meta charset="utf-8">
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
<script type="application/javascript">
    //提交新增
    function create() {
        window.location.href="/product/create";
    }
    //提交查询
    function read() {
        var productBarCode=document.getElementById("productBarCode").value;
        var productName=document.getElementById("productName").value;
        window.location.href="/product"+"?productBarCode="+productBarCode+"&productName="+productName;
    }
</script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <h2 class="text-center">
            商品管理后台系统
        </h2>
        <c:if test="${user!=null}">
            <label>欢迎您，${user.userName},
             <c:choose>
                 <c:when test="${cookie.lastTime!=null}">
                     上次登录时间为${cookie.lastTime.value}
                 </c:when>
                 <c:otherwise>
                     您是第一次登录
                 </c:otherwise>
             </c:choose>
            </label>
        </c:if>
        <div style="float: right">
            <a href="/product/out">退出登录</a>
        </div>
        <div class="col-md-12 column">
            <div class="input-group input-group-sm" style="margin: 20px auto">
              <label style="margin-right: 30px;"><a href="/product/show">查看相关的数据图表</a></label>
               <strong>条形码：</strong><input type="text" id="productBarCode" name="productBarCode" placeholder="请输入条形码" style="margin-right: 20px">
                <strong>商品名称：</strong><input type="text" id="productName"name="productName" placeholder="请输入商品名称" style="margin-right: 20px">
                    <button type="button" class="btn btn-sm" onclick="read()">查询</button>
            </div>
            <table class="table table-bordered table-hover" style="text-align: center">
                <thead>
                <tr style="text-align: center">
                    <th>
                        商品条形码
                    </th>
                    <th>
                        商品名称
                    </th>
                    <th>
                        商品描述
                    </th>
                    <th>
                        商品单价
                    </th>
                    <th>
                        商品类目
                    </th>
                    <th>
                        商品库存
                    </th>
                    <th>
                        商品上架数量
                    </th>
                    <th>
                        商品图片
                    </th>
                    <th colspan="2" style="align: center">
                        操作
                    </th>

                </tr>
                </thead>
                <tbody>
                    <c:if test="${productList!=null}">
                        <c:forEach items="${productList}" var="product" varStatus="order">
                            <c:choose>
                                <c:when test="${order.index%2==0}">
                                    <tr class="success">
                                        <td>
                                                ${product.productBarCode}
                                        </td>
                                        <td>
                                                ${product.productName}
                                        </td>
                                        <td>
                                                ${product.productDescription}
                                        </td>
                                        <td>
                                                ${product.productPrice}
                                        </td>
                                        <td>
                                                ${product.categoryCode}
                                        </td>
                                        <td>
                                                ${product.productStock}
                                        </td>
                                        <td>

                                            ${product.originStock}
                                        </td>
                                        <td>
                                                <a href="/product/detail?productBarCode=${product.productBarCode}">查看详情</a>
                                        </td>
                                        <td>
                                                <a href="/product/update?productBarCode=${product.productBarCode}">修改</a>
                                        </td>
                                        <td>

                                                <a  href="/product/delete?productBarCode=${product.productBarCode}">删除</a>
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <tr >
                                        <td>
                                                ${product.productBarCode}
                                        </td>
                                        <td>
                                                ${product.productName}
                                        </td>
                                        <td>
                                                ${product.productDescription}
                                        </td>
                                        <td>
                                                ${product.productPrice}
                                        </td>
                                        <td>
                                                ${product.categoryCode}
                                        </td>
                                        <td>
                                                ${product.productStock}
                                        </td>
                                        <td>
                                              ${product.originStock}
                                        </td>
                                        <td>
                                            <a href="/product/detail?productBarCode=${product.productBarCode}" style="text-decoration: none">查看详情</a>
                                        </td>
                                        <td>
                                            <a href="/product/update?productBarCode=${product.productBarCode}" style="text-decoration: none">修改</a>
                                        </td>
                                        <td>
                                            <a  href="/product/delete?productBarCode=${product.productBarCode}" style="text-decoration: none">删除</a>
                                        </td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                    </c:if>
                </tbody>
            </table>
            <button type="button" class="btn btn-primary btn-sm" onclick="create()">新增商品</button>
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
                            <a href="/product?pageIndex=1">首页</a>
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
                        <a href="/product?pageIndex=${page.index-1}">上一页</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                 <c:forEach begin="1" end="${page.total}" var="i" >
                   <c:choose>
                       <c:when test="${i==page.index}">
                           <li class="disabled">
                               <a href="JavaScript:void(0)" class="disabled">${i}</a>
                           </li>
                       </c:when>
                       <c:otherwise>
                           <li>
                               <a href="/product?pageIndex=${i}">${i}</a>
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
                        <a href="/product?pageIndex=${page.index+1}">下一页</a>
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
                        <li >
                            <a href="/product?pageIndex=${page.total}">尾页</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
