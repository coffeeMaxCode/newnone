<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pick1 = request.getParameter("pick1");
	String pick2 = request.getParameter("pick2");
	//out.print(pick1);
	Cookie cookie = new Cookie("pick1",pick1);
	cookie.setMaxAge(60*10);
	cookie.setPath("/");
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../../Stylesheet/JEasyUICommon3.jsp" %>
<meta charset="UTF-8">
<title>Question No.2</title>
<script type="text/javascript">
	function answer(p_answer){
		for(var i=0;i<document.getElementById("f_question2").cb_Question2.length;i++){
			if(p_answer==i){
				document.getElementById("f_question2").cb_Question2[i].checked=1;
			}
			else{
				document.getElementById("f_question2").cb_Question2[i].checked=0;
			}
		}
	}
	//이전 페이지로 이동
	function preview(){
		location.href="test1.jsp?pick1=<%=pick1%>";
	}
	//다음 문제 선택시 이전 문제 선택 값 기억하기 : hidden 속성
	function next(){
		var temp = 1;
		for(var i=0; i<document.getElementById("f_question2").cb_Question2.length;i++){
			if(document.getElementById("f_question2").cb_Question2[i].checked==1){
			document.getElementById("f_question2").pick2.value = temp;
			}
			else{
				temp = temp+1;
			}
		}
		document.getElementById("f_question2").submit();
	}
</script>
</head>
<body>
<script type="text/javascript">
	$("document").ready(function (){
		for(var i=0;i<document.getElementById("f_question2").cb_Question2.length;i++){
  			if(<%=pick2%>==document.getElementById("f_question2").cb_Question2[i].value){
				document.getElementById("f_question2").cb_Question2[i].checked=1;
			}
			else{
				document.getElementById("f_question2").cb_Question2[i].checked=0;
			}
		}
	});
</script>
<div class="easyui-panel" title="Question No.2"
	 style="width:600px; hight: 100px;"
	 data-options="fit:true,border:true,fotter:'#footer'">
	<div style="margin-left:40px">
		<h3>다음 중, 자바에서 사용하는 타입이 아닌 것은?</h3><br>
		<form id="f_question2" method="get" action="test3.jsp">
			<input type="hidden" name="pick1" value="<%=pick1 %>" />
			<input type="hidden" name="pick2" />
			<div style="margin-bottom:10px;margin-left:10px">
				<input type="checkbox" name="cb_Question2" value="1" onChange="answer(0)">
				1.int<br>
			</div>
			
			<div style="margin-bottom:10px;margin-left:10px">
				<input type="checkbox" name="cb_Question2" value="2" onChange="answer(1)">
				2.String<br>
			</div>
			
			<div style="margin-bottom:10px;margin-left:10px">
				<input type="checkbox" name="cb_Question2" value="3" onChange="answer(2)">
				3.varchar2<br>	<!-- 정답 -->
			</div>
			
			<div style="margin-bottom:10px;margin-left:10px">
				<input type="checkbox" name="cb_Question2" value="4" onChange="answer(3)">
				4.object<br>
			</div>
		</form>
<!-- 다음 페이지 이동 버튼 -->
		<div id="footer" style="padding:5px;">
	       <table>
				<tr>
					<td>
	        			<a href="javascript:preview()" class="easyui-linkbutton" style="width:150px">Previous Question</a>
	        		</td>
	        		<td>
	        			<a href="javascript:next()" class="easyui-linkbutton" style="width:150px">Next Question</a>
	        		</td>
	        	</tr>
	        </table>
	    </div>
    </div>
</div>
</body>
</html>