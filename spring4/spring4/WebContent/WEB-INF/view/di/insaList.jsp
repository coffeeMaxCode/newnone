<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsaList Page</title>
</head>
<body>
<%
	List<String> insaList = (List<String>)request.getAttribute("listBean");
	for(int i=0;i<insaList.size();i++){
		out.print(insaList.get(i)+"<br>");
	}
%>


</body>
</html>