<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap" %>
<%	/* 필요한값 가져오기 */
	String bm_no = request.getParameter("bm_no");
	String bm_pw = request.getParameter("bm_pw");
%>   
<%
	List<Map<String,Object>> boardDetail = 
	(List<Map<String,Object>>)request.getAttribute("boardDetail");
	Map<String,Object> rMap = new HashMap<>();
	
	 if(boardDetail!=null){
			rMap = boardDetail.get(0);
		}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 기능 구현</title>
<%@ include file="/Stylesheet/JEasyUICommon.jsp" %>
</head>
<body>
<div>
<%-- 텍스트 입력부분
 	 <table>
		<tr>
			<td>Title</td>
			<td><input class="easyui-textbox" value="<%=rMap.get("BM_TITLE") %>" id="bm_title" data-options="width:'450px'" ></td>
		</tr>
		<tr>
			<td>Writer</td>
			<td><input class="easyui-textbox" value="<%=rMap.get("BM_WRITER") %>" id="bm_writer" DAta-options="width:'450px'" ></td>
		</tr>
		<tr>
			<td>E-mail</td>
			<td><input class="easyui-textbox" value="<%=rMap.get("BM_EMAIL") %>" id="bm_email" data-options="width:'450px'" ></td>
		</tr>
		<tr>
			<td>Content</td>
			<td><input class="easyui-textbox" value="<%=rMap.get("BM_CONTENT") %>" id="bm_content" 
						data-options="width:'450px', height:'100px', MULTILINE:'true'" ></td>
		</tr>
		<tr>
		<td>File</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BS_FILE") %>" id="bs_file" data-options="width:'450px'" ></td>
		</tr>
	</table> --%>
<!-- 비밀번호 입력 기능 -->
	<input class="easyui-textbox" id="u_pw" name="u_pw"
			label="Password : " labelWidth="90px" style="width:80%; height:25px;">
</div>
</body>
</html>