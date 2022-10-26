package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Message;
import com.Service.IMessageService;
import com.Service.Impl.MessageServiceImpl;

/**
 * Servlet implementation class QueryAllMessageServlet
 */
@WebServlet("/QueryAllMessageServlet")
public class QueryAllMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IMessageService service=new MessageServiceImpl();
		String numStr=request.getParameter("num");
		int num;
		if("null".equals(numStr)) {
			num=1;
		}
		else
			num=Integer.parseInt(numStr);
		//int num=Integer.parseInt(request.getParameter("num"));
		int MaxPage= service.GetMaxPage();
		if(num>MaxPage)
			num-=1;
		if(num<1)
			num+=1;
		List<Message> messages=service.queryAllMessages(num);
		request.setAttribute("MaxPage", MaxPage);
		request.setAttribute("message",messages);
		request.setAttribute("num",num);
		request.getRequestDispatcher("liuyan.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
