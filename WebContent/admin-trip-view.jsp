<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.BoardAlbumDTOOut"%>
<%@page import="dto.BoardDTOOut"%>
<!doctype html>
<html lang="ko">
<%
	BoardDTOOut dto = (BoardDTOOut) request.getAttribute("BOARDDTOOUT");
	int num = dto.getNum(); //글번호 
	String type = dto.getType(); //콘텐츠 종류 
	String title = dto.getTitle(); //글 제목
	String content = dto.getContent(); //글 내용
	String mainphoto = dto.getMainphoto(); //사진 경로
	String map = dto.getMap(); //맵 링크 
	int nice = dto.getNice(); //좋아요
	int count = dto.getCount(); //조회수
	String regdate = dto.getReg_date(); //글 등록날짜 
	String level = dto.getLevel(); //글 권한
	
	//페이지 정보를 request 객체에서 가져옴
	String pageNo = request.getParameter("pageNo");
	String pageSize = request.getParameter("pageSize");
	String viewStart = request.getParameter("viewStart");
	String viewEnd = request.getParameter("viewEnd");
	String word = request.getParameter("search");
	%>

	<%
	
		ArrayList<BoardAlbumDTOOut> ALlist = (ArrayList<BoardAlbumDTOOut>)request.getAttribute("BOARDALBUMDTOOUT"); //수정을 위해 처리된 정보를 가져와 배열에 저장.
		BoardAlbumDTOOut album = null;
 		String[] subphoto = new String[ALlist.size()]; //String 배열에 길이를 저장해주어야함. 안할꺼면arrayList 사용. 
 		int[] alNum = new int[ALlist.size()]; //ALlist의 길이를 저장
 		
 		for(int i=0; i<ALlist.size(); i++)
		{
 			album = ALlist.get(i); //ALlist의 i값을 album에 저장
 			subphoto[i] = album.getPicPath(); //album안에 사진경로들을 subphoto에 길이만큼 저장
			alNum[i] = album.getAlNum(); //album안에 사진번호들을 alNum에 길이만큼 저장
			
 		}
 		
	%>
	
<head>
	<title>여행지</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, user-scalaboe-no">

	<link href="/portfolio/css/mystyle.css" rel="stylesheet">
	<link href="/portfolio/css/font-awesome.min.css" rel="stylesheet">
<script>
		function alertlogin()
		{
			alert("로그인후 사용해 주세요.");
		}
		function favlink()
		{
			var star = document.getElementById("star");
		
			var orstar = star.classList.toggle("fa-star-o");
			star.classList.toggle("fa-star");
			
			if(star.classList.contains("fa-star")==true)
			{
				star.style.color="gold";
				var check = confirm("즐겨찾기에 추가되었습니다.   \n확인하시겠습니까?");
				if(check == true)
				{
					location.href="favIn.board?&num=<%=num%>&type=<%=type%>&level=<%=level%>";
				}else
				{
					star.style.color="gold";
				}
			}else
			{
				star.style.color="black";
				
			}
		
		}
</script>
<script>
	function nice()
	{
		var num = <%=dto.getNum()%>;
		var type = "<%=dto.getType()%>";
		
		$.ajax
		({			
			type:"post",
			url:"nice.user",
			dataType:"json",
			data:"num="+num+"&type="+type,
			success:function(data)
			{
				//alert(data.result+" :"+data.nice);
				if(data.result == true)
				{
					var tag = document.getElementById("nice");
					tag.innerHTML=data.nice;
					
				}else
				{
					alert("이미 좋아요 하였습니다.");
				}
			}
		});
		
	}
