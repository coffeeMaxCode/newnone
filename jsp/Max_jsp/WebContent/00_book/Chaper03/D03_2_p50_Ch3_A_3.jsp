<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주는 JSP</title>
</head>
<body>
<%
	//요청 객체에 담기
	String name = "Max";

	//session 은 서버에 있는/저장된 캐시메모리에 직접 접근한다
	//캐시 메모리에서 이름(주소값)을 통하여 원하는 값을 가져옴
	session.setAttribute("name", name);
	
	//session 사용  → 단점 : 작은 저장소
	response.sendRedirect("D03_2_p50_Ch3_B_3.jsp");

%>
</body>
</html>