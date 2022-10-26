package com.Servlet;

import com.Entity.Message;
import com.Service.IMessageService;
import com.Service.Impl.MessageServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@WebServlet("/QueryMessageByIdServlet")
public class QueryMessageByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        IMessageService service=new MessageServiceImpl();
        Message message=service.queryMessageById(id);
        request.setAttribute("message",message);
        request.getRequestDispatcher("messageinfo.jsp" ).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