</script>
</head>
	
	
<body id="top1">
	
	
		<header class="header">
			<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon1"></i></a>
			<h1 class="logo">여행지</h1>
			<a href="#" class="btn_search"><i class="fa fa-map-marker headericon2"></i></a>
			

		</header>
	<%@ include file="../sidebar-nav.jsp" %>
	

		<section class="trip">
			<div class="trip_first">
				
				<div class="trip_visual">
					
					<header>
				
						<div class="trip_header">
							<h2 class="readonly">여행지 광고</h2>
							<%if(mainphoto.equals("")||mainphoto==null){ %> <!--메인사진 경로가 빈값이거나 null이면 default.jsp 출력 -->
		
								<img src="/portfolio/imgs/default.jpg" alt="사진없음" class="headerimg">
								
							<%}else{ %>
									<img src="/portfolio/upload/<%=mainphoto %>" alt="업로드파일" class="uploadimg"> <!-- upload에 있는 mainphoto경로 출력 -->							
							<%} %>
						</div>				
					</header>
				</div>
				<div class="trip_view_cont">
					 	<a><p><i class="fa fa-commenting-o"></i>&nbsp;35</p></a>
						<i class="fa fa-heart" style="font-size:11px;"><p id="nice" onclick="nice();" style="cursor:pointer;"><%=nice %></p></i>
						<p style="margin-right:15px;"><i class="fa fa-eye"></i>&nbsp;<%=count %></p>
				</div>
				
			</div>	
				
				<div class="trip_view_box">
					<h2 class="trip_view_h2"><%=title %></h2>
					
					<h3 class="trip_view_h3">[<%=type %>]</h3>
					<a href="del.board?num=<%=num %>&mainphoto=<%=mainphoto %>&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type %>" class="trip_view_a2">삭제</a>
					<!-- <a href="mod.jsp" class="trip_view_a">수정</a> -->
					<form method="post" action="/portfolio/mod.jsp" class="trip_view_a">
						<input type="submit" value="수정" style="cursor:pointer;"> <!-- 작성되어있는 여러정보들을 hidden으로 mod.jsp로 보냄 -->
						
						<input type="hidden" name="num" value="<%=num %>">
						<input type="hidden" name="type" value="<%=type%>">
						<input type="hidden" name="title" value="<%=title%>">		
						<input type="hidden" name="photo" value="<%=mainphoto%>">					
						<input type="hidden" name="content" value="<%=content%>">
						<input type="hidden" name="map" value="<%=map%>">
						<input type="hidden" name="level" value="<%=level %>">
						
 						<%
 						for(int i=0; i<ALlist.size(); i++){
 						album = ALlist.get(i);
 						subphoto[i] = album.getPicPath();	
						alNum[i] = album.getAlNum();	%> <!-- 반복으로 배열 서브사진경로들과 사진번호를 넘겨준다. -->			
 						<input type="hidden" name="subphoto" value="<%=subphoto[i]%>"> 	
 						<input type="hidden" name="alNum" value="<%=alNum[i]%>"> 	
 						
			 			<%} %>			
					</form>
				</div>
		
				<div class="trip_view_text">
					<p>	<%=content %></p>
				</div>
				<div class="tirp_view_list">
					<a href="#" onclick="favlink();"><p class="trip_view_p"><i class="fa fa-star-o" id="star"></i></p></a>
					
					<% if(type.equals("healing")==true){%>									
						<a href="listTrip.board?&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type%>"><p class="trip_view_l">List</p></a>
					<%}else if(type.equals("nature")==true){ %>
						<a href="listTrip2.board?&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type%>"><p class="trip_view_l">List</p></a>
					<%}else if(type.equals("winter")==true){ %>
						<a href="listTrip3.board?&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type%>"><p class="trip_view_l">List</p></a>
					<%} %>	
				
					
					<% if(type.equals("healing")==true){%>
					<a href="read.board?value=2&num=<%=num%>&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type%>"><p class="trip_view_r"><i class="fa  fa-angle-double-right"></i></p></a>
					<%} else if(type.equals("nature")==true){%>					
					<a href="read2.board?value=2&num=<%=num%>&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type%>"><p class="trip_view_r"><i class="fa  fa-angle-double-right"></i></p></a>
					<%} else if(type.equals("winter")==true){%>				
					<a href="read3.board?value=2&num=<%=num%>&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type%>"><p class="trip_view_r"><i class="fa  fa-angle-double-right"></i></p></a>
					<%} %>
				</div>
		</section>		
	
		
		
		<footer class="footer">
			<p>COPYRIGHT  SANGMIN ALL RIGHTS RESERVED </p>
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