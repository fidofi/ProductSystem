<%@ page import="com.fidofi.vo.ProductVO" %>
<%@ page contentType="text/html;charset=gbk" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>商品更新页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK" >
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h2 class="text-center">
               商品更新输入
            </h2>
        </div>
    </div>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" method="post" enctype="multipart/form-data" action="/update/submit">
                <div class="form-group">
                    <label>商品名称：</label><input type="text"  class="form-control" name="productName" style="width:160px;display: inline-block" value="${product.productName}"/>
                    <label>商品单价：</label><input type="text" class="form-control" name="productPrice"style="width:80px;display: inline-block" value="${product.productPrice}"/>
                </div>
               <div class="from-group">
                   <label>商品类别：</label>
                       <select  name="categoryCode">
                           <c:forEach items="${categoryName}" var="category">

                               <c:choose>
                                   <c:when test="${category==product.categoryCode}">
                                       <option value="${category}"selected>${category}</option>
                                   </c:when>
                                   <c:otherwise>
                                       <option value="${category}">${category}</option>
                                   </c:otherwise>
                               </c:choose>
                           </c:forEach>
                       </select>
               </div>
                <div class="form-group" >
                    <label>商品描述：</label>
                    <textarea name="productDescription" class="form-control" rows="3" style="width: 300px;margin: 0 auto;display: inline-block" >${product.productDescription}</textarea>
                </div>
                <div class="form-group" >
                    <label>商品图片：</label>
                    <img alt="商品图片" src="../${fn:substringAfter(product.productPhoto,'/webapp/')}" width="200px" height="200px;"/>
                </div>
                <div class="form-group">
                <label>上传图片：</label><input type="file" name="productPhoto" style="display: inline-block">
                <p class="help-block">
                    请选择.jpg格式的图片
                </p>
            </div>
             <button type="submit" class="btn btn-default" style="text-align: center">更新</button>
            </form>
            <%
                session.setAttribute("productBarCode",request.getParameter("productBarCode"));
            %>
    </div>
</div>
</div>
</body>
</html>