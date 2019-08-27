<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>    
<%
	List<Map<String,Object>> subList = null;
	subList = 
		(List<Map<String,Object>>)request.getAttribute("subList");
	String temp = null;
	if(subList.size()>0){
			Gson g = new Gson();
			temp = g.toJson(subList);
	}
	else{
		temp="";
	}
	out.print(temp);
%>