package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Message;
import com.Service.IMessageService;
import com.Service.IUserService;
import com.Service.Impl.MessageServiceImpl;
import com.Service.Impl.UserServiceImpl;

/**
 * Servlet implementation class DelelteMessageById
 */
@WebServlet("/DeleteMessageById")
public class DeleteMessageById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMessageById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		IMessageService service=new MessageServiceImpl();
		response.setContentType("text/html;charset=utf-8");
		if(service.deleteMessageById(id)) {
			response.sendRedirect("QueryAllMessageServlet?num=1");
		}else {
			response.getWriter().println("删除失败!<br><a href='index.jsp'>返回首页</a>");
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
