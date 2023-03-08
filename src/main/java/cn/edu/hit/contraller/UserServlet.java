package cn.edu.hit.contraller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hit.dao.SysuserDao;
import cn.edu.hit.dao.impl.SysuserDaoImpl;
import cn.edu.hit.entity.Sysuser;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from=request.getParameter("from");
        SysuserDao dao= (SysuserDao) new SysuserDaoImpl();
        if(from.equals("remove")) {
            String uid=request.getParameter("uid");
            dao.remove(uid);
        }
        response.sendRedirect("user.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        String from=request.getParameter("from");
        SysuserDao dao= (SysuserDao) new SysuserDaoImpl();
        if(from.equals("modify"))
        {
            String uid=request.getParameter("uid");
            String uname=request.getParameter("uname");
            String pwd=request.getParameter("pwd");
            dao.modify(new Sysuser(uid,uname,pwd));
        }else if(from.equals("remove")) {
            doGet(request,response);
        }


        response.sendRedirect("user.jsp");
	}

}
