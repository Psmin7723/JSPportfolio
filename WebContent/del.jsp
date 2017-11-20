 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file ="../login-check.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원탈퇴 비밀번호 한번더 묻기</title>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script>

function checkpw()
{
	
	var pw =  document.getElementById("delPw").value;

	$.ajax({
		type:"post",
		url:"checkpw.mem",
		dataType:"json",
		data:"pw="+pw,
		
		complete:function(data)
		{
			
		},
		success:function(data)
		{
			if(data.ret==true){
				location.href="del.mem";
			}else
			{
				alert("비밀번호가 일치하지 않습니다.");
			}
		}
	});
}
</script>
</head>
<body>
<form name="delform" action="main.jsp" method="post">
   <h3>탈퇴하시려면 비밀번호를 한번 더 입력하세요</h3>
   <input type="text" name="delPw" id="delPw" value="">
   <h4>정말로 탈퇴하시겠습니까?</h4>
   <button type="button" name="del" id="del" onclick="checkpw()">네, 탈퇴하겠습니다</button>
   <input type="submit" value="아니오, 탈퇴하지않겠습니다" name="not_del" id="not_del">
	<!-- onclick="location.href='main.jsp'" -->
</form>
</body>
</html>
