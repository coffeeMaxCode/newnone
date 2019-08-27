<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=1900, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script>

    function loginModal(){
      $("#myModal").modal();
    }
    
    function loginAction(){
		var mem_id = $("#mem_id").val();
		var mem_pw = $("#mem_pw").val();
		$.ajax({
			 url:"/member/login.max?work=member&mem_id="+mem_id+"&mem_pw="+mem_pw
			,method:"get"
			,success:function(data){
				$("#loginForm").html(data);
			}
			,error:function(e){
				alert(e.responseText);
			}
		});
    }   
    
    function logoutAction(){
    	$.ajax({
			 url:"logoutAction.jsp"
			,method:"get"
			,success:function(data){
				$("#loginForm").html(data);
			}
			,error:function(e){
				alert(e.responseText);
			}
		});
    }   	
</script>
</head>
<body>
<style>
	.jumbotron {
		background-image: url('./images/img_code6.jpeg');
		background-size: cover;
		text-shadow: black 0.2em 0.2em 0.2em;
		color: white;
	}
</style>
<!-- 페이지 상단 -->
<div>
	<%@ include file="./top.jsp" %>
</div>
<!-- 페이지 메인 이미지 -->
	<div class="container">
		<div class="jumbotron">
			<h1 class="text-center">JAVA Class</h1>
			<p class="text-center">Making OnlineTestCheck System Class note on java 52th
			<p class="text-center">
				<a class="btn-primary btn-lg" href="lecture.html" role="button">
				It's Coding time</a>
			</p>
		</div>
<!-- 메인 사이트 소개글 -->
		<div class="row">
			<div class="col-sm-4">
				<h4>Play with coding</h4>
				<p>코딩놀이는 프로그래밍 언어를 사용하여 자신이 상상하는 것들을 소프트웨어로 만들어 보는 놀이들로 구성되었습니다.</p>
				<p>
					<a class="btn btn-default" data-target="#modal" data-toggle="modal">자세히
						알아보기</a>
				</p>
			</div>
			<div class="col-sm-4">
				<h4>Play with coding</h4>
				<p>코딩놀이는 프로그래밍 언어를 사용하여 자신이 상상하는 것들을 소프트웨어로 만들어 보는 놀이들로 구성되었습니다.</p>
				<p>
					<a class="btn btn-default" href="instructor.html">자세히 알아보기</a>
				</p>
			</div>
			<div class="col-sm-4">
				<h4>Play with coding</h4>
				<p>코딩놀이는 프로그래밍 언어를 사용하여 자신이 상상하는 것들을 소프트웨어로 만들어 보는 놀이들로 구성되었습니다.</p>
				<p>
					<a class="btn btn-default" href="lecture.html">자세히 알아보기</a>
				</p>
			</div>
		</div>
		<hr>
<!-- 메인 이미지 다음 강의 게시판 -->
		<div class="pannel pannel-primary">
			<div class="pannel-heading">
				<h3 class="pannel-title">
					<span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;New Class list
				</h3>
			</div>
			<div class="pannel-body">
				<div class="col-sm-4">
					<div class="media-left">
						<a href="lecture.html?lectureName=C"><img
							src="./images/img_c.jpeg" width="50px" height="50px" alt="c언어"></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading">
							<a href="lecture.html?lectureName=C">C/C++</a>&nbsp;<span
								class="badge">New</span>
						</h4>
						C/C++ 프로그래밍 강의
					</div>
				</div>
				<div class="col-sm-4">
					<div class="media-left">
						<a href="lecture.html?lectureName=java"><img
							src="./images/img_java.png" width="100px" height="50px" alt="c언어"></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading">
							<a href="lecture.html?lectureName=C">JAVA</a>&nbsp;<span
								class="badge">New</span>
						</h4>
						JAVA 프로그래밍 강의
					</div>
				</div>
				<div class="col-sm-4">
					<div class="media-left">
						<a href="lecture.html?lectureName=oracle"><img
							src="./images/img_oracle.png" width="120px" height="50px"
							alt="c언어"></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading">
							<a href="lecture.html?lectureName=oracle">Oracle</a>&nbsp;<span
								class="badge">New</span>
						</h4>
						Oracle 데이터베이스 강의
					</div>
				</div>
				<br>
				<br>
				<hr>
			</div>
		</div>
	</div>

<!-- 페이지 하단 -->
<div>
	<%@ include file="./bottom.jsp" %>
</div>
</body>
</html>
