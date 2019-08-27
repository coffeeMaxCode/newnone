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
	request.setAttribute("name", name);
	
	//이동방법 1 A-1
		//주소 변경 : 기존 요청이 끊어지고, 새로운 요청이 일어남
		//request 서로 다른 요청임
		//session 으로 해결 가능 → 단점 : 작은 저장소
		//response.sendRedirect("p50_Ch3_B_1.jsp");
		
	//doGet(HttpServletRequest res);
	
	//이동방법 2 A-2
	// A 페이지에서 B 페이지로 request와 response를 넘겨주어야함
	RequestDispatcher view = request.getRequestDispatcher("D03_2_p50_Ch3_B_1.jsp");
	//내장객체에서 불러오는 것이므로, 전체 이름을 써야함
	//실제로 페이지 이동이 일어나는 부분 
	view.forward(request,response);
%>
</body>
</html>