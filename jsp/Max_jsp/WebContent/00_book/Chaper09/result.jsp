<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키에 저장
	String pick1 = request.getParameter("pick1");
	String pick2 = request.getParameter("pick2");
	String pick3 = request.getParameter("pick3");
	//정답 비교
	String right[] = {"2","3","3"};
	String picks[] = {pick1,pick2,pick3};
	
	/* ???? */
	//정답 개수
	int rightNum=0;
	//오답 개수
	int wrongNum=0;
	//카운트
	for(int i=0;i<right.length;i++){
		if(right[i].equals(picks[i])){
			rightNum++;
		}
		else{
			wrongNum++;
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Submit Page</title>
</head>
<body>
<div>
	<table>
		<tr>  <td>정답 수 </td> <td> <%=rightNum %> </td>  </tr>
		<tr>  <td>오답 수 </td> <td> <%=wrongNum %> </td>  </tr>
	</table>
</div>
</body>
</html>