<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>

	<title>관리자로그인</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, user-scalaboe-no">
	<link href="../css/mystyle.css" rel="stylesheet">
	<link href="../css/font-awesome.min.css" rel="stylesheet">

</head>
	<script>
	function logcheck()
	{
		if(myform.id.value=="")
		{
			alert("아이디를 입력해주세요.");
			myform.id.focus();
			
		}else if(myform.pw.value=="")
		{
			alert("비밀번호를 입력해주세요.");
			myform.pw.focus();
			
		}
		if(myform.id.value != "" && myform.pw.value != "")
		{
			myform.submit();
		}
		
	}
	</script>
<body id="top1">
	
	
		<header class="header">
			<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon1"></i></a>
			<h1 class="logo">로그인</h1>
			<a href="main.jsp" class="btn_search"><p style="font-weight:bold;">back</p></a>
			
		

		</header>
		<%@ include file="../sidebar-nav.jsp" %>
	

		<!-- contents start -->
		
		<section class="loginbox">
			<h2><span>제주</span>여행</h2>
				<form name="myform" method="post" action="login.admin" onsubmit="javascript:logcheck();return false;"> <!--텍스트가 아닌 파일을 넘길때는 post가 아니라 enctype="multipart/form-data"라고 해야함 -->
					
					<div class="id">
						
							
							<label for="id_input" class="readonly">아이디를 입력하세요</label>
							<input type="text" name="id" id="id_input" class="id_input" placeholder="&#xf2bc;    아이디입력" style="font-family:Arial, FontAwesome" />
					</div>
					
					<div class="pw">	
							<label for="pw_input" class="readonly">패스워드를 입력하세요 </label>
							<input type="password" name="pw" id="pw_input" class="pw_input" placeholder=" &#xf023;     비밀번호입력" style="font-family:Arial, FontAwesome" />			
						
					</div>
				
					<!--<div class="loginbutton"> </div>-->
					<input class="loginbutton" type="submit" value="로그인">
					
					
					<div class="searchbox">
					<a class="p_id" href="id_search.html">아이디 찾기</a>
					<a class="p_pw" href="pw_search.html">비밀번호 찾기</a>
					</div>
					
					<a class="member_join" href="signup.jsp">회원가입</a>
					
				</form>		
		</section>
		<!-- contents end -->
		<footer class="footer">
			<p>COPYRIGHT  SANGMIN ALL RIGHTS RESERVED </p>
		</footer>
		
		<script src=	"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script>
			$("#menu-toggle").click(function(e)
			{
				e.preventDefault();
				$("#slidebar-wrapper").toggleClass("active");
			});
			$("#menu-close").click(function(e)
			{
				e.preventDefault();
				$("#slidebar-wrapper").toggleClass("active");
			});
			
			$(".btn_search").click(function()
			{
				$(".bar-search").toggle();
			});
		</script>
		
</body>
</html>