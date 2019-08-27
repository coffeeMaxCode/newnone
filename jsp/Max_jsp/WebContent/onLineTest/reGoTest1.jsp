<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 응시 페이지</title>
<%@ include file="../Stylesheet/JEasyUICommon.jsp" %>
<script type="text/javascript">
//첫 시작
	function open(){
			$("#dlg_test1").dialog('open');
			$.ajax({
				method:"get"
				,url:'/onLineTest/swDesignExam.max?work=onLineTest&sub_cd=1001'
				,success:function(data){
					var jsonDoc = JSON.parse(data);
					if (jsonDoc.length>0) {
						for(var i=0;i<jsonDoc.length;i++){
							$("#d_test"+(i+1)).html(jsonDoc[i].question+"<br>"
													+jsonDoc[i].answer1+"<br>"
													+jsonDoc[i].answer2+"<br>"
													+jsonDoc[i].answer3+"<br>"
													+jsonDoc[i].answer4
													);
						}
					}
				}
			});
		}; 
//이전페이지
		function prev(now,next){
			$("#"+now+"").dialog('close');
			$("#"+next+"").dialog('open');
		}
//다음페이지
		function next(close,open){
			$("#"+close+"").dialog('close');
			$("#"+open+"").dialog('open');

		}
</script>
</head>
<body>
	<script type="text/javascript">
		//DOM 구성 완료 시, 콤보박스 초기화
		$(document).ready(function() {
			//콤보박스 초기화
			$('#cb_subject').combobox({
		        url:'/onLineTest/subjectList.max?work=onLineTest'
		       ,valueField:'SUB_CD'
		       ,textField:'SUB_NAME'
		       ,panelHeight:'auto'
		       ,onSelect:function(record){
		           alert(record.SUB_NAME);
		        }
			});
		});
	</script>
	
<!-- Panel -->
<div class="easyui-panel" title="Test Take" 
	 style="width:100%;max-width:400px;padding:30px 30px"> 
<!-- ComboBox -->	
	<div style="margin-bottom:20px">
		<select class="easyui-combobox" id="cb_subject"
				label="수험과목 선택:" labelPosition="top" 
				data-options="prompt:'수험과목 선택하세요.'" 
				style="width:100%"> 
		</select>
	</div>
<!-- TextBox -->	
	<div>
		<div  style="margin-bottom:30px" >
			<input class="easyui-textbox" 
					label="수험번호 :" labelPosition="top" 
					style="with:150%"> 
		</div>
	</div>
<!-- Button -->
	<div>
		<a href="javascript:open()" class="easyui-linkbutton" 
		   iconCls="icon-ok" style="width:100%;
		   height:32px">
		Test Start
		</a>
	</div>
</div>
<!-- 문제 넣기 -->
<!-- 1 -->
		<div id="dlg_test1" class="easyui-dialog" style="width: 700px; height: 400px;"
				data-options="title:'문제1', closed:'true', buttons:'#btn_test1',modal:true">
			<div id="d_test1"></div>
		</div>
		<div id="btn_test1">
       		<a href="javascript:next('dlg_test1','dlg_test2')" class="easyui-linkbutton">Question No.2</a>
    	</div>
<!-- 2 -->	    
	<div id="dlg_test2" class="easyui-dialog" style="width:700px;height:300px"
		data-options="title:'문제2', closed:'true', buttons:'#btn_test2', modal:true">
		<div id='d_test2'>
	    	Q2
	    </div>
	</div>
	<div id="btn_test2">
		<a href="javascript:prev('dlg_test2','dlg_test1')" class="easyui-linkbutton">Question No.1</a>
		<a href="javascript:next('dlg_test2','dlg_test3')" class="easyui-linkbutton">Question No.3</a>
	</div>
<!-- 3 -->	    
	<div id="dlg_test3" class="easyui-dialog" style="width:700px;height:300px"
		data-options="title:'문제3', closed:'true', buttons:'#btn_test3', modal:true">
		<div id='d_test3'>
	    	Q3
	    </div>
	</div>
	<div id="btn_test3">
		<a href="javascript:prev('dlg_test3','dlg_test2')" class="easyui-linkbutton">Question No.2</a>
		<a href="javascript:next('dlg_test3','dlg_test4')" class="easyui-linkbutton">Question No.4</a>
	</div>
<!-- 4 -->	    
	<div id="dlg_test4" class="easyui-dialog" style="width:700px;height:300px"
		data-options="title:'문제4', closed:'true', buttons:'#btn_test4', modal:true">
		<div id='d_test4'>
	    	Q4
	    </div>
	</div>
	<div id="btn_test4">
		<a href="javascript:prev('dlg_test4','dlg_test3')" class="easyui-linkbutton">Question No.3</a>
		<a href="javascript:next('dlg_test4','dlg_confirm')" class="easyui-linkbutton">Check Page</a>
	</div>
<!-- 제출 답안 확인 페이지 -->	
	<div id="dlg_confirm" class="easyui-dialog" style="width:700px;height:300px"
		data-options="title:'답안 확인 페이지', closed:'true', buttons:'#btn_confirm', modal:true">
	    	Did you do your best?<br>
	    	Thanks<br>
	    	Please, Submit your answer<br>
	</div>
	<div id="btn_confirm">
		<a href="javascript:examStart()" class="easyui-linkbutton">Submit</a>
	</div>

</body>
</html>