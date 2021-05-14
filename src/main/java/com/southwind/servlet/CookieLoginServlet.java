package com.southwind.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieLogin")
public class CookieLoginServlet extends HttpServlet {
    private String myusername = "admin";
    private String mypassword = "123123";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equals(myusername) && password.equals(mypassword)){
            Cookie cookie = new Cookie("name",username);//实例化cookie对象
            cookie.setMaxAge(60*60*24*7);//目标cookie的有效时间定为7天且每次刷新页面都会重置有效期7天
            resp.addCookie(cookie);//添加cookie对象
            resp.sendRedirect("cookie_welcome.jsp");
        }else{
            resp.sendRedirect("cookie_login.jsp");
        }
    }
}
