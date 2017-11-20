
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="dto.BoardAlbumDTOOut"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>

<html lang="ko">
<head>

	
	<title>관리자로그인</title>
	<%@ include file ="../login-check.jsp"%>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1, user-scalaboe-no">
	<link href="/portfolio/css/mystyle.css" rel="stylesheet">
	<link href="/portfolio/css/font-awesome.min.css" rel="stylesheet">
	<%
		request.setCharacterEncoding("UTF-8");
		String num=request.getParameter("num");
		
		String mainphoto=request.getParameter("photo");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String map=request.getParameter("map");
		String level=request.getParameter("level");
		
		String type=request.getParameter("type");
		
		
	%>

	
    <script>
    function fileupload() // 메인 업로드 파일 경로 자르고 출력
    {
        var mainpic = document.getElementById("main-pic");     
        var filename= document.getElementById("filename");
        var mainpic2 = mainpic.value;
        var mainidx = mainpic2.lastIndexOf("\\");
        var mainpic3 = mainpic2.substring(mainidx+1);
        filename.innerHTML = mainpic3;
        
        
    }  
     </script>
     <script> 
     function fileupload2(object,filename0) // 서브 업로드 파일 경로 자르고 출력
     {
    	 var spanTag = document.getElementById(filename0);
    	 var subpic = object.value;
    	 var subidx = subpic.lastIndexOf("\\");
    	 var subpic2 = subpic.substring(subidx+1);
     	spanTag.innerHTML = subpic2;
     }
   
    
    function filedelete() // 메인 파일 경로 삭제후 출력
    {
    	var pic = document.getElementById("main-pic");   	 	
    		pic.type="";
    	 	pic.type="file";   	 	
    	 	filename.innerHTML=pic.value;  	
    	 	
    }
   
    function filedelete2(object,subpic,filename) // 서브 파일 경로 삭제후 출력 (this, file, span) 받아옴
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
			
			<a href="listTrip.board?pageNo=0&pageSize=9&viewStart=0&viewEnd=5" class="btn_search"><p style="font-weight:bold;">list</p></a>

		</header>
		
		<%@include file ="../sidebar-nav.jsp" %>

		<!-- contents start -->
		
		<section class="adminbox">										<!--mod.board에 수정을 위한 글번호, 글 제목, 글 내용, 메인 사진을 넘겨 보낸다.-->
		
		<form name="myform" method="post" enctype="multipart/form-data"action="mod.board?num=<%=num%>&title=<%=title%>&content=<%=content%>&mainphoto=<%=mainphoto %>&level=<%=level %>&type=<%=type %>&pageNo=0&pageSize=9&viewStart=0&viewEnd=5">

		
		<!--enctype="multipart/form-data" 인코딩타입 정해줘야 파일업로드 가능
        "multipart request" 쓰려면 C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\cos.jar 있어야 업로드 기능 쓸 수 있다-->
				<select class="adminselect" name="type">
				<% if(type.equals("healing")==true){%>
					<option value="<%=type%>"> 힐링여행 </option>
				<%}else if(type.equals("nature")==true){%> 	
					<option value="<%=type%>"> 자연여행 </option>
				<%}	else if(type.equals("winter")==true){%> 	
					<option value="<%=type%>"> 겨울여행  </option>
				<%}%>
				</select>
				
				<% // admin-trip-view에서 사진과 해당 사진번호를 getParameterValues(배열)로 받아옴
				String[] subphoto = request.getParameterValues("subphoto");
				
				String[] alNum = request.getParameterValues("alNum");
				
					for(int i=0; i<subphoto.length; i++){//반복을 통해 수정이 필요한 사진번호를 hidden을 통해 mod.board로 넘겨줌.
						
				 %>	
					<input type="hidden" name="alNum" value="<%=alNum[i]%>"> 				
	 			<%} %>
					<ul class="writeUl">
						<li class="id">	
								<label for="id_input" class="readonly">글 제목을 입력하세요.</label>
								<input type="text" name="title" id="title" class="id_input" placeholder="&#xf2bc;    글 제목을 입력하세요." style="font-family:Arial, FontAwesome" value="<%=title%>">
								
						</li>
						<li class="contentarea">
								<textarea rows="5" cols="30" name="content" style="width:80%; font-size:12px; display:block; margin:0 auto; height:200px; border-radius:10px; padding-left:10px; padding-top:15px;"><%=content %></textarea>
						</li>
						</li>
							<li class="filenameLi">
							<label for="main-pic" class="filebox">메인사진업로드</label>						
							<input type="file" class="pic" name="main-pic" id="main-pic" onChange="fileupload()">
							
							<span id="filename" class="filename"><%=mainphoto %></span>	
							
							<a class="filebox2" onClick="filedelete()">첨부삭제</a>
						</li>
						
						
						
						<li class="filenameLi">
							<label for="sub-pic1" class="filebox">1번 앨범사진</label>						
							<input type="file" class="pic" name="sub-pic1" id="sub-pic1" onChange="fileupload2(this,'filename1')">
												
							<span id="filename1" class="filename"><%=subphoto[0] %></span>	

							<a class="filebox2" onClick="filedelete2(this,'sub-pic1','filename1')">첨부삭제</a>
						</li>
							<li class="filenameLi">
							<label for="sub-pic2" class="filebox">2번 앨범사진</label>						
							<input type="file" class="pic" name="sub-pic2" id="sub-pic2" onChange="fileupload2(this,'filename2')">
							
							<span id="filename2" class="filename"><%=subphoto[1] %></span>	
							
							
							<a class="filebox2" onClick="filedelete2(this,'sub-pic2','filename2')">첨부삭제</a>
						</li>
							<li class="filenameLi">
							<label for="sub-pic3" class="filebox">3번 앨범사진</label>						
							<input type="file" class="pic" name="sub-pic3" id="sub-pic3" onChange="fileupload2(this,'filename3')">
							
							<span id="filename3" class="filename"><%=subphoto[2] %></span>	

							<a class="filebox2" onClick="filedelete2(this,'sub-pic3','filename3')">첨부삭제</a>
						</li>
							<li class="filenameLi">
							<label for="sub-pic4" class="filebox">4번 앨범사진</label>						
							<input type="file" class="pic" name="sub-pic4" id="sub-pic4" onChange="fileupload2(this,'filename4')">
						
							<span id="filename4" class="filename"><%=subphoto[3] %></span>	

							<a class="filebox2" onClick="filedelete2(this,'sub-pic4','filename4')">첨부삭제</a>
						
						<li class="btncss">
							<button type="button" class="ok" onClick="javascript:check();" style="width:70px;">수정</button>
							<button type="button" class="cancel" onClick="javascript:history.back();"style="width:70px;">취소</button>
						</li>
					</ul>
				</form>				
			
		
		</section>
		<!-- contents end -->
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
	

</body>
</html>