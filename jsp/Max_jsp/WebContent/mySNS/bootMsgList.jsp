<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.vo.SNS_MsgVO" %>    
<%@ page import="com.vo.SNSMessageSet, com.vo.SNS_RepleVO" %>  
<%
	List<SNSMessageSet> msgList = null;
	msgList = (List<SNSMessageSet>)request.getAttribute("smsgList");
	int size = 0;
	if(msgList!=null)
		size = msgList.size();
	//out.print("size:"+size);
%>  

<script type="text/javascript">
//새 댓글 작성
function newRelp(mno){
	//alert("버튼작동");
	
}
//좋아요
function like(mno,like){
	//alert(mno);
	//alert("버튼작동");
	$.ajax({
		url:"/mySNS/test.hh?crud=like&mno="+mno+"&like="+like
		 ,success:function(data){
			   $("#d_msg").html(data);
		   }
		   ,error:function(e){
			   alert(e.responseText);
		   }
	});
}
</script>


 <div> 
<%
	// 상태글
	for(int i=0;i<size;i++){
		SNSMessageSet smSet = msgList.get(i);
		SNS_MsgVO smVO = smSet.getMsgVO();
		List<SNS_RepleVO> reList = smSet.getReList();
		int rsize = 0;
		if(reList!=null){
			rsize = reList.size();
		}
%>
	<div class="card bg-primary text-white">
		<div class="card-header">
			<input type="hidden" id="mno" value="<%=smSet.getMsgVO().getMno()%>" />
			<%=smSet.getMsgVO().getMsg() %>
			<br>
			<a class="btn btn-primary" data-toggle="collapse" href="#reText"
				role="button" aria-expanded="false" aria-controls="reText">
   			댓글 작성
 			</a>
			<button type="button" onclick="like(<%=smSet.getMsgVO().getMno()%>,<%=smSet.getMsgVO().getFavcnt()%>)"
					style = "width : 20px; height : 20px; font-size:20px; font-weight: bold; 
					background-color: rgba( 255, 255, 255, 0 ); border:0;" >
				<img src="./Like.png" border="0">
			</button>
			<span>
			<%=smSet.getMsgVO().getFavcnt() %>
			</span>
		</div>
	</div>

<%
	// 상태글에 대한 댓글
		if(rsize>0){
			for(int j=0;j<rsize;j++){
				SNS_RepleVO srVO = reList.get(j);
%>  
	<div class="card bg-info text-white">
		<div class="card-body" style="padding:10px">
		  └ <%=srVO.getReple() %>
		</div> 
	</div>    
<%
			}										// inner for
		}											// if(rsize>0)
	}												// outter for
%>  
</div>

<!-- 댓글 입력창 -->
<div class="collapse" id="reText">
	<div class="card card-body">
	<%=smSet.getMsgVO().getMno()%><!-- 좌측 값과 클릭했을 때 값을 비교  -->
   		<input id="reTextBox" type="text" style="width:300px">
   	</div>
</div>