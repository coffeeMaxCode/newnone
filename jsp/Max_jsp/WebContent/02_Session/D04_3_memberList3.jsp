<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<link rel="stylesheet" type="text/css" 	href="../../Stylesheet/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" 	href="../../Stylesheet/themes/icon.css">
<link rel="stylesheet" type="text/css" 	href="../../Stylesheet/demo/demo.css">
<script type="text/javascript" src="../../Stylesheet/js/jquery.min.js"></script>
<script type="text/javascript" src="../../Stylesheet/js/jquery.easyui.min.js"></script>

<script type="text/javascript">
<!-- Onclick Event -->
	function memberList(){
		$('#dg_member').datagrid({
			url : './D04_2_memberServlet2.max'
			,onLoadSuccess: function(data){
				alert("Search Success")
			}
		});
	}
</script>
</head>
<body>
	<table id="dg_member" toolbar="#tb_member" 
			class="easyui-datagrid" title="memberList" 
			width="400px" height="250px" style="border='1'">
		<thead>
		<tr>
			<th data-options="field:'mem_id',width:100">ID</th>
			<th data-options="field:'mem_pw',width:100">PW</th>
			<th data-options="field:'mem_name',width:100">Name</th>
		</tr>
		</thead>
	</table>
<!-- 테이블 내부 링크버튼 추가 -->
	<div id="tb_member" style="padding:5px">
		 <a href="#" class="easyui-linkbutton" 
		 	data-options="iconCls:'icon-search'" 
		 	style="width:100px"
		 	onClick="memberList()">Search</a>
	</div>
</body>
</html>