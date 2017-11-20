<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<title>로그인</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, user-scalaboe-no">
	<link href="css/mystyle.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
<script>
		function alertlogin()
		{
			alert("로그인후 사용해 주세요.");
		}
	</script>
</head>
	<script>
		function logcheck()
		{
			/**************************
			if(myform.id.value=="")
			{
				alert("아이디입력");
				myform.id.focus();
				return;
			}else if(myform.pw.value=="")
			{
				alert("비밀번호입력");
				myform.pw.focus();
				return;
			}
			***************************/
			myform.submit();
			
		}
	</script>
<body id="top1">
	
	
		<header class="header">
			<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon1"></i></a>
			<h1 class="logo"><span>제주</span>여행</h1>
			<a href="login.jsp" class="btn_search"><p style="font-weight:bold;">back</p></a>
			
		

		</header>
		<%@ include file="sidebar-nav.jsp" %>
	

		<!-- contents start -->
		
		<section class="loginbox">
			<h2><span>회원</span>가입</h2>
			<p class="readonly">회원가입</p>
				<form name="myform" class="form_join" method="post" action="reg.mem"> <!--텍스트가 아닌 파일을 넘길때는 post가 아니라 enctype="multipart/form-data"라고 해야함 -->
					
					<div class="id_join">
						<h4 class="idtxt">생성할 아이디를 입력해주세요.</h4>
						<label for="id_input" class="readonly">아이디를 입력하세요</label>
						<input type="text" name="id" id="id_input" class="id_input_join" placeholder="&#xf2bc;    아이디입력" style="font-family:Arial, FontAwesome" title="아이디를 입력해주세요."/>
						
					</div>
					
						<a href="idcheck.html" class="idcheck">중복확인</a>
					<h4 class="pwtxt">생성할 비밀번호를 입력하시고 확인해주세요.</h4>
					<div class="pw_join">	
						
						<label for="pw_input" class="readonly">패스워드를 입력하세요 </label>
						<input type="password" name="pw" id="pw_input" class="pw_input_join" placeholder=" &#xf023;     비밀번호입력" style="font-family:Arial, FontAwesome"title="패스워드를 입력해주세요." />			
					
					</div>
					
					<div class="pw2_join">	
						<label for="pw_input" class="readonly">패스워드를 한번 더 입력하세요 </label>
						<input type="password" name="pw2" id="pw_input" class="pw2_input_join" placeholder=" &#xf023;     비밀번호확인" style="font-family:Arial, FontAwesome" title="비밀번호를 입력해주세요." />		
						
					</div>
					<div class="tell">
						<h4 class="phone">전화번호를 입력해주세요.</h4>
						<label for="tell" class="readonly">전화번호 입력 </label>
						<select class="tell_join" id="tell" name="tell">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="017">017</option>
						</select>
						<p class="s1">-</p>
						<label for="cellnum" class="readonly">전화번호 앞자리입력</label>
						<input type="text" id="cellnum"name="tel2" class="tel2">
						<p class="s2">-</p>
						<label for="cellnum1" class="readonly">전화번호 뒷자리입력</label>
						<input type="text" id="cellnum1" name="tel3" class="tel3">
					</div>
					
					<div class="e-mail">	
						<h4 class="mail-e">메일주소를 입력해주세요.</h4>
						<label for="email" class="readonly">메일주소 입력</label>
						<input type="text" name="emailid" class="emailid" id="email">
			
						<p class="s3">@  </p>
						<label for="emailser" class="readonly">이메일 도메인 선택</label>
						<select name="emailser" class="email_sel" id="emailser">
							<option value="">메일선택</option>
							<option value="naver.com">naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="gmail.com">gmail.com</option>
						</select>
						
						
					</div>
					<div class="join">
						<input type="submit" class="joinup" value="회원가입">
					</div>	
				
					
					
					
					
					
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