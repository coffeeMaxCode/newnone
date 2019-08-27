<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap" %>
<%
	List<Map<String,Object>> boardDetail = 
		(List<Map<String,Object>>)request.getAttribute("boardDetail");
	Map<String,Object> rMap = new HashMap<>();
	
	/* MyBatis 사용시 자동으로 담아줌 
	 * 	VO의 경우 사용자가 대문자를 구분
	 * 	Map의 경우 MyBatis 컬럼명을 기준으로 자동으로 키값 생성 → 디폴트가 대문자			*/
	 if(boardDetail!=null){
			rMap = boardDetail.get(0);
		}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<%@ include file="/Stylesheet/JEasyUICommon.jsp" %>
<script type="text/javascript">
//댓글 작성
	function repleForm(){
		$("#dlg_commentAdd").dialog('open');
	}
	
//댓글 작성 저장 - form 값받아서 보내기	
  	function addAction(){
		$("#f_commentAdd").attr("method","post");
		$("#f_commentAdd").attr("action","/Board/test.mil?crud=boardAdd");
		$("#f_commentAdd").submit();
		/* 부모 창의 함수를 호출 시, opener.함수명(); */
		$(opener.document).boardList();
		self.close();
	} 
	
//글 수정 → 팝업화면 띄우기
	function updateForm(){
		cmm_window_popup('/Board/test.mil?crud=updateForm&bm_no=<%=rMap.get("BM_NO")%>','660','430','updateForm');
}
//수정창 처리
	function boardUpdClose(){
		
	}	
	
//글 삭제 다이얼로그 화면 - 비밀번호 확인
	function deleteFrom(){
		$("#dlg_boardDel").dialog({
			buttons: btn_boardDel,
			title:'Delete Data',
			width : 420,
			height:250,
			modal:true,
			href:'boardDelForm.jsp?bm_no=<%=rMap.get("BM_NO")%>&bm_pw=<%=rMap.get("BM_PW")%>'
		});
		$("#dlg_boardDel").dialog('open');
	}	
//글 삭제 처리 함수
	function boardDel(){
		var db_pw = <%=rMap.get("BM_PW")%>;
		//현재 위치한 페이지와 비밀번호 입력받는 화면이 다름 → 어떻게 접근?
		var u_pw = $("#u_pw").textbox('getValue');
		//alert("db_pw = "+db_pw+"/ u_pw = "+u_pw);
		
		/* 사용자가 입력한 비밀번호, DB의 비밀번호 비교 					*/
		//→ 일치 → 삭제									
		if(db_pw == u_pw){
			//alert("Same!");
			$.messager.confirm('confirm','Will u delete it?',function(d){
				if(d){
					location.href="\Board\test.mil?crud=boardDel&bm_no=<%=rMap.get("BM_NO")%>&bs_file=<%=rMap.get("BS_FILE")%>";
				}
			});
		}//→ 불일치 → 비밀번호 확인  알람
		else{
			alert("Check PW plz");
		}
	}	
//삭제창 처리
    function boardDelClose(){
		$("#dlg_boardDel").dialog('close');    	
    }	
	
//목록으로 돌아가기
	function bordList(){
		//alert("boardList");
		location.href="/Board/test.mil?crud=boardList";
	}
	
</script>
</head>
<body>

<script type="text/javascript">
	$("document").ready(function (){		
		$("#dlg_boardDel").hide();
	});
	
</script>

<!-- 글 상세 화면 -->
<table id="pan_read" class="easyui-panel" title="글 상세조회" data-options="footer:'#tb_read'"
	   style="width:670px;height:380px;padding:10px;background:#fafafa;">
	<tr>
		<td>Title</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BM_TITLE") %>" id="bm_title" data-options="width:'450px'" readonly  ></td>
	</tr>
	<tr>
		<td>Writer</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BM_WRITER") %>" id="bm_writer" DAta-options="width:'450px'"  readonly ></td>
	</tr>
	<tr>
		<td>E-mail</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BM_EMAIL") %>" id="bm_email" data-options="width:'450px', validType:'email'"  readonly ></td>
	</tr>
	<tr>
		<td>Content</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BM_CONTENT") %>" id="bm_content" 
					data-options="width:'450px', height:'100px', MULTILINE:'true'"  readonly ></td>
	</tr>
	<tr>
		<td>File</td>
		<td><input class="easyui-textbox" value="<%=rMap.get("BS_FILE") %>" id="bs_file" data-options="width:'450px'" ></td>
	</tr>
