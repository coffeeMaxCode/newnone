<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.google.gson.Gson" %>
<%
	List<Map<String,Object>> customerList = new ArrayList<>();
	Map<String,Object> customerInfo = new HashMap<>();
	
	customerInfo.put("mem_name","이순신");
	customerInfo.put("mem_addr","서울시 마포구 공덕동");
	customerInfo.put("mem_tel","025559999");
	customerList.add(customerInfo);
	
	customerInfo = new HashMap<>();
	customerInfo.put("mem_name","김유신");
	customerInfo.put("mem_addr","서울시 영등포구 당산동");
	customerInfo.put("mem_tel","026669999");
	customerList.add(customerInfo);
	
	customerInfo = new HashMap<>();
	customerInfo.put("mem_name","강감찬");
	customerInfo.put("mem_addr","서울시 구로구 개봉동");
	customerInfo.put("mem_tel","027779999");
	customerList.add(customerInfo);

	out.clear();
		
	Gson g = new Gson();
	String result = g.toJson(customerList);
	out.println(result);
	
%>