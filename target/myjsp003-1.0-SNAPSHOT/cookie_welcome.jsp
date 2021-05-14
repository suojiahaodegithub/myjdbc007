<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/14 0014
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            //如果cookie数组中某个值等于输入的name即username
            // 之前有Cookie cookie = new Cookie("name",username);key-value
            if(cookie.getName().equals("name")){
                out.write("欢迎回来!"+cookie.getValue());
            }
        }
    %>

    <a href="/cookieLogout">退出登录</a>
</body>
</html>
