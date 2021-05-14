package com.southwind.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieLogout")
public class CookieLogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁coookie,就是把cookie的有效时间变为0
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("name")){
                //把目标cookie的有效时间设置为0
                cookie.setMaxAge(0);
                //把cookie重新添加进去,不然设置的0秒无效
                resp.addCookie(cookie);
                //返回登陆页面
                resp.sendRedirect("cookie_login.jsp");
            }
        }
    }
}
