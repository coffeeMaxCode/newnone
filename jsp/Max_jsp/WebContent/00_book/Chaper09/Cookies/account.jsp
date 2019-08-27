<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../Stylesheet/JEasyUICommon3.jsp" %>
<% 
	//쿠키 불러와서 비교해야함
	String picks[] = new String[3];
	//쿠키에 담긴 답안지 추력
	Cookie cookies[] = request.getCookies();
	if(cookies!=null &&cookies.length>0){
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("pick1")){
				picks[0]=cookies[i].getValue();
			}
			if(cookies[i].getName().equals("pick2")){
				picks[1]=cookies[i].getValue();
			}
			if(cookies[i].getName().equals("pick3")){
				picks[2]=cookies[i].getValue();
			}
		}
	}
%>
<div>
<%
	for(String temp:picks){
		out.print("temp:"+temp+"<br>");
	}
%>
</div>
<%
	//정답 비교
	String right[] = {"2","3","3"};
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
 <html>
<head>
<meta charset="UTF-8">
<title>채점 결과</title>

</head>
<body> 
<div class="easyui-panel" style="width:600px;height:500px;padding:20px" title="Result">
	<table width="200" height="100">
	<tr> <td>정답수</td> <td align="right"><%=rightNum%>/3</td> </tr>
  	<tr> <td>오답수</td> <td align="right"><%=wrongNum%>/3</td> </tr>
  	<tr> <td> 총 점</td> <td align="right"><%=rightNum%>점</td> </tr>
  	</table>
</div>
</body>
</html> 