<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.vo.ZipCodeVO" %>    
<%
	List<ZipCodeVO> zipList = 
		(List<ZipCodeVO>)request.getAttribute("zipList");
	int size = 0;
	if(zipList!=null && zipList.size()>0){
		size = zipList.size();
	}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Member</title>
<%@ include file="../Stylesheet/JEasyUICommon.jsp"%>
</head>
<body>
	<script type="text/javascript">
	/* 전역변수  */
//	 	var g_address;
//	 	g_address = row.address; 
	//함수 선언
	$(document).ready(function (){
		//datagrid 설정
		$('#dg_member').datagrid({
			 //url:"./member.json"	//columns로 대체
			url:"memberList.max?work=member"
		    ,title:"Member List V0.3"
		    ,height:500
		    ,toolbar:'#tb_member'
		    ,columns:[[
		        {field:'MEM_ID',title:'ID',width:100},
		        {field:'MEM_NAME',title:'Name',width:100},
		        {field:'MEM_ADDR',title:'Address',width:100,align:'left'}
		    ]]
		});  
		//우편번호 검색 기능
		$('#dg_zipcode').datagrid({
			 title:"우편번호 검색"
			,columns:[[
		        {field:'zipcode',title:'zipcode',width:100,align:'center'},
		        {field:'address',title:'address',width:400,align:'left'}
		    ]]
			,data:[
				{"zipcode":15067,"address":"서울시 금천구 가산동"}
			]
		}); 
		//가입 다이얼로그 창
		$('#dlg_join').dialog({
			 title : "Join us"
			,width:500
			,height:550
			,footer:"#tb_join"
			,closed:true
		});
		// 우편번호 검색 다이얼로그 창
		$('#dlg_zipcode').dialog({
			 title : "Find ZipCode"
			,width:500
			,height:330
			,closed:true
		});
 		//우편번호 검색 다이얼로그 창 내 검색 이벤트
  		$('#dong').textbox('textbox').bind('keydown', function(e){
			// Enter key 눌렀을 때
			if(e.keyCode == 13){
				//우편번호 데이터 초기화 하기
				$("#dg_zipcode").datagrid({
					 url: './zipcodeList.max?work=member&dong='+$(this).val()
					,singleSelect: true
					/*	index는 0부터 카운트
					  	getSelected하면 선택한 로우의 값을 가짐	*/
					,onSelect:function(index,row){
						var row = $(this).datagrid('getSelected');
						alert(row.address);
					}
					,onDblClickCell: function(index,field,value){
						alert(index+"/"+field+"/"+value);
						if('zipcode'==field){
							//우편번호 textbox에 출력 id
							$("#mem_zipcode").textbox('setValue',value);
							$("#mem_addr").textbox('setValue',g_address);
							$("#dg_zipcode").datagrid('clearSelections');
						}
					}
				});
			}
		}); 
		// 우편번호 검색버튼
		$('#btn_zipcode').linkbutton({
			   onClick:function(){
				$('#dlg_zipcode').dialog('open');
			   }
		});
		// 회원가입 버튼
		 $('#btn_join').linkbutton({
			   onClick:function(){
			    $('#dlg_join').dialog('open');
			   }
			  });
 		// 검색버튼
			$('#btn_search').linkbutton({
				onClick:function(){
					var u_dong =$('#dong').val();
					$.ajax({
						 method:'get'
						,url:'./member/zipcodeList.max?work=member&dong='+u_dong
						,success:function(data){
							$("dg_zipcode").datagrid({
								
							});
						}
					})
				}
			}); 
		// 저장버튼
		$('#btn_save').linkbutton({
			onClick:function(){
				$('#f_join').attr('method','get');
				$('#f_join').attr('action','./memberInsert.max');
				$('#f_join').submit();
				$('#dlg_join').dialog('close');
			}
		});
		// 취소 버튼
		$('#btn_close').linkbutton({
			onClick:function(){
				$('#dlg_join').dialog('close');
			}
		});
		
	});
</script>
<!-- 페이지 GUI 시작 -->
	<table id="dg_member"></table>
<!-- 가입 버튼 -->
	<div id="tb_member" style="padding: 5px;">
		<a id="btn_join" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add'">Join </a>
	</div>
