<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap" %>
<%
	List<Map<String,Object>> boardUpdateForm = 
		(List<Map<String,Object>>)request.getAttribute("boardUpdateForm");
	Map<String,Object> rMap = new HashMap<>();

	 if(boardUpdateForm!=null){
			rMap = boardUpdateForm.get(0);
		}
	 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 화면</title>
<%@ include file="/Stylesheet/JEasyUICommon.jsp" %>
<script type="text/javascript">
	function updAction(){
		var db_pw = <%=rMap.get("BM_PW")%>;
		var u_pw = $("#u_pw").textbox('getValue');
		if(db_pw == u_pw){
			//alert("Same!");
			$.messager.confirm('confirm','Will u Update it?',function(u){
				if(u){
					$("#f_boardUpd").attr("method","post");
					$("#f_boardUpd").attr("action","/Board/test.mil?crud=boardUpd&bm_no="+<%=rMap.get("BM_NO")%>);
					$("#f_boardUpd").submit();
					/* 업데이트 완료 후, 부모창 새로고침 */
					/* opener.parent.location.reload(); */
					/* 창 자동 종료 */
					/* 폼전송과 충돌나는 코드임! */
					/* self.close(); */
				}
				else{
					alert("일안해");
				}
			});
		}//→ 불일치 → 비밀번호 확인  알람
		else{
			alert("Check PW plz");
		}
		
		/* opener.parent.location.reload(); */
		/* self.close(); */
		
	}
</script>
</head>
<body>
<script type="text/javascript">
	
</script>
<!-- 글 수정 화면 -->
<form id="f_boardUpd" method="post" enctype="multipart/form-data">
<%-- 
	<input type="hidden" name="crud" value="boardUpd" />
	<input type="hidden" name="bm_no" value="<%=rMap.get("BM_NO")%>" />
	<input type="hidden" name="bs_size" value="<%=rMap.get("BS_SIZE")%>" />
 --%>
<table id="pan_update" class="easyui-panel" title="게시글수정" data-options="footer:'#tb_update'"
	   style="width:620px;height:380px;padding:10px;background:#fafafa;">
	<tr>
		<td>Title</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BM_TITLE") %>"
						id="bm_title" name ="bm_title" data-options="width:'450px'" ></td>
	</tr>
	<tr>
		<td>Writer</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BM_WRITER") %>"
						id="bm_writer" name ="bm_writer" data-options="width:'450px'" ></td>
	</tr>
	<tr>
		<td>E-mail</td>
		<td><input class="easyui-textbox"  value="<%=rMap.get("BM_EMAIL") %>"
						id="bm_email" name ="bm_email" data-options="width:'450px', validType:'email'" ></td>
	</tr>
	<tr>
		<td>Content</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BM_CONTENT") %>"
						id="bm_content" name ="bm_content"
								data-options="width:'450px', height:'100px', MULTILINE:'true'"  ></td>
	</tr>
	<tr>
		<td>File</td>
		<td><input class="easyui-filebox"  value="<%=rMap.get("BS_FILE") %>"
						id="bs_file" name ="bs_file" data-options="width:'450px'" ></td>
	</tr>
	<tr>
		<td colspan="2" align="center">Insert Password</td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input class="easyui-passwordbox"
						id="u_pw" name ="u_pw" data-options="width:'450px'" ></td>
	</tr>
</table>
</form>
<!-- 버튼 추가 : 수정, 삭제, 댓글작성, 목록으로 이동 -->
<div id="tb_update" style="padding:2px 5px;" align="Center">
        <a href="javascript:updAction()" class="easyui-linkbutton" iconCls="icon-save" plain="true">Update</a>
        <a href="javascript:self.close()" class="easyui-linkbutton" iconCls="icon-back" plain="true">Close</a>
</div>
</body>
</html>