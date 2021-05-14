package com.southwind.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //为初始化参数定义全局变量
    private String myusername;
    private String mypassword;
    @Override
    public void init(ServletConfig config) throws ServletException {
        myusername = config.getInitParameter("username");//得到初始化username
        mypassword = config.getInitParameter("password");//得到初始化password
    }

    @Override//表单methou="get"时调用doGet方法
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");//得到传进来的username
        String password = req.getParameter("password");//得到传进来的password


        //将初始化的myusername,mypassword与传进来的username和password比较
        if(username.equals(myusername) && password.equals(mypassword)){
            //登陆成功,进入首页
            //req.setAttribute("username",username);跳转过去后生命周期结束,再次访问welcome需要重新登录
            //得到session对象,浏览器中再次访问welcome页面不会失效
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            //设置最长失效时间,单位秒
            session.setMaxInactiveInterval(3000);
            //由于使用了session保存信息,所以转发和重定向都可以
            req.getRequestDispatcher("welcome.jsp").forward(req,resp);//转发
            //resp.sendRedirect("welcome.jsp");//重定向
        }else{
            //登陆失败,返回登陆页面
            resp.sendRedirect("login.jsp");
        }

        /**
        * 不能在转发之前调用resp.getWriter().writer()方法,否则welcome页面中文回显示问号?
         * 但是可以在转发之后调用,但是此时调用页面已经调转过去,没有意义*/
        //传进来的username和password输出到网页上
        resp.getWriter().write(username);
        resp.getWriter().write(password);
    }

    @Override//表单methou="post"时调用doPost方法
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");//得到传进来的username
//        String password = req.getParameter("password");//得到传进来的password
//        resp.getWriter().write(username);
//        resp.getWriter().write(password);
//        //将初始化的myusername,mypassword与传进来的username和password比较
//        if(username.equals(myusername) && password.equals(mypassword)){
//            //登陆成功,进入首页
//            //req.setAttribute("username",username);跳转过去后生命周期结束,再次访问welcome需要重新登录
//            //得到session对象,浏览器中再次访问welcome页面不会失效
//            HttpSession session = req.getSession();
//            session.setAttribute("username",username);
//            req.getRequestDispatcher("/welcome.jsp").forward(req,resp);
//        }else{
//            //登陆失败,返回登陆页面
//            resp.sendRedirect("login.jsp");
//        }
    }
}