</table>
<!-- 버튼 추가 : 수정, 삭제, 댓글작성, 목록으로 이동 -->
<div id="tb_read" style="padding:2px 5px;" align="Center">
        <a href="javascript:repleForm()" class="easyui-linkbutton" iconCls="icon-add" plain="true">Comment</a>
        <a href="javascript:updateForm()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">Update</a>
        <a href="javascript:deleteFrom()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">Delete</a>
        <a href="javascript:bordList()" class="easyui-linkbutton" iconCls="icon-back" plain="true">Back To List</a>
</div>


<!-- 글 수정기능 -->


<!-- 글 삭제하기 화면 : 비밀번호 화면-->
<div	id="dlg_boardDel" closed="true" class="easyui-dialog" style="padding:20px 50px">
	<!-- 버튼 : 삭제 닫기 -->
	<div id="btn_boardDel" align="right">
		<a href="javascript:boardDel()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">Delete Commit</a>
        <a href="javascript:boardDelClose()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">Cancel</a>
	</div>
</div>


<!-- 댓글 작성하기 화면 -->
<!-- JEasyUI - Dialog API 활용 -->
<div 	id="dlg_commentAdd" class="easyui-dialog" style="width:600px;height:558px;padding:10px" 
		title="댓글쓰기 화면" data-options="closed:true,modal:'true',footer:'#tbar_boardAdd'">
	<!-- 
		form 전송시, encType옵션이 추가되면 request객체로 사용자가 입력한 값을 꺼낼 수 없다
		MultipartRequest → cos.jar OR API
	-->
 	<form id="f_commentAdd" method="post" enctype="multipart/form-data">
 	<!-- hidden으로 Map에 값으로 넘겨주기 --> 
 	<!-- <input type="hidden" name="crud" value="boardAdd"> -->
 	<input type="hidden" name="bm_no" value="<%=rMap.get("BM_NO") %>">
 	<input type="hidden" name="bm_group" value="<%=rMap.get("BM_GROUP") %>">
 	<input type="hidden" name="bm_pos" value="<%=rMap.get("BM_POS") %>">
 	<input type="hidden" name="bm_step" value="<%=rMap.get("BM_STEP") %>">
 	
		<table cellspacing="7px">
			<tr>
				<td width="100px">Title</td>
				<td width="500px">
					<input class="easyui-textbox" id="bm_title" name="bm_title" data-options="width:'250px'" required>
				</td>
			</tr>
			<tr>
				<td width="100px">Writer</td>
				<td width="500px">
					<input class="easyui-textbox" id="bm_writer" name="bm_writer" required>
				</td>
			</tr>
			<tr>
				<td width="100px">E-mail</td>
				<td width="500px">
					<input class="easyui-textbox" id="bm_email" name="bm_email" required>
				</td>
			</tr>
			<tr>
				<td width="100px">Content</td>
				<td width="500px">
					<input 	class="easyui-textbox" id="bm_content" name="bm_content" 
							data-options="multiline:'true',width:'350px',height:'250px'" required>
				</td>
			</tr>
			<tr>
				<td width="100px">Password</td>
				<td width="500px">
					<input class="easyui-passwordbox" id="bm_pw" name="bm_pw" required>
				</td>
			</tr>
		</table>
	</form>
</div>
<!-- 버튼 추가 : 저장/닫기 -->
<div id="tbar_boardAdd" align="right" style="padding:3px 10px">
	<a href="javascript:addAction()" class="easyui-linkbutton" iconCls="icon-save" >Save</a>
	<a href="javascript:$('pan_read').dialog('close')" class="easyui-linkbutton" iconCls="icon-cancel">Close</a>
</div>

</body>
</html>