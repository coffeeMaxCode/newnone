<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List, java.util.Map" %>
<%
	List<Map<String,Object>> memList 
		= (List<Map<String,Object>>)request.getAttribute("memList");
	if(memList!=null){
		out.print("size = "+memList.size());
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[WEB-INF]boardList.jsp</title>
</head>
<body>
	<h1>WEB-INF → view → board</h1>
</body>
</html>