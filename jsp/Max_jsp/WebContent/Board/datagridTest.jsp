<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/Stylesheet/JEasyUICommon.jsp" %>
</head>
<body>
<table class="easyui-datagrid" title="물품목록" style="width:400px;height:250px"
        data-options="fitColumns:true,singleSelect:true">
    <thead>
        <tr>
            <th data-options="field:'code',width:100">Code</th>
            <th data-options="field:'name',width:100">Name</th>
            <th data-options="field:'price',width:100,align:'right'">Price</th>
        </tr>
    </thead>
<!-- dataSet & dataGrid가 만나는 부분 = Mapping -->
    <tbody>
<%
   for(int i=0; i<2;i++){
 %>
    	<tr>
    		<td><%="a001" %></td>
    		<td><%="노트북" %></td>
    		<td><%=350000 %></td>
    	</tr>
<%
   		}
%>
    </tbody>
</table>
<div id="tb_board" style="padding:2px 5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
</div>
</body>
</html>