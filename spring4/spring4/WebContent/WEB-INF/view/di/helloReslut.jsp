<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP페이지</title>
</head>
<body>
<%
	List<String> nameList = 
		(List<String>)request.getAttribute("nameList");
	out.print(nameList.size());
	out.print(nameList);
%>
</body>
</html>