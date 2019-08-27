<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  //총레코드 갯수
	int total = 0;
	if(session.getAttribute("s_total")!=null){
		total = Integer.parseInt(session.getAttribute("s_total").toString());
	}
	out.print("total = "+total);
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
	
	
//form 값받아서 보내기	
  	function addAction(){
		$("#f_boardAdd").attr("method","post");
		$("#f_boardAdd").attr("action","/Board/test.mil?crud=boardAdd");
		$("#f_boardAdd").submit();
	} 
	
/***학습목표
	나는 오라클 서버에서 조회된 결과를 담은 List<Map>을 화면(datagrid)에 출력 내용 보내기
	화면(DOM구성)과 Java코드가 만나는 부분에 대한 처리 방법에 대해 설명하고 코드에 적용
	화면은 html로 그리지만 조회된 결과를 html에 반영하기 위해 DOM을 조작하는 방법 이해
	html과 DOM 사이에서 json의 역할 이해											*/
	
/***결론
	화면을 조작하는 다양한 방법 확인
	다양한 UI솔루션이 제공하는 컴포넌트에 조회된 결과를 반영
	각 device 마다 혹은 시스템마다 서로 다른 UI솔루션을 선택하고 사용 가능
	UI솔루션이 javascript / xml / 안드로이드 기반으로 적용할 수 있도록 실습해 볼 것			*/	
	
//검색 기능	//// 태그 조작 == DOM조작 : json : DefaultTableModel  / datagrid : JTable
	function boardList(){
		//alert("bordList 호출성공");
		//alert(user_combo);
		 
		//사용자가 선택한 콤보에 대한 키워드 값 저장
		cb_value=user_combo;
		//선택한 콤보에 대한 키워드 값 저장
		tb_value = $("#keyword").val();	
			//alert(tb_value);
		
		$("#dg_board").datagrid({
			 /* 직접 데이터를 넣어서 단위테스트 시도
			 	data: [
						{bm_title:'테스트1', bm_writer:'김유신1', bs_file:'temp1.png'},
						{bm_title:'테스트2', bm_writer:'김유신2', bs_file:'temp2.txt'}
				      ]																	*/
			/* url → json, 콤보박스 입력값 + 선택날짜 값을 전해주어야함
				   → "jsonBoardList.jsp"												*/
			 url: "test.mil?crud=boardList&cb_search="+cb_value
					 					+"&keyword="+tb_value
			 							+"&pageNumber=1"
			 		 					+"&pageSize=5"	
			 //,pagination:'true'
 			,onLoadSuccess:function(data){
 				/* 검색시, 검색한 값만 데이터 갯수 따지기 */
 				$.ajax({
 					url:"test.mil?crud=total&cb_search="+cb_value
 										  +"&keyword="+tb_value
 										  +"&timestamp="+new Date().getTime()
 					,method:"get"
 					,success:function(data){
 						$('#pn_board').pagination({
 							total:data
 							});
 					}
 					
 				});
 				
				<%-- 1차
				//alert("Success Load");
				$('#pn_board').pagination({
				total:<%=total%>
				}); 
				--%>
			}
		});
	}

	//페이지 이동 함수
	function pageMove(pageNumber, pageSize) {
		//alert(pageNumber+"  /  "+pageSize);
		$("#dg_board").datagrid(
				{
					url : "/Board/test.mil?crud=boardList&pageNumber="
							+ pageNumber + "&pageSize=" + pageSize
				});
	}

	//글 추가기능
	function addForm() {
		//alert("addForm 호출성공");
		$("#dlg_boardAdd").dialog('open');
	}
	//글 수정기능
	function updForm() {
		alert("updForm 호출성공");
	}
	//글 삭제기능
	function delForm() {
		alert("delForm 호출성공");
	}
</script>
</head>
<body onLoad="boardList()">
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
		
//datagrid : 초기화 및 컬럼 설정
		$("#dg_board").datagrid({
			 /* url:'datagrid_data.json', */
			  rownumbers : 'true'
			 ,columns:[[
				 	{field:'BM_NO',title:'No',width:50, hidden:'true'}, 
			        {field:'BM_TITLE',title:'Title',width:260},
			        {field:'BM_WRITER',title:'Writer',width:100,align:'center'},
			        {field:'BM_DATE',title:'Date',width:150,align:'center'},
			        {field:'BS_FILE',title:'File',width:200},
			        {field:'BM_HIT',title:'Hit',width:59,align:'center'}
			    	]]
			/* ,singleSelect:true */
			,onSelect:function(index,row){
				//alert(row.BM_NO);
				g_no = row.BM_NO;
			}
			,onDblClickCell: function(index,field,value){
				// 글 제목 상세 조회 시도
				if("BM_TITLE" == field){
					//클릭 이벤트 실행 + 입력값 확인
					//alert("글 조회 / 값 = "+value);
					cmm_window_popup("test.mil?crud=boardDetail&bm_no="+g_no,"700","500","read");
					//선택한 로우값 초기화
					$("#dg_board").datagrid('clearSelections');
				}
				// 첨부파일 다운 시도 = ajax로 가능 // 이동하지 않으므로, 스크립트 	처리
				else if("BS_FILE" == field){
					//클릭 이벤트 실행 + 입력값 확인
					//alert("파일 다운 / 값 = "+value);
					location.href="downLoad.jsp?bs_file="+value
				}
			}
		});
	
//combobox 이벤트 설정
		$("#cb_search").combobox({
			onChange:function(){
				user_combo = $(this).combobox('getValue');
			}
		});

/* //textbox Enter 이벤트 설정
		$("#keyword").textbox('textbox').bind('keydown',function(e){
			if(e.keyCode == 13){	// Enter key Code = 13 
				//alert("Press Enter");
				$("#dg_board").datagrid({
					url:"test.mil?crud=boardList&cb_search="
							    +user_combo+"&keyword="+$("#keyword").val()
				});			    
			}
		});
	 */	
//페이지네이션 pagenation(pn_board) 초기화 및 설정 : 세션에서 값 가져옴
		$('#pn_board').pagination({
			total:<%=total%>,
			pageSize:5,
			pageList: [5,8,10,15,20],
			/* pageNumber : 현재 내가 바라보는 페이지
			 * pageSize	  : 한 페이지에 보여줄 로우 갯수									*/
			onSelectPage: function(pageNumber, pageSize){
                /* $('#dg_board').datagrid('refresh', 'show_content.php?page='+pageNumber); */
                /* alert(pageNumber+"  /  "+pageSize); */
                pageMove(pageNumber,pageSize);
			}
		});
		
		
	})//DOM구성 마무리
</script>


<!-- 글 목록 화면 -->
<!-- JEasyUI - DataGrid API 활용
		1) 익스프레션을 이용 : 화면처리 : tr,td태그 직접 작성
		2) json포맷으로 처리 : 매핑     : field 만 맞춰주면 자동으로 매핑				 -->
<table	id="dg_board" class="easyui-datagrid" titile="글목록"
		data-options="toolbar:'#tb_search, #tb_board', footer:'#pn_board'"
		style="width:801px;height:400px">
</table>

	<!-- 페이지네이션 -->
<div id="pn_board" class="easyui-pagination" style="background:#efefef;border:1px solid #ccc;"></div>

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


</body>
</html>