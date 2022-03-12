<%@ page import="java.util.List" %>
<%@ page import="com.fang.pojo.Brand" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 12291
  Date: 2022/3/2
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%
    List<Brand> brands = new ArrayList();
    brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
    brands.add(new Brand(2,"优衣库","优衣库",100,"优衣库服饰",1));
    brands.add(new Brand(3,"小米","小",100,"三只松鼠，好吃不上火",1));
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <%
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
    %>
    <tr align="center">
        <td><%=brand.getId()%></td>
        <td><%=brand.getBrandName()%></td>
        <td><%=brand.getCompanyName()%></td>
        <td><%=brand.getOrdered()%></td>
        <td><%=brand.getDescription()%></td>
        <td><%=brand.getStatus()%></td>
        <td><a href="#"> 修改</a></td>
        <td><a href="#"> 删除</a></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
