<%@ page import="com.fidofi.vo.CategoryAndCountVO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品的数据图表</title>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="../js/echarts.min.js"></script>
</head>
<body>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var categoryName = new Array();
    var categorySell = new Array();
    <%
       List<CategoryAndCountVO> categoryAndCountVOList=(List<CategoryAndCountVO>)request.getAttribute("categoryList");
       for(int i=0;i<categoryAndCountVOList.size();i++){
               %>
    categoryName[<%=i%>] = '<%=categoryAndCountVOList.get(i).getCategoryCode()%>'
    categorySell[<%=i%>] = '<%=categoryAndCountVOList.get(i).getSell()%>'
    <%
       }
       %>
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '商品后台管理系统数据'
        },
        tooltip: {},
        legend: {
            data: ['销量']
        },
        xAxis: {
            data: categoryName
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: categorySell
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>
