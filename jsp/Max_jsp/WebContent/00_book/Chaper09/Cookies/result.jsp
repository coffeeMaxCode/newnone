<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키에 저장
	String pick3 = request.getParameter("pick3");
	Cookie cookie = new Cookie("pick3",pick3);
	cookie.setMaxAge(60*10);
	cookie.setPath("/");
	response.addCookie(cookie);
	response.sendRedirect("account.jsp");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Submit Page</title>
</head>
<body>
Will you  submit your answer?
</body>
</html>