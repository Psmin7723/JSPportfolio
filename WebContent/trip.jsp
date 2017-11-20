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
	<% 
	 		String userid = (String)session.getAttribute("USERID"); 		
	%>	
<script>
		function alertlogin()
		{
			alert("로그인후 사용해 주세요.");
		}
		function loginCheck()
		{

			if(<%=userid%>!=null)
			{
				return true;
			}else
			{
				alert("로그인후 사용해 주세요.");
				return false;
			}
			
		}
	</script>
</head>
	
<body id="top1">
	
	
		<header class="header">
			<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon1"></i></a>
			<h1 class="logo">여행지</h1>
			<a href="/portfolio/main.user" class="btn_search"><p style="font-weight:bold;">back</p></a>
			

		</header>
		<%@ include file="sidebar-nav.jsp" %>
	

		<section class="trip">
			<div class="trip_first">
				<div class="tab2_cont">
				<p class="tab2_txt1">힐링 여행지</p>
				<p class="tab2_txt2"><span><a href="listTrip.board?pageNo=0&pageSize=9&viewStart=0&viewEnd=5&level=admin"onclick="return loginCheck();">더보기</a></span></p>
				</div>
				<div class="trip_visual">
					
					<header>
				
						<div class="trip_header">
							<h2 class="readonly">여행지 광고</h2>
							
							<p><span>&nbsp;&nbsp;&nbsp;제주여행</span><br/>따뜻한 푸르름<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 그리고 제주</p>
							
						</div>
					
					</header>
					
						<div class="inner">
							
							<div class="tripbackgroundchange">
								<div class="tripbackgroundimg" id="tripback1"></div>
								<div class="tripbackgroundimg" id="tripback2"></div>
								<div class="tripbackgroundimg" id="tripback3"></div>
								<div class="tripbackgroundimg" id="tripback4"></div>
								<div class="tripbackgroundimg" id="tripback5"></div>
							</div>
							
						</div>

				</div>
				
					<div class="trip_info">
							<h3 class="trip_header1"><a href="trip-view.html">[올레길]</a></h3>
						<div class="trip_line">
							<p class="trip_txt1"><a href="#">'올레'는 제주 방언으로 좁은 골목을 뜻하며, 통상 큰길에서 집의 대문까지 이어지는 좁은 길이다.</a></p>
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
				<p class="tab2_txt1">자연 여행지</p>
				<p class="tab2_txt2"><span><a href="listTrip2.board?pageNo=0&pageSize=9&viewStart=0&viewEnd=5&level=admin"onclick="return loginCheck();">더보기</a></span></p>
				</div>
				<div class="trip_visual">
					
					<header>
				
						<div class="trip_header">
							<h2 class="readonly">여행지 광고</h2>
							
							<p><span>&nbsp;&nbsp;&nbsp;제주여행</span><br/>따뜻한 푸르름<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 그리고 제주</p>
							
						</div>
					
					</header>
					
						<div class="inner">
							
							<div class="tripbackgroundchange">
								<div class="tripbackgroundimg" id="tripback11"></div>
								<div class="tripbackgroundimg" id="tripback12"></div>
								<div class="tripbackgroundimg" id="tripback13"></div>
								<div class="tripbackgroundimg" id="tripback14"></div>
								<div class="tripbackgroundimg" id="tripback15"></div>
							</div>
							
						</div>

				</div>
				
					<div class="trip_info">
							<h3 class="trip_header1"><a href="#">[올레길]</a></h3>
						<div class="trip_line">
							<p class="trip_txt1"><a href="#">'올레'는 제주 방언으로 좁은 골목을 뜻하며, 통상 큰길에서 집의 대문까지 이어지는 좁은 길이다.</a></p>
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
		
		
		<!--3번째 컨텐츠-->
		<section class="trip">
			<div class="trip_first">
				<div class="tab2_cont">
				<p class="tab2_txt1">겨울 여행지</p>
				<p class="tab2_txt2"><span><a href="listTrip3.board?pageNo=0&pageSize=9&viewStart=0&viewEnd=5&level=admin"onclick="return loginCheck();">더보기</a></span></p>
				</div>
				<div class="trip_visual">
					
					<header>
				
						<div class="trip_header">
							<h2 class="readonly">여행지 광고</h2>
							
							<p><span>&nbsp;&nbsp;&nbsp;제주여행</span><br/>따뜻한 푸르름<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 그리고 제주</p>
							
						</div>
					
					</header>
					
						<div class="inner">
							
							<div class="tripbackgroundchange">
								<div class="tripbackgroundimg" id="tripback21"></div>
								<div class="tripbackgroundimg" id="tripback22"></div>
								<div class="tripbackgroundimg" id="tripback23"></div>
								<div class="tripbackgroundimg" id="tripback24"></div>
								<div class="tripbackgroundimg" id="tripback25"></div>
							</div>
							
						</div>

				</div>
				
					<div class="trip_info">
							<h3 class="trip_header1"><a href="#">[올레길]</a></h3>
						<div class="trip_line">
							<p class="trip_txt1"><a href="#">'올레'는 제주 방언으로 좁은 골목을 뜻하며, 통상 큰길에서 집의 대문까지 이어지는 좁은 길이다.</a></p>
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