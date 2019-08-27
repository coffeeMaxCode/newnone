<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap" %>
<%@ page import="com.util.PageBar" %> 
<%  //총레코드 갯수
	int total = 0;
	if(session.getAttribute("s_total")!=null){
		total = Integer.parseInt(session.getAttribute("s_total").toString());
	}
	out.println("total = "+total);
	
	//게시글 개수 파악하기 + 넣어주기 : 세션에서 값을 가져오기
	int size = 0;
	List<Map<String,Object>> boardList = (List<Map<String,Object>>)request.getAttribute("boardList");
/* 	out.println("boardList = "+boardList);
	out.println("size ="+size);					 */
	if(boardList !=null && boardList.size()>0){
		size = boardList.size();
	}
	out.println("size ="+size);	
	
	//페이지네비게이션 추가
	int numPerPage = 10;
	int nowPage = 0;
	if(request.getParameter("nowPage")!=null){
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
	
	//필요한 Map 가져오기
	List<Map<String, Object>> boardDetail 
			= (List<Map<String, Object>>)request.getAttribute("boardDetail");
	Map<String, Object> rMap = new HashMap<>();
	
	//
%>
<!-- 화면안에 태그로 할때와 스크립트로 할 경우 차이점
	1) 태그안에 코드 작성시 : 디자인과 코드 분리 어려움 : 가독성 떨어짐
	2) 스크립트로     처리시 : 화면과 코드가 분리 : 이벤트처리 or DOM조작 中 접근성 좋음
	3) 화면과 스크립트 코드를 분리 : react 적용시, 라이프 사이클에 따라 코드 적용 용의
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC패턴을 적용한 계층형 게시판 구현</title>
<%@ include file="/Stylesheet/JEasyUICommon.jsp" %>
<script type="text/javascript">
//전역변수
	//사용자가 선택한 콤보에 대한 키워드 값 저장
	var cb_value;
	//선택한 콤보에 대한 키워드 값 저장
	var tb_value;

//상세조회
	function boardDetail(p_bmno){
		/* 팝업으로 띄우기 */
		//cmm_window_popup("test.mil?crud=boardDetail&bm_no="+p_bmno,"700","500","read");
		/* 페이지 이동 */
		location.href="test.mil?crud=boardDetail&bm_no="+p_bmno;
		/* 다이얼로그로 */
		
	}
	
//form 값받아서 보내기	
  	function addAction(){
		$("#f_boardAdd").attr("method","post");
		$("#f_boardAdd").attr("action","/Board/test.mil?crud=boardAdd");
		$("#f_boardAdd").submit();
		
	} 
	
<%-- //검색 기능	//// 태그 조작 == DOM조작 : json : DefaultTableModel  / datagrid : JTable
					삭제		삭제		삭제		삭제		삭제										--%>

//페이지 이동 함수
	function pageMove(pageNumber, pageSize) {
		//alert(pageNumber+"  /  "+pageSize);
		//페이지 안에서 url을 받아서 결과를 받아 dg에 다가 뜨워줌
		/* $("#dg_board").datagrid(
				{
					 url : "/Board/test.mil?crud=boardList&pageNumber="+pageNumber+"&pageSize="+pageSize 
				}); */
		location.href = "/Board/test.mil?crud=boardList&pageNumber="+pageNumber+"&pageSize="+pageSize
	}
/* 각 로우별 DB에서 새로 읽어들인 값이 출력되고 그 파일이름으로 다운로드 파일명을 찾아야 하므로
 * 이벤트 발생시 마다, 파일이름이 달라짐
 
 * 자바코드로 읽어들인 정보를 자바스크립트 변수로 사용 가능, 그 값은 상숯러럼 정해진 정적인 성격을 가지고 있음!!
 * 서버에서 바뀐 값이 화면에 즉시 반영 될 수 없는 것은 서버페이지가 아닌 응답페이지의 경우 
 * 이미 html코드로 변경된 페이지가 다운되고 출력
 * 							→ 절대 유동적인 변화를 기대할 수 없음													 */
//파일 다운로드 기능
	function fileDown(fname){
		location.href="downLoad.jsp?bs_file="+fname;
	}

//글 추가기능
	function addForm() {
		//alert("addForm 호출성공");
		$("#dlg_boardAdd").dialog('open');
	}
//글 수정기능
	function updForm() {
		//alert("updForm 호출성공");
	}

