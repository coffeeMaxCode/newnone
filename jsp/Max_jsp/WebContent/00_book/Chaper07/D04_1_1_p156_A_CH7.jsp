<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 액션태그</title>
</head>
<body>
<%
	int temp1 = 10;
/* 	클래스가 다르기 때문에 A에서 만든 temp를
	B에서 사용할 수 없다 
	파라미터를 이용해 값을 넘겨 주어야 사용 가능	*/
	
	//인코딩 설정 : 최초에 생성 후, 넘기기 전 해야 제대로 작동
	request.setCharacterEncoding("UTF-8");
	String temp2 = "훈민정음";
%>
A1.First Code 	<br>	<!--실행순서  1-->
A2.Second Code 	<br>	<!--실행순서  2-->
<jsp:include page="D04_1_1_p156_B_CH7.jsp" flush="false">
	<jsp:param value="<%=temp1%>" name="p1"/>
	<jsp:param value="<%=temp2%>" name="p2"/>
</jsp:include>
A3.Third Code <br>		<!--실행순서  6-->
A4.Fourth Code <br>		<!--실행순서  7-->
</body>
</html>