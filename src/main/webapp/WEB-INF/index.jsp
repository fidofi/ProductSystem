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
        <div class="col-md-12 column">
            <div class="input-group input-group-sm" style="margin: 20px auto">
                条形码：<input type="text" id="productBarCode" name="productBarCode" placeholder="请输入条形码" style="margin-right: 20px">
                商品名称：<input type="text" id="productName"name="productName" placeholder="请输入商品名称" style="margin-right: 20px">
                    <button type="button" class="btn btn-sm" onclick="read()">查询</button>
            </div>
            <table class="table">
                <thead>
                <tr>
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
                        商品图片
                    </th>
                    <th colspan="2" style="align: center">
                        操作
                    </th>

                </tr>
                </thead>
                <tbody>
                    <c:if test="${productList!=null}">
                        <c:forEach items="${productList}" var="product">
                            <tr>
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
                                        ${product.productPhoto}
                                </td>
                                <td>
                                    <a href="/product/update?productBarCode=${product.productBarCode}">修改</a>
                                </td>
                                <td>
                                    <a  href="/product/delete?productBarCode=${product.productBarCode}">删除</a>
                                </td>
                            </tr>

                        </c:forEach>

                    </c:if>
                </tbody>
            </table>
            <button type="button" class="btn btn-primary btn-sm" onclick="create()">新增商品</button>
            <nav style="text-align: center">
            <ul class="pagination">
                <li>
                    <a href="/product?pageIndex=1&productBarCode=${productBarCode}&productName=${productName}">首页</a>
                </li>
                <li>
                    <a href="/product?pageIndex=${page.index-1}&productBarCode=${productBarCode}&productName=${productName}">上一页</a>
                </li>
                 <c:forEach begin="1" end="${page.total}" var="i" >
                     <li>
                         <a href="/product?pageIndex=${i}&productBarCode=${productBarCode}&productName=${productName}">${i}</a>
                     </li>
                 </c:forEach>
                <li>
                <a href="/product?pageIndex=${page.index+1}&productBarCode=${productBarCode}&productName=${productName}"">下一页</a>
            </li>
                <li>
                    <a href="/product?pageIndex=${page.total}&productBarCode=${productBarCode}&productName=${productName}">尾页</a>
                </li>
            </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
