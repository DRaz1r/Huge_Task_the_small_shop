package cn.edu.hit.contraller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hit.dao.GoodsDao;
import cn.edu.hit.dao.impl.GoodsDaoImpl;
import cn.edu.hit.entity.Goods;


@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public GoodsServlet() {
        super();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");


        String from=request.getParameter("from");
        GoodsDao dao= (GoodsDao) new GoodsDaoImpl();
        if(from.equals("add")) {
            String gid=request.getParameter("gid");
            String gname=request.getParameter("gname");
            String type=request.getParameter("type");
            int price =Integer.parseInt(request.getParameter("price"));
            dao.add(new Goods(gid,gname,0,0,type,price));
        }else if(from.equals("modify"))
        {
            String gid=request.getParameter("gid");
            String gname=request.getParameter("gname");
            String type=request.getParameter("type");
            int price=Integer.parseInt(request.getParameter("price"));
            Goods gds = dao.getByGid(gid);
            dao.modify(new Goods(gid,gname,gds.getPnum(),gds.getSnum(),type,price));
        }else if(from.equals("remove")) {
            doGet(request,response);
        }


        response.sendRedirect("index.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String from=request.getParameter("from");
        GoodsDao dao= (GoodsDao) new GoodsDaoImpl();
        if(from.equals("remove")) {
            String gid=request.getParameter("gid");
            dao.remove(gid);
        }
        response.sendRedirect("index.jsp");
    }

}