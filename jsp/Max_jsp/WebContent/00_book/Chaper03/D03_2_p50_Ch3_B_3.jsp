<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>받는 JSP</title>
</head>
<body>
	<h3>  session 을 통한 값 넘기기  </h3>
<%
	String name = (String)session.getAttribute("name");
	out.print(name); 
	
%>
</body>
</html>