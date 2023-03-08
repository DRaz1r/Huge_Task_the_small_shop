<%@ page language="java" contentType="text/html; charset=utf8"
		 pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf8">
	<title>登陆商城管理系统</title>
	<style type="text/css">
		<!--
		.STYLE1 {font-size: x-large}
		-->
	</style>
</head>
<body>
<p>
	<%
		Cookie[] cc=request.getCookies();
		String adname="";
		String adpwd="";
		for(Cookie c:cc){
			if(c.getName().equals("adname")){
				adname=c.getValue();
			}
			if(c.getName().equals("adpwd")){
				adpwd=c.getValue();

			}
		}
	%>
</p>
<p>&nbsp;</p>
<p align="center" class="STYLE1">请登陆：</p>
<hr>
<p>&nbsp;</p>
<p>&nbsp;</p>
<form action="LoginServlet" method="post">
	<table border="1" align="center">
		<tr>
			<td>用户名</td>
			<td><input type="text" name="adname" value="<%=adname%>"/></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="adpwd" value="<%=adpwd%>" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type ="submit" value ="登陆"/>
				<input type ="checkbox" name="remberme" value="1"/>记住我

			</td>
		</tr>
	</table>

</form>

<div align="center">
	<b><a href="userlogin.jsp">用户登录</a></b>&nbsp;
</div>
</body>
</html>