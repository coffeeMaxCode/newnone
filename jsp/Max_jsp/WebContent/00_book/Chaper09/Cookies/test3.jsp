<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pick2 = request.getParameter("pick2");
	String pick3 = request.getParameter("pick3");
	
	Cookie cookie = new Cookie("pick2",pick2);
	cookie.setMaxAge(60*10);
	cookie.setPath("/");
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../../Stylesheet/JEasyUICommon3.jsp" %>
<script type="text/javascript">
	function submitConfirm(){
		alert("Will you submit?");
		location.href="result.jsp"
	}
	
	function answer(p_answer){
		/* 브라우저가 돔 구성시 같은 이름이면 자동으로 배열로 전환 */
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
		location.href="test2.jsp?pick2=<%=pick2%>";
	}
	//다음페이지 이동
	function next(){
		var temp = 1;
		for(var i=0; i<document.getElementById("f_question3").cb_Question3.length;i++){
			if(document.getElementById("f_question3").cb_Question3[i].checked==1){
			document.getElementById("f_question3").pick3.value = temp;
			}
			else{
				temp = temp+1;
			}
		}
		document.getElementById("f_question3").submit();
	}
	
	</script>
<meta charset="UTF-8">
<title>Question No.3</title>
</head>
<body>
<script type="text/javascript">
	$("document").ready(function (){
		for(var i=0;i<document.getElementById("f_question3").cb_Question3.length;i++){
  			if(<%=pick3%>==document.getElementById("f_question3").cb_Question3[i].value){
				document.getElementById("f_question3").cb_Question3[i].checked=1;
			}
			else{
				document.getElementById("f_question3").cb_Question1[i].checked=0;
			}
		}
	});
</script>
<div class="easyui-panel" title="Question No.3"
	 style="width:600px; hight: 100px;"
	 data-options="fit:true,border:true,fotter:'#footer'">
	<div style="margin-left:40px">
		<h3>다음 중 옳지 않은 설명은 무엇인가?</h3><br>
		<form id="f_question3" method="get" action="result.jsp">
			<input type="hidden" name="pick2" value="<%=pick2 %>" />
			<input type="hidden" name="pick3" />
			<div style="margin-bottom:10px;margin-left:10px">
				<input type="checkbox" name="cb_Question3" value="1" onChange="answer(0)">
				1.jeasyUI는 자바스크립트  기반의 UI솔루션이다.<br>
			</div>
			
			<div style="margin-bottom:10px;margin-left:10px">
				<input type="checkbox" name="cb_Question3" value="2" onChange="answer(1)">
				2.jeasyUI는 jquery기반의 솔루션이다.<br>
			</div>
			
			<div style="margin-bottom:10px;margin-left:10px">
				<input type="checkbox" name="cb_Question3" value="3" onChange="answer(2)">
				3.jeasyUI는 자바코드와 직접 연동이 가능하다.<br> <!-- 정답 -->
			</div>
			
			<div style="margin-bottom:10px;margin-left:10px">
				<input type="checkbox" name="cb_Question3" value="4" onChange="answer(3)">
				4.jeasyUI는 html5보다 훨씬 더 많은 콤퍼넌트를 제공한다.<br>
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
        			<a href="javascript:next()" class="easyui-linkbutton" style="width:150px">Submit Page</a>
        		</td>
        	</tr>
        </table>
    </div>
    </div>
</div>
</body>
</html>