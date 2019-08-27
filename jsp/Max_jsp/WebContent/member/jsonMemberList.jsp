<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> memList = null;
	memList = 
			(List<Map<String,Object>>)request.getAttribute("memList");
	String temp = null;
	if(memList.size()>0){
		Gson g = new Gson();
		temp = g.toJson(memList);
	}
	else{
		temp="";
	}
	out.print(temp);
%>