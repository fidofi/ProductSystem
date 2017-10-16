<%@ page import="com.fidofi.vo.ProductVO" %>
<%@ page contentType="text/html;charset=gbk" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>商品详情页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK" >
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                商品详情
            </h3>
        </div>
    </div>
</div>
<div class="container" style="text-align: center">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div >
                <div class="form-group">
                    <label>商品名称：</label><b  class="text-info">${productVO.productName}</b>
                    <hr align=center width=300 color=#777 size=1>
                    <label>商品单价：</label><b  class="text-info">${productVO.productPrice}元</b>
                </div>
                <hr align=center width=300 color=#777 size=1>
                <div class="from-group">
                    <label>商品上架数量：</label><b  class="text-info">${productVO.originStock}</b>
                    <label>商品库存：</label><b  class="text-info">${productVO.productStock}</b>
                </div>
                <hr align=center width=300 color=#777 size=1>
                <div class="from-group">
                    <label>商品类别：</label><b  class="text-info">${productVO.categoryCode}</b>
                </div>
                <hr align=center width=300 color=#777 size=1>
                <div class="form-group" >
                    <label>商品描述：</label>
                    <b  class="text-info">${productVO.productDescription}</b>
                </div>
                <hr align=center width=300 color=#777 size=1>
                <div class="form-group" >
                    <label>商品图片：</label>
                    <img alt="商品图片" src="../${fn:substringAfter(productVO.productPhoto,'/webapp/')}" class="img-thumbnail" width="250px"/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
