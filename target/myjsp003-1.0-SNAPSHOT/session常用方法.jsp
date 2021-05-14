<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/14 0014
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //得到session会话窗口ID,不同浏览器不同ID,重新打开也刷新ID
    String sessionID = session.getId();
%>
<%="sessionID="+sessionID%>
<%
    //设置session最长失效时间,单位秒,记录账号密码等信息
    session.setMaxInactiveInterval(3600);
    //获取session最长失效时间
    int max = session.getMaxInactiveInterval();
    //设置session立即失效,主动退出时销毁密码
    //session.invalidate();
    //通过键值对存储/修改 数据
    session.setAttribute("key","value");
    //通过键获取对应数据
    session.getAttribute("key");
    //通过键删除对应数据
    session.removeAttribute("key");
%>
<br/>
<%="session最长失效时间"+max%>
</body>
</html>
