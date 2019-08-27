<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String menu = request.getParameter("menu");
//	out.print(menu);
%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
    background-color: #ECE5E2;
}
</style>
<meta charset="UTF-8">
<title>Include 활용한 html 작성</title>
</head>
<body>

<table  width="1000px" height="800px" border="1" bordercolor=white align="center">
	<!-- Top -->
	<tr  width="1000px" height="200px" border="1">
		<td><jsp:include page="11_top.jsp" flush="false" /></td>
	</tr>
	
	<!-- Middle -->
	<tr>
		<td>
			<table width="1000px" height="400px">
				<tr>
				<!-- menu -->
					<td width="200px" height="400px" border="1">
						<jsp:include page="11_menu.jsp" flush="false" />
					</td>
				<!-- Main -->
					<td  width="800px" height="400px" border="1">
				<%
					if("Login".equals(menu)){
				%>
						<jsp:include page="12_login.jsp" flush="false" />
				<%
					}
					else if("Online Test".equals(menu)){
				%>
						<jsp:include page="12_online Test.jsp" flush="false" />
				<%
					}
					else if("Post".equals(menu)){
				%>
						<jsp:include page="12_post.jsp" flush="false" />
				<%
					}
					else{
				%>
						<jsp:include page="11_main.jsp" flush="false" />
				<%
					}
				%>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<!-- Bottom -->
	<tr  width="1000px" height="200px" border="1">
		<td><jsp:include page="11_bottom.jsp" flush="false" /></td>
	</tr>
</table>

</body>
</html>