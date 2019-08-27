<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문확인서</title>
</head>
<body>
	<%
		//스크립틀릿 - html코드 안에 자바코드를 쓰고 싶을 때
		String user_name = request.getParameter("mem_name");
		String paper = request.getParameter("paper");
		String del = request.getParameter("mem_addr");
		out.print(user_name + ", " + paper + ", " + del);
	%>
	<table align="center" width="500px" border="1">
		<tr>
			<td width="100px">주문자</td>
			<!-- out.print 파라미터에 있는 값을 브라우저에 출력해줌. -->
			<td>
				<%
					out.print(user_name);
				%>
			</td>
		</tr>
		<tr>
			<td width="100px">주문내용</td>
			<td>
				<%
					out.print(paper);
				%>
			</td>
		</tr>
		<tr>
			<td width="100px">배송지</td>
			<td>
				<%
					out.print(del);
				%>
			</td>
		</tr>
	</table>
</body>