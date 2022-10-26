package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.User;
import com.Service.IUserService;
import com.Service.Impl.UserServiceImpl;

/**
 * Servlet implementation class UpdateMyInfoServlet
 */
@WebServlet("/UpdateMyInfoServlet")
public class UpdateMyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String uaccount=request.getParameter("uaccount");
		String upassword=request.getParameter("upassword");
		User newUser=new User(username,uaccount,upassword,null);
		User oldUser=(User)request.getSession().getAttribute("user");
		IUserService service=new UserServiceImpl();
		response.setContentType("text/html;charset=utf-8");
		if(service.UpdateMyInfo(oldUser, newUser)) {
			newUser.setImage(oldUser.getImage());
			request.getSession().setAttribute("user",newUser);
			response.sendRedirect("myInfo.jsp");
		}else {
			response.getWriter().println("修改失败!<br><a href='myInfo.jsp'>返回</a>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
