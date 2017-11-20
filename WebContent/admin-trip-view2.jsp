<%@page import="dto.ReplyDTOOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="dto.BoardAlbumDTOOut"%>
<%@page import="dto.BoardDTOOut2"%>
<%@page import="dto.BoardDTOOut"%>
<!doctype html>
<html lang="ko">
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
		function showMod(i){
	      
	      var replyList = document.getElementById("replyList"+i);
	      replyList.style.display = "none";
	      
	      var modArea = document.getElementById("mod"+i);
	      modArea.style.display = "block";
	   }
	   
	   function hideMod(i){
	      
	      var replyList = document.getElementById("replyList"+i);
	      replyList.style.display = "block";
	      
	      var modArea = document.getElementById("mod"+i);
	      modArea.style.display = "none";
	   }
	</script>
<script>
		function delReply(num,i)
		{ 
			var reply = document.getElementById("reply"+i);
			var check = confirm("댓글을 삭제하시겠습니까?");
			if(check == true)
			{
				$.ajax({
					type:"post",
					async:false,
					url:"delReply.user",
					dataType:"json",
					data:"num="+num,
					complete:function(data)
					{
						
					},
					success:function(data)
					{
						if(data.ret==true)
						{
							reply.remove();
						}
					}
					
					});
			}
		}
		
</script>
<script>
function modReply(num,i)
{
	var check = confirm("댓글을 수정하시겠습니까?");
	if(check == true)
	{
	
	var inputContent = document.getElementById("modcontent"+i).value;
	var cp = document.getElementById("contentP"+i);
	
	
		$.ajax({
			type:"post",
			async:false,
			url:"repMod.user",
			dataType:"json",
			data:"num="+num+"&inputContent="+inputContent,
			complete:function(data)
			{
				
			},
			success:function(data)
			{
				if(data.ret==true)
				{
					cp.innerHTML = "<font>"+inputContent+"</font>";
					hideMod(i);
					
					
				}
			}
			
			});
	}
}
</script>
</head>

<%
	String userid = (String)session.getAttribute("USERID");
	BoardDTOOut2 dto2 = (BoardDTOOut2) request.getAttribute("BOARDDTOOUT2");
	int num = dto2.getNum(); //글번호 
	String type = dto2.getType(); //콘텐츠 종류 
	String mainphoto = dto2.getMainphoto(); //사진 경로
	
	//페이지 정보를 request 객체에서 가져옴
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		String viewStart = request.getParameter("viewStart");
		String viewEnd = request.getParameter("viewEnd");
		String word = request.getParameter("search");
		
%>
<%
	String level = request.getParameter("level");
	//System.out.println(level);
%>
<%
	ArrayList<ReplyDTOOut> dto = (ArrayList<ReplyDTOOut>)request.getAttribute("REPLYDTOOUT");
	

