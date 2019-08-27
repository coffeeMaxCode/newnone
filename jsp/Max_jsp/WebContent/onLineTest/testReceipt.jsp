<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vo.MemberVO"  %>
<%
	MemberVO mVO = (MemberVO)session.getAttribute("rmVO");
	String s_memid = null;
	String s_memname =  null;
	if(mVO!=null){
		s_memid = mVO.getMEM_ID();
		s_memname = mVO.getMEM_NAME();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online test enroll</title>
<%@ include file="../Stylesheet/JEasyUICommon.jsp" %>
</head>
<body>
<script type="text/javascript">
	function receipt(){
		$("#f_receipt").attr("method","get");
		/* crud 이름 */
		$("#f_receipt").attr("action","examReceipt.max");
		/* 전송 시작 */
		$("#f_receipt").submit();
		}
	//달력 넣기
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'/'+(m<10?('0'+m):m)+'/'+(d<10?('0'+d):d);
	}
	$.fn.datebox.defaults.parser = function(s){
		var t = Date.parse(s);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	}
	
	//DOM 구성 완료 시, 콤보박스 초기화
	$(document).ready(function() {
		//로그인 후, 이름 정보 받아오기
		$("#mem_name").textbox('setValue','<%=s_memname%>');
		//콤보박스 초기화
		$('#cb_subject').combobox({
	        url:'/onLineTest/subjectList.max?work=onLineTest'
	       /* 서버에 넘어가는 값 */
	       ,valueField:'SUB_CD'
	       /* 화면에 출력 되는 값 */
	       ,textField:'SUB_NAME'
	       ,panelHeight:'auto'
	       ,onSelect:function(record){
	           alert(record.SUB_NAME);
	        }
		});
	});
	
	
</script>
<!-- Panel -->
<div class="easyui-panel" title="Test Enroll" 
	 style="width:100%;max-width:600px;padding:30px 30px">
	 <form id="f_receipt">
	 <input type="hidden" id="mem_id" name="mem_id" value="<%=s_memid %>">
	 <input type="hidden" id="work" name="work" value="onLineTest">
<!-- TextBox -->	
	<div>
		<div  style="margin-bottom:30px" >
			<input class="easyui-textbox"  
			       id="mem_name" name="mem_name"
				   label="Name :" labelPosition="top" 
				   style="with:150%"> 
		</div>
	</div>
<!-- DateBox -->	
	<div>
		<div  style="margin-bottom:30px" >
			<input class="easyui-datebox"  
			       id="exam_date" name="exam_date"
				   label="Exam Date :" labelPosition="top" 
				   style="with:150%"> 
		</div>
	</div>
<!-- ComboBox -->	
	<div style="margin-bottom:20px">
		<select class="easyui-combobox" id="cb_subject" name="sub_cd"
				label="수험과목 선택:" labelPosition="top" 
				data-options="prompt:'수험번호를 선택하세요.'" 
				style="width:50%"> 
		</select>
	</div>
<!-- Button -->
	<div>
		<a href="javascript:receipt()" class="easyui-linkbutton" 
		   iconCls="icon-ok" style="width:100%;
		   height:32px">
		Accepted
		</a>
	</div>
	</form>
</div>

</body>
</html>