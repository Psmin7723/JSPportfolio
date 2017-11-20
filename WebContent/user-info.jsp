<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.FavDTOOut"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<html lang="ko">
<head>
	<title>여행지</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, user-scalaboe-no">
	<link href="css/mystyle.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">



<% String fav =(String)request.getAttribute("FAVORIT"); %>	
<script>

window.onload = function () {
	var fav = "fav";
	
		if(fav=="<%=fav%>")
		{
			 document.location.href="#favorit1";
		}else
		{
			alert("땡");
		}
	}

		function alertlogin()
		{
			alert("로그인후 사용해 주세요.");
		}
	</script>
</head>
	
<body id="top1">
	
	
		<header class="header">
			<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon1"></i></a>
			<h1 class="logo">ContentInfo</h1>
			<a href="main.jsp" class="btn_search"><p style="font-weight:bold;">back</p></a>
			

		</header>
		<%@ include file="sidebar-nav.jsp" %>
	

		<section>
			<ul class="info">
				<li>
					<h3>메세지</h3>
					<p class="info_p">[받으실 분의 아이디를 입력해주세요.]</p>
					<label for="masage" class="readonly">아이디 입력</label>
					<input type="text" name="masageid" class="masageid" id="masage"placeholder=" 아이디입력">
					<a href="#"><p class="info_p1">확인</p></a>
					<label for="masage" class="readonly">내용 입력</label>
					<input type="text" name="masageid1" class="masageid1" id="masage"placeholder=" 내용입력">
					<a href="#"><p class="info_p2">보내기</p></a>
				</li>
				<li id="bell">
					<h3>알림</h3>
					<p> 받은 메세지가 없습니다. </p>
				</li>
				<li id="wh">
					<h3>날씨</h3>
					<p>현재 제주도의 날씨 입니다.</p>
					<img src="imgs/jejuw.jpg" alt="날씨" class="imgw100">
				</li>
				<li id="where">
					<h3>내 위치</h3>
					<p>현재 나의 위치 입니다.</p>
					<img src="imgs/map.jpg" alt="지도" class="imgw100">
				</li>
				<li id="favorit1">
					<h3>즐겨찾기</h3>
					
					<p>현재 나의 즐겨찾기 목록입니다. </p>
					<h4>[여행지]</h4>
					<%
						ArrayList<FavDTOOut> dto = (ArrayList)request.getAttribute("FAVTRIP");
						String title;
						String reg_date;
						
						int num;
						for(int i = 0; i<dto.size();i++)
						{
							num = dto.get(i).getNum();
							title = dto.get(i).getTitle();
							reg_date = dto.get(i).getReg_date();
							String yymmdd = reg_date.substring(0,16);
							
					%>
					<a href="read.user?value=fav&num=<%=num %>&pageNo=0&pageSize=9&viewStart=0&viewEnd=5&search="><p class="info_pp"><%=title%></p></a>	
					<p><%=yymmdd %></p>
					<% 		
						}							
					%>
					
					<!-- <img src="imgs/winter.jpg" alt="날씨" class="imgw51"></a> -->
					
					<h4>[맛집]</h4>
					<p class="info_pp">1.제주도 흑돼지</p>
					<img src="imgs/pig.PNG" alt="날씨" class="imgw51">
					<p class="info_pp">2.제주도 해산물</p>
					<img src="imgs/seafood.PNG" alt="날씨" class="imgw51">
					<h4>[특산물]</h4>
					<p>저장된 즐겨찾기가 없습니다.</p>
				</li>
				<li>
					<a href="info.mem"><h3>회원정보수정</h3></a>
				</li>
				<li>
					<a href="del.jsp"><h3>회원탈퇴</h3></a>
					
				</li>
			</ul>
			
		
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