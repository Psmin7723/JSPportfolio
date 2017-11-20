<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin-check</title>
</head>
<body>
 <% //sidebar-nav에 있는 변수와 충돌을 우려해 변수를 소문자로 작성
 	String userid = (String)session.getAttribute("USERID");
 	String admin = (String)session.getAttribute("ADMIN");
 %>
 <%if(userid != null && admin != null){ %> <!-- 로그인 된 관리자 -->
 	<script>
 		//alert("관리자 모드");
 	</script> 
 <%}else{%> <!-- 관리자가 아니거나 로그인 되지 않음 -->
 	<script>
 		alert("관리자 권한으로 사용되는 페이지 입니다.\n관리자로 로그인해 주세요.");
 		location.href="adminLogin.jsp"; //관리자 로그인 페이지로 이동함
 	</script>
 <%} %>
</body>
</html>