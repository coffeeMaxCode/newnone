<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* 단위 테스트 페이지
	 	http://localhost:8000/onLineTest/isOk.max?work=onLineTest&mem_id=test&exam_no=1907250024
*/
	String msg = (String)request.getAttribute("msg");
	out.clear();
	out.print(msg);
%>