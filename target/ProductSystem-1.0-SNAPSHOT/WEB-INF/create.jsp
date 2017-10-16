<%@ page contentType="text/html;charset=gbk" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>������Ʒҳ��</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK" >
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <!--��У��-->
    <link href="../js/bootstrap.css" rel="stylesheet">
    <link href="../js/bootstrapValidator.css" rel="stylesheet">
    <script src="../js/bootstrap.js"></script>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrapValidator.js"></script>
   <script>
        <!--������֤-->
        $(function () {
            $("#createProduct").bootstrapValidator({
                message:'This value is not valid',
//            ����δͨ����֤��״̬ͼ��
                feedbackIcons: {/*�����ͬ״̬����ʾͼƬ����ʽ*/
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                //�ֶ���֤
                fields:{
                    //��Ʒ����
                    productName:{
                        message:'��Ʒ���ƷǷ�',
                        validators:{
//                        �ǿ�
                            notEmpty:{
                                message:'��Ʒ������Ϊ��'
                            },
//                        �����ַ�������
                            stringLength:{
                                min:2,
                                max:15,
                                message:'�û������ȱ���λ��2��10֮��'
                            },
                        }
                    },
                    productPrice:{
                        validators:{
                            notEmpty: {message: '��Ʒ���۲���Ϊ��'},
                            numeric: {message: '��Ʒ����ֻ����������'}
                        }
                    },
                    productDescription:{
                        validators:{
                            notEmpty: {message: '��Ʒ��������Ϊ��'},
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
                ������Ʒ����
            </h2>
        </div>
    </div>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="/product/save" method="post"  enctype="multipart/form-data" id="createProduct">
                <div class="form-group">
                    <label >��Ʒ���ƣ�</label><input type="text"  class="form-control" name="productName" style="width:160px;display: inline-block"/>
                    <label >��Ʒ���ۣ�</label><input type="text" class="form-control" name="productPrice" style="width:80px;display: inline-block"/>
                </div>
                <div class="from-group">
                    <label>��Ʒ���</label>
                    <select  name="categoryCode">
                        <c:forEach items="${categoryName}" var="category">
                            <option value="${category}">${category}</option>
                        </c:forEach>
                    </select>
                    <label>��Ʒ�ϼ�������</label>
                    <input type="text" class="form-control" name="originStock" style="width:80px;display: inline-block"\>
                </div>
                <div class="form-group" >
                    <label>��Ʒ������</label>
                    <textarea class="form-control" rows="3" style="width: 300px;margin: 0 auto;display: inline-block" name="productDescription"></textarea>
                </div>
                <div class="form-group">
                    <label>�ϴ�ͼƬ��</label><input type="file" name="productPhoto" style="display: inline-block">
                    <p class="help-block">
                        ��ѡ��.jpg��ʽ��ͼƬ
                    </p>
                </div>
                <button type="submit" class="btn btn-default" style="text-align: center">����</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
