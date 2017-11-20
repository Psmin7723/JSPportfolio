package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import dto.BoardAlbumDTOIn;
import dto.BoardAlbumDTOOut;
import dto.BoardAlbumModDTOIn;
import dto.BoardDTOIn;
import dto.BoardDTOOut;
import dto.BoardDTOOut2;
import dto.BoardModDTOIn;
import dto.FavDTOIn1;
import dto.FavDTOOut;
import dto.ListTripDTOOut;
import dto.PageDTOIn;

public class BoardDAO 
{
	PreparedStatement pstm;
	ResultSet rs;
	
	
	//글을 저장하는 메소드 
	public boolean write(BoardDTOIn dto) throws SQLException
	{
		
		Connection con = DBCP.getConnection();
		String sql = "insert into tripHealingboard set type=?, title=?, content=?, mainphoto=?, map=?,level=?";
		String map="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d51009.071032223575!2d128.2999384089632!3d36.96045809232604!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3563f4913b29f6d7%3A0x20aafaf95cba675b!2z64-E64u07IK867SJ!5e0!3m2!1sko!2skr!4v1496277584007";
		String type = dto.getType();
		String title = dto.getTitle();
		String content = dto.getContent();
		String mainphoto = dto.getMainphoto();
		String level = dto.getLevel();
		 
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, type);
		pstm.setString(2, title);
		pstm.setString(3, content);
		pstm.setString(4, mainphoto);
		pstm.setString(5, map);
		pstm.setString(6, level);
		
