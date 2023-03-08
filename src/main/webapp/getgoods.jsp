<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" import="cn.edu.hit.dao.*,cn.edu.hit.dao.impl.*,cn.edu.hit.entity.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf8">
  <title>进货系统</title>
  <style type="text/css">
    <!--
    .STYLE1 {font-size: x-large}
    -->
  </style>
</head>
<body>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p align="center" class="STYLE1">进货管理</p>
<hr>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div align="center">
<%
    String uname=(String)session.getAttribute("uname");
	
    if(uname == null)
    {
     out.println("非法用户，禁止访问！");
     out.println("请<a href='login.jsp'>登陆</a>");
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


</div>
<form action="GetGoodsServlet" method="post">
<table border="1" align="center">
  <tr>
    <td width="43"><div align="center">商品序号</div></td>
    <td width="57"><div align="center">商品名</div></td>
    <td width="54"><div align="center">类型</div></td>
    <td width="36"><div align="center">价格</div></td>
    <td width="34"><div align="center">进货数量</div></td>
    <td width="126"><div align="center">进货</div></td>
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
    <td><input type="text" name="gid" readonly value="<%=gid%>" /></td>
    <td><div align="center"><%=gname%></div></td>
    <td><div align="center"><%=type%></div></td>
    <td><div align="center"><%=price%></div></td>
	<td><input type="text" name="gnum"/></td>
    <td><input type ="submit" name="进货"/></td>
  <tr>

<%
}
%>
</table>
</form>
</body>
</html>