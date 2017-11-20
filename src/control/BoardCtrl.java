package control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import dao.BoardDAO;
import dao.ReplyDAO;
import dto.BoardAlbumDTOIn;
import dto.BoardAlbumDTOOut;
import dto.BoardAlbumModDTOIn;
import dto.BoardDTOIn;
import dto.BoardDTOOut;
import dto.BoardDTOOut2;
import dto.BoardModDTOIn;
import dto.FavDTOIn1;
import dto.ListTripDTOOut;
import dto.MemDTOIn;
import dto.PageDTOIn;
import dto.PageDTOOut;
import dto.ReplyDTOOut;
import dto.FavDTOOut;


@WebServlet("*.board")
public class BoardCtrl extends HttpServlet {
	
	BoardDAO dao = new BoardDAO();
	ReplyDAO daoRep = new ReplyDAO();
    
    public BoardCtrl() {

    }
    void sendReDirect(HttpServletResponse response, String view) throws IOException //페이지 이동시키는 메소드 //REdirect로 이동함 : request 객체가 새로 만들어짐 그러므로 리스폰만 있으면 됌
	{
		response.sendRedirect(view);
	}

	//forward로 이동 함 : 기존의 request 객체를 전달함 
	void forward(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException // 기존의 리퀘스트를 이용하기 때문에 재사용, 이전에 저장했던 정보가 따라감 
	{
		RequestDispatcher RD = request.getRequestDispatcher(view);
		RD.forward(request, response);
	}
    String parseCommand(HttpServletRequest request)
	{
		//request 객체에서 uri 경로만을 가져옴.
		String uri = request.getRequestURI();
		//String path = request.getContextPath();
		int idx    = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		
		
		return cmd;
	}
	
    void write(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException
    {
    	String path=request.getSession().getServletContext().getRealPath("/")+"upload";
    	int size = 1024*1024*100;
    	String encType = "utf-8";
    	MultipartRequest mr = new MultipartRequest(request,path,size,encType,new DefaultFileRenamePolicy());
    											//리퀘스트, 경로, 크기, 문자, 이름중복방지
    	
    	//기타 입력 정보
    	String type = mr.getParameter("type"); //셀렉트 박스 
    	String title = mr.getParameter("title"); //제목
    	String content = mr.getParameter("content"); //글내용
    	String mainphoto = mr.getFilesystemName("main-pic"); //업로드 파일 
    	String level = mr.getParameter("level");
    	 
    	
    	
    	
    	BoardDTOIn dto;
    	//DTO 객체를 생성함
    	if(mainphoto == null)
    	{
    		dto = new BoardDTOIn(type, title, content,"",level);
    	}else
    	{
    		dto = new BoardDTOIn(type, title, content,mainphoto,level );
    	}
    	//DTO를 DAO 전달해줌
    if(type.equals("healing")==true)
    {
    	if(dao.write(dto)==true)
    	{
    			String picpath = mr.getFilesystemName("sub-pic1");	
    			String picpath2 = mr.getFilesystemName("sub-pic2"); 
    			String picpath3 = mr.getFilesystemName("sub-pic3"); 	
    			String picpath4 = mr.getFilesystemName("sub-pic4"); 	
    			
    			int link=dao.getnum();
    			
    			if(picpath != null){
		     		
				    BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,picpath,type);
		        	dao.album(ALdto);
    				}else{
    					  BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,"",type);
    			        	dao.album(ALdto);
    				}
		        if(picpath2 != null){		
		        	BoardAlbumDTOIn ALdto2 = new BoardAlbumDTOIn(link,picpath2,type);
		        	dao.album(ALdto2);
		        	}else{
  					  BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,"",type);
			        	dao.album(ALdto);
				}
		        if(picpath3 != null){			
		        	BoardAlbumDTOIn ALdto3 = new BoardAlbumDTOIn(link,picpath3,type);
		        	dao.album(ALdto3);
		        	}else{
  					  BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,"",type);
			        	dao.album(ALdto);
				}
		        if(picpath4 != null){		
		        	BoardAlbumDTOIn ALdto4 = new BoardAlbumDTOIn(link,picpath4,type);
		        	dao.album(ALdto4);
		        	}else{
  					  BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,"",type);
			        	dao.album(ALdto);
				}
	    	
	        	
	        	//BoardAlbumDTOIn dto = dto.getPicpath();
    		
        	
		        
