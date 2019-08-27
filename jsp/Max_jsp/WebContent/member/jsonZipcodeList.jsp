<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.vo.ZipCodeVO"; %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<ZipCodeVO> zipList = null;
	zipList = 
			(List<ZipCodeVO>)request.getAttribute("zipList");
	String temp = null;
	if(zipList.size()>0){
		Gson g = new Gson();
		temp = g.toJson(zipList);
	}
	else{
		temp="";
	}
	out.print(temp);
%>