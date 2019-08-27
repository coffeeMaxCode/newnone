<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.List, java.util.Map" %>
<%
	List<Map<String,Object>> memList = 
		(List<Map<String,Object>>)request.getAttribute("memList");
	String temp = "";
	if(memList!=null){
		Gson g = new Gson();
		temp = g.toJson(memList);
	}
	out.print(temp);
%>