<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String mem_id = "Tester";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Test</title>
</head>
<body>
		<table border='1'>
		<tr><td>서블릿으로 화면 그리려면 작업이 두배</td></tr>
		<tr><td>mem_id</td></tr>
		<tr><td><%out.print(mem_id);%></td></tr>
		</table>
</body>
</html>