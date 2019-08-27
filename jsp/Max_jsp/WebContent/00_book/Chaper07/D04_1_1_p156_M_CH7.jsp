<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다이렉티브 시작</title>
</head>
<body>
<%
	int temp1 = 10;
	String temp2 = "훈민정음";
%>
A1.First Code <br>		<!--실행순서  1-->
A2.Second Code <br>		<!--실행순서  2-->
<%@ include file="D04_1_1_p156_N_CH7.jsp" %>
A3.Third Code <br>		<!--실행순서  6-->
A4.Fourth Code <br>		<!--실행순서  7-->
</body>
</html>