<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSP = Servlet
 크기 순서 : (상위) JAVA > Servlet > JSP (하위)
지금 만든 파일 = index.jsp → [서블릿] index_jsp.java → [?] index_jsp.class
자바 = Object[로컬에서만 실행]  VS 서블릿 = HttpServlet[원격 호출]
톰캣 (JSP엔진+Servlet엔진+JAVA엔진) = jsp파일을 자바코드로 변환
	> 확장자 달라짐 : 웹서버마다 확장자 명명 규칙이 다름
	* Class 이름 모르면 → 인스턴스화 불가
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to New Servelt</title>
</head>
<body>
	<h3>New JSP</h3>
</body>
</html>