<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DataGrid_data 속성</title>
</head>
<body>
    <script>
    $(document).ready(function(){
        $("#dg_test").datagrid({
            columns:[[
                {field:'code',title:'f1',width:100},
                {  field:'name',title:'f2',width:100}
    		]]
	        ,data: [
		        {f1:'value11', f2:'value12'},
		        {f1:'value21', f2:'value22'}
            ]
        });
    });
    </script>
    <table id=dg_test>
        
    </table>

</body>
</html>