//글 삭제기능
	//글 삭제 다이얼로그 화면
	function delForm(){
		//alert("delForm 호출성공");
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
</script>
</head>
<body>
<script type="text/javascript">
//전역변수 선언 위치
	//콤보박스에서 선택한 값 담기
	var user_combo;
	/* 게시글 목록화면에서 사용자가 제목을 더블클릭했을 때, 
		셀에대한 정보만 들어있으므로 선택한 로우에 숫자값을 가지고
		숨어있는 필드 bm_no의 값을 가져와서 담기 								*/
	var g_no;
//기본 날짜 형식 재정 : formatter
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'/'+(m<10 ? "0"+m:m)+'/'+(d<10 ? "0"+d:d);
	}
//기본 날짜 형식 재정 : parser
	$.fn.datebox.defaults.parser = function(s){
		var t = Date.parse(s);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	}
	
//DOM구성
	$(document).ready(function(){
		
//삭제 (datagrid : 초기화 및 컬럼 설정 기능) : Ver2. 스크립트에서 처리하는 방법
	
//combobox 이벤트 설정
		$("#cb_search").combobox({
			onChange:function(){
				user_combo = $(this).combobox('getValue');
			}
		});

//textbox Enter 이벤트 설정
		$("#keyword").textbox('textbox').bind('keydown',function(e){
			if(e.keyCode == 13){	// Enter key Code = 13 
				//alert("Press Enter");
				$("#dg_board").datagrid({
					url:"test.mil?crud=boardList&cb_search="
							    +user_combo+"&keyword="+$("#keyword").val()
				});			    
			}
		});
		
<%-- //페이지네이션 pagenation(pn_board) 초기화 및 설정
페이지네비게이션으로 변경														--%>
		
	})//DOM구성 마무리
</script>


<!-- 글 목록 화면 -->
<!-- JEasyUI - DataGrid API 활용
		1) 익스프레션을 이용 : 화면처리 : tr,td태그 직접 작성
		2) json포맷으로 처리 : 매핑     : field 만 맞춰주면 자동으로 매핑				 -->
<table id="dg_board" title="글목록" style="width:946px;height:457px" class="easyui-datagrid" 
		data-options="singleSelect:'true', toolbar:'#tb_search,#tb_board',footer:'#pn_board'">
 	<!--헤더부분 추가 -->
 	<thead>
	 	<tr>
	 		<th data-options="field:'BM_TITLE',width:'350px'">제목</th>
            <th data-options="field:'BM_WRITER',width:'100px'">작성자</th>
            <th data-options="field:'BM_DATE',width:'110px'">작성일</th>
            <th data-options="field:'BS_FILE',width:'280px'">첨부파일</th>
            <th data-options="field:'BM_HIT',width:'100px'">조회수</th>
	 	</tr>
 	</thead>
 	<!--데이터 출력 영역  -->
 	<tbody>
<%		/* 데이터가 없습니다 */
	if(size==0){
%> 	
 		<tr>
	 		<td colspan="5">조회결과가 없습니다.</td>
	 	</tr>
<%
	}	/* 데이터 존재 */
	else if(size>0){
		for(int i=nowPage*numPerPage; i<(nowPage*numPerPage)+numPerPage ;i++){
			if(size == i) break;
			rMap = boardList.get(i);
%>	 	
 		<tr>
	 		<td>
<!-- 너 댓글이니? -->
<%
	/* String imgPath ="\\board\\"; */
	if(Integer.parseInt(rMap.get("BM_POS").toString()) > 0 ){
		for(int j=0;j<Integer.parseInt(rMap.get("BM_POS").toString());j++){
			out.print("&nbsp;&nbsp;");
		}
%>
	<img src="reply.gif" border="0"> 
<%		
	}
%>	 		
<a href="javascript:boardDetail('<%=rMap.get("BM_NO")%>')" style="text-decoration:none;color:#000000">
	 		<%=rMap.get("BM_TITLE") %>	
</a>	 		
	 		</td>
	 		<td><%=rMap.get("BM_WRITER") %></td>
	 		<td><%=rMap.get("BM_DATE") %></td>
	 		<td><a href="javascript:fileDown('<%=rMap.get("BS_FILE") %>')"><%=rMap.get("BS_FILE") %></a></td>
	 		<td><%=rMap.get("BM_HIT") %></td>
	 	</tr>
<%
		}
	}
