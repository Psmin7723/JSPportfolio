<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<title>여행지</title>
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
			<h1 class="logo">여행지</h1>
			<a href="#" class="btn_search"><i class="fa fa-map-marker headericon2"></i></a>
			
			

		</header>
	<%@ include file="sidebar-nav.jsp" %>
	
		<section class="view2">

			<ul class="view2UL">
				<li>
					<img src="imgs/ssub1.jpg" alt="겨울풍경" class="imgw100">
				</li>
				<li>
					<img src="imgs/ssub4.gif" alt="겨울풍경" class="imgw100">
				</li>
				<li>
					<img src="imgs/ssub2.jpg" alt="겨울풍경" class="imgw100">
				</li>
				<li>
					<img src="imgs/ssub3.jpg" alt="겨울풍경" class="imgw100">
				</li>
				
			</ul>
			<h3 class="trip-viewh3">제주도 겨울테마(리뷰)</h3>
			
			<ul class="view2RP">
				<li>
					<img src="imgs/sssub1.jpg" alt="고래" class="imgw50">
					<h4 class="trip-viewhh3">수학왕연산군</h4>
					
					<p>풍경이 너무 아름다워요 겨울 한라산에 한번 가보고 싶어요. ~~~~ </p>
				</li>
				<li>
					<img src="imgs/sssub2.jpg" alt="꼬북" class="imgw50">
					<h4>주차왕파킹</h4>
					<p>진정한 겨울 풍경을 느끼고 싶으시다면 제주도로 오세요!! 강추!! </p>
				</li>
				<li>
					<img src="imgs/sssub3.png" alt="토마스" class="imgw50">
					<h4>흡연왕스모킹</h4>
					<p>승마체험도 할 수 있어서 좋아요. 겨울 바람을 받으며 멋지게 승마드라이빙 어떠세요? </p>
				</li>
				
				
			</ul>
			<div class="paging">
			
				<strong>1</strong>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
				<a href="#">5</a>
				<a href="#"><i class="fa fa-angle-double-right"></i>
				</a>
			</div>
			<div class="tirp_view_list">
					<a href="#"><p class="trip_view_p"><i class="fa  fa-map-o"></i></p></a>
					<a href="trip.jsp"><p class="trip_view_l">List</p></a>
					<a href="trip-view.jsp"><p class="trip_view_r"><i class="fa  fa-angle-double-left"></i></p></a>
			</div>
			
		</section>
	
		
		
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