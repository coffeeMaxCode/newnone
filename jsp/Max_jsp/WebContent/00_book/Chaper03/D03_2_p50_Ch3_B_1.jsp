<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>받는 JSP</title>
</head>
<body>
	<h3>  A_@.jsp → B_1.jsp 이동 완료 == 주소 변경  </h3>
<%
	//이동방법 1에서 request 에는 name에 해당하는 값이 없음
	// name == null
	
	//이동방법 2
	// A페이지에서 넘겨준 값들을 가지고 옮
	
	String name = (String)request.getAttribute("name");
	out.print(name); 
	
%>
</body>
</html>