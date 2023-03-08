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

import cn.edu.hit.dao.SysuserDao;
import cn.edu.hit.dao.impl.SysuserDaoImpl;
import cn.edu.hit.entity.Sysuser;


@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public UserLoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset = utf-8");
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        SysuserDao dao=new SysuserDaoImpl();
        PrintWriter out = response.getWriter();
        if(dao.login(uname, pwd)) {
            //把用户名和密码保存到session（会话）中
            HttpSession session = request.getSession();
            session.setAttribute("uname", uname);
            session.setAttribute("pwd", pwd);
            Sysuser sur = new Sysuser();
            sur = dao.getByUname(uname);
            session.setAttribute("uid", sur.getUid());
            //把用户名和密码保存到浏览器的cookie中
            String remberme = request.getParameter("remberme");
            System.out.print(remberme);
            if(remberme != null && remberme.equals("1")) {
                Cookie cookieUname = new Cookie("uname", uname);
                Cookie cookiePwd = new Cookie("pwd", pwd);
                cookieUname.setMaxAge(7*24*60*60);
                cookiePwd.setMaxAge(7*24*60*60);
                response.addCookie(cookieUname);
                response.addCookie(cookiePwd);
            }
            response.sendRedirect("buygoods.jsp");
        }
        else {
            out.print("用户名或密码错误！");
        }
    }

}
