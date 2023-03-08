package cn.edu.hit.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{
	 
		//需要定义系统页面访问中可放行的连接
		private List<String> list = new ArrayList<String>();
		public void init(FilterConfig arg0) throws ServletException {
			list.add("/userlogin.jsp");
			list.add("/regist.jsp");
			list.add("/userpwdchange.jsp");
			list.add("/login.jsp");
			//list.add("/image.jsp");
			//list.add("/system/elecMenuAction_home.do");     //定义不被拦截的页面
		}
	 
		public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
				FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			//1、获取页面中的访问的路径连接
			String path = request.getServletPath();
			if(list!=null && list.contains(path)){
				//如果页面中获取的访问连接于定义的可放行的连接一致，则放行
				chain.doFilter(request, response);
				return;
			}
			//2、从session(globle_user)对象中获取当前登录的用户
			String uid = (String)request.getSession().getAttribute("uid");
			String adname = (String)request.getSession().getAttribute("adname");
			if(uid != null){
				//如果从session中获取的用户对象不为空，则放行
				chain.doFilter(request, response);
				return;
			}
			if(adname != null){
				//如果从session中获取的用户对象不为空，则放行
				chain.doFilter(request, response);
				return;
			}
			//如果不满足条件1和2，则不能放行，回到系统的登录页面
			response.sendRedirect("login.jsp/");
		}
	 
		public void destroy() {
			
	 
		}
	}