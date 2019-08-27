<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다이렉티브 중간부분</title>
</head>
<body>
<!-- 실제로 선언되지 않았으나, class M N 은 하나로 취급하므로 실행 가능함 -->
<%= temp1 %>	<br>
<%= temp2 %>	<br>
B1.First Code 	<br>	<!--실행순서  3-->
B2.Second Code 	<br>	<!--실행순서  4-->
B3.Third Code 	<br>	<!--실행순서  5-->
</body>
</html>