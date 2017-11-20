<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.InfoDTOOut"%>
<!doctype html>
<html lang="ko">
<head>
	<title>회원정보수정</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, user-scalaboe-no">
	<link href="css/mystyle.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$(function()
	{
		$( "#pw_input_bf" ).prop( "disabled", true ); //Disable
		$( "#pw_input_bf2" ).prop( "disabled", true ); //Disable
		$( "#tell" ).prop( "disabled", true ); //Disable
		$( "#cellnum" ).prop( "disabled", true ); //Disable
		$( "#cellnum1" ).prop( "disabled", true ); //Disable
		$( "#email" ).prop( "disabled", true ); //Disable
		$( "#email2" ).prop( "disabled", true ); //Disable	
		$( ".complete").prop("disabled", true ); //Disable	
		$( ".complete").css("display","none");
		
	});
</script>	
<script>
 var isPwChecked = false;
 
 function modcheck()
 {
	 var pwvalue = document.getElementById('pw_input_bf').value
	 if(isPwChecked == true || pwvalue == "")
	 {
		 
	 
		 
				 //myform.submit();
				 var param = $('form[name=myform]').serialize();
		          //alert("회원정보입력: "+param);
		         $.ajax({
		            type:"POST",
		            url:"mod.mem",
		            data:param,
		            dataType:"JSON",
		            success:function(result)
		            {
		               
		               	if(result.ret == true)
		               	{
		               		alert("회원 정보가 성공적으로 수정되었습니다.");
		               		location.href="main.jsp";
		               	}else
		               	{
		               		alert("회원 정보 수정중 오류가 발생하였습니다.\n 다시한번 시도해 주세요.");
		               	}
		 		
		            },
		            error:function(){
		               alert("회원정보수정 처리중 에러가 발생하였습니다.");
		            }
		         });
	 }else{
		 alert("비밀번호가 일치하는지 확인해주세요.")
		 
		 
	 }
 }
 
 function PwCheck()
 {
		 var pw = document.getElementById("pw_input_bf").value;
	     var pw2 = document.getElementById("pw_input_bf2").value;
	     
		 var e=document.getElementById("inputkey2");
		 var pattern = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/;
		 var input = $("#pw_input_bf").val().trim();
		
		e.style.color = "red";
		
		
		if (pattern.test(input)) 
		{
			e.style.color="blue";
			e.style.fontSize="11px";
			e.innerHTML="올바른 형식입니다."		
			chgPwtf = true; //정규표현식이 맞음
				
			
			//************  위는 정규식 밑은 비밀번호 일치 ************
			 isPwChecked = false; //패스워드 확인검사 포함

		     		if(pw !="" && pw2=="")
		 				{
		     			document.getElementById("inputkey").innerHTML =" ";
		 				}
		     		else
						{
			   			if (pw != pw2) 
				   			{
			        			document.getElementById("inputkey").style.color = "red";
			        			document.getElementById("inputkey").style.fontSize = "11px";
			            		document.getElementById("inputkey").innerHTML = "비밀번호가 일치하지 않습니다. 다시 입력해 주세요.";
			            		isPwChecked = false;
			            		return false;
			        		}
			        	else{
			        	   		document.getElementById("inputkey").style.color = "blue";
			        	   		document.getElementById("inputkey").style.fontSize = "11px";
			        	   		document.getElementById("inputkey").innerHTML = "비밀번호가 일치합니다.";
			        	   		isPwChecked = true;
			        	   		
			        	   		
			    			}		   
						}
		} else {			
			e.style.fontSize="11px";
			e.innerHTML="영문 대소문자,숫자 또는 특수문자 포함,6~20자";	
			chgPwtf = false; //정규표현식이 틀림
			document.getElementById("inputkey").innerHTML =" ";
		}
	

				
 }
</script>

<script>



function checkpw()
{

	var pw =  document.getElementById("pw_input").value;
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
				$( "#pw_input_bf" ).prop( "disabled", false ); //Enable
				$( "#pw_input_bf2" ).prop( "disabled", false ); //Ensable
				$( "#tell" ).prop( "disabled", false ); //Ensable
				$( "#cellnum" ).prop( "disabled", false ); //Ensable
				$( "#cellnum1" ).prop( "disabled", false ); //Ensable
				$( "#email" ).prop( "disabled", false ); //Ensable
				$( "#email2" ).prop( "disabled", false ); //Ensable
				$( ".complete").prop("disabled", false ); //Disable	
				$( ".complete").css("display","block");
				
			}else
			{
				alert("비밀번호가 일치하지 않습니다.");
			}
			
		}
		
	});
}


</script>
</head>
	
