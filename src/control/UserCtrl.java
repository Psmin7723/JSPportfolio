package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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

import dao.ReplyDAO;
import dao.UserDAO;
import dto.BoardAlbumDTOIn;
import dto.BoardAlbumDTOOut;
import dto.BoardDTOIn;
import dto.BoardDTOOut;
import dto.ListContentDTOOut;
import dto.ListMainDTOOut;
import dto.PageDTOIn;
import dto.ReplyDTOIn;
import dto.ReplyDTOOut;


@WebServlet("*.user")
public class UserCtrl extends HttpServlet {

       
    UserDAO dao = new UserDAO();
    ReplyDAO daoRep = new ReplyDAO();
    public UserCtrl() {
       
       
    }
    
    String parseCommand(HttpServletRequest request)
	{
		//request 객체에서 uri 경로만을 가져옴.
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cmd = uri.substring(path.length()+1);
		//System.out.println("uri: " + uri);
		//System.out.println("path: " + path);
		
		return cmd;
	}
	
	//페이지 이동방법은 2가지  //로그인은 세션을 사용하기때문에 어떤 방법을 사용하던지 상관x 다만 정보를 계속 가져가야하는 게시판은 forward 방법이 좋음 
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
	void delReply(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
	{
		PrintWriter out = response.getWriter();
		
		int repNum = Integer.parseInt(request.getParameter("num"));
		
		if(daoRep.delReply(repNum)==true)
		{
			out.println("{\"ret\":true}");
		}else
		{
			out.println("{\"ret\":false}");
		}
	}
	void modReply(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
	{
		PrintWriter out = response.getWriter();
		
		int repNum = Integer.parseInt(request.getParameter("num"));
		String content = request.getParameter("inputContent");
		
		
		if(daoRep.modReply(repNum,content)==true)
		{
			out.println("{\"ret\":true}");
		}else
		{
			out.println("{\"ret\":false}");
		}
	}
	void nice(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
	{
		
		PrintWriter out = response.getWriter();
		int num = Integer.parseInt(request.getParameter("num"));
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		String id = (String)session.getAttribute("USERID");
		
		
		
		int count = dao.niceCheck(num, type, id);
		if(count == 0)
		{
			if(dao.niceIn(num,type,id)==true)
			{
				if(type.equals("healing")==true)
				{
					int ret = dao.nice(num);
					out.println("{\"result\":true, \"nice\":"+ret+"}"); //결과값은 true false로 증가값은 ret으로 
				}else if(type.equals("nature")==true)
				{
					int ret = dao.nice2(num);
					out.println("{\"result\":true, \"nice\":"+ret+"}"); //결과값은 true false로 증가값은 ret으로 
				}else if(type.equals("winter")==true)
				{
					int ret = dao.nice3(num);
					out.println("{\"result\":true, \"nice\":"+ret+"}"); //결과값은 true false로 증가값은 ret으로 
				}
				
			}else
			{
				System.out.println("nice 오류");
			}
			
			
		}else
		{
			out.println("{\"result\":false}");
		}
		
		
	   
		
	}
	void writeRep(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		
		
		
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	    int viewStart =  Integer.parseInt(request.getParameter("viewStart"));
	    int viewEnd =  Integer.parseInt(request.getParameter("viewEnd"));
	    String word = request.getParameter("search");
		
	    int link = Integer.parseInt(request.getParameter("link"));
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USERID");
		
		
		ReplyDTOIn dto = new ReplyDTOIn(link, content, type,id );
		daoRep.writeRep(dto);
		
		if(type.equals("healing")==true)
		{
			forward(request, response,"read.board?value=2&num="+link+"&pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"&search="+word+"&type="+type);
			
		}else if(type.equals("nature")==true)
		{
			forward(request, response, "read2.board?value=2&num="+link+"&pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"&search="+word+"&type="+type);
			
		}else if(type.equals("winter")==true)
		{
			forward(request, response, "read3.board?value=2&num="+link+"&pageNo="+pageNo+"&pageSize="+pageSize+"&viewStart="+viewStart+"&viewEnd="+viewEnd+"&search="+word+"&type="+type);
			
		}
		
		
	}
	
	void listContent(HttpServletRequest request, HttpServletResponse response, String type) throws SQLException, ServletException, IOException
	{
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int viewStart = Integer.parseInt(request.getParameter("viewStart"));
		int viewEnd = Integer.parseInt(request.getParameter("viewEnd"));
		String word = request.getParameter("search");
		int mode;
		
		if(word == null || word.equals("")== true)
		{
			mode = -1; //검색기능 사용 x 
		}else
		{
			mode = 0; //검색어 있음
		}
		
		PageDTOIn dto = new PageDTOIn(pageNo,pageSize,mode,word,type);
		
		ArrayList<ListContentDTOOut> list = dao.listContent(dto);
		
		request.setAttribute("LISTCONTENTDTOOUT", list);
		
		forward(request, response,"trip.jsp");
		
	}
	
	void main(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
    {
		String level= request.getParameter("level");	
	
		ArrayList<ListMainDTOOut> listTour=dao.listmain("Healing", 4);

    			request.setAttribute("LISTTOUR", listTour);   		    	

    	ArrayList<ListMainDTOOut> listTour2=dao.listmain2("Nature", 2);
    	
    			request.setAttribute("LISTTOUR2", listTour2);   		    	

    	ArrayList<ListMainDTOOut> listTour3=dao.listmain3("Winter", 2);

    			request.setAttribute("LISTTOUR3", listTour3);   		    	
    			
    			
    	forward(request, response,"main.jsp?level="+level);
    	
    	
    }

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = parseCommand(request);
		
		try {
				if(cmd.equals("main.user")==true)
				{
						main(request,response);
				}else if(cmd.equals("listContent.user")==true)
				{
						listContent(request,response, "관광지");
				}else if(cmd.equals("writeRep.user")==true)
				{
						writeRep(request,response);
				}else if(cmd.equals("delReply.user")==true)
				{
						delReply(request,response);
				}else if(cmd.equals("repMod.user")==true)
				{
						modReply(request,response);
				}else if(cmd.equals("nice.user")==true)
				{
						nice(request,response);
				}
						
						
				
				}
		catch (SQLException e) {
			e.printStackTrace();
			} 
		
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
