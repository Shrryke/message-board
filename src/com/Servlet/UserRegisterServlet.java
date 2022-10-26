package com.Servlet;

import com.Dao.IUserDao;
import com.Entity.User;
import com.Service.IUserService;
import com.Service.Impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserRegisterServlet", value = "/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	String uname=request.getParameter("uname");
    	String uaccount=request.getParameter("uaccount");
        String upassword=request.getParameter("upassword");
        User user=new User(uname,uaccount,upassword,"images/1.jpg");
        IUserService service=new UserServiceImpl();
        boolean result=service.addUser(user);
        response.setContentType("text/html;charset=utf-8");
        if(result){
            response.getWriter().println("注册成功<br><a href='logIn.jsp'>前往登录</a>");
        }else{
            response.getWriter().println("账号已经存在<br>注册失败<br><a href='register.jsp'>返回重新注册</a>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
