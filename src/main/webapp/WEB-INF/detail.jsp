<%@ page import="com.fidofi.vo.ProductVO" %>
<%@ page contentType="text/html;charset=gbk" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>��Ʒ����ҳ��</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK" >
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                ��Ʒ����
            </h3>
        </div>
    </div>
</div>
<div class="container" style="text-align: center">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div >
                <div class="form-group">
                    <label>��Ʒ���ƣ�</label><b  class="text-info">${productVO.productName}</b>
                    <hr align=center width=300 color=#777 size=1>
                    <label>��Ʒ���ۣ�</label><b  class="text-info">${productVO.productPrice}Ԫ</b>
                </div>
                <hr align=center width=300 color=#777 size=1>
                <div class="from-group">
                    <label>��Ʒ�ϼ�������</label><b  class="text-info">${productVO.originStock}</b>
                    <label>��Ʒ��棺</label><b  class="text-info">${productVO.productStock}</b>
                </div>
                <hr align=center width=300 color=#777 size=1>
                <div class="from-group">
                    <label>��Ʒ���</label><b  class="text-info">${productVO.categoryCode}</b>
                </div>
                <hr align=center width=300 color=#777 size=1>
                <div class="form-group" >
                    <label>��Ʒ������</label>
                    <b  class="text-info">${productVO.productDescription}</b>
                </div>
                <hr align=center width=300 color=#777 size=1>
                <div class="form-group" >
                    <label>��ƷͼƬ��</label>
                    <img alt="��ƷͼƬ" src="../${fn:substringAfter(productVO.productPhoto,'/webapp/')}" class="img-thumbnail" width="250px"/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
