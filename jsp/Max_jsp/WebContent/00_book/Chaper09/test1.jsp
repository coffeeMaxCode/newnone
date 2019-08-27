<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pick1 = request.getParameter("pick1");
	String pick2 = request.getParameter("pick2");
	//out.print(pick1);
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../Stylesheet/JEasyUICommon2.jsp" %>
<meta charset="UTF-8">
<title>Question No.1</title>
<script type="text/javascript">
	//중복 선택을 배제하기 위한 함수 선언
	/* 선택한 답안지 확인하기 : p_answer 변수 > 1~4 */
	function answer(p_answer){
		/* 브라우저가 돔 구성시 같은 이름이면 자동으로 배열로 전환 */
		for(var i=0;i<document.getElementById("f_question1").cb_Question1.length;i++){
			if(p_answer==i){
				document.getElementById("f_question1").cb_Question1[i].checked=1;
			}
			else{
				document.getElementById("f_question1").cb_Question1[i].checked=0;
			}
		}
	}
	//다음 문제 선택시 이전 문제 선택 값 기억하기 : hidden 속성
	function next(){
		var temp = 1;
		for(var i=0; i<document.getElementById("f_question1").cb_Question1.length;i++){
			if(document.getElementById("f_question1").cb_Question1[i].checked==1){
			document.getElementById("f_question1").pick1.value = temp;
			}
			else{
				temp = temp+1;
			}
		}
		document.getElementById("f_question1").submit();
	}
</script>
</head>
<body>
<script type="text/javascript">
	$("document").ready(function (){
		for(var i=0;i<document.getElementById("f_question1").cb_Question1.length;i++){
  			if(<%=pick1%>==document.getElementById("f_question1").cb_Question1[i].value){
				document.getElementById("f_question1").cb_Question1[i].checked=1;
			}
			else{
				document.getElementById("f_question1").cb_Question1[i].checked=0;
			}
		}
	});
</script>
<div class="easyui-panel" title="Question No.1"
	 style="width:600px; hight: 100px;"
	 data-options="fit:true,border:true,fotter:'#footer'">
	<div style="margin-left:40px">
		<h3>DML구문 중 성격이 다른 하나를 고르시오</h3><br>
		<form id="f_question1" method="get" action="test2.jsp">
			<input type="hidden" name="pick1" />
			<div style="margin-bottom:10px;margin-left:10px">
				<input type="checkbox" name="cb_Question1" value="1" onChange="answer(0)">
				1.INSERT<br>
			</div>
			
			<div style="margin-bottom:10px;margin-left:10px">
				<input type="checkbox" name="cb_Question1" value="2" onChange="answer(1)">
				2.SELECT<br>	<!-- 정답 -->
			</div>
			
			<div style="margin-bottom:10px;margin-left:10px">
				<input type="checkbox" name="cb_Question1" value="3" onChange="answer(2)">
				3.UPDATE<br>
			</div>
			
			<div style="margin-bottom:10px;margin-left:10px">
				<input type="checkbox" name="cb_Question1" value="4" onChange="answer(3)">
				4.DELETE<br>
			</div>
		</form>
<!-- 다음 페이지 이동 버튼 -->
		<div id="footer" style="padding:5px;">
	        <table>
				<tr>
					<td width=152.5px>
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