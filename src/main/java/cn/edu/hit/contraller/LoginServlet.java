package cn.edu.hit.contraller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hit.dao.loginDao;
import cn.edu.hit.dao.impl.loginDaoImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		String adname = request.getParameter("adname");
		String adpwd = request.getParameter("adpwd");
		loginDao dao = new loginDaoImpl();
		PrintWriter out = response.getWriter();
		if(dao.login(adname, adpwd)) {
			//把用户名和密码保存到session（会话）中
			HttpSession session = request.getSession();
			session.setAttribute("adname", adname);
			session.setAttribute("adpwd", adpwd);
			//把用户名和密码保存到浏览器的cookie中
			String remberme = request.getParameter("remberme");
			System.out.print(remberme);
			if(remberme != null && remberme.equals("1")) {
				Cookie cookieAdname = new Cookie("adname", adname);
				Cookie cookieAdpwd = new Cookie("pwd", adpwd);
				cookieAdname.setMaxAge(7*24*60*60);
				cookieAdpwd.setMaxAge(7*24*60*60);
				response.addCookie(cookieAdname);
				response.addCookie(cookieAdpwd);
			}
			response.sendRedirect("index.jsp");
		}
		else {
			out.print("用户名或密码错误！");
		}
	}

}
