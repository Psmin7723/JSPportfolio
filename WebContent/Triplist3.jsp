<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.PageDTOOut"%>
<%@page import="dto.ListTripDTOOut"%>
<%@page import="java.util.ArrayList"%>  
<%@ include file ="../login-check.jsp"%>
 
<!doctype html>
<html lang="ko">
<head>
	<title>자연게시판</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, user-scalaboe-no">
	
	<link href="../css/mystyle.css" rel="stylesheet">
	<link href="../css/font-awesome.min.css" rel="stylesheet">
	<link href="css/mystyle.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">

</head>
<%
			ArrayList<ListTripDTOOut> List = (ArrayList<ListTripDTOOut>)request.getAttribute("LISTTRIP3");
		String type;
		String level;				
			PageDTOOut Page = (PageDTOOut)request.getAttribute("PAGEOUT");
		%>
		<%
					int pageNum = Page.getPageNum(); //전체 페이지 개수 
				  	int pageNo = Page.getPageNo(); //현재 페이지 번호
				    int pageSize = Page.getPageSize(); //한 페이지의 출력할 글 목록 개수
					int prevPage = Page.getPrevPage(); //이전 페이지 이동 정보
					int nextPage = Page.getNextPage(); //다음 페이지 이동 정보
					String word = Page.getWord(); //검색어 
					int viewStart = Page.getViewStart(); //보여지는 페이지 번호 시작
					int viewEnd = Page.getViewEnd(); //보여지는 페이지 번호 끝 
		%>
	
	<script>
		function logcheck()
		{
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
			myform.submit();
		}
	</script>
	
	<% 
		String realPath=request.getRealPath("");
		//System.out.println("톰캣이 사용하는 실제 경로 : "+realPath);
	%>
	
<body id="top1">
	
	
		<header class="header">
			<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon1"></i></a>
			<h1 class="logo"><a href="/portfolio/main.user">겨울게시판</a></h1>
			<a href="#" class="btn_search"><i class="fa fa-search headericon2"></i></a>
			
			<div class="bar-search">
				<div class="inner">
					<form name="mysearch" action="listTrip3.board">
					
						<label for="search" class="readonly">검색어를 입력하세요</label>
						<input type="text" name="search" class="search" placeholder="검색어를 입력하세요" id="search">
						<input type="hidden" name="pageSize" value="9">
						<input type="hidden" name="pageNo" value="0">
						<input type="hidden" name="viewStart" value="0">
						<input type="hidden" name="viewEnd" value="5">
						
					</form>
				</div>
			</div>

		</header>
		
		<%@include file ="../sidebar-nav.jsp" %>

		<!-- contents start -->
		
		
				
		
		<section class="adminbox">
				<select class="adminselect2" onchange="location.href=this.value" name="type" id="selecttype">
					<option value="#"> 게시판 선택  </option>
					<option value="listTrip.board?pageNo=0&pageSize=9&viewStart=0&viewEnd=5"> 힐링게시판  </option>
					<option value="listTrip2.board?pageNo=0&pageSize=9&viewStart=0&viewEnd=5"> 자연게시판 </option>
					<option value="listTrip3.board?pageNo=0&pageSize=9&viewStart=0&viewEnd=5"> 겨울게시판  </option>
				</select>
				<table class="list">
					<caption>제주여행 목록으로 번호, 제목, 작성일, 조회수를 보여줌</caption> <!--caption 표제목 /// 안보이게 함 -->
					<colgroup>
						<col width="15%">
						<col width="*">
						<col width="10%">
						<col width="20%"> <!-- *는 남는 나머지를 다 사용한다.-->
					</colgroup>
					<thead> <!-- 열제목 -->
						<th scope="col" class="titlenum">번호</th> <!--  scope 번호라는 열제목이라는걸 알려줌 -->
						<th	scope="col" class="titletirp">관광여행지</th> <!-- scope 관광지라는 열제목이라는걸 알려줌 -->
						<th	scope="col" class="titledate">작성일</th>
						<th	scope="col" class="titlecount">조회수</th>
						
					</thead>
					<tbody><!-- 본문-->
					
					</tbody>
					<% for(int i = 0 ; i< List.size() ; i++)
					  { 
						ListTripDTOOut dto = List.get(i);  
						
						int num = dto.getNum();
						String title = dto.getTitle();
						String reg_date = dto.getReg_date();
						int count = dto.getCount();
						String yymmdd = reg_date.substring(0,10);
						type = List.get(i).getType();
						level = List.get(i).getLevel();
					%>
						<tr>
							
							<td class="contentnum"><%=num %></td>
							<td class="contenttrip"><a href="read3.board?num=<%=num%>&value=1&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&type=<%=type%>&search=<%=word%>&level=<%=level%>"><%=title %></a></td>
							<td class="contentdate"><%=yymmdd %></td>
							<td class="contentcount"><%=count %></td>
						
						</tr>
					<%} %>
				</table>
				<div class="paging">
				<!-- 이젠 페이지 기능 -->
				
				<% 
					if(prevPage != -1) //이전 페이지 이동이 없음
					{					
				%>
					<a href="listTrip3.board?pageNo=<%=prevPage%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>"><i class="fa fa-angle-double-left"></i></a>
				<% 		
					}
				%>
				<%
					//페이지 번호 출력 / 페이지 이동
					
				  for( int i=viewStart ; i < viewEnd ; i++)
				  { 
				%> 
					 <%if(i == pageNo) {%><!-- 현재 페이지 페이지링크 안됨 -->
		 			 <Strong><%=i+1 %></Strong> 
					 <%}else{%>
					 <a href="listTrip3.board?pageNo=<%=i%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>"><%=i+1 %></a> 
					 <%}%>
				 <%}%> 
				 <% if(nextPage != -1){ //다음 페이지 이동이 없음%>
					<a href="listTrip3.board?pageNo=<%=nextPage%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>"><i class="fa fa-angle-double-right"></i></a>	
				<% 	}else{ %>
					
				<% 	
					}
				%>
				 
				 <div class="top">
				 
					
						 <a href="/portfolio/write.jsp?type=winter">글쓰기</a>
				
				 </div>
			
		</div>
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