<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/14 0014
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--cookie存在于浏览器,即便停止服务器,cookie也会继续存在浏览器-->
<!--session存在服务器,服务器停止,保存的信息就会销毁-->
<%
    //创建Cookie//如果key一样,value会覆盖
    Cookie cookie = new Cookie("name","lisi");
    response.addCookie(cookie);//添加cookie
    //提取cookie
    Cookie[] cookies = request.getCookies();
    out.write("cookie中保存的信息有:"+"<br/>");
    for(Cookie cookie1:cookies){
        out.write(cookie1.getName()+":"+cookie1.getValue()+"<br/>");
    }
%>
<%
    //cookie常用方法
    //设置cookie的有效时间,单位秒
    //cookie.setMaxAge(-1);
    //获取cookie的有效时间
    // 默认有效时间-1,只要关闭浏览器添加的cookie就会销毁
    //如果设置有效时间没有过完,就算关闭浏览器记录仍然保存(一般用作播放记录,下次打开浏览器仍然存在)
    int cook = cookie.getMaxAge();
    out.write("cook有效时间为"+cook);
    //获取cookie的名称
    cookie.getName();
    //获取cookie的值
    cookie.getValue();
%>


</body>
</html>
