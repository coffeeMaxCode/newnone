<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%@ page import="com.vo.SNSMessageSet" %>    
<%
	List<SNSMessageSet> list = 
			(List<SNSMessageSet>)request.getAttribute("smsgList");
	if(list !=null){
		out.print("list ==> "+list.size());
	}
%>    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>My Simple SNS</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../Stylesheet/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../Stylesheet/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../Stylesheet/demo/demo.css">
<script type="text/javascript" src="../Stylesheet/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../Stylesheet/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../Stylesheet/js/jquery.cookie.js"></script>
<script type="text/javascript" src="../Stylesheet/js/commons.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
//상태글 작성창 열기
function openMsg(){
	//alert("버튼작동");
	$("#dlg_newAdd").dialog('open');
}
//작성글 저장 기능
function addAction(){
	//alert("버튼작동");
	$("#f_newAdd").attr("method","post");
	$("#f_newAdd").attr("action","/mySNS/test.hh?crud=newAdd");
	$("#f_newAdd").submit();
	//self.close();
} 

</script>
</head>
<script type="text/javascript">
	$.ajax({
		method:"get"
	   ,url:"test.hh?crud=smsgList&timestamp="+new Date().getTime()
	   ,success:function(data){
		   //alert(data);
		   $("#d_msg").html(data);
	   }
	});

</script>

<!-- 상단 제목 -->
<div class="jumbotron text-center">
  <h1>My Simple SNS</h1>
</div>

<!-- 글 목록 -->
<div class="container">
  <div class="row">
  
    <div class="col-sm-7">
      <h3>친구들의 최신소식</h3>
      <!-- 새 상태글 쓰기 버튼 -->
      <a href="javascript:openMsg()" class="easyui-linkbutton" 
      		data-options="iconCls:'icon-edit'" plain="true" >새 상태글 작성</a><br><br>
      <!-- 상태글 넣기 -->
      <div id="d_msg"></div>
    </div>
    
     <div class="col-sm-5">
      <h3>새로운 친구들!!!</h3>        
    <div id="d_new"></div>
    </div>
    
  </div>
</div>


<!-- 글쓰기 화면 -->
<!-- JEasyUI - Dialog API 활용 -->
<div 	id="dlg_newAdd" class="easyui-dialog" style="width:600px;height:450px;padding:10px" 
		title="새 상태글 쓰기 화면" data-options="closed:true,modal:'true',footer:'#tbar_newAdd'">
 	<form id="f_newAdd" method="post">
 	<!-- hidden으로 Map에 값으로 넘겨주기 --> 
 	
		<table cellspacing="7px">
			<tr>
				<td width="100px">NickName</td>
				<td width="500px">
					<input class="easyui-textbox" id="mem_id" name="mem_id" data-options="width:'250px'">
				</td>
			</tr>
			<tr>
				<td width="100px">상태글 작성</td>
				<td width="500px">
					<input class="easyui-textbox" id="msg" name="msg" style="width:450px;height:300px">
				</td>
			</tr>
		</table>
	</form>
</div>
<!-- 버튼 추가 : 저장/닫기 -->
<div id="tbar_newAdd" align="right" style="padding:3px 10px">
	<a href="javascript:addAction()" class="easyui-linkbutton" iconCls="icon-save" >Save</a>
	<a href="javascript:$('#dlg_newAdd').dialog('close')" class="easyui-linkbutton" iconCls="icon-cancel">Close</a>
</div>


</body>
</html>