<!-- 우편번호 검색 -->
	<div id="dlg_zipcode" style="width:100%;max-width:600px;padding:30px 30px;">
	<!-- 우편주소 검색 텍스트 박스 -->
		<input class="easyui-textbox" id="dong" name ="dong" 
            labelPosition="top" 
            data-options="prompt:'Enter a Dong...'" 
            style="width:250px;">
	<!-- 검색 링크 버튼 -->
      <a id="btn_search" href="#" class="easyui-linkbutton"
      	 data-options="iconCls:'icon-btn_search'">Search</a>
      	 <div style="margin-bottom:10px"></div>
    <!-- 결과 출력 테이블 -->
		<table id="dg_zipcode" border="1">
		<thead>
			<th>우편번호</th>
			<th>주소</th>
		</thead>
		<tbody>
<!-- 조회한 데이터가 들어갈 곳 -->			
	 		<%
			//data가 없을때
			%>
			<tr>
				<td colspan="2"></td>
			</tr>
			<%
			//data가 있을 때
				if(size>0){
					for(int i=0;i<size;i++){
						ZipCodeVO zVO = zipList.get(i);
			%>
			<tr>
				<td><%=zVO.getZipcode() %></td>
				<td><%=zVO.getAddress() %></td>
			</tr> 
			<%	
					}
				}
			%>
			</tbody>
		</table>
	</div>
<!-- 회원가입 -->
	<div id="dlg_join" style="width:100%;max-width:480px;padding:30px 60px;">
	<!-- 
			사용자가 화면에 입력한 값을 서버측에 전달할 때는 name속성이 반드시 필요하다.
			입력받는 컴포넌트에 값이 담기기 때문에 반드시 form전송으로 처리한다.
			form태그는 여러개를 사용할 수 있고 아이디로 구분하여 서로 다른 서버 계층으로 
			전송이 가능하다.
			화면에는 존재하지 않지만 개발자가 업무처리를 위한 목적으로 따로 전달하고 싶은 
			정보가 있을 때도 form태그를 사용할 것.
			이때 사용하는 컴포넌트는 hidden 속성으로 처리한다.
			hidden속성은 input type text속성과 동일하게 사용하면 된다.
			아이디와 이름 속성을 반드시시 부여 하여
			서버에 전송할 때와 ajax처리 할 때를 준비해 둔다.
			아이디는 절대로 중복되면 안된다.
			실제 서버로 전송할 때는 form태그에 메소드 방식과 목적지를 기술하지 말고
			jquery api를 사용하여 함수 처리한다.
			화면에 담겨 있는 정보들은 가독성이 떨어지고 화면 내용이 많아지게 되면
			찾기가 불편함.
 	-->
	<form id ="f_join">
	<!-- id는 화면단/브라우저  name 서버에서 사용 -->
	<input type="hidden" id ="work" name ="work" value="member" />
		 <div style="margin-bottom:15px">
            <input class="easyui-textbox" id="mem_id" name ="mem_id" 
            label="ID" labelPosition="right" 
            data-options="prompt:'Enter a ID...'" 
            style="width:450px;">
        </div>
        <div style="margin-bottom:15px">
            <input class="easyui-textbox" id="mem_pw" name ="mem_pw" 
            label="PW" labelPosition="right" 
            data-options="prompt:'Enter a pass word...'" 
            style="width:450px;">
        </div>
        <div style="margin-bottom:15px">
            <input class="easyui-textbox" id="mem_name" name ="mem_name" 
            label="Name" labelPosition="right" 
            data-options="prompt:'Enter your name...'" 
            style="width:450px;">
        </div>
        <div style="margin-bottom:15px">
            <input class="easyui-textbox" id="mem_addr" name ="mem_addr" 
            label="Address" labelPosition="right" 
            data-options="prompt:'Enter a address...'" 
            style="width:450px;">
        </div>
        <div style="margin-bottom:15px">
            <input class="easyui-textbox" id="mem_zipcode" name ="mem_zipcode" 
            label="Zipcode" labelPosition="right" 
            data-options="prompt:'Enter a zipcode...'" 
            style="width:450px;">
<!-- 우편주소 검색 링크버튼 -->
            <a id="btn_zipcode" href="#" class="easyui-linkbutton"
            data-options="iconCls:'icon-search'">Find ZipCode</a>
        </div>
        </form>
	</div>
	
	<div id="tb_join" style="padding:5px;">
	<a id="btn_save" href="#" class="easyui-linkbutton"
		data-options="iconCls:'icon-save',plain:true">Save</a>
	<a id="btn_close" href="#" class="easyui-linkbutton">Close</a>
	</div>

</body>
</html>