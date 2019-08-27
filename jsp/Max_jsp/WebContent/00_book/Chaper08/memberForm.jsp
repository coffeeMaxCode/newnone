<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML  CSS  JavaScript 영역 -->
<%
	/*	스크립틀릿
			지역변수  
			메소드선언불가  
			생성자불가  
			제어문가능  
			인스턴스화		*/
	MemberVO mVO = new MemberVO();
	mVO.setMEM_ID("test");
	mVO.setMEM_NAME("김유신");
%>
일반 인스턴스 화 후, set으로 값 부여, get을 값 얻어 불러오기  <br><br>
ID	 : <%=mVO.getMEM_ID() %>	<br>
Name : <%=mVO.getMEM_NAME() %>  <br>
------------------------------------------<br><br>
useBean 사용, property / value 로 값 부여 후 불러오기  <br><br>
<jsp:useBean id="bmVO" scope="request" class="com.vo.MemberVO" />
<jsp:setProperty name="bmVO" property="MEM_ID" value="test2"/>
<jsp:setProperty name="bmVO" property="MEM_NAME" value="김유신2"/>
ID	 : <jsp:getProperty name="bmVO" property="MEM_ID"/>   <br>
Name : <jsp:getProperty name="bmVO" property="MEM_NAME"/> <br>
------------------------------------------<br>

</body>
</html>