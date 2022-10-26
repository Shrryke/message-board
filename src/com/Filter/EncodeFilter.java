package com.Filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Entity.User;

import java.util.List;
import java.util.ArrayList;
/**
 * Servlet Filter implementation class EncodeFilter
 */

@WebFilter(filterName="EncodingFilter",urlPatterns="/*")
public class EncodeFilter implements Filter {
	private List<String> list = new ArrayList<String>();
    /**
     * Default constructor. 
     */
    public EncodeFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("过滤器构造");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤器销毁");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {

		System.out.println("过滤器正在过滤中");
		// 转化为我们习惯用的request和response对象(个人习惯)
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		// 设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		chain.doFilter(request, response);
		//获取传来的请求
//		String uri = request.getRequestURI();
//		// 对请求的字符串进行截取 例如http://localhost:8080/aaa/bbb.jsp中我们想要的请求字符串为bbb.jsp
//		uri = uri.substring(uri.lastIndexOf("/")+1);
//		System.out.println(uri);
//		// 放行登录注册界面和请求以及相对应的效验请求还有css样式！！！很多人加了过滤器没有放行样式所以导致样式都没了
//		// 解决方法放行样式：如下
//		if (uri.equals("logIn.jsp") || uri.equals("UserLogInServlet") ||uri.equals("register.jsp")||
//			 uri.equals("QueryAllMessageServlet")||uri.equals("index.jsp")||
//			uri.equals("UserRegisterServlet")||uri.equals("UserQuitServlet")||
//
//				uri.indexOf(".jfif") >0 || uri.indexOf(".jpg") > 0 ||
//				uri.indexOf(".jpeg") > 0 || uri.indexOf(".png") > 0 ||
//				uri.indexOf(".gif") > 0 || uri.indexOf(".css") > 0 ||
//				uri.indexOf("js") > 0) {
//			// 放行到下一个过滤器，如果是最后一个，跳转到对应请求处理方法
//			chain.doFilter(request, response);
//			return;
//		}
//		//session检查，看session中是否有登录过的用户
//		HttpSession session = request.getSession();
//		// 我的登录方法中，登录成功就往session中存一个用户信息，key为login
//		User user = (User) session.getAttribute("user");
//		if (user == null) {
//			// 没有就跳转到登录
//			response.sendRedirect("logIn.jsp");
//		}else{
//			// 有就向下执行
//			chain.doFilter(request, response);
//		}
//
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器初始化");
	}

}
