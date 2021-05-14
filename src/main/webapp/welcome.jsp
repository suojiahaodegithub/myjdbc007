<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/14 0014
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Welcome</h1>
    <%
        request.setCharacterEncoding("gbk");
    %>
    欢迎回来!<%=session.getAttribute("username")%>
    </br>
    <a href="/logout">退出登录</a>
</body>
</html>
