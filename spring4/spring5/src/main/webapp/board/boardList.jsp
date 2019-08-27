<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List, java.util.Map" %>
<%
	List<Map<String,Object>> memList 
		= (List<Map<String,Object>>)request.getAttribute("memList");
	if(memList!=null){
		out.print("size = "+memList.size());
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[webapp]boardList.jsp</title>
<script type="text/javascript">
	function boardList(){
		document.getElementById("f_test").submit();
	}
</script>
</head>
<body>
	<h1>webapp → board</h1>	<br>
	게시판 목록
	<form id="f_test" method="post" action="boardList3">
		<button onClilck="boardList()">조회</button>
	</form>
</body>
</html>