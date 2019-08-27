<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvc.MemberDao, com.vo.MemberVO" %>
<%@ page import="java.util.ArrayList, java.util.Map, java.util.HashMap" %>
<%@ page import="java.util.List, com.google.gson.Gson" %>
<%
	MemberDao mDao = new MemberDao();
//	MemberVO mVO = new MemberVO();
	Map<String,Object> pMap = new HashMap<>();
	mDao.my_proc2(pMap);
//	out.print("<br>");
	
	mDao.my_proc2(pMap);	
//	out.print("<br>");
//	out.print(pMap.get("key"));
	List list = (List)pMap.get("key");
//	out.print("<br>");
//	out.print(list.size());
/*	for(int i=0;i<list.size();i++){
		MemberVO mVO = (MemberVO)list.get(i);
//		out.print(mVO.MEM_ID);
	}*/
	Gson g = new Gson();
	String temp = g.toJson(list);
	out.print(temp);
%>