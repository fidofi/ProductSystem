<%@ page contentType="text/html;charset=gbk" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>新增商品页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK" >
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h2 class="text-center">
                新增商品输入
            </h2>
        </div>
    </div>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="/product/save" method="post"  enctype="multipart/form-data">
                <div class="form-group">
                    <label >商品名称：</label><input type="text"  class="form-control" name="productName" style="width:160px;display: inline-block"/>
                    <label >商品单价：</label><input type="text" class="form-control" name="productPrice" style="width:80px;display: inline-block"/>
                </div>
                <div class="from-group">
                    <label>商品类别：</label>
                    <select  name="categoryCode">
                        <c:forEach items="${categoryName}" var="category">
                            <option value="${category}">${category}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group" >
                    <label>商品描述：</label>
                    <textarea class="form-control" rows="3" style="width: 300px;margin: 0 auto;display: inline-block" name="productDescription"></textarea>
                </div>
                <div class="form-group">
                    <label>上传图片：</label><input type="file" name="productPhoto" style="display: inline-block">
                    <p class="help-block">
                        请选择.jpg格式的图片
                    </p>
                </div>
                <button type="submit" class="btn btn-default" style="text-align: center">增加</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
