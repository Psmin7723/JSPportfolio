<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<title>특산물</title>
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
	
<body id="top1">
	
	
		<header class="header">
			<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon1"></i></a>
			<h1 class="logo">특산물</h1>
			<a href="main3.jsp" class="btn_search"><p style="font-weight:bold;">back</p></a>
			

		</header>
		<%@ include file="sidebar-nav.jsp" %>
	

		<section class="trip">
			<div class="trip_first">
				<div class="tab2_cont">
				<p class="tab2_txt1">제주 대표 특산물</p>
				<p class="tab2_txt2"><span><a href="#">더보기</a></span></p>
				</div>
				<div class="trip_visual">
					
					<header>
				
						<div class="trip_header">
							<h2 class="readonly">제주 대표 특산물 소개</h2>
							
							
							
						</div>
					
					</header>
					
						<div class="inner">
							
							<div class="tripbackgroundchange">
								<div class="tripbackgroundimg" id="tripback61"></div>
								<div class="tripbackgroundimg" id="tripback62"></div>
								<div class="tripbackgroundimg" id="tripback63"></div>
								<div class="tripbackgroundimg" id="tripback64"></div>
								<div class="tripbackgroundimg" id="tripback65"></div>
							</div>
							
						</div>

				</div>
				
					<div class="trip_info">
							<h3 class="trip_header1"><a href="#">[제주 대표 특산물]</a></h3>
						<div class="trip_line">
							<p class="trip_txt1"><a href="#">'제주 대표 특산물'은 제주도 특산물 중 가장 유명한 5가지를 선정하여 소개합니다.</a></p>
						</div>
					</div>
					<div class="trip_cont">
						<h3 class="trip_header1"><a href="#">[컨텐츠]</a></h3>
						<a class="trip_cont_a" href="message.html">조회수</a><i class="fa fa-eye"></i><p>12345</p>
						<a class="trip_cont_a" href="message.html">좋아요</a><i class="fa fa-heart"></i><p>345</p>
						<a class="trip_cont_a" href="message.html">댓&nbsp;&nbsp;글</a><i class="fa fa-commenting-o"></i><p>35</p>
					</div>
			</div>	
		</section>		
		<!--두번째 컨텐츠 -->
		<section class="trip">
			<div class="trip_first">
				<div class="tab2_cont">
				<p class="tab2_txt1">먹거리 특산물</p>
				<p class="tab2_txt2"><span><a href="#">더보기</a></span></p>
				</div>
				<div class="trip_visual">
					
					<header>
				
						<div class="trip_header">
							<h2 class="readonly">서브 특산물 소개</h2>
							
							
							
						</div>
					
					</header>
					
						<div class="inner">
							
							<div class="tripbackgroundchange">
								<div class="tripbackgroundimg" id="tripback71"></div>
								<div class="tripbackgroundimg" id="tripback72"></div>
								<div class="tripbackgroundimg" id="tripback73"></div>
								<div class="tripbackgroundimg" id="tripback74"></div>
								<div class="tripbackgroundimg" id="tripback75"></div>
							</div>
							
						</div>

				</div>
				
					<div class="trip_info">
							<h3 class="trip_header1"><a href="#">[먹거리 특산물]</a></h3>
						<div class="trip_line">
							<p class="trip_txt1"><a href="#">'먹거리특산물'은 제주도에서 엄선한 먹거리 특산물을 다섯 가지 선정하여 소개합니다. 가장 많은 좋아요를 받은 업체를 둘러보세요.</a></p>
						</div>
					</div>
					<div class="trip_cont">
						<h3 class="trip_header1"><a href="#">[컨텐츠]</a></h3>
						<a class="trip_cont_a" href="message.html">조회수</a><i class="fa fa-eye"></i><p>12345</p>
						<a class="trip_cont_a" href="message.html">좋아요</a><i class="fa fa-heart"></i><p>345</p>
						<a class="trip_cont_a" href="message.html">댓&nbsp;&nbsp;글</a><i class="fa fa-commenting-o"></i><p>35</p>
					</div>
			</div>	
		</section>		
		
					
					
				
		<!-- 마무리 -->
		<section class="contents">
			<h2 class="readonly">콘텐츠내용</h2>
		</section>
		
		<div class="paging">
			
				<strong>1</strong>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
				<a href="#">5</a>
				<a href="#"><i class="fa fa-angle-double-right"></i>
				</a>
				<div class="top">
					<a href="#top1">Top</a>
				</div>
			
		</div>
		
		
		
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