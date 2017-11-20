<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="dto.ListMainDTOOut"%>
<%@page import="java.util.ArrayList"%>
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
		<% 
	 		String userid = (String)session.getAttribute("USERID"); 		
	 	%>	
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
	<%
		String level = request.getParameter("level");
	%>
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
			<article class="tab_cont">
				<h2 class="readonly">탭메뉴</h2>
				<ul> 
					<li><a href="#">여행지</a></li>
					<li class="active"><a href="main2.jsp">맛  집</a></li>
					<li class="active"><a href="main3.jsp">특산물</a></li>			
				</ul>
			</article>
		</div>
		
		<section>
			
				<div class="main_visual">
				
					<header>
				
						<div class="main_header">
							<h2 class="readonly">메인비주얼 광고</h2>
							
							<p><span>&nbsp;&nbsp;&nbsp;제주여행</span><br/>따뜻한 푸르름<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 그리고 제주</p>
							
						</div>
					</header>
						<div class="inner">
						<div class="backgroundchange">
							<div class="backgroundimg" id="back1"></div>
							<div class="backgroundimg" id="back2"></div>
							<div class="backgroundimg" id="back3"></div>
							<div class="backgroundimg" id="back4"></div>
							<div class="backgroundimg" id="back5"></div>
						</div>
					</div>
					
					
				</div>
				<div class="tab1_cont">
					<p class="tab1_txt1">힐링 여행지</p>
					<p class="tab1_txt2"><span><a href="listTrip.board?pageNo=0&pageSize=9&viewStart=0&viewEnd=5&level=<%=level%>">더보기</a></span></p>
					<ul>
						<%
							//관광지 목록
							ArrayList<ListMainDTOOut> listTour = (ArrayList<ListMainDTOOut>) request.getAttribute("LISTTOUR");
							ArrayList<ListMainDTOOut> listTour2 = (ArrayList<ListMainDTOOut>) request.getAttribute("LISTTOUR2");
							ArrayList<ListMainDTOOut> listTour3 = (ArrayList<ListMainDTOOut>) request.getAttribute("LISTTOUR3");
						%>	
						<%
							if(listTour.size() >=1)
							{
								ListMainDTOOut dto = listTour.get(0);
								String title = dto.getTitle();
								String content = dto.getContent();
								String mainphoto = dto.getMainphoto();
								int num = dto.getNum();					
								if(mainphoto==null|| mainphoto.equals(""))
								{ 
									mainphoto = "/portfolio/imgs/default.jpg";%>			
							 <% }else{
							 	
								 	mainphoto = "/portfolio/upload/"+mainphoto;
							 %>									
									<%} %>
							<li class="sub_visual1"><a href="read.board?num=<%=num%>&value=1&pageNo=0&pageSize=9&viewStart=0&viewEnd=5&search=&level=<%=level%>&type=healing" onclick="return loginCheck();">
								<img src="<%=mainphoto %>" alt="유채꽃" class="imgw101">
								<p><span>[<%=title %>]&nbsp;&nbsp;</span><%=content %></p></a>
							</li>
						<%} %>
						
						<%if(listTour.size() >=2){
							ListMainDTOOut dto = listTour.get(1);
							String title = dto.getTitle();
							String content = dto.getContent();
							String mainphoto = dto.getMainphoto();
							int num = dto.getNum();					
							if(mainphoto==null || mainphoto.equals(""))
							{
								mainphoto = "/portfolio/imgs/default.jpg";%>

							<% }else{
								mainphoto = "/portfolio/upload/"+mainphoto;%>
							<%}%>
							<li class="sub_visual2"><a href="read.board?num=<%=num%>&value=1&pageNo=0&pageSize=9&viewStart=0&viewEnd=5&search=&level=<%=level%>&type=healing"onclick="return loginCheck();">
							<img src="<%=mainphoto %>" alt="왕벚꽃" class="imgw101">
							<p><span>[<%=title %>]&nbsp;&nbsp;</span><%=content %></p></a>	
						</li>
						<%} %>
						
						
						
						
					</ul>
				</div>
			
		</section>
		
		<section class="sub_visual">
				<h2 class="readonly">테마 게시물</h2>
				<p class="tab1_txt1">테마 여행지</p>
				<p class="tab1_txt2"><span><a href="listContent.user?pageNo=0&pageSize=4&viewStart=0&viewEnd=4&search=">더보기</a></span></p>
				
				<ul class="sub_ul1">	
			<% 	if(listTour.size() >=3){	
				ListMainDTOOut dto = listTour.get(2);
							String title = dto.getTitle();
							String content = dto.getContent();
							String mainphoto = dto.getMainphoto();
							int num = dto.getNum();
							if(mainphoto==null || mainphoto.equals(""))
							{
								mainphoto = "/portfolio/imgs/default.jpg";%>

							<% }else{
								mainphoto = "/portfolio/upload/"+mainphoto;%>
							<%}%>
					<li>			
						<a href="read.board?num=<%=num%>&value=1&pageNo=0&pageSize=9&viewStart=0&viewEnd=5&search=&level=<%=level%>&type=healing"onclick="return loginCheck();">
						<img src=<%=mainphoto %> alt="제주길" class="imgm100">
						<p class="main_2"><span>[<%=title %>]&nbsp;&nbsp;</span><%=content %></p>
						</a>		
					</li>	
			<%} %>					
				</ul>	
				
				<ul class="sub_ul2">	
					<% 	if(listTour.size() >=4){	
				ListMainDTOOut dto = listTour.get(3);
							String title = dto.getTitle();
							String content = dto.getContent();
							String mainphoto = dto.getMainphoto();
							int num = dto.getNum();
							if(mainphoto==null || mainphoto.equals(""))
							{
								mainphoto = "/portfolio/imgs/default.jpg";%>

							<% }else{
								mainphoto = "/portfolio/upload/"+mainphoto;%>
							<%}%>
					<li>			
						<a href="read.board?num=<%=num%>&value=1&pageNo=0&pageSize=9&viewStart=0&viewEnd=5&search=&level=<%=level%>&type=healing"onclick="return loginCheck();">
						<img src=<%=mainphoto %> alt="제주길" class="imgm100">
						<p class="main_2"><span>[<%=title %>]&nbsp;&nbsp;</span><%=content %></p>
						</a>		
					</li>	
			<%} %>					
				</ul>
				<ul class="sub_ul1">				
					<% 	if(listTour2.size() >=1){
							ListMainDTOOut dto = listTour2.get(0);
							String title = dto.getTitle();
							String content = dto.getContent();
							String mainphoto = dto.getMainphoto();
							int num = dto.getNum();
							if(mainphoto==null || mainphoto.equals(""))
							{
								mainphoto = "/portfolio/imgs/default.jpg";%>

							<% }else{
								mainphoto = "/portfolio/upload/"+mainphoto;%>
							<%}%>
					<li>			
						<a href="read2.board?num=<%=num%>&value=1&pageNo=0&pageSize=9&viewStart=0&viewEnd=5&search=&level=<%=level%>&type=nature"onclick="return loginCheck();">
						<img src=<%=mainphoto %> alt="제주길" class="imgm100">
						<p class="main_2"><span>[<%=title %>]&nbsp;&nbsp;</span><%=content %></p>
						</a>		
					</li>	
			<%} %>					
				</ul>
				<ul class="sub_ul2">	
					<% 	if(listTour2.size() >=2){	
							ListMainDTOOut dto = listTour2.get(1);
							String title = dto.getTitle();
							String content = dto.getContent();
							String mainphoto = dto.getMainphoto();
							int num = dto.getNum();
							if(mainphoto==null || mainphoto.equals(""))
							{
								mainphoto = "/portfolio/imgs/default.jpg";%>

							<% }else{
								mainphoto = "/portfolio/upload/"+mainphoto;%>
							<%}%>
					<li>			
						<a href="read2.board?num=<%=num%>&value=1&pageNo=0&pageSize=9&viewStart=0&viewEnd=5&search=&level=<%=level%>&type=nature"onclick="return loginCheck();">
						<img src=<%=mainphoto %> alt="제주길" class="imgm100">
						<p class="main_2"><span>[<%=title %>]&nbsp;&nbsp;</span><%=content %></p>
						</a>		
					</li>	
			<%} %>					
				</ul>
				<ul class="sub_ul1">		
					<% 	if(listTour3.size() >=1){	
							ListMainDTOOut dto = listTour3.get(0);
							String title = dto.getTitle();
							String content = dto.getContent();
							String mainphoto = dto.getMainphoto();
							int num = dto.getNum();
							if(mainphoto==null || mainphoto.equals(""))
							{
								mainphoto = "/portfolio/imgs/default.jpg";%>

							<% }else{
								mainphoto = "/portfolio/upload/"+mainphoto;%>
							<%}%>
					<li>			
						<a href="read3.board?num=<%=num%>&value=1&pageNo=0&pageSize=9&viewStart=0&viewEnd=5&search=&level=<%=level%>&type=winter"onclick="return loginCheck();">
						<img src=<%=mainphoto %> alt="제주길" class="imgm100">
						<p class="main_2"><span>[<%=title %>]&nbsp;&nbsp;</span><%=content %></p>
						</a>		
					</li>	
			<%} %>												
				</ul>	
				<ul class="sub_ul2">	
					<% 	if(listTour3.size() >=2){	
				ListMainDTOOut dto = listTour3.get(1);
							String title = dto.getTitle();
							String content = dto.getContent();
							String mainphoto = dto.getMainphoto();
							int num = dto.getNum();
							if(mainphoto==null || mainphoto.equals(""))
							{
								mainphoto = "/portfolio/imgs/default.jpg";%>

							<% }else{
								mainphoto = "/portfolio/upload/"+mainphoto;%>
							<%}%>
					<li>			
						<a href="read3.board?num=<%=num%>&value=1&pageNo=0&pageSize=9&viewStart=0&viewEnd=5&search=&level=<%=level%>&type=winter"onclick="return loginCheck();">
						<img src=<%=mainphoto %> alt="제주길" class="imgm100">
						<p class="main_2"><span>[<%=title %>]&nbsp;&nbsp;</span><%=content %></p>
						</a>		
					</li>	
			<%} %>					
				</ul>
		</section>
		<section class="contents">
			<h2 class="readonly">콘텐츠내용</h2>
		</section>
		
		<footer class="footer">
			<p>COPYRIGHT SANGMIN ALL RIGHTS RESERVED </p>
		</footer>
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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