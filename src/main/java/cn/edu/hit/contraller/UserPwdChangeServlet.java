package cn.edu.hit.contraller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hit.dao.SysuserDao;
import cn.edu.hit.dao.impl.SysuserDaoImpl;

@WebServlet("/UserPwdChangeServlet")
public class UserPwdChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserPwdChangeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");
		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		SysuserDao dao = new SysuserDaoImpl();
		if(dao.modifyPwd(uname, oldpwd, newpwd)) {
			PrintWriter out = response.getWriter();
	        out.print("修改成功");
		}
		else {
			PrintWriter out = response.getWriter();
	        out.print("修改失败。用户不存在。");
		}
		response.sendRedirect("userlogin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


