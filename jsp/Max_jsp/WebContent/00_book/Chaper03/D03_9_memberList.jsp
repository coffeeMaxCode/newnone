<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
    <!-- 각 언어별 실행 주체가 다르다 -->
<%
/* 이 페이지는 max_jsp - book 하위에 존재
      요청시 톰캣 서버는 자신이 바라보는 경로에서 해당 페이지 검색
   xxx_jsp.java 로 변환 : xxx.jsp.class컴파일 > 실행 > 태그생성
      생성된 태그와 아래 태그들을 개인 컴퓨터에 다운로드
      사용자의 브라우저를 통해 출력								*/
	out.print("Here is Scriptlet part!<br>");
	String name = "Hopman";
	out.println("your name's "+name+"<br>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script type="text/javascript">
		var s_name = 'Jone Cena';
	</script>
</head>
<body>
Here is HTML part!
	<div id='d_msg'></div>
	<script type="text/javascript">
		/* 익스프레이션에 출력된 정보는 항상 고정값
			이미 서버에서 실행된 결과가 출력
			유연하게 바뀌지 않음			*/
		s_name ='<%=name%>';
		document.getElementById("d_msg").innerHTML=s_name;
	</script>
</body>
</html>