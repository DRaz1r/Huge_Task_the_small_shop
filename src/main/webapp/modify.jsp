<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"
		 import="cn.edu.hit.dao.*,cn.edu.hit.dao.impl.*,cn.edu.hit.entity.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>修改</title>
</head>
<body>

<p>
<%

		String adname=(String)session.getAttribute("adname");

		if(adname == null)
		{
			out.println("非法用户，禁止访问！");
			out.println("请<a href='login.jsp'>登陆</a>");
			return;
		}


		String gid=request.getParameter("gid");
		GoodsDao dao=new GoodsDaoImpl();
		Goods g=dao.getByGid(gid);
		String gname = g.getGname();
		String type=g.getType();
		int price=g.getPrice();

%>
</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<hr>
<p>&nbsp;</p>
<form action="GoodsServlet" method="post">
	<input type ="hidden" name = "from" value="modify" />



	<table border="1" align="center">
		<tr>
			<td>商品序号</td>
			<td><input type="text" name="gid" readonly value="<%=gid%>" /></td>
		</tr>
		<tr>
			<td>商品名</td>
			<td><input type="text" name="gname" value="<%=gname%>"/></td>
		</tr>
		<tr>
			<td>商品类型</td>
			<td><input type="text" name="type" value="<%=type%>"/></td>
		</tr>
		<tr>
			<td>商品价格</td>
			<td><input type="text" name="price" value="<%=price%>"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type ="submit" name="修改"/></td>
		</tr>
	</table>

</form>
</body>
</html>