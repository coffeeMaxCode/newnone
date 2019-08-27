<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML 영역 -->
<%!
/*자바*/
//Declaration 디클레이션
	// i 전역변수
	int i = 10;
	
	public String methodA(int j){
		j = 20;
		return "hello";
	}
 %>
 
<%
/*JSP 스크립트*/
//scriptlet 스크립틀릿
	// name 지역변수
	String name;
	name = "Max";
	out.print(name);
	out.print("<br>");
	out.print(i);
	out.print("<br>");
	
	String call = methodA(10);
	out.print("call : "+call+"<hr>");
 %>
 
<%= 
//Expression 익스프레션
"문자열"
%>

</body>
</html>