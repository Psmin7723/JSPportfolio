 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!doctype html>
<html lang="ko">
<head>

	
	<title>관리자글쓰기</title>
	<%@ include file ="login-check.jsp"%>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, user-scalaboe-no">
	<link href="css/mystyle.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	
	
    <script>
    function fileupload(){
        var mainpic = document.getElementById("main-pic");     
        var filename= document.getElementById("filename");
        var mainpic2 = mainpic.value;
        var mainidx = mainpic2.lastIndexOf("\\");
        var mainpic3 = mainpic2.substring(mainidx+1);
        filename.innerHTML = mainpic3;
        
    }  
     </script>
     <script> 
     function fileupload2(object,filename0)
     {
    	 var spanTag = document.getElementById(filename0);
    	 var subpic = object.value;
    	 var subidx = subpic.lastIndexOf("\\");
    	 var subpic2 = subpic.substring(subidx+1);
     	spanTag.innerHTML = subpic2;
     }
  
    function filedelete()
    {
    	var pic = document.getElementById("main-pic");   	 	
    		pic.type="";
    	 	pic.type="file";   	 	
    	 	filename.innerHTML=pic.value;  	
    }
   
    function filedelete2(object,subpic,filename)
    {
	   	 var spanTag = document.getElementById(subpic);
	   	 var filename1 = document.getElementById(filename);
	   	 	spanTag.type="";
	   	 	spanTag.type="file";
	    	filename1.innerHTML = spanTag.value;	    	
	}
   	
  		
    	
</script>
</head>
	<script>
		function check()
		{
			if(myform.title.value.trim() =="")
			{
				alert("제목을 입력해 주세요.");
				return;
			}
			if(myform.content.value.trim() =="")
			{
				alert("글 내용을 입력해 주세요.");
				return;
			}
			myform.submit();
		}
	</script>
	
<body id="top1">
	
	
		<header class="header">
			<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon1"></i></a>
			<h1 class="logo">관리자로그인</h1>
			
			<a href="listTrip.board?pageNo=0&pageSize=9&search=&viewStart=0&viewEnd=5" class="btn_search"><p style="font-weight:bold;">list</p></a>

		</header>
		
		<%@include file ="sidebar-nav.jsp" %>

		<!-- contents start -->
		
		<section class="adminbox">
		<form name="myform" method="post" enctype="multipart/form-data" action="write.board"> <!--텍스트가 아닌 파일을 넘길때는 post가 아니라 enctype="multipart/form-data"라고 해야함 -->
		<!--enctype="multipart/form-data" 인코딩타입 정해줘야 파일업로드 가능
        "multipart request" 쓰려면 C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\cos.jar 있어야 업로드 기능 쓸 수 있다-->
        		<input type="hidden" name="level" value="user">
				<select class="adminselect" name="type">
					<option value="관광지"> 여행지 글쓰기 </option>
					<option value="맛집"> 맛집 글쓰기 </option>
					<option value="특산물"> 특산물 글쓰기  </option>
				</select>
					
					<ul class="writeUl">
						<li class="id">	
								<label for="id_input" class="readonly">글 제목을 입력하세요.</label>
								<input type="text" name="title" id="title" class="id_input" placeholder="&#xf2bc;    글 제목을 입력하세요." style="font-family:Arial, FontAwesome" />
						</li>
						<li class="contentarea">
								<textarea rows="5" cols="30" name="content" style="width:80%; font-size:12px; display:block; margin:0 auto; height:200px; border-radius:10px; padding-left:10px; padding-top:15px;"></textarea>
						</li>
						</li>
							<li class="filenameLi">
							<label for="main-pic" class="filebox">메인사진업로드</label>						
							<input type="file" class="pic" name="main-pic" id="main-pic" onChange="fileupload()">
							
							<span id="filename" class="filename"></span>	
							
							<a class="filebox2" onClick="filedelete()">첨부삭제</a>
						</li>
						<li class="filenameLi">
							<label for="sub-pic1" class="filebox">1번 앨범사진</label>						
							<input type="file" class="pic" name="sub-pic1" id="sub-pic1" onChange="fileupload2(this,'filename1')">
							
							<span id="filename1" class="filename"></span>	
							
							<a class="filebox2" onClick="filedelete2(this,'sub-pic1','filename1')">첨부삭제</a>
						</li>
							<li class="filenameLi">
							<label for="sub-pic2" class="filebox">2번 앨범사진</label>						
							<input type="file" class="pic" name="sub-pic2" id="sub-pic2" onChange="fileupload2(this,'filename2')">
							
							<span id="filename2" class="filename"></span>	
							
							<a class="filebox2" onClick="filedelete2(this,'sub-pic2','filename2')">첨부삭제</a>
						</li>
							<li class="filenameLi">
							<label for="sub-pic3" class="filebox">3번 앨범사진</label>						
							<input type="file" class="pic" name="sub-pic3" id="sub-pic3" onChange="fileupload2(this,'filename3')">
							
							<span id="filename3" class="filename"></span>	
							
							<a class="filebox2" onClick="filedelete2(this,'sub-pic3','filename3')">첨부삭제</a>
						</li>
							<li class="filenameLi">
							<label for="sub-pic4" class="filebox">4번 앨범사진</label>						
							<input type="file" class="pic" name="sub-pic4" id="sub-pic4" onChange="fileupload2(this,'filename4')">
							
							<span id="filename4" class="filename"></span>	
							
							<a class="filebox2" onClick="filedelete2(this,'sub-pic4','filename4')">첨부삭제</a>
						
						<li class="btncss">
							<button type="button" class="ok" onClick="javascript:check();" style="width:70px;">확인</button>
							<button type="button" class="cancel" onClick="javascript:history.back();"style="width:70px;">취소</button>
						</li>
					</ul>
				</form>				
			
		
		</section>
		<!-- contents end -->
		<footer class="footer">
			<p>COPYRIGHT  SANGMIN ALL RIGHTS RESERVED </p>
		</footer>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>
		
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