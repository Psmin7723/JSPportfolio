<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.PageDTOOut"%>
<%@page import="dto.ListTripDTOOut"%>
<%@page import="java.util.ArrayList"%>  
<%@ include file ="admin-check.jsp"%>
 
<!doctype html>
<html lang="ko">
<head>
	<title>관리자로그인</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, user-scalaboe-no">
	<link href="../css/mystyle.css" rel="stylesheet">
	<link href="../css/font-awesome.min.css" rel="stylesheet">

</head>
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
<body id="top1">
	
	
		<header class="header">
			<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon1"></i></a>
			<h1 class="logo">관리자로그인</h1>
			<a href="#" class="btn_search"><i class="fa fa-search headericon2"></i></a>
			
			<div class="bar-search">
				<div class="inner">
					<form name="search" action="listTrip.board">					
						<label for="search" class="readonly">검색어를 입력하세요</label>
						<input type="text" name="search" class="search" placeholder="검색어를 입력하세요" id="search">
						<input type="hidden" name="pageSize" value="9">
						<input type="hidden" name="pageNo" value="0">
						
					</form>
				</div>
			</div>

		</header>
		
		<%@include file ="../sidebar-nav.jsp" %>

		<!-- contents start -->
		
		<%
			ArrayList<ListTripDTOOut> List = (ArrayList<ListTripDTOOut>)request.getAttribute("LISTTRIP");
								
			PageDTOOut Page = (PageDTOOut)request.getAttribute("PAGEOUT");
		%>
		
		<section class="adminbox">
				<select class="adminselect2" name="type">
					<option value="관광지"> 여행지  </option>
					<option value="맛집"> 맛집 </option>
					<option value="특산물"> 특산물  </option>
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
						<th	scope="col" class="titletirp">특산물</th> <!-- scope 관광지라는 열제목이라는걸 알려줌 -->
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
						
					%>
						<tr>
							<td class="contentnum"><%=num %></td>
							<td class="contenttrip"><%=title %></td>
							<td class="contentdate"><%=yymmdd %></td>
							<td class="contentcount"><%=count %></td>
						</tr>
					<%} %>
				</table>
				<div class="paging">
			
				<% int pageNum = Page.getPageNum(); //전체 페이지 개수 
			  for(int i = 0 ; i< pageNum ; i++)
			  { 
				 %> 
 				<a href="#"><%=i+1 %></a> 

				<%} %> 
				<a href="#"><i class="fa fa-angle-double-right"></i></a>
				<div class="top">
					<a href="write.jsp">글쓰기</a>
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