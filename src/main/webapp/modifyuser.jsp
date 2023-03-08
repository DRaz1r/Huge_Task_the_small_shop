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


		String uid=request.getParameter("uid");
		SysuserDao dao=new SysuserDaoImpl();
		Sysuser g=dao.getByUid(uid);
		String uname = g.getUname();
		String pwd = g.getPwd();
%>
</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<hr>
<p>&nbsp;</p>
<form action="UserServlet" method="post">
	<input type ="hidden" name = "from" value="modify" />



	<table border="1" align="center">
		<tr>
			<td>用户ID</td>
			<td><input type="text" name="uid" readonly value="<%=uid%>" /></td>
		</tr>
		<tr>
			<td>用户名</td>
			<td><input type="text" name="uname" value="<%=uname%>"/></td>
		</tr>
		<tr>
			<td>用户密码</td>
			<td><input type="text" name="pwd" value="<%=pwd%>"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type ="submit" name="修改"/></td>
		</tr>
	</table>

</form>
</body>
</html>