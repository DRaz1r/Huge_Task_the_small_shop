package cn.edu.hit.contraller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hit.dao.GoodsDao;
import cn.edu.hit.dao.SysuserDao;
import cn.edu.hit.dao.impl.GoodsDaoImpl;
import cn.edu.hit.dao.impl.SysuserDaoImpl;
import cn.edu.hit.entity.Goods;

@WebServlet("/BuyGoodsServlet")
public class BuyGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuyGoodsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gid=request.getParameter("gid");
        int bnum=Integer.parseInt(request.getParameter("bnum"));
        //PrintWriter out = response.getWriter();
        //out.print(gid + bnum);
        SysuserDao dao = new SysuserDaoImpl();
        HttpSession session = request.getSession();
        String uid = (String)session.getAttribute("uid");
        dao.buyGoods(gid, uid, bnum);
        GoodsDao gdao = new GoodsDaoImpl();
        Goods gds = gdao.getByGid(gid);
        gds.setSnum(bnum + gds.getSnum());
        gdao.modify(gds);
        response.sendRedirect("buygoods.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