		        forward(request, response, "listTrip.board?pageNo=0&pageSize=9&viewStart=0&viewEnd=5");
			    
		 
    	}else
    	{
    		System.out.println("힐링 테마 글쓰기 실패");
    	}
    }
    if(type.equals("nature")==true)
    {
      	if(dao.write2(dto)==true)
    	{
    			String picpath = mr.getFilesystemName("sub-pic1");	
    			String picpath2 = mr.getFilesystemName("sub-pic2"); 
    			String picpath3 = mr.getFilesystemName("sub-pic3"); 	
    			String picpath4 = mr.getFilesystemName("sub-pic4"); 	
    			
    			int link=dao.getnum2();
    			
    			if(picpath != null){
		     		
				    BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,picpath,type);
		        	dao.album2(ALdto);
    				}else{
    					  BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,"",type);
    			        	dao.album2(ALdto);
    				}
		        if(picpath2 != null){		
		        	BoardAlbumDTOIn ALdto2 = new BoardAlbumDTOIn(link,picpath2,type);
		        	dao.album2(ALdto2);
		        	}else{
  					  BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,"",type);
			        	dao.album2(ALdto);
				}
		        if(picpath3 != null){			
		        	BoardAlbumDTOIn ALdto3 = new BoardAlbumDTOIn(link,picpath3,type);
		        	dao.album2(ALdto3);
		        	}else{
  					  BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,"",type);
			        	dao.album2(ALdto);
				}
		        if(picpath4 != null){		
		        	BoardAlbumDTOIn ALdto4 = new BoardAlbumDTOIn(link,picpath4,type);
		        	dao.album2(ALdto4);
		        	}else{
  					  BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,"",type);
			        	dao.album2(ALdto);
				}
	    	
	        	
	        	//BoardAlbumDTOIn dto = dto.getPicpath();
    		
        	
		       forward(request, response,"listTrip2.board?pageNo=0&pageSize=9&viewStart=0&viewEnd=5&level="+level);
			  
		  
			  
		  
    	}else
    	{
    		System.out.println("자연 테마 글쓰기 실패");
    	}
    }
    if(type.equals("winter")==true)
    {
      	if(dao.write3(dto)==true)
    	{
    			String picpath = mr.getFilesystemName("sub-pic1");	
    			String picpath2 = mr.getFilesystemName("sub-pic2"); 
    			String picpath3 = mr.getFilesystemName("sub-pic3"); 	
    			String picpath4 = mr.getFilesystemName("sub-pic4"); 	
    			
    			int link=dao.getnum3();
    			
    			if(picpath != null){
		     		
				    BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,picpath,type);
		        	dao.album3(ALdto);
    				}else{
    					  BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,"",type);
    			        	dao.album3(ALdto);
    				}
		        if(picpath2 != null){		
		        	BoardAlbumDTOIn ALdto2 = new BoardAlbumDTOIn(link,picpath2,type);
		        	dao.album3(ALdto2);
		        	}else{
  					  BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,"",type);
			        	dao.album3(ALdto);
				}
		        if(picpath3 != null){			
		        	BoardAlbumDTOIn ALdto3 = new BoardAlbumDTOIn(link,picpath3,type);
		        	dao.album3(ALdto3);
		        	}else{
  					  BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,"",type);
			        	dao.album3(ALdto);
				}
		        if(picpath4 != null){		
		        	BoardAlbumDTOIn ALdto4 = new BoardAlbumDTOIn(link,picpath4,type);
		        	dao.album3(ALdto4);
		        	}else{
  					  BoardAlbumDTOIn ALdto = new BoardAlbumDTOIn(link,"",type);
			        	dao.album3(ALdto);
				}
	    	
		       forward(request, response, "listTrip3.board?pageNo=0&pageSize=9&viewStart=0&viewEnd=5&level="+level);
			 
		 
    	}else
    	{
    		System.out.println("겨울 테마 글쓰기 실패");
    	}
    }
    	
    }
    void makeCookie(String key, String value, HttpServletResponse response)
	{
		Cookie c = new Cookie(key, value);
		
		c.setMaxAge(60*60*24*365); 
		response.addCookie(c);

	}
	boolean checkCookie(String key, String value, HttpServletRequest request)
	{
		Cookie[] cookies = request.getCookies();
		
		for(int i=0; i<cookies.length;i++)
		{
			String cKey = cookies[i].getName();
			String cValue = cookies[i].getValue();
				if(cKey.equals(key)==true && cValue.equals(value)==true)
				{
					return true; //일치하는 쿠키가 있음
				}
		}
		return false; //일치하는 쿠키가 없음없음
	}
    void read(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
    	int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int viewStart =  Integer.parseInt(request.getParameter("viewStart"));
        int viewEnd =  Integer.parseInt(request.getParameter("viewEnd"));
        String word = request.getParameter("search");
    	int num = Integer.parseInt(request.getParameter("num")); //Triplist에서 글번호를 받아옴, 매개변수로 받아온 num을 int로 형변환해줌.
    	String type = request.getParameter("type");
    	String level = request.getParameter("level");
    	//여행지 다음페이지 넘어가기 
    	String value = null;
    	
    	
    	try {
    		value = request.getParameter("value"); //value 값을 가져옴('2')
    		
    		
    	} catch(Exception e) {
    		
    		e.printStackTrace();
    		value = "1"; //오류가 생길시 value에 '1'을 저장
    	}
    	
    
    	if(value.equals("2")) //가져온 value가 '2'와 같으면 밑을 실행하시오 //즉, trip-view에서 trip-view2로 갈때만 value='2'가 되기 때문에 다른 곳에서는 실행되지 않음.
    	{//value2에는 num, type, mainphoto만 필요하기 때문에 read2(dao)를 따로 만들어둠
    		BoardDTOOut2 dto2=dao.readHL2(num); //dao read2에 num을 넣고 num에 해당하는 글을 읽어온 값을 변수 dto2에 저장
    		request.setAttribute("BOARDDTOOUT2", dto2);  //저장된 변수 dto2를 BOARDDTOOUT2에 보냄  
    		ArrayList<BoardAlbumDTOOut> ALlist = dao.albumRead(num,type); //dao albumRead에 num을 넣고 배열 ALlist에 저장 // 오직 서브사진을 출력하기 위해서 필요함. 
    		request.setAttribute("BOARDALBUMDTOOUT",ALlist); // 저장된 배열변수 ALlist를 BOARDALBUMDTOOUT에 저장
    		ArrayList<ReplyDTOOut> RepList = daoRep.readRep(num,type);
    		request.setAttribute("REPLYDTOOUT", RepList);
    	
    		forward(request, response, "/admin-trip-view2.jsp?level="+level+"num="+num+"&pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"&search="+word+"&level="+level+"&type"+type);
 		
    	}else if(value.equals("fav"))
    	{	
    		
    		//System.out.println("num: "+num);    		   		
    		BoardDTOOut dto=dao.readHL(num); //dao read에 num을 넣고 그에 해당하는 글을 읽어온 값을 변수 dto에 저장 	 		
        	request.setAttribute("BOARDDTOOUT", dto); //dto롤 BOARDDTOOUT에 보냄   
        	ArrayList<BoardAlbumDTOOut> ALlist = dao.albumRead(num,type); //else에서는 출력에 필요없는 객체 //view2사진을 수정하기 위해 수정버튼이 있는 view로 정보를 가져와야하므로 필요한 객체
    		request.setAttribute("BOARDALBUMDTOOUT",ALlist); // 저장된 배열변수 ALlist를 BOARDALBUMDTOOUT에 저장
        	ArrayList<ReplyDTOOut> RepList = daoRep.readRep(num,type);
    		request.setAttribute("REPLYDTOOUT", RepList);
    		
    		forward(request, response,"/admin-trip-view.jsp?level="+level+"num="+num+"&pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"&search="+word+"&level="+level+"&type"+type);
        	
    	}else {//Triplist에서 글을 선택했을때 read(dao)를 사용.   
    		
    		//(1)쿠키 키를 생성함
    		String cmd="read";
    		String table="tripHealingboard";
    		String id=(String)request.getSession().getAttribute("USERID");
    		//ip 구하기  String ip = request.getRemoteAddr();
    		String key = cmd + "|"+table+"|"+num+"|"+id;
    		if(checkCookie(key,"read",request)!=true)
    		{
    			dao.click(num,type);
    			makeCookie(key, "read", response);
    		}
    		
        	BoardDTOOut dto=dao.readHL(num); //dao read에 num을 넣고 그에 해당하는 글을 읽어온 값을 변수 dto에 저장 	
        	request.setAttribute("BOARDDTOOUT", dto); //dto롤 BOARDDTOOUT에 보냄   
        	
        	
        	ArrayList<BoardAlbumDTOOut> ALlist = dao.albumRead(num,type); //else에서는 출력에 필요없는 객체 //view2사진을 수정하기 위해 수정버튼이 있는 view로 정보를 가져와야하므로 필요한 객체
    		request.setAttribute("BOARDALBUMDTOOUT",ALlist); // 저장된 배열변수 ALlist를 BOARDALBUMDTOOUT에 저장
		
    		ArrayList<ReplyDTOOut> RepList = daoRep.readRep(num,type);
    		request.setAttribute("REPLYDTOOUT", RepList);
    		
    		forward(request, response,"/admin-trip-view.jsp?level="+level+"num="+num+"&pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"&search="+word+"&level="+level+"&type"+type);
    		
        	
    	}
    	
    }
    void read2(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
    	int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int viewStart =  Integer.parseInt(request.getParameter("viewStart"));
        int viewEnd =  Integer.parseInt(request.getParameter("viewEnd"));
        String word = request.getParameter("search");
    	int num = Integer.parseInt(request.getParameter("num")); //Triplist에서 글번호를 받아옴, 매개변수로 받아온 num을 int로 형변환해줌.
    	String type = request.getParameter("type");
    	String level = request.getParameter("level");
    	//여행지 다음페이지 넘어가기 
    	String value = null;
    	
    	try {
    		value = request.getParameter("value"); //value 값을 가져옴('2')
    		
    		
    	} catch(Exception e) {
    		
    		e.printStackTrace();
    		value = "1"; //오류가 생길시 value에 '1'을 저장
    	}
    	
    
    	if(value.equals("2")) //가져온 value가 '2'와 같으면 밑을 실행하시오 //즉, trip-view에서 trip-view2로 갈때만 value='2'가 되기 때문에 다른 곳에서는 실행되지 않음.
    	{//value2에는 num, type, mainphoto만 필요하기 때문에 read2(dao)를 따로 만들어둠
    		BoardDTOOut2 dto2=dao.readNT2(num); //dao read2에 num을 넣고 num에 해당하는 글을 읽어온 값을 변수 dto2에 저장
    		request.setAttribute("BOARDDTOOUT2", dto2);  //저장된 변수 dto2를 BOARDDTOOUT2에 보냄  
    		ArrayList<BoardAlbumDTOOut> ALlist = dao.albumRead2(num,type); //dao albumRead에 num을 넣고 배열 ALlist에 저장 // 오직 서브사진을 출력하기 위해서 필요함. 
    		request.setAttribute("BOARDALBUMDTOOUT",ALlist); // 저장된 배열변수 ALlist를 BOARDALBUMDTOOUT에 저장
  		
    		ArrayList<ReplyDTOOut> RepList = daoRep.readRep(num,type);
    		request.setAttribute("REPLYDTOOUT", RepList);
    		
    		forward(request, response,"/admin-trip-view2.jsp?level="+level+"num="+num+"&pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"&search="+word+"&level="+level+"&type"+type);
    		
 		
    	}else if(value.equals("fav"))
    	{	//System.out.println("num: "+num);    		   		
    		BoardDTOOut dto=dao.readNT(num); //dao read에 num을 넣고 그에 해당하는 글을 읽어온 값을 변수 dto에 저장 	
    		
        	request.setAttribute("BOARDDTOOUT", dto); //dto롤 BOARDDTOOUT에 보냄   
        	ArrayList<BoardAlbumDTOOut> ALlist = dao.albumRead2(num,type); //else에서는 출력에 필요없는 객체 //view2사진을 수정하기 위해 수정버튼이 있는 view로 정보를 가져와야하므로 필요한 객체
    		request.setAttribute("BOARDALBUMDTOOUT",ALlist); // 저장된 배열변수 ALlist를 BOARDALBUMDTOOUT에 저장   	
    		forward(request, response,"/admin-trip-view.jsp?level="+level+"num="+num+"&pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"&search="+word+"&level="+level+"&type"+type);
    	
        	
    	}else {//Triplist에서 글을 선택했을때 read(dao)를 사용.   
    		//(1)쿠키 키를 생성함
    		String cmd="read";
    		String table="tripNatureboard";
    		String id=(String)request.getSession().getAttribute("USERID");
    		//ip 구하기  String ip = request.getRemoteAddr();
    		String key = cmd + "|"+table+"|"+num+"|"+id;
    		if(checkCookie(key,"read",request)!=true)
    		{
    			dao.click(num,type);
    			makeCookie(key, "read", response);
    		}
        	BoardDTOOut dto=dao.readNT(num); //dao read에 num을 넣고 그에 해당하는 글을 읽어온 값을 변수 dto에 저장 	
        	request.setAttribute("BOARDDTOOUT", dto); //dto롤 BOARDDTOOUT에 보냄   
        	ArrayList<BoardAlbumDTOOut> ALlist = dao.albumRead2(num,type); //else에서는 출력에 필요없는 객체 //view2사진을 수정하기 위해 수정버튼이 있는 view로 정보를 가져와야하므로 필요한 객체
    		request.setAttribute("BOARDALBUMDTOOUT",ALlist); // 저장된 배열변수 ALlist를 BOARDALBUMDTOOUT에 저장
		
    		forward(request, response,"/admin-trip-view.jsp?level="+level+"num="+num+"&pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"&search="+word+"&level="+level+"&type"+type);
    	
        	
    	}
    	
    }
    void read3(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
    	int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int viewStart =  Integer.parseInt(request.getParameter("viewStart"));
        int viewEnd =  Integer.parseInt(request.getParameter("viewEnd"));
        String word = request.getParameter("search");
    	int num = Integer.parseInt(request.getParameter("num")); //Triplist에서 글번호를 받아옴, 매개변수로 받아온 num을 int로 형변환해줌.
    	String type = request.getParameter("type");
    	String level = request.getParameter("level");
    	//여행지 다음페이지 넘어가기 
    	String value = null;
    	
    	try {
    		value = request.getParameter("value"); //value 값을 가져옴('2')
    		
    		
    	} catch(Exception e) {
    		
    		e.printStackTrace();
    		value = "1"; //오류가 생길시 value에 '1'을 저장
    	}
    	
    
    	if(value.equals("2")) //가져온 value가 '2'와 같으면 밑을 실행하시오 //즉, trip-view에서 trip-view2로 갈때만 value='2'가 되기 때문에 다른 곳에서는 실행되지 않음.
    	{//value2에는 num, type, mainphoto만 필요하기 때문에 read2(dao)를 따로 만들어둠
    		BoardDTOOut2 dto2=dao.readWT2(num); //dao read2에 num을 넣고 num에 해당하는 글을 읽어온 값을 변수 dto2에 저장
    		request.setAttribute("BOARDDTOOUT2", dto2);  //저장된 변수 dto2를 BOARDDTOOUT2에 보냄  
    		ArrayList<BoardAlbumDTOOut> ALlist = dao.albumRead3(num,type); //dao albumRead에 num을 넣고 배열 ALlist에 저장 // 오직 서브사진을 출력하기 위해서 필요함. 
    		request.setAttribute("BOARDALBUMDTOOUT",ALlist); // 저장된 배열변수 ALlist를 BOARDALBUMDTOOUT에 저장
  		
    		ArrayList<ReplyDTOOut> RepList = daoRep.readRep(num,type);
    		request.setAttribute("REPLYDTOOUT", RepList);
    
    		forward(request, response, "/admin-trip-view2.jsp?level="+level+"num="+num+"&pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"&search="+word+"&level="+level+"&type"+type);
    	}else if(value.equals("fav"))
    	{	//System.out.println("num: "+num);    		   		
    		BoardDTOOut dto=dao.readWT(num); //dao read에 num을 넣고 그에 해당하는 글을 읽어온 값을 변수 dto에 저장 	
    		
        	request.setAttribute("BOARDDTOOUT", dto); //dto롤 BOARDDTOOUT에 보냄   
        	ArrayList<BoardAlbumDTOOut> ALlist = dao.albumRead3(num,type); //else에서는 출력에 필요없는 객체 //view2사진을 수정하기 위해 수정버튼이 있는 view로 정보를 가져와야하므로 필요한 객체
    		request.setAttribute("BOARDALBUMDTOOUT",ALlist); // 저장된 배열변수 ALlist를 BOARDALBUMDTOOUT에 저장   		
    		
        	forward(request, response,  "/admin-trip-view.jsp?level="+level+"num="+num+"&pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"&search="+word+"&level="+level+"&type"+type);
    	}else {//Triplist에서 글을 선택했을때 read(dao)를 사용.  
    		//(1)쿠키 키를 생성함
    		String cmd="read";
    		String table="tripWinterboard";
    		String id=(String)request.getSession().getAttribute("USERID");
    		//ip 구하기  String ip = request.getRemoteAddr();
    		String key = cmd + "|"+table+"|"+num+"|"+id;
    		
    		if(checkCookie(key,"read",request)!=true)
    		{
    			dao.click(num,type);
    			makeCookie(key, "read", response);
    		}
        	BoardDTOOut dto=dao.readWT(num); //dao read에 num을 넣고 그에 해당하는 글을 읽어온 값을 변수 dto에 저장 	
        	request.setAttribute("BOARDDTOOUT", dto); //dto롤 BOARDDTOOUT에 보냄   
        	ArrayList<BoardAlbumDTOOut> ALlist = dao.albumRead3(num,type); //else에서는 출력에 필요없는 객체 //view2사진을 수정하기 위해 수정버튼이 있는 view로 정보를 가져와야하므로 필요한 객체
    		request.setAttribute("BOARDALBUMDTOOUT",ALlist); // 저장된 배열변수 ALlist를 BOARDALBUMDTOOUT에 저장
		
    		this.forward(request, response, "/admin-trip-view.jsp?level="+level+"num="+num+"&pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"&search="+word+"&level="+level+"&type"+type);
    		
        	
    	}
    	
    }
    void del(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
    	int num = Integer.parseInt(request.getParameter("num"));
    	String mainphoto = request.getParameter("mainphoto");
    	String savePath = request.getSession().getServletContext().getRealPath("/")+"upload";
    	String filePath = savePath+"/"+mainphoto;
    	String level = request.getParameter("level");
    	String type = request.getParameter("type");
    	
    	//System.out.println("파일경로"+filePath);
    	File file = new File(filePath); //파일을 다루는 객체 
    	if(file.exists() == true) //파일이 존재하면 삭제  exists = 존재하다
    	{
    		file.delete(); //파일 지우기 
    	}
    	if(type.equals("healing")==true)
    	{

	    	if(dao.del(num)==true)
	    	{
	    		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
	    		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	    		int viewStart = Integer.parseInt(request.getParameter("viewStart"));
	    		int viewEnd = Integer.parseInt(request.getParameter("viewEnd"));
	    		String search = request.getParameter("search");
	    		forward(request, response,"listTrip.board?pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+""+"&level="+level);
	    		
	    	}
    	}else if(type.equals("nature")==true)
    	{
    		if(dao.del2(num)==true)
    		{
    			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
	    		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	    		int viewStart = Integer.parseInt(request.getParameter("viewStart"));
	    		int viewEnd = Integer.parseInt(request.getParameter("viewEnd"));
	    		String search = request.getParameter("search");
	    		
	    		forward(request, response,"listTrip2.board?pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+""+"&level="+level);
	    			
    		}	
    	}else if(type.equals("winter")==true)
    	{
    		if(dao.del3(num)==true)
    		{
	    		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
	    		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	    		int viewStart = Integer.parseInt(request.getParameter("viewStart"));
	    		int viewEnd = Integer.parseInt(request.getParameter("viewEnd"));
	    		String search = request.getParameter("search");
	    		this.forward(request, response, "listTrip3.board?pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+""+"&level="+level);
	    		
    		}
    	}else
    	{
    		System.out.println("글 삭제에 실패하였습니다.");
    	}
    }
    
    void delPhoto(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	
    	int num = Integer.parseInt(request.getParameter("num"));
    	
    	
    	PrintWriter out = response.getWriter();
    	
    	out.print("{\"ret\":true}"); //{\"ret\"}객체를 표현함 - ret은 변수 이름 :true ret 변수값
    }
    void mod(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
    	
    	String path=request.getSession().getServletContext().getRealPath("/")+"upload";
    	int size = 1024*1024*100;
    	String encType = "utf-8";
    	MultipartRequest mr = new MultipartRequest(request,path,size,encType,new DefaultFileRenamePolicy());
    	
    	int num = Integer.parseInt(mr.getParameter("num"));
    	String title = mr.getParameter("title");
    	String content= mr.getParameter("content");
    	String mainphoto = null;
    	String type = mr.getParameter("type");
    	String level = mr.getParameter("level");
    	String[] albumNum = mr.getParameterValues("alNum");
    	
    	
    	int[] alNum = new int[albumNum.length];
    	
    	for(int i = 0 ; i<albumNum.length; i++ )
    	{
    		alNum[i] = Integer.parseInt(albumNum[i]);
    		
    	   	//albumNum[i] = Integer.parseInt(mr.getParameter("alNum"+i));
    		
    	}

    	
    	ArrayList<String> subphoto = new ArrayList<String>();
    	
    	
    	Enumeration files = mr.getFileNames();
    	
    	for(int i=0; files.hasMoreElements(); i++)
    	{
    		String name = (String) files.nextElement();
    		if(name.equals("main-pic")==true)
    		{
    			mainphoto = mr.getFilesystemName(name);
    			if(mainphoto==null){
    				String him = "";
    				mainphoto = him;
    		}	
    		}else
    		{
    			String sub1 = mr.getFilesystemName(name);
    			if(sub1!=null)
    			{
    				subphoto.add(sub1);
    					
    			}else
    			{
    				subphoto.add("");
    			}
    			
    		}
    		
    	}
   
    	String[] subphoto1 = new String[subphoto.size()]; //arraylist를 스트링으로 형변환
    	
    	for(int i=0 ; i<subphoto.size() ; i++){
    		subphoto1[i] = subphoto.get(subphoto.size()-i-1);
    		
    	}

    	BoardModDTOIn mainDto = new BoardModDTOIn(title,content,mainphoto);
    	BoardAlbumModDTOIn subDto = new BoardAlbumModDTOIn(alNum,subphoto1,type,level);
    	
    	int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int viewStart = Integer.parseInt(request.getParameter("viewStart"));
		int viewEnd = Integer.parseInt(request.getParameter("viewEnd"));	
		
		//System.out.println("모드보드 : "+type);
		if(type.equals("healing")==true)
		{
			dao.mod(num, mainDto);
			dao.subphotomod(num, subDto);
			forward(request, response, "listTrip.board?pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"");
		}else if(type.equals("nature")==true)
		{
			dao.mod2(num, mainDto);
			dao.subphotomod2(num, subDto);
			forward(request, response, "listTrip2.board?pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"");
		}else if(type.equals("winter")==true)
		{
			dao.mod3(num, mainDto);
			dao.subphotomod3(num, subDto);
			forward(request, response, "listTrip3.board?pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"");
		}
		
		
		
    }
  
    void favIn(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
    	HttpSession session = request.getSession();
    	
    	int num = Integer.parseInt(request.getParameter("num")); 
    	String type = request.getParameter("type");
    	String userId = (String) session.getAttribute("USERID");
    	String level = request.getParameter("level");
    	
    	if(type.equals("healing")==true)
    	{
    		dao.favIn(num,type,userId);
    	}else if(type.equals("nature")==true)
    	{
    		dao.favIn2(num,type,userId);
    	}else if(type.equals("winter")==true)
    	{
    		dao.favIn3(num,type,userId);
    	}
    	forward(request, response, "favOut.board?level="+level+"&type="+type);
    	
    	
    }
   
    void favOut(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    { 	
    	HttpSession session = request.getSession();
    	String userId = (String)session.getAttribute("USERID");
    	ArrayList<FavDTOIn1> favdto = dao.favOut(userId);
    	String type = request.getParameter("type");
    	String level = request.getParameter("level");
    	if(type.equals("healing")==true)
    	{
    		ArrayList<FavDTOOut> dto = dao.fav(favdto, "healing");
    		request.setAttribute("FAVTRIP",dto);
    		request.setAttribute("DATE", dto);
    		
    	}else if(type.equals("nature")==true)
    	{
    		ArrayList<FavDTOOut> dto2 = dao.fav(favdto, "nature");
    		request.setAttribute("FAVTRIP2", dto2);
    		request.setAttribute("DATE2", dto2);
    	}else if(type.equals("winter")==true)
    	{
    		ArrayList<FavDTOOut> dto3 = dao.fav(favdto, "winter");
    		request.setAttribute("FAVTRIP3", dto3);
    		request.setAttribute("DATE3", dto3);
    	}
	    	

		String favorit = "fav";
		
		request.setAttribute("FAVORIT", favorit);
		
		forward(request, response, "/admin-info.jsp?level="+level);
		
				
    }
    void favList(HttpServletRequest request, HttpServletResponse response)
    {
    	int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int viewStart = Integer.parseInt(request.getParameter("viewStart"));
		int viewEnd = Integer.parseInt(request.getParameter("viewEnd"));
		int mod;
		String word = request.getParameter("search");
    }
   
    void listTrip(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
    	int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int viewStart = Integer.parseInt(request.getParameter("viewStart"));
		int viewEnd = Integer.parseInt(request.getParameter("viewEnd"));
		int mode;		
		String word = request.getParameter("search");
		String type = request.getParameter("type");
		String level = request.getParameter("level");
		
		
		//System.out.println("검색어 : "+word);
		if(word==null || word.equals("") == true || word.equals("null")==true)
		{
		    mode = -1; //검색어를 사용하지마시오
		}else{
			mode = 0; //사용가능한 검색어가 전달되었으므로.. 검색어를 사용하시오
		}
		
		PageDTOIn dto = new PageDTOIn(pageNo, pageSize, mode, word,"");
		
		
		//System.out.println(dto.toString());
		
		
    	ArrayList<ListTripDTOOut> list = dao.listTrip(dto);
    	//list를 jsp 페이지에 전달하기 위해서.. request객체에 저장
    	
    	
    	
    	
    	request.setAttribute("LISTTRIP", list);
    	
    	int total	= dao.countAll(dto);  
    	
    	int pageNum = total/pageSize;
    	if(total % pageSize != 0) pageNum++; //페이지 갯수
    	
    	int prevPage = pageNo-1; //이전 페이지
    							 //prevPage가 -1이면 이전페이지는 기능 없음  	
    	int nextPage = pageNo+1; //다음 페이지
    	if(nextPage >= pageNum) nextPage=-1; //nextPage가 -1이면 다음페이지 기능 없음
    	
    	//보여지는 페이지 번호 범위 조절
    	if(pageNo > viewEnd-1)
    	{
    		viewStart++;
    		viewEnd++;
    	}
    	if(pageNo < viewStart)
    	{
    		viewStart--;
    		viewEnd--;
    	}
    	if(viewStart < 0 ) viewStart = 0;
    	if(viewEnd > pageNum) viewEnd = pageNum;
    	
    	PageDTOOut pageOut = new PageDTOOut(	pageNo,		//현재 페이지 번호
								    			pageSize, 	//페이지의 글의 개수
								    			total, 		//전체 글의 개수
								    			pageNum,	//페이지 개수
								    			prevPage, 	//이전 페이지 번호
								    			nextPage,	//다음 페이지 번호
								    			word,		//검색어
								    			viewStart,	//보여지는 글의 시작번호
								    			viewEnd);	//보여지는 글의 끝번호
    	request.setAttribute("PAGEOUT", pageOut);
    	
    	
   	//리스트는 장기적으로 유지할 필요가 없음으로 포워드 이용
    	
    	
    	forward(request, response, "/Triplist.jsp?level="+level+"&type="+type);
    	
    	
    }
    void listTrip2(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
    	int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int viewStart = Integer.parseInt(request.getParameter("viewStart"));
		int viewEnd = Integer.parseInt(request.getParameter("viewEnd"));
		int mode;		
		String word = request.getParameter("search");
		String level = request.getParameter("level");
		//System.out.println("검색어 : "+word);
		if(word==null || word.equals("") == true || word.equals("null")==true)
		{
		    mode = -1; //검색어를 사용하지마시오
		}else{
			mode = 0; //사용가능한 검색어가 전달되었으므로.. 검색어를 사용하시오
		}
		
		PageDTOIn dto = new PageDTOIn(pageNo, pageSize, mode, word,"");
		
		
		//System.out.println(dto.toString());
		
		
    	ArrayList<ListTripDTOOut> list = dao.listTrip2(dto);
    	//list를 jsp 페이지에 전달하기 위해서.. request객체에 저장
    	
    	
    	
    	
    	request.setAttribute("LISTTRIP2", list);
    	
    	int total	= dao.countAll2(dto);  
    	
    	int pageNum = total/pageSize;
    	if(total % pageSize != 0) pageNum++; //페이지 갯수
    	
    	int prevPage = pageNo-1; //이전 페이지
    							 //prevPage가 -1이면 이전페이지는 기능 없음  	
    	int nextPage = pageNo+1; //다음 페이지
    	if(nextPage >= pageNum) nextPage=-1; //nextPage가 -1이면 다음페이지 기능 없음
    	
    	//보여지는 페이지 번호 범위 조절
    	if(pageNo > viewEnd-1)
    	{
    		viewStart++;
    		viewEnd++;
    	}
    	if(pageNo < viewStart)
    	{
    		viewStart--;
    		viewEnd--;
    	}
    	if(viewStart < 0 ) viewStart = 0;
    	if(viewEnd > pageNum) viewEnd = pageNum;
    	
    	PageDTOOut pageOut = new PageDTOOut(	pageNo,		//현재 페이지 번호
								    			pageSize, 	//페이지의 글의 개수
								    			total, 		//전체 글의 개수
								    			pageNum,	//페이지 개수
								    			prevPage, 	//이전 페이지 번호
								    			nextPage,	//다음 페이지 번호
								    			word,		//검색어
								    			viewStart,	//보여지는 글의 시작번호
								    			viewEnd);	//보여지는 글의 끝번호
    	request.setAttribute("PAGEOUT", pageOut);
    	
    	
   	//리스트는 장기적으로 유지할 필요가 없음으로 포워드 이용
    	
    	
    	forward(request, response, "/Triplist2.jsp?level="+level);
    	
    	
    }
    void listTrip3(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
    	int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int viewStart = Integer.parseInt(request.getParameter("viewStart"));
		int viewEnd = Integer.parseInt(request.getParameter("viewEnd"));
		int mode;		
		String word = request.getParameter("search");
		String level = request.getParameter("level");
		//System.out.println("검색어 : "+word);
		if(word==null || word.equals("") == true || word.equals("null")==true)
		{
		    mode = -1; //검색어를 사용하지마시오
		}else{
			mode = 0; //사용가능한 검색어가 전달되었으므로.. 검색어를 사용하시오
		}
		
		PageDTOIn dto = new PageDTOIn(pageNo, pageSize, mode, word,"");
		
		
		//System.out.println(dto.toString());
		
		
    	ArrayList<ListTripDTOOut> list = dao.listTrip3(dto);
    	//list를 jsp 페이지에 전달하기 위해서.. request객체에 저장
    	
    	
    	
    	
    	request.setAttribute("LISTTRIP3", list);
    	
    	int total	= dao.countAll3(dto);  
    	
    	int pageNum = total/pageSize;
    	if(total % pageSize != 0) pageNum++; //페이지 갯수
    	
    	int prevPage = pageNo-1; //이전 페이지
    							 //prevPage가 -1이면 이전페이지는 기능 없음  	
    	int nextPage = pageNo+1; //다음 페이지
    	if(nextPage >= pageNum) nextPage=-1; //nextPage가 -1이면 다음페이지 기능 없음
    	
    	//보여지는 페이지 번호 범위 조절
    	if(pageNo > viewEnd-1)
    	{
    		viewStart++;
    		viewEnd++;
    	}
    	if(pageNo < viewStart)
    	{
    		viewStart--;
    		viewEnd--;
    	}
    	if(viewStart < 0 ) viewStart = 0;
    	if(viewEnd > pageNum) viewEnd = pageNum;
    	
    	PageDTOOut pageOut = new PageDTOOut(	pageNo,		//현재 페이지 번호
								    			pageSize, 	//페이지의 글의 개수
								    			total, 		//전체 글의 개수
								    			pageNum,	//페이지 개수
								    			prevPage, 	//이전 페이지 번호
								    			nextPage,	//다음 페이지 번호
								    			word,		//검색어
								    			viewStart,	//보여지는 글의 시작번호
								    			viewEnd);	//보여지는 글의 끝번호
    	request.setAttribute("PAGEOUT", pageOut);
    	
    	
   	//리스트는 장기적으로 유지할 필요가 없음으로 포워드 이용
    	
    		
    	forward(request, response,"/Triplist3.jsp?level="+level);	
    
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//System.out.println("게시판 서블릿");
		
		String cmd = parseCommand(request);
		try {
		if(cmd.equals("write.board")==true)
		{	
			
			write(request,response);	
		}
		else if(cmd.equals("read.board")==true)
		{
			read(request,response);
		}else if(cmd.equals("read2.board")==true)
		{
			read2(request,response);
		}else if(cmd.equals("read3.board")==true)
		{
			read3(request,response);
		}
		else if(cmd.equals("listTrip.board")==true)//전체 글 목록을 가져옴 
		{		
			listTrip(request,response);
		}else if(cmd.equals("listTrip2.board")==true)
		{
			listTrip2(request,response);
		}else if(cmd.equals("listTrip3.board")==true)
		{
			listTrip3(request,response);
		}else if(cmd.equals("del.board")==true)
		{
			del(request,response);
		}else if(cmd.equals("mod.board")==true) 
		{
			mod(request,response);
		}else if(cmd.equals("favIn.board")==true)
		{
			favIn(request,response);
		}else if(cmd.equals("favOut.board")==true)
		{
			favOut(request,response);
		}else if(cmd.equals("favList.board")==true)
		{
			favList(request,response);
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("문제가 생겼습니다. dao 확인해보세요.");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
