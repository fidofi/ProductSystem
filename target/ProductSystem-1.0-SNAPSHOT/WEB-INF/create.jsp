<%@ page contentType="text/html;charset=gbk" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>新增商品页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK" >
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <!--表单校验-->
    <link href="../js/bootstrap.css" rel="stylesheet">
    <link href="../js/bootstrapValidator.css" rel="stylesheet">
    <script src="../js/bootstrap.js"></script>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrapValidator.js"></script>
   <script>
        <!--数据验证-->
        $(function () {
            $("#createProduct").bootstrapValidator({
                message:'This value is not valid',
//            定义未通过验证的状态图标
                feedbackIcons: {/*输入框不同状态，显示图片的样式*/
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                //字段验证
                fields:{
                    //商品名称
                    productName:{
                        message:'商品名称非法',
                        validators:{
//                        非空
                            notEmpty:{
                                message:'商品名不能为空'
                            },
//                        限制字符串长度
                            stringLength:{
                                min:2,
                                max:15,
                                message:'用户名长度必须位于2到10之间'
                            },
                        }
                    },
                    productPrice:{
                        validators:{
                            notEmpty: {message: '商品单价不能为空'},
                            numeric: {message: '商品单价只能输入数字'}
                        }
                    },
                    productDescription:{
                        validators:{
                            notEmpty: {message: '商品描述不能为空'},
                        }
                    },
                }
            });
        });
    </script>
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
            <form role="form" action="/product/save" method="post"  enctype="multipart/form-data" id="createProduct">
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
                    <label>商品上架数量：</label>
                    <input type="text" class="form-control" name="originStock" style="width:80px;display: inline-block"\>
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
