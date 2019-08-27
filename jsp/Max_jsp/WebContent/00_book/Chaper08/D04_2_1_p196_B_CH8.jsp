<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberVO mvo = (MemberVO)request.getAttribute("mvo");
	out.print("ID : ");
	out.print(mvo.getMEM_ID());
	out.print("<br>");
	out.print("Name : ");
	out.print(mvo.getMEM_NAME());
	out.print("<br>");
%>


</body>
</html>