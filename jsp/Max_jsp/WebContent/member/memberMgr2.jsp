<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../Stylesheet/JEasyUICommon.jsp"%>
</head>
<body>
	<script type="text/javascript">

	$(document).ready(function(){
		 $('#dg_member').datagrid({
			 URL:"memberList.max?work=member"
		    ,title:"Member List V1.0"
		    ,toolbar:'#tb_member'
		    ,columns:[[
		        {field:'MEM_ID',title:'ID',width:100},
		        {field:'MEM_NAME',title:'Name',width:100},
		        {field:'MEM_ADDR',title:'Address',width:100,align:'left'}
		    ]]
		});  
		
		 $('#btn_join').linkbutton({
			   onClick:function(){
			    $('#dlg_join').dialog('open');
			   }
			  })
		
		$('#dlg_join').dialog({
			 width:500
			,height:330
			,footer:"#tb_join"
			,closed:false
		});
		
		$('#btn_save').linkbutton({
			onClick:function(){
				$('#f_join').attr('method','get');
				$('#f_join').attr('action','./memberInsert.max');
				$('#f_join').submit();
				$('#dlg_join').dialog('close');
			}
		});
		
		$('#btn_close').linkbutton({
			onClick:function(){
				$('#dlg_join').dialog('close');
			}
		});
		
	});
</script>

	<table id="dg_member"></table>
<!-- 가입 버튼 -->
	<div id="tb_member" style="padding: 5px;">
		<a id="btn_join" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true">Join </a>
	</div>
	
<!-- 회원가입 -->
	<div id="dlg_join" padding=30>
	<form id ="f_join">
	<!-- id는 화면단/브라우저  name 서버에서 사용 -->
	<input type="hidden" id ="work" name ="work" value="member" />
		 <div style="margin-bottom:15px">
            <input class="easyui-textbox" id="mem_id" name ="mem_id" label="ID" labelPosition="right" 
            data-options="prompt:'Enter a ID...'" style="width:450px;">
        </div>
        <div style="margin-bottom:15px">
            <input class="easyui-textbox" id="mem_pw" name ="mem_pw" label="PW" labelPosition="right" 
            data-options="prompt:'Enter a pass word...'" style="width:450px;">
        </div>
        <div style="margin-bottom:15px">
            <input class="easyui-textbox" id="mem_name" name ="mem_name" label="Name" labelPosition="right" 
            data-options="prompt:'Enter your name...'" style="width:450px;">
        </div>
        <div style="margin-bottom:15px">
            <input class="easyui-textbox" id="mem_addr" name ="mem_addr" label="Address" labelPosition="right" 
            data-options="prompt:'Enter a address...'" style="width:450px;">
        </div>
        <div style="margin-bottom:15px">
            <input class="easyui-textbox" id="mem_zipcode" name ="mem_zipcode" label="Zipcode" labelPosition="right" 
            data-options="prompt:'Enter a zipcode...'" style="width:450px;">
        </div>
        </form>
	</div>
	
	<div id="tb_join" style="padding:5px;">
	<a id="btn_save" href="#" class="easyui-linkbutton"
		data-options="iconCls:'icon-save',plain:true">Save</a>
	<a id="btn_close" href="#" class="easyui-linkbutton">Close</a>
	</div>

</body>
</html>