		int ret=pstm.executeUpdate();	//ret == 1 성공 , ret != 1 실패

		
		if(ret ==1)
		{
			pstm.close();
			con.close();
			return true;
		}else{
			pstm.close();
			con.close();
			return false;
		}
	}
	public boolean write2(BoardDTOIn dto) throws SQLException
	{
		
		Connection con = DBCP.getConnection();
		String sql = "insert into tripnatureboard set type=?, title=?, content=?, mainphoto=?, map=?,level=?";
		String map="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d51009.071032223575!2d128.2999384089632!3d36.96045809232604!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3563f4913b29f6d7%3A0x20aafaf95cba675b!2z64-E64u07IK867SJ!5e0!3m2!1sko!2skr!4v1496277584007";
		String type = dto.getType();
		String title = dto.getTitle();
		String content = dto.getContent();
		String mainphoto = dto.getMainphoto();
		String level = dto.getLevel();
		 
		
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, type);
		pstm.setString(2, title);
		pstm.setString(3, content);
		pstm.setString(4, mainphoto);
		pstm.setString(5, map);
		pstm.setString(6, level);
		
		int ret=pstm.executeUpdate();	//ret == 1 성공 , ret != 1 실패

		
		if(ret ==1)
		{
			pstm.close();
			con.close();
			return true;
		}else{
			pstm.close();
			con.close();
			return false;
		}
	}
	public boolean write3(BoardDTOIn dto) throws SQLException
	{
		
		Connection con = DBCP.getConnection();
		String sql = "insert into tripwinterboard set type=?, title=?, content=?, mainphoto=?, map=?,level=?";
		String map="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d51009.071032223575!2d128.2999384089632!3d36.96045809232604!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3563f4913b29f6d7%3A0x20aafaf95cba675b!2z64-E64u07IK867SJ!5e0!3m2!1sko!2skr!4v1496277584007";
		String type = dto.getType();
		String title = dto.getTitle();
		String content = dto.getContent();
		String mainphoto = dto.getMainphoto();
		String level = dto.getLevel();
		 
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, type);
		pstm.setString(2, title);
		pstm.setString(3, content);
		pstm.setString(4, mainphoto);
		pstm.setString(5, map);
		pstm.setString(6, level);
		
		int ret=pstm.executeUpdate();	//ret == 1 성공 , ret != 1 실패

		
		if(ret ==1)
		{
			pstm.close();
			con.close();
			return true;
		}else{
			pstm.close();
			con.close();
			return false;
		}
	}
	public int getnum() throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "select num from tripHealingboard order by reg_date DESC limit 1"; //관리자 게시판 최신게시물 순서로. 유저게시판은 유저 아이디 + 시간으로 묶어보기.
		PreparedStatement pstm = con.prepareStatement(sql);
		rs = pstm.executeQuery();
		if(rs.next()==true)
		{
			int num = rs.getInt("num");
			con.close();
			pstm.close();
			rs.close();
			return num;
		}else 
		{
			System.out.println("최신글번호를 dao에서 execute하지 못함");
			rs.close();
			pstm.close();
			con.close();
			
			
			return 0;		
		}
		
	}
	public int getnum2() throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "select num from tripnatureboard order by reg_date DESC limit 1"; //관리자 게시판 최신게시물 순서로. 유저게시판은 유저 아이디 + 시간으로 묶어보기.
		PreparedStatement pstm = con.prepareStatement(sql);
		rs = pstm.executeQuery();
		if(rs.next()==true)
		{
			int num = rs.getInt("num");
			con.close();
			pstm.close();
			rs.close();
			return num;
		}else 
		{
			System.out.println("최신글번호를 dao에서 execute하지 못함");
			rs.close();
			pstm.close();
			con.close();
			
			
			return 0;		
		}
		
	}
	public int getnum3() throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "select num from tripwinterboard order by reg_date DESC limit 1"; //관리자 게시판 최신게시물 순서로. 유저게시판은 유저 아이디 + 시간으로 묶어보기.
		PreparedStatement pstm = con.prepareStatement(sql);
		rs = pstm.executeQuery();
		if(rs.next()==true)
		{
			int num = rs.getInt("num");
			con.close();
			pstm.close();
			rs.close();
			return num;
		}else 
		{
			System.out.println("최신글번호를 dao에서 execute하지 못함");
			rs.close();
			pstm.close();
			con.close();
			
			
			return 0;		
		}
		
	}
	
	public ArrayList<ListTripDTOOut> listTrip3(PageDTOIn pagedto) throws SQLException  //전체 글목록가져오기 
	{
		int pageNo = pagedto.getPageNo();
		int pageSize = pagedto.getPageSize();
		
		int start = pageNo * pageSize;//시작 글의 위치
		int mode = pagedto.getMode();//-1이면 검색어를 사용하지 않음, 0 검색어사용해서.. 리스트 만듬
		
		ArrayList<ListTripDTOOut> list = new ArrayList<ListTripDTOOut>(); //<>안에 저장하려는 클래스 이름 넣기 
		//DBCP에서 Connection 객체를 가져옴
		Connection con = DBCP.getConnection();
		
		if(mode == -1)
		{
			String sql = "select num, title, reg_date, count,type,level from tripwinterboard order by num desc limit ?,?"; //limit 가져올 글 개수를 정해줌 ?시작(start) , ?개수(pageSize)
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, start); //글을 가져올 위치 
			pstm.setInt(2, pageSize);
			
		}else if(mode == 0)
		{
			String sql = "select num, title, reg_date, count,type,level from tripwinterboard where num > 0 and title like ? order by num desc limit ?,?"; //limit 가져올 글 개수를 정해줌 ?시작(start) , ?개수(pageSize)
			String search = "%"+pagedto.getWord()+"%";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1,search);
			pstm.setInt(2, start); //글을 가져올 위치 
			pstm.setInt(3, pageSize);
			
		}
			rs = pstm.executeQuery();
		while(rs.next() == true)
		{
			int num = rs.getInt("num");
			String title = rs.getString("title");
			int count = rs.getInt("count");
			String reg_date = rs.getString("reg_date");
			String type = rs.getString("type");
			String level = rs.getString("level");
			ListTripDTOOut dto = new ListTripDTOOut(num, title, count, reg_date,type,level);
			//각 글목록을 객체에 저장함

			list.add(dto);	
			//num title count reg_date를 dto로 한번에 묶고 객체를 저장하고 arraylist를 사용해서 보냄	
			//arraylist는 맨위로 올려줌 list변수를 써줘야(list.add(dto) 함으로..
			//void를 ArrayList<ListTripDTOOut>로 바꿔주고 list를 리턴
		}
		rs.close();
		pstm.close();
		con.close();

		return list; 
		
	}
	public ArrayList<ListTripDTOOut> listTrip2(PageDTOIn pagedto) throws SQLException  //전체 글목록가져오기 
	{
		int pageNo = pagedto.getPageNo();
		int pageSize = pagedto.getPageSize();
		
		int start = pageNo * pageSize;//시작 글의 위치
		int mode = pagedto.getMode();//-1이면 검색어를 사용하지 않음, 0 검색어사용해서.. 리스트 만듬
		
		ArrayList<ListTripDTOOut> list = new ArrayList<ListTripDTOOut>(); //<>안에 저장하려는 클래스 이름 넣기 
		//DBCP에서 Connection 객체를 가져옴
		Connection con = DBCP.getConnection();
		
		if(mode == -1)
		{
			String sql = "select num, title, reg_date, count,type,level from tripnatureboard order by num desc limit ?,?"; //limit 가져올 글 개수를 정해줌 ?시작(start) , ?개수(pageSize)
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, start); //글을 가져올 위치 
			pstm.setInt(2, pageSize);
			
		}else if(mode == 0)
		{
			String sql = "select num, title, reg_date, count,type,level from tripnatureboard where num > 0 and title like ? order by num desc limit ?,?"; //limit 가져올 글 개수를 정해줌 ?시작(start) , ?개수(pageSize)
			String search = "%"+pagedto.getWord()+"%";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1,search);
			pstm.setInt(2, start); //글을 가져올 위치 
			pstm.setInt(3, pageSize);
			
		}
			rs = pstm.executeQuery();
		while(rs.next() == true)
		{
			int num = rs.getInt("num");
			String title = rs.getString("title");
			int count = rs.getInt("count");
			String reg_date = rs.getString("reg_date");
			String type = rs.getString("type");
			String level = rs.getString("level");
			ListTripDTOOut dto = new ListTripDTOOut(num, title, count, reg_date, type,level);
			//각 글목록을 객체에 저장함

			list.add(dto);	
			//num title count reg_date를 dto로 한번에 묶고 객체를 저장하고 arraylist를 사용해서 보냄	
			//arraylist는 맨위로 올려줌 list변수를 써줘야(list.add(dto) 함으로..
			//void를 ArrayList<ListTripDTOOut>로 바꿔주고 list를 리턴
		}
		rs.close();
		pstm.close();
		con.close();

		return list; 
		
	}
	
	public ArrayList<ListTripDTOOut> listTrip(PageDTOIn pagedto) throws SQLException  //전체 글목록가져오기 
	{
		int pageNo = pagedto.getPageNo();
		int pageSize = pagedto.getPageSize();
		
		int start = pageNo * pageSize;//시작 글의 위치
		int mode = pagedto.getMode();//-1이면 검색어를 사용하지 않음, 0 검색어사용해서.. 리스트 만듬
		
		ArrayList<ListTripDTOOut> list = new ArrayList<ListTripDTOOut>(); //<>안에 저장하려는 클래스 이름 넣기 
		//DBCP에서 Connection 객체를 가져옴
		Connection con = DBCP.getConnection();
		
		if(mode == -1)
		{
			String sql = "select num, title, reg_date, count, type,level from tripHealingboard order by num desc limit ?,?"; //limit 가져올 글 개수를 정해줌 ?시작(start) , ?개수(pageSize)
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, start); //글을 가져올 위치 
			pstm.setInt(2, pageSize);
			
		}else if(mode == 0)
		{
			String sql = "select num, title, reg_date, count, type,level from tripHealingboard where num > 0 and title like ? order by num desc limit ?,?"; //limit 가져올 글 개수를 정해줌 ?시작(start) , ?개수(pageSize)
			String search = "%"+pagedto.getWord()+"%";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1,search);
			pstm.setInt(2, start); //글을 가져올 위치 
			pstm.setInt(3, pageSize);
			
		}
			rs = pstm.executeQuery();
		while(rs.next() == true)
		{
			int num = rs.getInt("num");
			String title = rs.getString("title");
			int count = rs.getInt("count");
			String reg_date = rs.getString("reg_date");
			String type = rs.getString("type");
			String level = rs.getString("level");
			ListTripDTOOut dto = new ListTripDTOOut(num, title, count, reg_date,type,level);
			//각 글목록을 객체에 저장함

			list.add(dto);	
			//num title count reg_date를 dto로 한번에 묶고 객체를 저장하고 arraylist를 사용해서 보냄	
			//arraylist는 맨위로 올려줌 list변수를 써줘야(list.add(dto) 함으로..
			//void를 ArrayList<ListTripDTOOut>로 바꿔주고 list를 리턴
		}
		rs.close();
		pstm.close();
		con.close();

		return list; 
		
	}
	public void click(int num, String type) throws SQLException
	{
		
		Connection con = DBCP.getConnection();
		if(type.equals("healing")==true)
		{
			String sql = "update tripHealingboard set count=count+1 where num=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, num);
			pstm.executeUpdate();
			pstm.close();
			con.close();
		}else if(type.equals("nature")==true)
		{
			String sql = "update tripNatureboard set count=count+1 where num=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, num);
			pstm.executeUpdate();
			pstm.close();
			con.close();
		}else if(type.equals("winter")==true)
		{
			
			String sql = "update tripwinterboard set count=count+1 where num=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, num);
			pstm.executeUpdate();
			pstm.close();
			con.close();
		}
	}
	public BoardDTOOut readHL(int num) throws SQLException //힐링테마 게시판읽기 
	{
		Connection con = DBCP.getConnection();
		String sql = "select * from tripHealingboard where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		
		ResultSet rs = pstm.executeQuery();
		BoardDTOOut dto=null;
		if(rs.next()==true)
		{
			String type = rs.getString("type");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String mainphoto = rs.getString("mainphoto");
			String map = rs.getString("map");
			int nice = rs.getInt("nice");
			int count = rs.getInt("count");
			String reg_date = rs.getString("reg_date");
			String level = rs.getString("level");
			
			dto = new BoardDTOOut(num, type, title, content, mainphoto, map, nice, count, reg_date, level);
	
		}
			rs.close();
			pstm.close();
			con.close();
			
			return dto;
		
	}
	public BoardDTOOut2 readHL2(int num) throws SQLException //힐링테마게시판읽기 2
	{
		Connection con = DBCP.getConnection();
		String sql = "select * from tripHealingboard where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		
		ResultSet rs = pstm.executeQuery();
		BoardDTOOut2 dto=null;
		if(rs.next()==true)
		{
			String type = rs.getString("type"); //type 뽑아 저장
			String mainphoto = rs.getString("mainphoto"); // mainphoto 뽑아 저장
			
			
			dto = new BoardDTOOut2(num,type,mainphoto); // 게시글번호, 타입, 메인포토 저장후 변수에 저장 후 리턴
		
			
		}
			rs.close();
			pstm.close();
			con.close();
			return dto;
		
	}
	public BoardDTOOut readNT(int num) throws SQLException //자연테마 게시판 읽기 
	{
		Connection con = DBCP.getConnection();
		String sql = "select * from tripnatureboard where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		
		ResultSet rs = pstm.executeQuery();
		BoardDTOOut dto=null;
		if(rs.next()==true)
		{
			String type = rs.getString("type");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String mainphoto = rs.getString("mainphoto");
			String map = rs.getString("map");
			int nice = rs.getInt("nice");
			int count = rs.getInt("count");
			String reg_date = rs.getString("reg_date");			
			String level = rs.getString("level");
			
			dto = new BoardDTOOut(num, type, title, content, mainphoto, map, nice, count, reg_date, level);
	
		}
			rs.close();
			pstm.close();
			con.close();
			return dto;
		
	}
	
	public BoardDTOOut2 readNT2(int num) throws SQLException //자연테마 게시판읽기2 
	{
		Connection con = DBCP.getConnection();
		String sql = "select * from tripnatureboard where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		
		ResultSet rs = pstm.executeQuery();
		BoardDTOOut2 dto=null;
		if(rs.next()==true)
		{
			String type = rs.getString("type"); //type 뽑아 저장
			String mainphoto = rs.getString("mainphoto"); // mainphoto 뽑아 저장
			
			
			dto = new BoardDTOOut2(num,type,mainphoto); // 게시글번호, 타입, 메인포토 저장후 변수에 저장 후 리턴
		
			
		}
			rs.close();
			pstm.close();
			con.close();
			return dto;
		
	}
	public BoardDTOOut readWT(int num) throws SQLException //힐링테마 게시판읽기 
	{
		Connection con = DBCP.getConnection();
		String sql = "select * from tripwinterboard where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		
		ResultSet rs = pstm.executeQuery();
		BoardDTOOut dto=null;
		if(rs.next()==true)
		{
			String type = rs.getString("type");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String mainphoto = rs.getString("mainphoto");
			String map = rs.getString("map");
			int nice = rs.getInt("nice");
			int count = rs.getInt("count");
			String reg_date = rs.getString("reg_date");			
			String level = rs.getString("level");		
			dto = new BoardDTOOut(num, type, title, content, mainphoto, map, nice, count, reg_date, level);
	
		}
			rs.close();
			pstm.close();
			con.close();
			return dto;
		
	}
	public BoardDTOOut2 readWT2(int num) throws SQLException //힐링테마게시판읽기 2
	{
		Connection con = DBCP.getConnection();
		String sql = "select * from tripwinterboard where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		
		ResultSet rs = pstm.executeQuery();
		BoardDTOOut2 dto=null;
		if(rs.next()==true)
		{
			String type = rs.getString("type"); //type 뽑아 저장
			String mainphoto = rs.getString("mainphoto"); // mainphoto 뽑아 저장
			
			
			dto = new BoardDTOOut2(num,type,mainphoto); // 게시글번호, 타입, 메인포토 저장후 변수에 저장 후 리턴
		
			
		}
			rs.close();
			pstm.close();
			con.close();
			return dto;
		
	}
	public void album(BoardAlbumDTOIn ALdto ) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "insert into album set link=?, path=?,albumtype=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, ALdto.getLink());
		pstm.setString(2, ALdto.getPicpath());
		pstm.setString(3, ALdto.getAlbumType());
		
		pstm.executeUpdate();
		
		pstm.close();
		con.close();
		
		
	}
	public void album2(BoardAlbumDTOIn ALdto ) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "insert into album2 set link=?, path=?,albumtype=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, ALdto.getLink());
		pstm.setString(2, ALdto.getPicpath());
		pstm.setString(3, ALdto.getAlbumType());
		
		pstm.executeUpdate();
		
		pstm.close();
		con.close();
		
		
	}
	public void album3(BoardAlbumDTOIn ALdto ) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "insert into album3 set link=?, path=?,albumtype=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, ALdto.getLink());
		pstm.setString(2, ALdto.getPicpath());
		pstm.setString(3, ALdto.getAlbumType());
		
		pstm.executeUpdate();
		
		pstm.close();
		con.close();
		
		
	}
	public void mod(int num,BoardModDTOIn Mod) throws SQLException
	{
		
		Connection con = DBCP.getConnection();
		String sql = "update tripHealingboard set title=?, content=?, mainphoto=? where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, Mod.getTitle());
		pstm.setString(2, Mod.getContent());
		pstm.setString(3, Mod.getMainphoto());
		pstm.setInt(4, num);
		pstm.executeUpdate();
		 
		pstm.close();
		con.close();
	
	}
	public void mod2(int num,BoardModDTOIn Mod) throws SQLException
	{
		
		Connection con = DBCP.getConnection();
		String sql = "update tripNatureboard set title=?, content=?, mainphoto=? where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, Mod.getTitle());
		pstm.setString(2, Mod.getContent());
		pstm.setString(3, Mod.getMainphoto());
		pstm.setInt(4, num);
		pstm.executeUpdate();
		 
		pstm.close();
		con.close();
	
	}
	public void mod3(int num,BoardModDTOIn Mod) throws SQLException
	{
		
		Connection con = DBCP.getConnection();
		String sql = "update tripWinterboard set title=?, content=?, mainphoto=? where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, Mod.getTitle());
		pstm.setString(2, Mod.getContent());
		pstm.setString(3, Mod.getMainphoto());
		pstm.setInt(4, num);
		pstm.executeUpdate();
		 
		pstm.close();
		con.close();
	
	}
	public void subphotomod(int num,BoardAlbumModDTOIn Mod) throws SQLException
	{
		Connection con = DBCP.getConnection();
		//String type = Mod.getType();
		String[] mod=Mod.getSubphoto();
		int[] alNum=Mod.getAlNum();
		String type = Mod.getType();
		for(int i=0; i<mod.length;i++)
		{
			 String sql = "update Album set path=? where link=? and num=? and albumtype=?";	 
			 PreparedStatement pstm = con.prepareStatement(sql);
			
			 pstm.setString(1, mod[i]);
			
			 pstm.setInt(2, num);
			
			 pstm.setInt(3, alNum[i]);
			 
			 pstm.setString(4, type);
			
			// pstm.setString(4, type);
			 
			 pstm.executeUpdate();
		}	
		 pstm.close(); 
		 con.close();
		 
	}
	public void subphotomod2(int num,BoardAlbumModDTOIn Mod) throws SQLException
	{
		Connection con = DBCP.getConnection();
		//String type = Mod.getType();
		String[] mod=Mod.getSubphoto();
		int[] alNum=Mod.getAlNum();
		String type = Mod.getType();
		for(int i=0; i<mod.length;i++)
		{
			 String sql = "update Album2 set path=? where link=? and num=? and albumtype=?";	 
			 PreparedStatement pstm = con.prepareStatement(sql);
			
			 pstm.setString(1, mod[i]);
			 //System.out.println("mod[i]"+mod[i]);
			 pstm.setInt(2, num);
			 //System.out.println("num"+num);
			 pstm.setInt(3, alNum[i]);
			 //System.out.println("alNum"+alNum[i]);
			 pstm.setString(4, type);
			// System.out.println("type"+type);
			// pstm.setString(4, type);
			 
			 pstm.executeUpdate();
		}	
		 pstm.close(); 
		 con.close();
		 
	}
	public void subphotomod3(int num,BoardAlbumModDTOIn Mod) throws SQLException
	{
		Connection con = DBCP.getConnection();
		//String type = Mod.getType();
		String[] mod=Mod.getSubphoto();
		int[] alNum=Mod.getAlNum();
		String type = Mod.getType();
		for(int i=0; i<mod.length;i++)
		{
			 String sql = "update Album3 set path=? where link=? and num=? and albumtype=?";	 
			 PreparedStatement pstm = con.prepareStatement(sql);
			
			 pstm.setString(1, mod[i]);
			 System.out.println("mod[i]"+mod[i]);
			 pstm.setInt(2, num);
			 System.out.println("num"+num);
			 pstm.setInt(3, alNum[i]);
			 System.out.println("alNum"+alNum[i]);
			 pstm.setString(4, type);
			 System.out.println("type"+type);
			// pstm.setString(4, type);
			 
			 pstm.executeUpdate();
		}	
		 pstm.close(); 
		 con.close();
		 
	}
	public ArrayList<BoardAlbumDTOOut> albumRead(int num,String type) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "select num,path from album where link = ?  and albumtype = ?"; //보드의 넘버가 링크와 같으면 페스를 가져와주세요. 
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		pstm.setString(2, type);
		rs = pstm.executeQuery();
		
		ArrayList<BoardAlbumDTOOut> list = new ArrayList<BoardAlbumDTOOut>();
		
		
		while(rs.next()==true)
		{
			String picpath = rs.getString("path");
			int alNum = rs.getInt("num");
			
			
			BoardAlbumDTOOut ALdto = new BoardAlbumDTOOut(alNum,num, picpath,type);
			
			list.add(ALdto);
		}
		rs.close();
		pstm.close();
		con.close();
		
		
		
		return list;
	}
	public ArrayList<BoardAlbumDTOOut> albumRead2(int num,String type) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "select num,path from album2 where link = ?  and albumtype = ?"; //보드의 넘버가 링크와 같으면 페스를 가져와주세요. 
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		pstm.setString(2, type);
		rs = pstm.executeQuery();
		
		ArrayList<BoardAlbumDTOOut> list = new ArrayList<BoardAlbumDTOOut>();
		
		
		while(rs.next()==true)
		{
			String picpath = rs.getString("path");
			int alNum = rs.getInt("num");
			
			
			BoardAlbumDTOOut ALdto = new BoardAlbumDTOOut(alNum,num, picpath,type);
			
			list.add(ALdto);
		}
		rs.close();
		pstm.close();
		con.close();
		
		
		
		return list;
	}
	public ArrayList<BoardAlbumDTOOut> albumRead3(int num,String type) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "select num,path from album3 where link = ?  and albumtype = ?"; //보드의 넘버가 링크와 같으면 페스를 가져와주세요. 
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		pstm.setString(2, type);
		rs = pstm.executeQuery();
		
		ArrayList<BoardAlbumDTOOut> list = new ArrayList<BoardAlbumDTOOut>();
		
		
		while(rs.next()==true)
		{
			String picpath = rs.getString("path");
			int alNum = rs.getInt("num");
			
			
			BoardAlbumDTOOut ALdto = new BoardAlbumDTOOut(alNum,num, picpath,type);
			
			list.add(ALdto);
		}
		rs.close();
		pstm.close();
		con.close();
		
		
		
		return list;
	}
	public int countAll(PageDTOIn dto) throws SQLException
	{
		PreparedStatement pstm;
		ResultSet rs;
		int mode;
		Connection con = DBCP.getConnection();
		mode = dto.getMode();
		
		if(mode == -1)
		{
			String sql  = "select count(*) from tripHealingboard";
			pstm = con.prepareStatement(sql);
		}else
		{
			String sql = "select count(*) from tripHealingboard where title like ?";
			String search="%"+dto.getWord()+"%";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, search);
		}
		
		rs = pstm.executeQuery();
		
		rs.next();
		int count = rs.getInt("count(*)");
		
		rs.close();
		pstm.close();
		con.close();
		
		return count; //전체 글 개수 
	}
	public int countAll2(PageDTOIn dto) throws SQLException
	{
		PreparedStatement pstm;
		ResultSet rs;
		int mode;
		Connection con = DBCP.getConnection();
		mode = dto.getMode();
		
		if(mode == -1)
		{
			String sql  = "select count(*) from tripnatureboard";
			pstm = con.prepareStatement(sql);
		}else
		{
			String sql = "select count(*) from tripnatureboard where title like ?";
			String search="%"+dto.getWord()+"%";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, search);
		}
		
		rs = pstm.executeQuery();
		
		rs.next();
		int count = rs.getInt("count(*)");
		
		rs.close();
		pstm.close();
		con.close();
		
		return count; //전체 글 개수 
	}
	public int countAll3(PageDTOIn dto) throws SQLException
	{
		PreparedStatement pstm;
		ResultSet rs;
		int mode;
		Connection con = DBCP.getConnection();
		mode = dto.getMode();
		
		if(mode == -1)
		{
			String sql  = "select count(*) from tripHealingboard";
			pstm = con.prepareStatement(sql);
		}else
		{
			String sql = "select count(*) from tripHealingboard where title like ?";
			String search="%"+dto.getWord()+"%";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, search);
		}
		
		rs = pstm.executeQuery();
		
		rs.next();
		int count = rs.getInt("count(*)");
		
		rs.close();
		pstm.close();
		con.close();
		
		return count; //전체 글 개수 
	}
	public boolean del(int num) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "delete from tripHealingboard where num=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		
		
		int ret = pstm.executeUpdate();
		
		if(ret == 1)
		{
			pstm.close();
			con.close();		
			return true;
			
		}else
		{
			pstm.close();	
			con.close();		
			return false;
		}
		
	}
	public boolean del2(int num) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "delete from tripNatureboard where num=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		
		
		int ret = pstm.executeUpdate();
		
		if(ret == 1)
		{
			pstm.close();
			con.close();		
			return true;
			
		}else
		{
			pstm.close();	
			con.close();		
			return false;
		}
		
	}
	public boolean del3(int num) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "delete from tripWinterboard where num=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		
		
		int ret = pstm.executeUpdate();
		
		if(ret == 1)
		{
			pstm.close();
			con.close();		
			return true;
			
		}else
		{
			pstm.close();	
			con.close();		
			return false;
		}
		
	}
	public void delPhoto(int num, String type) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "update tripHealingboard set photo=null where num=? and type=?";
		
		//preparedStatement 객체 
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		pstm.setString(2, type);
		//SQL 문장을 실행함
		pstm.executeUpdate();
		
		pstm.close();
		con.close();
		
	}
	public ArrayList<FavDTOIn1> favOut(String userId) throws SQLException
	{
		Connection con = DBCP.getConnection();
		
		//System.out.println("before userId : "+userId);
		String sql = "select num,type from favmem where userid=?";
		
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, userId);
		
		//System.out.println("after userId : "+userId);
		rs = pstm.executeQuery();
		ArrayList<FavDTOIn1> dto = new ArrayList<FavDTOIn1>();
		while(rs.next()==true)
		{
			int num = rs.getInt("num");
			String type = rs.getString("type");
			
			FavDTOIn1 favdto = new FavDTOIn1(num,type);
			
			dto.add(favdto);
			
			//System.out.println(favdto.getType());
		}
		rs.close();
		pstm.close();
		con.close();
		
		return dto;
		
	}
	public void favIn(int num,String type,String userId) throws SQLException
	{
		
		Connection con = DBCP.getConnection();
		String sql = "insert into favmem set num=?,type=?,userid=?";
		//System.out.println("num :"+num+" type :"+type+" userid :"+userId);
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		pstm.setString(2, type);
		pstm.setString(3, userId);
		
		pstm.executeUpdate();
		
		pstm.close();
		con.close();

	}
	public void favIn2(int num,String type,String userId) throws SQLException
	{
		
		Connection con = DBCP.getConnection();
		String sql = "insert into favmem2 set num=?,type=?,userid=?";
		//System.out.println("num :"+num+" type :"+type+" userid :"+userId);
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		pstm.setString(2, type);
		pstm.setString(3, userId);
		
		pstm.executeUpdate();
		
		pstm.close();
		con.close();

	}
	public void favIn3(int num,String type,String userId) throws SQLException
	{
		
		Connection con = DBCP.getConnection();
		String sql = "insert into favmem3 set num=?,type=?,userid=?";
		//System.out.println("num :"+num+" type :"+type+" userid :"+userId);
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		pstm.setString(2, type);
		pstm.setString(3, userId);
		
		pstm.executeUpdate();
		
		pstm.close();
		con.close();

	}
	
	public ArrayList<FavDTOOut> fav(ArrayList<FavDTOIn1> dtoin, String type) throws SQLException{
		
		Connection con = DBCP.getConnection();
		ArrayList<FavDTOOut> dto = new ArrayList<FavDTOOut>();
		ArrayList<FavDTOOut> dto2 = new ArrayList<FavDTOOut>();
		ArrayList<FavDTOOut> dto3 = new ArrayList<FavDTOOut>();
		PreparedStatement pstm = null;
		
		for(int i=0; i<dtoin.size();i++){
			
			String favtype = dtoin.get(i).getType();
			int num = dtoin.get(i).getNum();
		
			
			if(favtype.equals(type)==true && type.equals("healing")==true){
				String sql = "select title, reg_date from tripHealingboard where num=?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, num);
				rs = pstm.executeQuery();
				while(rs.next()==true)
				{
					String title = rs.getString("title");
					String reg_date = rs.getString("reg_date");
					
					FavDTOOut favdto = new FavDTOOut(title,reg_date,num);
					dto.add(favdto);
				}
				
			}else if(favtype.equals(type)==true&& type.equals("nature")==true){
				System.out.println("들어왔다");
				String sql = "select title, reg_date from tripNatureboard where num=?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, num);
				rs = pstm.executeQuery();
				while(rs.next()==true)
				{
					String title = rs.getString("title");
					String reg_date = rs.getString("reg_date");
					
					FavDTOOut favdto = new FavDTOOut(title,reg_date,num);
					dto2.add(favdto);
				}
				
			}else if(favtype.equals(type)==true&& type.equals("winter")==true){
				String sql = "select title, reg_date from Winterboard where num=?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, num);
				rs = pstm.executeQuery();
				while(rs.next()==true)
				{
					String title = rs.getString("title");
					String reg_date = rs.getString("reg_date");
					
					FavDTOOut favdto = new FavDTOOut(title,reg_date,num);
					dto3.add(favdto);
				}
				
			}
		}
		rs.close();
		pstm.close();
		con.close();
		
		return dto;
		
	}

	
}
