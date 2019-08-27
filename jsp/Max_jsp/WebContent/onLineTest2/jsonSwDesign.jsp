<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
/* 	out.print("jsp 호출 완료"); */
	List<Map<String,Object>> designList = null;
	designList
		=(List<Map<String,Object>>)request.getAttribute("designList");
	String temp = null;
	if(designList.size()>0){
		Gson g = new Gson();
		temp = g.toJson(designList);
	}
	else{
		temp = "";
	}
	out.print(temp);
%>