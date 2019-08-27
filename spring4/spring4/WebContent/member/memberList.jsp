<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%
	//req, res로 접근
	List<Map<String,Object>>  memList =
		(List<Map<String,Object>>)request.getAttribute("memList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList : WebContent </title>
</head>
<body>
<h1>Open : [WebContent] memberList.jsp</h1>
<br>
<h3> → request/response 를 통해서 접근</h3>
<br>
<br>
<%
	for(int i=0;i<memList.size();i++){
		out.println(memList.get(i));
%>
<br>
<%
	}
%>

</body>
</html>