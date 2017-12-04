<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>用户购物车</title>
    <script type="text/javascript">
        function add(productBarCode) {
          window.location.href="/user/buy?type=add&productBarCode="+productBarCode;
        }
        function  sub(productBarCode) {
            window.location.href="/user/buy?type=sub&productBarCode="+productBarCode;
        }
        //清空购物车
        function clean() {
            window.location.href="/user/buy/cleanCard";
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <c:choose>
                <c:when test="${card.map!=null}">
                <div class="media">
                    <c:forEach items="${card.productMap}" var="entry">
                        <div class="media-body">
                            <img src="../${fn:substringAfter(entry.getKey().productPhoto,'/webapp/')}" height="50" width="50" class="media-object"/>
                            <h4 class="media-heading">
                                商品名称：${entry.getKey().productName}
                            </h4>
                            <h5>
                                商品描述：${entry.getKey().productDescription}
                                商品单价：¥${entry.getKey().productPrice}
                            </h5>
                            <button type="button" name="add" class="btn btn-sm" value="+" onclick="add(${entry.getKey().productBarCode})">+</button>
                            数量：${entry.getValue()}
                            <button type="button" name="sub" class="btn btn-sm" value="-" onclick="sub(${entry.getKey().productBarCode})">-</button>
                        </div>
                    </c:forEach>
                </div>
                <button type="button" name="clean" class="btn btn-sm"  onclick="clean()">清空购物车</button>
                <h2>总金额为:${card.moneyNum}</h2>
        </div>
                </c:when>
                <c:otherwise>
                    您的购物车为空！
                </c:otherwise>
            </c:choose>
    </div>
</div>
</body>
</html>
