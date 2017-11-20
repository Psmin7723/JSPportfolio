package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;


@WebServlet("*.admin")
public class AdminCtrl extends HttpServlet {
	
	AdminDAO dao = new AdminDAO(); //컨트롤러에서 필요한 dao 객체를 생성
       
   
    public AdminCtrl() 
    {
       super();
    }

    String parseCommand(HttpServletRequest request)
	{
		//request 객체에서 uri 경로만을 가져옴.
		String uri = request.getRequestURI();
		//String path = request.getContextPath();
		int idx    = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		System.out.println("uri: " + uri);
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
    void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
    	//System.out.println("관리자 로그인 하기");
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	//System.out.println(id);
    	//System.out.println(pw);
    	dao.login(id, pw); 
    	if(dao.login(id, pw)==true)
		{
			HttpSession session = request.getSession();
			
			session.setAttribute("USERID",id);
			session.setAttribute("ADMIN","관리자");
			
			forward(request, response, "/portfolio/main.user?level=admin");
			
		}
		else
		{
			forward(request, response, "loginFail.jsp");
			
		}
    }
    void logout(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	HttpSession session = request.getSession();
		
		//session.removeAttribute("USERID");
		//session.removeAttribute("USERPW");
		session.invalidate(); //한가지 씩이 아닌 한꺼번에 다 지우는 메소드
		
		sendReDirect(response, "/portfolio/admin/adminLogin.jsp");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		
		//System.out.println("admin 서블릿");
		//(1) 명령어 추출
		String cmd = parseCommand(request);
		//System.out.println("명렁어: "+cmd);
		try
		{
			if(cmd.equals("login.admin")==true)
			{				
				login(request,response);
			}else if(cmd.equals("logout.admin")==true)
			{
				logout(request,response);
			}
			
			
		} 
		catch (SQLException e) 
		{
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
