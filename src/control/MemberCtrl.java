package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemDAO;
import dto.InfoDTOOut;
import dto.MemDTOIn;
import dto.ModDTOIn;


@WebServlet("*.mem")
public class MemberCtrl extends HttpServlet {
	
       //DAO 객체 만들기
	MemDAO dao = new MemDAO();
 
    public MemberCtrl() 
    {
       
        
    }


	String parseCommand(HttpServletRequest request)
	{
		//request 객체에서 uri 경로만을 가져옴.
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cmd = uri.substring(path.length()+1);
//		System.out.println("uri: " + uri);
//		System.out.println("path: " + path);
		
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
	void logout(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession();
		
		//session.removeAttribute("USERID");
		//session.removeAttribute("USERPW");
		session.invalidate(); //한가지 씩이 아닌 한꺼번에 다 지우는 메소드
		
		sendReDirect(response, "main.user");
	}
	void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(dao.login(id, pw)==true)
		{
			HttpSession session = request.getSession();
			
			session.setAttribute("USERID",id);
			session.setAttribute("USERPW",pw);
			forward(request, response, "main.user?level=user" );
		
		}
		else
		{
			forward(request, response, "loginFail.jsp");
			
		}
	}
	 void idCheck(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	   {
		   PrintWriter out = response.getWriter();
		   
		   String id = request.getParameter("id");
		   //System.out.println("id : " + id);
		   if(dao.idCheck(id)==true) //사용가능한 아이디
		   {
			   //System.out.println("id true");
			   out.println("{\"ret\":true}"); //JSON 형식 데이터 
			   
		   }else //사용 불가능한 아이디
		   {
			   //System.out.println("id flase");
			   out.println("{\"ret\":false}"); //JSON 형식 데이터
		   }
	   }
	 void del(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	 {
		 HttpSession session = request.getSession();
		 String Userid =  (String)session.getAttribute("USERID");
		 String Userpw = (String)session.getAttribute("USERPW");
		 System.out.println(Userid);
		 if(dao.del(Userid)==true)
		 {
			// System.out.println("dao 통과 회원탈퇴 성공 ");
			 session.invalidate();
			 sendReDirect(response, "main.user");
			 
		 }else
		 {
			 System.out.println("dao 통과못함 회원탈퇴 실패 ");
		 }
		 
	 }
	 void checkpw(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException
	 {
		 PrintWriter out = response.getWriter();
		 String pw = request.getParameter("pw");
		 if(dao.pwCheck(pw)==true)
		 {
			 //System.out.println("pw true");
			 out.println("{\"ret\":true}");
			 
		 }else
		 {
			 out.println("{\"ret\":false}");
		 } 
	 }
	 void info(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	 {
		 HttpSession session = request.getSession();
		 String Userid = (String)session.getAttribute("USERID");
		
		 
		 InfoDTOOut dto = dao.info(Userid); //회원정보를 가지고있는 DTO를 반환받음
		 
		 //회원정보 DTO를 memberInfo.jsp로 전달
		 request.setAttribute("InfoDTOOut", dto);
		 forward(request, response, "memberInfo.jsp");
	 
	 }
	 void mod(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	 {
		 PrintWriter out = response.getWriter();
		 HttpSession session = request.getSession();
		 String Userid = (String)session.getAttribute("USERID");
 
		 String cellphone = request.getParameter("mobile");
	     String cellphone1 = request.getParameter("mobile1");
	     String cellphone2 = request.getParameter("mobile2");   
	     String email1 = request.getParameter("email");
	     String email2 = request.getParameter("email2");
	     String pwchg = request.getParameter("pw");
	     
	     String pw = pwchg;
	     String phone = cellphone+"-"+cellphone1+"-"+cellphone2;
	     String email = email1+"@"+email2;
	     System.out.println(pw);
	     
	     ModDTOIn dto = new ModDTOIn(Userid, phone, email, pw);
	     dao.mod(dto);
	     
	     if(dao.mod(dto)==true)
	     {
	    	 System.out.println("회원정보 수정 성공");
	    	 out.println("{\"ret\":true}"); //회원정보수정 완료 alert를 띄우기 위해
	    	 //sendReDirect(response,"main.jsp");
	     }else
	     {
	    	 System.out.println("회원정보 수정 실패");
	    	 out.println("{\"ret\":false}");//회원정보수정 완료 alert를 띄우기 위해
	     }
	 }
    void reg(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException//회원가입 명령어 처리 메소드

    {
    	String agree	= request.getParameter("agree01");
    	String agree2 = request.getParameter("agree02");
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	String name = request.getParameter("name");
    	String gender = request.getParameter("sex");
    	String cellphone = request.getParameter("mobile");
    	String cellphone1 = request.getParameter("mobile1");
    	String cellphone2 = request.getParameter("mobile2");
    	String phone = request.getParameter("phone");
    	String phone1 = request.getParameter("phone1");
    	String phone2 = request.getParameter("phone2");
    	String email = request.getParameter("email");
    	String email2 = request.getParameter("email2");
    	String zipcode  = request.getParameter("zipcode");
    	String zipcode2  = request.getParameter("zipcode2");
    	String address  = request.getParameter("address");
    	String addressSub  = request.getParameter("address-sub");
    	String birthY = request.getParameter("birth-year");
    	String birthM = request.getParameter("birth-month");
    	String birthD = request.getParameter("birth-day");
    	String tall = request.getParameter("height");
    	String weight = request.getParameter("weight");
    	String arm = request.getParameter("arm");
    	String leg = request.getParameter("leg");
    	String waist = request.getParameter("waist");
//    	Double tall = Double.parseDouble(request.getParameter("height"));
//    	Double weight = Double.parseDouble(request.getParameter("weight"));
//    	Double arm = Double.parseDouble(request.getParameter("arm"));
//    	Double leg = Double.parseDouble(request.getParameter("leg"));
//    	Double waist = Double.parseDouble(request.getParameter("waist"));
    	
//    	System.out.println("aree: " +aree);
//    	System.out.println("aree1: " +aree1);
//    	System.out.println("id: " +id);
//    	System.out.println("pw: " +pw);
//    	System.out.println("name: " +name);
//    	System.out.println("gender: " +gender);
//    	System.out.println("cellphone: " +cellphone+"-"+cellphone1+"-"+cellphone2);
//    	System.out.println("phone: " +phone +"-"+phone1+"-"+phone2);
//    	System.out.println("email: " +email+"@"+autoemail);
//    	System.out.println("address: " +address);
//    	System.out.println("birth: "+birthy+"년"+birthm+"월"+birthd+"일");
//    	System.out.println("physical: " +height);
//    	System.out.println("physical2: " +weight);
//    	System.out.println("physical3: " +arm);
//    	System.out.println("physical4: " +leg);
//    	System.out.println("physical5: " +waist);
    	
    	MemDTOIn dto = new MemDTOIn(agree,agree2,id,pw,name,gender,cellphone+"-"+cellphone1+"-"+cellphone2,
    								phone+"-"+phone1+"-"+phone2,email+"@"+email2,
    								"우편번호"+zipcode+"-"+zipcode2+" "+address+" 상세주소:"+addressSub,
    								birthY+"년 "+birthM+"월 "+birthD+"일 ",tall,weight,arm,leg,waist);
    	
    	//dto를 dao에 전달해서 데이터베이스에 정보를 저장함
    	if(dao.reg(dto) == true) //회원가입 성공
    	{
    		System.out.println("로그인에 성공하였습니다.");
    		//첫번째 경우 로그인 페이지로 이동 - 사용자가 직접 로그인 해야함//
    		sendReDirect(response, "login2.jsp"); 
    		
    		//두번째 경우 회원가입후 로그인 상태로 메인으로 감// 
    		//(1)리퀘스트에서 세션 객체를 가져옴
    		//HttpSession session = request.getSession();
    		//(1-1)세션에 로그인 정보를 추가함
    		//session.setAttribute("USERID", id);
    		//session.setAttribute("USERID", id);
    		
    		//(2) 페이지 이동
    		//sendReDirect(response, "login.jsp");
    		
    	}else
    	{
    		System.out.println("회원가입 실패");
    	}
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("회원 관리 서블릿");
		//(1) 명령어 추출
		String cmd = parseCommand(request);
		System.out.println("명렁어: "+cmd);
		try {
			if(cmd.equals("reg.mem")==true)	//회원가입 명령어
			{		
				reg(request, response);				
			}else if(cmd.equals("login.mem")==true){
				login(request,response);
			}else if(cmd.equals("logout.mem")==true){
				logout(request,response);
			}else if(cmd.equals("idCheck.mem")==true) {
				idCheck(request,response);
			}else if(cmd.equals("del.mem")==true){
				del(request,response);
			}else if(cmd.equals("checkpw.mem")==true){
				checkpw(request,response);
			}else if(cmd.equals("info.mem")==true){
				info(request,response);
			}else if(cmd.equals("mod.mem")==true){
				mod(request,response);
			}
			
			}
		catch (SQLException e) 
		{
				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
