<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"
    import="cn.edu.hit.dao.*,cn.edu.hit.dao.impl.*,cn.edu.hit.entity.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>教务处</title>
</head>
<body>
<%
String uname = (String)session.getAttribute("uname");
if(uname == null){
	out.println("非法用户，禁止访问!请<a href='userlogin.jsp'>登录</a>");
	return;
}
SysuserDao dao = new SysuserDaoImpl();
%>
<%
	int pageCount = dao.getPageCount();
	String sPageCount = request.getParameter("pageNum");
	if(sPageCount == null) sPageCount = "1";
	int pageNum = Integer.parseInt(sPageCount);
	List<OrderForm> list = dao.getAllOrder("select * from orderform limit " + ((pageNum - 1) * 5) + "," + 5);
	String oid, gid, time,uid;
	int num;
%>
<%
	if(pageNum == 1 && pageNum < pageCount){
%>
首页
上一页
<a href="findorderform.jsp?pageNum=<%=pageNum + 1%>">下一页</a> 
<a href="findorderform.jsp?pageNum=<%=pageCount%>">尾页</a>
<%
}
	else if(pageCount > 1 && pageNum == pageCount){
%>
<a href="findorderform.jsp?pageNum=1">首页</a>
<a href="findorderform.jsp?pageNum=<%=pageNum - 1%>">上一页</a> 
下一页
尾页
<%
	}
	else if(pageCount > 1 && pageNum < pageCount){
%>
<a href="findorderform.jsp?pageNum=1">首页</a>
<a href="findorderform.jsp?pageNum=<%=pageNum - 1%>">上一页</a> 
<a href="findorderform.jsp?pageNum=<%=pageNum + 1%>">下一页</a> 
<a href="findorderform.jsp?pageNum=<%=pageCount%>">尾页</a>
<%
	}
	else if(pageCount == 1 && pageNum == pageCount){
%>
首页
上一页
下一页
尾页
<%
	}
%>
</p>
<table border="1">
<tr>
	<td>订单号</td><td>商品ID</td><td>用户ID</td><td>商品数</td><td>时间</td>
</tr>
<% 
for(OrderForm s : list){
	oid = s.getOid();
	gid = s.getGid();
	uid = s.getUid();
	num = s.getNum();
	time = s.getTime();
%>
<tr>
	<td><%=oid%></td>
	<td><%=gid%></td>
	<td><%=uid%></td>
	<td><%=num%></td>
	<td><%=time%></td>
</tr>
<%
}
%>
</table>
</body>
</html>