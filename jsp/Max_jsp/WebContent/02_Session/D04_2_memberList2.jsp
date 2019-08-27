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
</head>
<body>
	<table class="easyui-datagrid" title="memberList" style="width:400px;height:250px;border:1"
	data-options="singleSelect:true,collasible:true,url:'./D04_2_memberServlet2.max',method:'get'">
		<thead>
		<tr>
			<th data-options="field:'mem_id',width:100">ID</th>
			<th data-options="field:'mem_pw',width:100">PW</th>
			<th data-options="field:'mem_name',width:100">Name</th>
		</tr>
		</thead>
	</table>
</body>
</html>