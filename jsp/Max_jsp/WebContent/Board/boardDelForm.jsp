<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	/* 필요한값 가져오기 */
	String bm_no = request.getParameter("bm_no");
	String bm_pw = request.getParameter("bm_pw");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제기능 구현</title>
<%@ include file="/Stylesheet/JEasyUICommon.jsp" %>
</head>
<body>

<div>
<!-- 비밀번호 입력 기능 -->
	<input class="easyui-textbox" id="u_pw" name="u_pw"
			label="Password : " labelWidth="90px" style="width:80%; height:25px;">
</div>
</body>
</html>