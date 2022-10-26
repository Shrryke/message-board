package com.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Entity.User;

/**
 * Servlet Filter implementation class JudgeUserExist
 */
@WebFilter("/SubmitMessageServlet")
public class JudgeUserExist implements Filter {

    /**
     * Default constructor. 
     */
    public JudgeUserExist() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		//session检查，看session中是否有登录过的用户
		HttpSession session = request.getSession();
		// 我的登录方法中，登录成功就往session中存一个用户信息，key为login
		User user = (User) session.getAttribute("user");
		if (user == null) {
			// 没有就跳转到登录
			response.sendRedirect("logIn.jsp");
		}else{
			// 有就向下执行
			chain.doFilter(request, response);
		}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