%>

	
<body id="top1">
	
	
		<header class="header">
			<a href="#" class="btn_gnb" id="menu-toggle"><i class="fa fa-navicon headericon1"></i></a>
			<h1 class="logo">여행지</h1>
			<a href="#" class="btn_search"><i class="fa fa-map-marker headericon2"></i></a>
			
			

		</header>
	<%@ include file="../sidebar-nav.jsp" %>
	
		<section class="view2">

			<ul class="view2UL">
			<%
	
			ArrayList<BoardAlbumDTOOut> ALlist = (ArrayList<BoardAlbumDTOOut>)request.getAttribute("BOARDALBUMDTOOUT");
			
			BoardAlbumDTOOut album = null; 
			String subphoto = null;
			for(int i=0; i<ALlist.size(); i++)
			{
				
				album = ALlist.get(i);
				subphoto = album.getPicPath();
				
			%>
				<li>
				<%if(subphoto.equals("") || subphoto==null){ %>	
						<img src="/portfolio/imgs/default.jpg" alt="사진없음" class="headerimg">	
				<%}else {%>		
						<img src="/portfolio/upload/<%=subphoto %>" alt="앨범" class="imgw100">					
				<%} %>
				</li>
			<%	
			}
			
			
			%>

			</ul>
			<h3 class="trip-viewh3">제주도 <%=type %>(리뷰)</h3>
			
			<ul class="view2RP">
			<%for(int i=0; i<dto.size();i++)
			{ 
				int repNum = dto.get(i).getNum();
				String id = dto.get(i).getId();
				String content = dto.get(i).getContent();
				String reg_date = dto.get(i).getReg_date();
				
			%>
				<li id="reply<%=i%>">
					
					<img src="/portfolio/imgs/sssub1.jpg" alt="고래" class="imgw50" >
					<div style="margin-left:25%;width:75%; height:20px;">
					<h4 class="trip-viewhh3" style="display:inline-block;line-height:20px; font-size:11px;"><%=id %></h4>
					<p style="display:inline-block;line-height:20px; font-size:11px;float:right;padding-right:10px;"><%=reg_date %></p>
					</div>
					<div id="replyList<%=i%>" >	
						<div style="margin-left:25%;width:70%;overflow:hidden;margin-top:8px;">
							<p id="contentP<%=i%>"style="display:inline;line-height:20px;padding-right:7px;font-size:11px;"><%=content %></p>					
						</div>
						<div style="width:100%; clear:both;">
							<%if(userid != null && userid.equals(id)==true){ %>
								<div>
									<input type="button" onclick="delReply(<%=repNum %>,<%=i %>)" value="삭제" style="cursor:pointer;display:inline-block;font-size:11px;float:right;padding-right:30px;margin-top:7px;margin-bottom:3px;">
									<input type="button" onclick="showMod(<%=i %>)" value="수정" style="cursor:pointer;display:inline-block;font-size:11px;float:right;padding-right:5px;margin-top:7px; margin-bottom:3px;">									
								</div>						
							<%}else {}%>					
						</div>				
					</div>				
					<div id="mod<%=i%>" style="display:none;width:70%; margin-left:25%;">
						    <textarea id="modcontent<%=i %>" maxlength="200" style="width:100%;overflow:hidden;height:50px;margin-top:10px;font-size:11px;"></textarea>
							<input type="button" onclick="hideMod(<%=i %>)" value="취소" style="cursor:pointer;display:inline-block;font-size:11px;float:right;padding-right:5px; margin-top:7px;margin-bottom:3px;">
							<input type="button" onclick="modReply(<%=repNum %>,<%=i %>)" value="수정" style="cursor:pointer;display:inline-block;font-size:11px;float:right;padding-right:5px;margin-top:7px;margin-bottom:3px;">
					</div>
					
				</li>
				
			<%} %>
					
					<form method="post" action="/portfolio/writeRep.user" id="writeRep">    
						    
	                 	 <textarea form="writeRep" name="content" maxlength="200"style="width:83%; height:50px;padding:8px; margin:3px 0; font-size:11px; margin-left:2%;"></textarea>
	                	 <input type="submit" value="댓글" style="width :15%; height:50px; float:right;margin:3px 0;background-color:#eee;">
	                	 <input type="hidden" name="link" value="<%=dto2.getNum()%>">	                
	                	 <input type="hidden" name="type" value="<%=dto2.getType() %>">
	                	 <input type="hidden" name="pageNo" value="<%=pageNo%>">  
			             <input type="hidden" name="pageSize" value="<%=pageSize%>">
			             <input type="hidden" name="type" value="<%=type%>">
			             <input type="hidden" name="viewStart" value="<%=viewStart%>">
			             <input type="hidden" name="viewEnd" value="<%=viewEnd%>">
			             <input type="hidden" name="search" value="<%=word %>">
	                	 
             		 </form>
				</li>
				
			</ul>
			<div class="paging">
			
				<strong>1</strong>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
				<a href="#">5</a>
				<a href="#"><i class="fa fa-angle-double-right"></i>
				</a>
			</div>
			<div class="tirp_view_list">
					<a href="#"><p class="trip_view_p"><i class="fa  fa-map-o"></i></p></a>
				<% if(type.equals("healing")==true){%>									
					<a href="listTrip.board?&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type%>"><p class="trip_view_l">List</p></a>
				<%}else if(type.equals("nature")==true){ %>
					<a href="listTrip2.board?&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type%>"><p class="trip_view_l">List</p></a>
				<%}else if(type.equals("winter")==true){ %>
					<a href="listTrip3.board?&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type%>"><p class="trip_view_l">List</p></a>
				<%} %>	
					
				<% if(type.equals("healing")==true){%>									
					<a href="read.board?num=<%=num%>&value=1&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type%>"><p class="trip_view_r"><i class="fa  fa-angle-double-left"></i></p></a>
				<%}else if(type.equals("nature")==true){ %>
					<a href="read2.board?num=<%=num%>&value=1&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type%>"><p class="trip_view_r"><i class="fa  fa-angle-double-left"></i></p></a>
				<%}else if(type.equals("winter")==true){ %>
					<a href="read3.board?num=<%=num%>&value=1&pageNo=<%=pageNo%>&pageSize=<%=pageSize%>&search=<%=word%>&viewStart=<%=viewStart%>&viewEnd=<%=viewEnd%>&level=<%=level%>&type=<%=type%>"><p class="trip_view_r"><i class="fa  fa-angle-double-left"></i></p></a>
				<%} %>
			</div>
			
		</section>
	
		
		
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