<body id="top1">
	
	
		<header class="header">
			<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon1"></i></a>
			<h1 class="logo"><a href="main.jsp"><span>제주</span>여행</a></h1>
			<a href="info.jsp" class="btn_search"><p style="font-weight:bold;">back</p></a>
			
		
		
		</header>
		<%@ include file="sidebar-nav.jsp" %>
	

		<!-- contents start -->
		
		<section class="loginbox">
			<h2><span>회원정보</span>수정</h2>
			<p class="readonly">회원정보수정</p>
				<form name="myform" class="form_join" method="post" onsubmit="modcheck(); return false;" action="mod.mem"> <!--텍스트가 아닌 파일을 넘길때는 post가 아니라 enctype="multipart/form-data"라고 해야함 -->
					
					<div class="id_join">
						<h4 class="idtxt">현재 비밀번호를 입력해주세요.</h4>
						<label for="id_input" class="readonly">비밀번호를 입력하세요</label>
						<input type="password" name="id" id="pw_input"  class="id_input_join" placeholder="&#xf2bc;    비밀번호 입력" style="font-family:Arial, FontAwesome" title="비밀번호를 입력해주세요."/>
						
					</div>
						<a href="#" class="idcheck" onclick="checkpw()">확인</a>
					<h4 class="pwtxt">새로 생성할 비밀번호를 입력하시고 확인해주세요.</h4>
					<div class="pw_join">	
						
						<label for="pw_input" class="readonly" >새로운 패스워드를 입력하세요 </label>
						<input type="password" name="pw" id="pw_input_bf" onkeyup="PwCheck()"class="pw_input_join" placeholder=" &#xf023;     새로운 비밀번호 입력" style="font-family:Arial, FontAwesome"title="패스워드를 입력해주세요." />			
						<p class="pwkey" id="inputkey2"></p>
					</div>
					
					<div class="pw2_join">	
						<label for="pw_input" class="readonly" >새로운 패스워드를 한번 더 입력하세요 </label>
						<input type="password" name="pw2" id="pw_input_bf2" onkeyup="PwCheck()"class="pw2_input_join" placeholder=" &#xf023;     새로운 비밀번호 확인" style="font-family:Arial, FontAwesome" title="비밀번호를 입력해주세요." />		
						<p class="pwkey" id="inputkey"></p>
					</div>
					<div class="tell">
						<h4 class="phone">변경할 전화번호를 입력해주세요.</h4>
						<label for="tell" class="readonly">전화번호 입력 </label>
						<select class="tell_join" id="tell" name="mobile">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="017">017</option>
						</select>
						<p class="s1">-</p>
						<label for="cellnum" class="readonly">전화번호 앞자리입력</label>
						<input type="text" id="cellnum"name="mobile1" class="tel2" style="padding-left:10px;">
						<p class="s2">-</p>
						<label for="cellnum1" class="readonly">전화번호 뒷자리입력</label>
						<input type="text" id="cellnum1" name="mobile2" class="tel3"style="padding-left:10px;">
					</div>
					
					<div class="e-mail">	
						<h4 class="mail-e">변경할 메일주소를 입력해주세요.</h4>
						<label for="email" class="readonly">메일주소 입력</label>
						<input type="text" name="email" class="emailid" id="email" style="padding-left:15px;">
			
						<p class="s3">@  </p>
						<label for="emailser" class="readonly">이메일 도메인 선택</label>
						<select name="email2" class="email_sel" id="email2">
							<option value="">메일선택</option>
							<option value="naver.com">naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="gmail.com">gmail.com</option>
						</select>
						
						
					</div>
				
					
					<div style="width:100%; padding-bottom:30px;">
						<input type="submit" class="complete" value="수정완료" style="font-size:17px; font-weight:bold; color:#fff;width:150px; height:50px; background-color:#2ba9e7; margin:0 auto;display:block;">
					</div>
					
					
					
				</form>		
		</section>
		<!-- contents end -->
		<footer class="footer">
			<p>COPYRIGHT  SANGMIN ALL RIGHTS RESERVED </p>
		</footer>
		
		<% //밑에 작성해야만 아이디값을 가져올수있다. 
		InfoDTOOut dto = (InfoDTOOut)request.getAttribute("InfoDTOOut");
		
	 	String tel1 = dto.getTel1();
	 	String tel2 = dto.getTel2();
	 	String tel3 = dto.getTel3();
	 	
	 	String email = dto.getEmail();
	 	String email2 = dto.getEmail2();
	 	
	 	System.out.println(tel1+"-"+tel2+"-"+tel3);
	 	System.out.println(email+"@"+email2);
	%>
	<script>

	
			
		<%  String userPhone1 = (String) request.getAttribute("pw_input"); %>
		window.onload = function() {
		var JStel1 = "<%=tel1%>";
	   	document.myform.tell.value = JStel1;}
		var JStel2 = document.getElementById("cellnum");
		JStel2.value = "<%=tel2%>";
		var JStel3 = document.getElementById("cellnum1");
		JStel3.value = "<%=tel3%>";
		
		var JSemail = document.getElementById("email");
		JSemail.value = "<%=email%>";
		var JSemail2 = document.getElementById("email2");
		JSemail2.value = "<%=email2%>";
		
</script>
	
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