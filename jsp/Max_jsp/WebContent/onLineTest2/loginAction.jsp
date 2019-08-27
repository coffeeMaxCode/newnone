<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="com.vo.MemberVO" %>
<%
/* MemberController 에서 세션에 담아둔 값 읽어오기
     세션값은 서버의 cache메모리에 기억되어 있어서 페이지 이동과 상관없이 그 시간 동안 무조건 유지됨 			*/
   
/*	String mem_name = (String)session.getAttribute("mem_name");
	request.getAttribute("rmVO");시간이 아니라 forward를 통해 유지
	forward의 경우 화면 호출시 파라미터에 request와 response가 담겨 있다.
	
	서블릿에서 객체 주입 받은 원본이므로 그 원본에서 값을 꺼내는 방식
	session의 경우 컴터의 cache메모리에 담긴 정보는꺼내는 것이므로 어디서든 꺼낼 수 있다.
	톰캣의 경우 기본시간은 30분이고 그 시간을 연장하려면 web.xml 설정추가							*/
     
    /* 프로시저 미사용 */
	//String mem_name = (String)session.getAttribute("mem_name");
	/* 프로시저 사용 */
	MemberVO rmVO = (MemberVO)session.getAttribute("rmVO");
//	out.print(rmVO.getMEM_ID()+" / "+rmVO.getMEM_NAME());
%>

<div id="loginForm" class="nav navbar-nav navbar-right">
        <form class="navbar-form navbar-right">
          <label for="msg">
          	<!-- 프로시저 미사용 -->
          	<%-- <font color="white"><%=mem_name %></font> --%>
          	<!-- 프로시저 사용 -->
          	<font color="white">Welcome! <%=rmVO.getMEM_NAME() %></font>
          </label>
          <button type="button" class="btn btn-dark" onclick="logoutAction()">LogOut</button>
        </form>
    </div>