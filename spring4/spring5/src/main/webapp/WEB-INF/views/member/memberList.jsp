<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%
	List<Map<String,Object>>  memList =
		(List<Map<String,Object>>)request.getAttribute("memList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList</title>
</head>
<body>
<h1>memberList</h1>
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