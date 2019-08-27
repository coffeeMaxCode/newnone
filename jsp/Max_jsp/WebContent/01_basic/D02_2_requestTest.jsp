<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestTest.max 응답 페이지</title>
<!-- java에서 자료 받아와 실행하는 파일 -->
</head>
<body>
<%
	//실행 시, 오류 이유 : List<String> nameList = null;
	List<String> nameList = (List<String>)request.getAttribute("nameList");
	for(String name:nameList){  
		out.print("name = "+name+"\n");
	// RUN 이후, URL을 web.xml 에서 연결한 주소로 변경
	}
%>

</body>
</html>