<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String coffeeMaker = request.getParameter("coffeeMaker");
	String name = request.getParameter("name");

	for(double i=0; i<4000000000.0;i++){
		
	}
	//기존에 가지고 있는 정보 > 출력버퍼에서 삭제
	//안하면, 계속 1번 머신 정보만 유지
	out.clear();
	out.print(coffeeMaker+name);
%>