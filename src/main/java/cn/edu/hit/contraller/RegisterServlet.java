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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("username");
        String pwd = request.getParameter("password");

        SysuserDao dao=new SysuserDaoImpl();

        String uid=dao.register(uname,pwd);

        PrintWriter out = response.getWriter();
        out.print("注册成功："+uid);
        response.sendRedirect("userlogin.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}