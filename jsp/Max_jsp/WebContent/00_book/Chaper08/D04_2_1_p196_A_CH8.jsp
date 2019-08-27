<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1 객체 주입 일어남 -->
<jsp:useBean id="mvo" scope="request" class="com.vo.MemberVO"/>
<!-- 2 내용 실행 -->
<%
	mvo.setMEM_ID("apple");
	mvo.setMEM_NAME("Jone");
	
%>
<%=mvo.getMEM_ID() %>
<%=mvo.getMEM_NAME() %>

<%
	request.setAttribute("mvo", mvo);
%>
<!-- forward 실행 > 페이지 이동 -->
<!-- JSP 방식 -->
<jsp:forward page="D04_2_1_p196_B_CH8.jsp"/>
<!-- JAVA 방식 -->
<%
	RequestDispatcher view = request.getRequestDispatcher("D04_2_1_p196_B_CH8.jsp");
	view.forward(request, response);
%>

</body>
</html>