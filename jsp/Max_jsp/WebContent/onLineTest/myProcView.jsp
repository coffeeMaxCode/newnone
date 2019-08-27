<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../../Stylesheet/JEasyUICommon2.jsp" %>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			 method:"get"
			,url:"myProcTest.jsp"
			,success:function(data){
				//자바에서 자바 스크립트로 바뀜 new Array()
				var jsonDoc = JSON.parse(data);
				/* if(jsonDoc.length>0){
					for(var i=0;i<jsonDoc.length;i++){
						alert(jsonDoc[i].MEM_NAME);
					}
				}
				else{
						alert("if문 놀고 있다");
				} */
				$("#d_json").text(data);
			}
		});
		
	});
</script>
<div id="d_json"></div>
</body>
</html>