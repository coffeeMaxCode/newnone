<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<!-- 테스트 시나리오 - 사용자 메뉴얼
	1) memeberList.do → memberSerblet → memberDao → List 받음 → Forward
	2) memberList.jsp → memberList.jsp → 빈화면						-->
<%  // JSP == DB 연동
   	List<Map<String,Object>> memList 
   		=(List<Map<String,Object>>)request.getAttribute("memList");
	int size =0;
	if(memList!=null){
		// NullPointerException 가능성 배제!
		size = memList.size();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<body>
	<table width="400px" border="1">
		<thead>
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>Name</th>
		</tr>
		</thead>
		
<%
/* 조회결과가 있는지 */
	if(size>0){
/* 조회결과 존재 > 반복문 처리 */
		for(int i=0;i<size;i++){
			Map<String,Object> rMap = memList.get(i);
%>

			<!-- 데이터 출력 - <tr>/<th> 영역구분 확실히 -->
			<tr>
				<th><%=rMap.get("mem_id") %></th>
				<th><%=rMap.get("mem_id") %></th>
				<th><%=rMap.get("mem_id") %></th>
			</tr>
<%
		}
	}
	else{
%>
		<tr>
			<th colspan="3">Nothing Can Found</th>
		</tr>
<%
	}
%>
</table>
<!-- 조회결과가 없음 : 결과 없음 출력하기 -->
</body>
</html>