package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BoardAlbumDTOIn;
import dto.BoardAlbumDTOOut;
import dto.BoardAlbumModDTOIn;
import dto.BoardDTOIn;
import dto.BoardDTOOut;
import dto.BoardDTOOut2;
import dto.BoardModDTOIn;
import dto.FavDTOIn1;
import dto.FavDTOOut;
import dto.ListContentDTOOut;
import dto.ListMainDTOOut;
import dto.ListTripDTOOut;
import dto.PageDTOIn;

public class UserDAO 
{
		PreparedStatement pstm;
		ResultSet rs;
		//글을 저장하는 메소드 
		//글을 저장하는 메소드 
		
	public boolean niceIn(int num,String type, String id) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "insert into nice set type=?, link=?, id=?";
		PreparedStatement pstm= con.prepareStatement(sql);
		
		pstm.setString(1, type);
		pstm.setInt(2, num);
		pstm.setString(3, id);
		
		int ret = pstm.executeUpdate();
		if(ret==1)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public int niceCheck(int num,String type, String id) throws SQLException
	{
		Connection con = DBCP.getConnection();
		
		String sql = "select count(*) from nice where type=? and link=? and id=?";
		
		PreparedStatement pstm= con.prepareStatement(sql);
		
		pstm.setString(1, type);
		pstm.setInt(2, num);
		pstm.setString(3, id);
		ResultSet rs = pstm.executeQuery();
		
		rs.next();
		int count = rs.getInt("count(*)");
		System.out.println(count);
		rs.close();
		pstm.close();
		con.close();
		
		return count;
		
		
	}
	public int nice(int num) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "update triphealingboard set nice=nice+1 where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		
		pstm.executeUpdate();
		pstm.close();
		
		sql = "select nice from triphealingboard where num=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		rs = pstm.executeQuery();
		rs.next();
		int ret = rs.getInt("nice");
		System.out.println(ret);
		
		rs.close();
		pstm.close();
		con.close();
		
		return ret;
	}
	public int nice2(int num) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "update tripnatureboard set nice=nice+1 where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		
		pstm.executeUpdate();
		pstm.close();
		
		sql = "select nice from tripnatureboard where num=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		rs = pstm.executeQuery();
		rs.next();
		int ret = rs.getInt("nice");
		System.out.println(ret);
		
		rs.close();
		pstm.close();
		con.close();
		
		return ret;
	}
	public int nice3(int num) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql = "update tripwinterboard set nice=nice+1 where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		
		pstm.executeUpdate();
		pstm.close();
		
		sql = "select nice from tripwinterboard where num=?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, num);
		rs = pstm.executeQuery();
		rs.next();
		int ret = rs.getInt("nice");
		System.out.println(ret);
		
		rs.close();
		pstm.close();
		con.close();
		
		return ret;
	}
	public ArrayList<ListContentDTOOut> listContent(PageDTOIn page) throws SQLException
	{
		int pageNo = page.getPageNo();
		int pageSize = page.getPageSize();
		int mode = page.getMode();
		String Word = page.getWord();
		String type = page.getType();
		
		int start = pageNo * pageSize; //pageNo에 속하는 글의 시작위치 
		
		Connection con = DBCP.getConnection();
		String sql;
		PreparedStatement pstm = null;
		if(mode == 1)
		{
			//검색어를 사용하지 않음
			sql = "select num, mainphoto, title, content,nice,count,reg_date from tripHealingboard order by num desc limit ?,?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, start);
			pstm.setInt(2, pageSize);
			
					
		}else{
			//검색어를 사용함 
			String word = "%"+page.getWord()+"%";
			sql = "select num, mainphoto, title, content,nice,count,reg_date from tripHealingboard where title like ? order by num desc limit ?,?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, word);
			pstm.setInt(2, start);
			pstm.setInt(3, pageSize);
		}
		rs = pstm.executeQuery();
		
		ArrayList<ListContentDTOOut> list= new ArrayList<ListContentDTOOut>();
		
		while(rs.next()==true)
		{
			int num = rs.getInt("num");
			String mainphoto = rs.getString("mainphoto");
			String title = rs.getString("title");
			String content = rs.getString("content");
			int nice = rs.getInt("nice");
			int count = rs.getInt("count");
			String reg_date = rs.getString("reg_date");
		
			ListContentDTOOut dto = new ListContentDTOOut(num,mainphoto,title,content,nice,count,reg_date);
			
			list.add(dto);
		}
		return list;
	}
	public ArrayList<ListMainDTOOut> listmain(String type,int cnt) throws SQLException
	{
		Connection con = DBCP.getConnection();
		
		String sql = "select num, mainphoto, title, content, type from triphealingboard where type=? order by num desc limit 0,?"; //0개부터 ? 개수의 게시판을 표현 (최신순으로)
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, type); //검색할 콘텐츠 종류
		pstm.setInt(2, cnt);	//글의 갯수
		//System.out.println(type);
		rs = pstm.executeQuery();  //검색을 함 
		
		ArrayList<ListMainDTOOut> list = new ArrayList<ListMainDTOOut>();
		
		while(rs.next() == true)
		{
			int num = rs.getInt("num");
			String mainphoto = rs.getString("mainphoto");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String type2 = rs.getString("type");
			
			ListMainDTOOut dto = new ListMainDTOOut(num,  title, content,mainphoto,type2);
			
			list.add(dto); //리스트에 dto를 저장 
		}
		rs.close();		
		pstm.close();
		con.close();
		return list;
	
	}
	public ArrayList<ListMainDTOOut> listmain2(String type,int cnt) throws SQLException
	{
		Connection con = DBCP.getConnection();
		
		String sql = "select num, mainphoto, title, content, type from tripnatureboard where type=? order by num desc limit 0,?"; //0개부터 ? 개수의 게시판을 표현 (최신순으로)
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, type); //검색할 콘텐츠 종류
		pstm.setInt(2, cnt);	//글의 갯수
		//System.out.println(type);
		rs = pstm.executeQuery();  //검색을 함 
		
		ArrayList<ListMainDTOOut> list = new ArrayList<ListMainDTOOut>();
		
		while(rs.next() == true)
		{
			int num = rs.getInt("num");
			String mainphoto = rs.getString("mainphoto");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String type2 = rs.getString("type");
			
			ListMainDTOOut dto = new ListMainDTOOut(num,  title, content,mainphoto,type2);
			
			list.add(dto); //리스트에 dto를 저장 
		}
		rs.close();		
		pstm.close();
		con.close();
		return list;
	
	}
	public ArrayList<ListMainDTOOut> listmain3(String type,int cnt) throws SQLException
	{
		Connection con = DBCP.getConnection();
		
		String sql = "select num, mainphoto, title, content,type from tripwinterboard where type=? order by num desc limit 0,?"; //0개부터 ? 개수의 게시판을 표현 (최신순으로)
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, type); //검색할 콘텐츠 종류
		pstm.setInt(2, cnt);	//글의 갯수
		//System.out.println(type);
		rs = pstm.executeQuery();  //검색을 함 
		
		ArrayList<ListMainDTOOut> list = new ArrayList<ListMainDTOOut>();
		
		while(rs.next() == true)
		{
			int num = rs.getInt("num");
			String mainphoto = rs.getString("mainphoto");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String type2 = rs.getString("type");
			
			ListMainDTOOut dto = new ListMainDTOOut(num,  title, content,mainphoto,type2);
			
			list.add(dto); //리스트에 dto를 저장 
		}
		rs.close();		
		pstm.close();
		con.close();
		return list;
	
	}
}