%>	 	
 	</tbody>
 </table>

	<!-- 페이지네이션 pagination -->
<table border="1" borderColor="red" style="width:950px;height:20px">
 	<tr>
 	<td align="center" >
 		<!-- 1 2 3 4 5 6 7 8 9 10 <br> -->
<%
	String pagePath = "test.mil?crud=boardList";
	PageBar pb = new PageBar(numPerPage,size,nowPage,pagePath);
 	String pagination = null;
 	pagination = pb.getPageBar();
 	out.print(pagination);
%> 		
 	</td>
 	</tr>
 </table>	

	<!-- 조건 검색 툴바 -->
<div id="tb_search" style="padding:2px 5px;">
	<select id="cb_search" name="cb_search" class="easyui-combobox" style="width:100px;" panelHeight="auto">
		<option selected> Select </option>
		<option value="bm_title"> Title </option>
		<option value="bm_content"> Content </option>
		<option value="bm_writer"> Writer </option>
	</select>
	<input class="easyui-textbox" id="keyword" name="keyword" style="width:340px">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	작성일 : <input class="easyui-datebox" id="bm_date" name="bm_date" style="width:120px">
	<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true">Search</a> -->
</div>

	<!-- 버튼 툴바 -->
<div id="tb_board" style="padding:2px 5px;">
        <a href="javascript:boardList()" class="easyui-linkbutton" iconCls="icon-search" plain="true">Search</a>
        <a href="javascript:addForm()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">Input</a>
        <a href="javascript:updFrom()" class="easyui-linkbutton" iconCls="icon-add" plain="true">Update</a>
        <a href="javascript:delForm()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">Remove</a>
</div>


<!-- 글쓰기 화면 -->
<!-- JEasyUI - Dialog API 활용 -->
<div 	id="dlg_boardAdd" class="easyui-dialog" style="width:600px;height:558px;padding:10px" 
		title="글쓰기 화면" data-options="closed:true,modal:'true',footer:'#tbar_boardAdd'">
	<!-- 
		form 전송시, encType옵션이 추가되면 request객체로 사용자가 입력한 값을 꺼낼 수 없다
		MultipartRequest → cos.jar OR API
	-->
 	<form id="f_boardAdd" method="post" enctype="multipart/form-data">
 	<!-- hidden으로 Map에 값으로 넘겨주기 --> 
 	<input type="hidden" name="bm_no" value="0">
 	<input type="hidden" name="bm_group" value="0">
 	<input type="hidden" name="bm_pos" value="0">
 	<input type="hidden" name="bm_step" value="0">
 	
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
					<input class="easyui-textbox" id="bm_email" name="bm_email" data-options="validType:'email'" required>
				</td>
			</tr>
			<tr>
				<td width="100px">Content</td>
				<td width="500px">	<!-- style="white-space:pre;"  -->
					<input 	class="easyui-textbox" id="bm_content" name="bm_content" 
							data-options="multiline:'true',Enterkeybehavior:'true',width:'350px',height:'250px'" required>
				</td>
			</tr>
			<tr>
				<td width="100px">Password</td>
				<td width="500px">
					<input class="easyui-passwordbox" id="bm_pw" name="bm_pw" required>
				</td>
			</tr>
			<tr>
				<td width="100px">File</td>
				<td width="500px">
					<input class="easyui-filebox" id="bs_file" name="bs_file" data-options="width:'350px'">
				</td>
			</tr>
		</table>
	</form>
</div>
<!-- 버튼 추가 : 저장/닫기 -->
<div id="tbar_boardAdd" align="right" style="padding:3px 10px">
	<a href="javascript:addAction()" class="easyui-linkbutton" iconCls="icon-save" >Save</a>
	<a href="javascript:$('#dlg_boardAdd').dialog('close')" class="easyui-linkbutton" iconCls="icon-cancel">Close</a>
</div>


<!-- 글 수정하기 화면 : updateForm.jsp -->

<!-- 글 삭제하기 화면 -->
<div	id="dlg_boardDel" closed="true" class="easyui-dialog" style="padding:20px 50px">
	<!-- 버튼 : 삭제 닫기 -->
	<div id="btn_boardDel" align="right">
		<a href="javascript:boardDel()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">Delete Commit</a>
        <a href="javascript:boardDelClose()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">Cancel</a>
	</div>
</div>


</body>
</html>