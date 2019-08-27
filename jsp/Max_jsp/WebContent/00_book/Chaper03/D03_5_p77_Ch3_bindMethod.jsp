<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.util.D03_5_HashMapBinder" %>
<%@ page import="com.util.D03_5_HashMapBinder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공통코드 bind메소드 활용</title>
</head>
<body>
<%
	Map<String,Object> target = new HashMap<>();
	/* src/util/~ */
	D03_5_HashMapBinder hmb = new D03_5_HashMapBinder(request);
	hmb.bind(target);
	Object keys[] = target.keySet().toArray(); 
	for(int i=0;i<keys.length;i++){
		out.print(target.get(keys[i]));
		out.print("<br>");
	}
%>
</body>
</html>