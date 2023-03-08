<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" import="cn.edu.hit.dao.*,cn.edu.hit.dao.impl.*,cn.edu.hit.entity.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf8">
  <title>欢迎光临商城</title>
  <style type="text/css">
    <!--
    .STYLE1 {font-size: x-large}
    -->
  </style>
</head>
<body>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p align="center" class="STYLE1">商品信息管理</p>
<hr>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div align="center">
  <%
    String uname=(String)session.getAttribute("uname");

    if(uname == null)
    {
      out.println("非法用户，禁止访问！");
      out.println("请<a href='Userlogin.jsp'>登陆</a>");
      return;
    }
    GoodsDao dao = new GoodsDaoImpl();
    List<Goods> list =dao.getAll("select * from goods");
    String gid;
    String gname;
    int pnum;
    int snum;
    String type;
    int price;
  %>

  <a href="">查看购物车</a>

</div>
<table border="1" align="center">
  <tr>
    <td width="57"><div align="center">商品名</div></td>
    <td width="46"><div align="center">Pnum</div></td>
    <td width="74"><div align="center">Snum</div></td>
    <td width="54"><div align="center">类型</div></td>
    <td width="36"><div align="center">价格</div></td>
  <tr>


      <%

for(Goods s:list){
    gid=s.getGid();
	gname=s.getGname();
	pnum=s.getPnum();
	snum=s.getSnum();
	type=s.getType();
	price=s.getPrice();


%>
  <tr>

  <td><div align="center"><%=gid%></div></td>

  </td><td><div align="center"><%=gname%></div></td><td><div align="center"><%=pnum%></div></td><td><div align="center"><%=snum%></div></td>
    <td><div align="center"><%=type%></div></td>
    <td><div align="center"><%=price%></div></td>

    <td><div align="center"><a onClick="return confirm('是否确定加入？')" href="GoodsServlet?from=remove&gid=<%=gid%>">加入购物车</a></div></td>
  <tr>

      <%
}
%>
</table>
</body>
</html>