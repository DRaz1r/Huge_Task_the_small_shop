<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>添加商品</title>
</head>
<body>
  <%
    String adname=(String)session.getAttribute("adname");
	
    if(adname == null)
    {
      out.println("非法用户，禁止访问！");
      out.println("请<a href='login.jsp'>登陆</a>");
      return;
    }
%>
<form action="GoodsServlet" method="post">

	<p>
		<input type ="hidden" name = "from" value="add" />
	</p>
	<p>&nbsp;</p>
	<p>、</p>
	<p>&nbsp;</p>
	<hr>
	<p>&nbsp;</p>
	<table width="294" height="223" border="1" align="center">
		<tr>
			<td>商品序号</td>
			<td><input name="gid" type="text" id="gid"/></td>
		</tr>
		<tr>
			<td>商品名</td>
			<td><input name="gname" type="text" id="gname"/></td>
		</tr>
		<tr>
			<td>商品类型</td>
			<td><input name="type" type="text" id="type"/></td>
		</tr>
		<tr>
			<td height="44">商品价格</td>
			<td><input name="price" type="text" id="price"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type ="submit"/></td>
		</tr>
  </table>

</form>
</body>
</html>