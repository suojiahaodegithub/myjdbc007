<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/14 0014
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/login" method="get">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</body>
</html>
