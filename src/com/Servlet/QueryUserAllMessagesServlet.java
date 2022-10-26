package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Message;
import com.Entity.User;
import com.Service.IMessageService;
import com.Service.IUserService;
import com.Service.Impl.MessageServiceImpl;
import com.Service.Impl.UserServiceImpl;

/**
 * Servlet implementation class QueryUserAllMessagesServlet
 */
@WebServlet("/QueryUserAllMessagesServlet")
public class QueryUserAllMessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserAllMessagesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IMessageService mservice=new MessageServiceImpl();
		IUserService uservice=new UserServiceImpl();
		String account=request.getParameter("account");
		String numStr=request.getParameter("num");
		int num;
		if("null".equals(numStr)) {
			num=1;
		}
		else
			num=Integer.parseInt(numStr);
		//int num=Integer.parseInt(request.getParameter("num"));
		int MaxPage= mservice.GetUserMaxPage(account);
		if(num>MaxPage)
			num-=1;
		if(num<1)
			num+=1;
		List<Message> messages=mservice.queryUserAllMessages(account, num);
		User user=uservice.queryUserByAccount(account);
		request.setAttribute("message",messages);
		request.setAttribute("UserInfo",user);
		request.setAttribute("MaxPage", MaxPage);
		request.setAttribute("num",num);
		request.getRequestDispatcher("userInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
