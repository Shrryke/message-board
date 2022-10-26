package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.IUserDao;
import com.Entity.User;
import com.Service.IUserService;
import com.Service.Impl.UserServiceImpl;

/**
 * Servlet implementation class userLogInServlet
 */
@WebServlet("/UserLogInServlet")
public class UserLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("uaccount");
		String password=request.getParameter("upassword");
		User user=new User(null,account,password,null);
		IUserService userService=new UserServiceImpl();
		user=userService.logIn(user);
		response.setContentType("text/html;charset=utf-8");
		

		
		if(user!=null) {
			request.getSession().setAttribute("user",user);
			response.sendRedirect("index.jsp");
		}else {
			response.getWriter().println("账号不存在或者密码错误!<br><a href='logIn.jsp'>返回重新登录</a>");
		}
	}

}
