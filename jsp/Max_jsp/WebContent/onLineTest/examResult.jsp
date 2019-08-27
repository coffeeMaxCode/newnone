<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 응시 결과</title>
<%@ include file="../Stylesheet/JEasyUICommon.jsp" %>
<script type="text/javascript">
//작성 답안 최종 제출
	function examSend(){
		//전송한 답안지를 DB에 추가 → 현재 창은 닫기 처리
/* 		$.ajax({
			 method	:
			,url	:
			,sucess	:
		}); */
		self.close();
	}
</script>
</head>
<body>
<!-- 제출 답안 확인 페이지 -->	
	<div id="pan_confirm" class="easyui-panel" style="width:700px;height:300px"
		data-options="title:'답안 확인 페이지', closed:'true', footer:'#btn_confirm', modal:true">
		<div id=u_dap></div>
			<script type="text/javascript">
				$("#u_dap").text("No1."+$.cookie("c_test1")
								+"No2."+$.cookie("c_test2")
								+"No3."+$.cookie("c_test3")
								+"No4."+$.cookie("c_test4")
								);
			</script>
	    	Did you do your best?<br>
	    	Thanks<br>
	    	Please, Submit your answer<br>
	</div>
	<div id="btn_confirm" align="center">
		<a href="javascript:examSend()" class="easyui-linkbutton">Submit</a>
	</div>

</body>
</html>