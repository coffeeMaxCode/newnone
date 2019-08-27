<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<!-- 이 파일은 JSON 포맷으로 출력해주는 파일 
	 이 주석은 응답페이지에 출력되는 주석이므로 반드시 jsp주석을 사용할 것
	 
	 테스트 방법
	 오라클 서버     : 211.45.89.50
	 오라클 계정	  : scott.tiger
	 톰캣 서버 주소 : 210.40.56.90:7005
	 관리자 계정...
	 
	 실행시 Elements 탭에서 확인 가능 : 보안상 절대 서버관련 정보는 주석으로도 올리지 않아야 함	-->
<%-- <jsp:useBean id="a" class="baisc.A scope="page"/> --%>
<%
	//Select * emp
	List<Map<String,Object>> deptList = new ArrayList<>();
	
	Map<String,Object> pMap = new HashMap<>();	
	pMap.put("deptno", 10);
	pMap.put("dname", "영업부");
	pMap.put("loc", "NewYork");
	deptList.add(pMap);
	
	pMap = new HashMap<>();
	pMap.put("deptno", 20);
	pMap.put("dname", "총무부");
	pMap.put("loc", "Los Angeles");
	deptList.add(pMap);
	
	pMap = new HashMap<>();
	pMap.put("deptno", 30);
	pMap.put("dname", "기획부");
	pMap.put("loc", "Cicago");
	deptList.add(pMap);
	
	pMap = new HashMap<>();
	pMap.put("deptno", 40);
	pMap.put("dname", "관리부");
	pMap.put("loc", "Washington DC");
	deptList.add(pMap);
	
	//out.print(deptList); > JSON 포맷이 아님
	Gson g = new Gson();
	String temp = g.toJson(deptList);
	out.print(temp);
%>