<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 액션태그 A.jsp에 포함된 페이지</title>
</head>
<body>
<%= request.getParameter("p1") %>	<br>
<%= request.getParameter("p2") %>	<br>
B1.First Code 	<br>	<!--실행순서  3-->
B2.Second Code 	<br>	<!--실행순서  4-->
B3.Third Code 	<br>	<!--실행순서  5-->
</body>
</html>