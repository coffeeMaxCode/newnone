<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>    
<%
	List<Map<String,Object>> boardList = 
				(List<Map<String,Object>>)request.getAttribute("boardList");
	Gson g = new Gson();
	String temp =  g.toJson(boardList);
	out.print(temp);
%>