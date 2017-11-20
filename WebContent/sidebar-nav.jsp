<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>객체저장</title>


</head>
<body>
		<%
		String USERID =(String) session.getAttribute("USERID");
		String ADMIN =(String) session.getAttribute("ADMIN");
		//ADMIN이 null이면 일반 사용자, null이 아니면 관리자
		
		String uri =request.getRequestURI();
		int idx = uri.lastIndexOf("/"); //마지막 경로 구분 문자를 찾음
		String jsppage = uri.substring(idx+1);
		
		//System.out.println("현재 경로 :"+uri);
		//System.out.println("현재 jsp 페이지 :"+jsppage);
		if(USERID!=null){ 

		%>
   
   
	<nav id="slidebar-wrapper">
		
			<a href="#" id="menu-close" class="btn-close"><i class="fa fa-close"></i></a>
			<div class="slidebarwrap">
				<div class="slidebar-brand" style="background:url(/portfolio/imgs/sm.jpg) no-repeat center center;background-size:cover;">
				</div>
				<a href="#" ><p class="nickname"> 로봇왕위잉치킹 </p></a>
				<%if(ADMIN == null){ %>
				<a href="/portfolio/logout.mem"><p class="nickname1">로그아웃 </p></a>
				<%}else{ %>
				<a href="logout.admin"><p class="nickname1">관리자 로그아웃 </p></a>
				<%} %>
				<div class="slidebar-bottomline">

				</div>
			</div>
				<ul class="sidebar-nav">
					
					<li><i class="fa fa-pencil-square-o"></i><a href="/portfolio/write.jsp?type=none">글쓰기</a></li>
					<li><i class="fa fa-list-alt"></i><a href="/portfolio/listTrip.board?pageNo=0&pageSize=9&viewStart=0&viewEnd=5&level=admin">게시판</a></li>
				
					<li><i class="fa fa-comments-o"></i><a href="info.jsp">메세지</a></li>
					<li><i class="fa fa-bell-o"></i><a href="/portfolio/admin-info.jsp">알림</a></li>
					
					<li><i class="fa fa-umbrella"></i><a href="info.jsp#wh">날씨</a></li>
					<li><i class="fa fa-map-marker"></i><a href="info.jsp#where">내 위치</a></li>
				
					<li><i class="fa fa-star-o"></i><a href="/portfolio/favOut.board?level=&type=">즐겨찾기</a></li>
				
				
					<%if(ADMIN == null){%>					
					<li><i class="fa fa-map-signs"></i><a href="info.jsp">회원정보수정</a></li>
					<li><i class="fa fa-gear"></i><a href="del.jsp">회원탈퇴</a></li>			
					<%} %>
				</ul>
		
	</nav>
	<%}else { %>
	<nav id="slidebar-wrapper">
		
			<a href="#" id="menu-close" class="btn-close"><i class="fa fa-close"></i></a>
			<div class="slidebarwrap">
				<div class="slidebar-brand" style="background:url(/portfolio/imgs/goat3.png) no-repeat center center;background-size:cover;">
				</div>
				<%if(ADMIN == null){%>
				<a href="signup.jsp" ><p class="nickname"> 회원가입 </p></a>
				<%} %>
				
				
				<a href="/portfolio/login.jsp" ><p class="nickname1">로그인 </p></a>
				
				
				
				<div class="slidebar-bottomline">

				</div>
			</div>
				<ul class="sidebar-nav">
						
				</ul>
		
	</nav>
	<%} %>

</body>
</html>