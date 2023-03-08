<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" import="cn.edu.hit.dao.*,cn.edu.hit.dao.impl.*,cn.edu.hit.entity.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf8">
  <title>用户信息管理系统</title>
  <style type="text/css">
    <!--
    .STYLE1 {font-size: x-large}
    -->
  </style>
</head>
<body>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p align="center" class="STYLE1">用户信息管理</p>
<hr>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div align="center">
  <%
    String adname=(String)session.getAttribute("adname");
	
    if(adname == null)
    {
      out.println("非法用户，禁止访问！");
      out.println("请<a href='login.jsp'>登陆</a>");
      return;
    }
    SysuserDao dao = new SysuserDaoImpl();
    List<Sysuser> list =dao.getAll("select * from sysuser");

    String uid;
    String uname;
    String pwd;
%>
</div>
<table border="1" align="center">
  <tr>
    <td width="43"><div align="center">用户ID</div></td>
    <td width="57"><div align="center">用户名</div></td>
    <td width="46"><div align="center">用户密码</div></td>
    <td width="34"><div align="center">修改</div></td>
    <td width="126"><div align="center">删除</div></td>
  <tr>
<%

for(Sysuser s:list){

    uid=s.getUid();
	uname=s.getUname();
	pwd=s.getPwd();

%>
<tr>
    <td><div align="center"><%=uid%></div></td><td><div align="center"><%=uname%></div></td><td><div align="center"><%=pwd%></div></td>
    <td><div align="center"><a href="modifyuser.jsp?uid=<%=uid%>">修改</a></div></td>
    <td><div align="center"><a onClick="return confirm('是否确定删除？')" href="UserServlet?from=remove&uid=<%=uid%>">删除</a></div></td>
  <tr>

<%
}
%>
</table>
</body>
</html>