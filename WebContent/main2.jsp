<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<title>제주여행</title>
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
	
<body>
	
	
		<header class="header">
			<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon1"></i></a>
			<h1 class="logo"><a href="main.user"><span class="txt1">제주</span><span class="txt2"></span>여행</a></h1>
			<a href="#" class="btn_search"><i class="fa fa-search headericon2"></i></a>
			
			<div class="bar-search">
				<div class="inner">
					<form name="mysearch">
					
						<label for="search" class="readonly">검색어를 입력하세요</label>
						<input type="text" name="search" class="search" placeholder="검색어를 입력하세요"
						id="search">
						
					</form>
				</div>
			</div>
			
		</header>
	<%@ include file="sidebar-nav.jsp" %>
	
	
	
		<div class="tab_bar">
			<article class="tab_cont_1">
				<h2 class="readonly">탭메뉴</h2>
				<ul> 
					<li class="active"><a href="main.user">여행지</a></li>
					<li><a href="">맛  집</a></li>
					<li class="active"><a href="main3.jsp">특산물</a></li>			
				</ul>
			</article>
		</div>
		
		<section>
			
				<div class="main_visual">
				
					<header>
				
						<div class="main_header">
							<h2 class="readonly">메인비주얼 광고</h2>
							
							
							
						</div>
					</header>
					<div class="inner">
						<div class="backgroundchange">
							<div class="backgroundimg" id="back1_1"></div>
							<div class="backgroundimg" id="back2_1"></div>
							<div class="backgroundimg" id="back3_1"></div>
							<div class="backgroundimg" id="back4_1"></div>
							<div class="backgroundimg" id="back5_1"></div>
						</div>
					</div>
					
					
				</div>
				<div class="tab1_cont">
					<p class="tab1_txt1">대표 맛집</p>
					<p class="tab1_txt2"><span><a href="food.jsp">더보기</a></span></p>
					<ul>
						<li class="sub_visual1"><a href="trip.jsp">		
						<img src="imgs/visual11.jpg" alt="흑돼지" class="imgw100">
						<p><span>[흑돼지고기]&nbsp;&nbsp;</span>제주도 토종 흑돼지의 쫄깃쫄깃함을 
						제두소 산지에서 느껴보세요. </p></a>
						</li>
						<li class="sub_visual2"><a href="trip.jsp">
						<img src="imgs/visual12.jpg" alt="왕벚꽃" class="imgw100">
						<p><span>[해산물]&nbsp;&nbsp;</span>제주도 바다에서 나온 싱싱한 해산물의
						향연을 산지에서 즐겨보세요.</p></a>	
						</li>
						
						
					</ul>
				</div>
			
		</section>
		
		<section class="sub_visual">
				<h2 class="readonly">테마 게시물</h2>
				<p class="tab1_txt1">테마 맛 집</p>
				<p class="tab1_txt2"><span><a href="#">더보기</a></span></p>
				
				<ul>		
					<li>			
						<a href="#">
						<img src="imgs/sup1.jpg" alt="제주길" class="imgm100">
						<p class="main_2"><span>[대표 맛집]&nbsp;&nbsp;</span>제주도에서도 대표로 꼽히는 맛집을 모아두었습니다. </p>
						</a>		
					</li>						
				</ul>	
				
				<ul>	
					<li>					
						<a href="#">
						<img src="imgs/sup2.jpg" alt="제주길" class="imgm100">
						<p class="main_2"><span>[해산물 맛집]&nbsp;&nbsp;</span>해산물을 좋아하시는 분들을 위한 메뉴입니다. </p></a>
					</li>
				</ul>
				<ul>	
					<li>			
						<a href="#">
						<img src="imgs/sup3.jpg" alt="제주길" class="imgm100">
						<p class="main_2"><span>[흑돼지 맛집]&nbsp;&nbsp;</span>흑돼지의 진수를 맛보고 싶으시다면 클릭해주세요.</p></a>
					</li>
				</ul>
			
		</section>
		<section class="contents">
			<h2 class="readonly">콘텐츠내용</h2>
		</section>
		
		<footer class="footer">
			<p>COPYRIGHT SANGMIN ALL RIGHTS RESERVED </p>
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