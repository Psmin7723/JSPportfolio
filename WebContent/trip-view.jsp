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
	

		<section class="trip">
			<div class="trip_first">
				
				<div class="trip_visual">
					
					<header>
				
						<div class="trip_header">
							<h2 class="readonly">여행지 광고</h2>
							
							<img src="imgs/images14.jpg" alt="겨울한라산" class="imgm200">
						</div>				
					</header>
				</div>
				<div class="trip_view_cont">
						<p></a>&nbsp;<i class="fa fa-eye"></i>&nbsp;12345</p>
						<p></a><i class="fa fa-heart"></i>&nbsp;345</p>
						<p></a><i class="fa fa-commenting-o"></i>&nbsp;35</p>
				</div>
				
			</div>	
				
			
				<h2 class="trip_view_h2">겨울속의 한라산</h2>
				<h3 class="trip_view_h3">[힐링여행]</h3>
				<div class="trip_view_text">
					<p>	드디어 올게 왔습니다! 12월 중순을 넘어가니 꽤 강한 추위와 폭설이 한라산을 찾아왔습니다!<br>그러면 한라산 눈꽃 산행에 나서지 않을 수 없지요!^^<br>
						성판악, 관음사, 어리목, 돈내코, 영실 등 다양한 등반 코스 중 눈꽃 산행은 역시 영실코스가 제일 좋은 것 같아요!<br>
						중간에 깔딱 고개가 있지만, 소요시간도 왕복 3~4시간 정도면 충분할 정도로 코스도 짧고 풍경도 좋은 편이니, 등반이 좀 서툰 분들의 겨울 산행은 영실코스로 추천합니다.<br>
						어리목코스와 영실코스는 해발 1700미터 윗세오름까지 등반 가능합니다.</p>
				</div>
				<div class="tirp_view_list">
					<a href="#"><p class="trip_view_p"><i class="fa fa-star-o"></i></p></a>
					<a href="trip.jsp"><p class="trip_view_l">List</p></a>
					<a href="trip-view2.jsp"><p class="trip_view_r"><i class="fa  fa-angle-double-right"></i></p></a>
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