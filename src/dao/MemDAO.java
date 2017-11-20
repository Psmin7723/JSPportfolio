package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import dto.InfoDTOOut;
import dto.MemDTOIn;
import dto.ModDTOIn;

//member 테이블을 관리하는 DAO
public class MemDAO 
{
	ResultSet rs;
	public boolean reg(MemDTOIn dto) throws SQLException	//회원가입 메소드
	{
		int ret;
		//DTO에서 필요한 데이터 꺼내오기 (설명차원 꼭 안해도됌)
		String agree = dto.getAgree();
		String agree2 = dto.getAgree2();
		String id = dto.getId();
		String pw = dto.getPw();
		String name = dto.getName();
		String gender = dto.getGender();
		String phone = dto.getPhone();
		String phone2 = dto.getPhone2();
		String email = dto.getEmail();
		String address = dto.getAddress();
		String birth = dto.getBirth();
	    Double tall = dto.getTall();
		Double weight = dto.getWeight();
		Double arm = dto.getArm();
		Double leg = dto.getLeg();
		Double waist = dto.getWaist();
		
		//(1)커넥션 객체 꺼내오기 
		Connection con = DBCP.getConnection();
		//(2)sql 문장 작성
		String sql ="insert into member ";
			   sql +="set agree=?, agree2=?,id=?, pw=sha1(?), name=?, gender=?, phone=?, phone2=?, email=?, address=?, birth=?, tall=?, weight=?,arm=?, leg=?,waist=?, reg_date=now()";
		//(3)PreparedStatement 객체 생성
	
		
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, agree);
			pstm.setString(2, agree2);
			pstm.setString(3, id);
			pstm.setString(4, pw);
			pstm.setString(5, name);
			pstm.setString(6, gender);
			pstm.setString(7, phone);
			pstm.setString(8, phone2);
			pstm.setString(9, email);
			pstm.setString(10, address);
			pstm.setString(11, birth);		
			pstm.setDouble(12,tall);
			pstm.setDouble(13, weight);
			pstm.setDouble(14, arm);
			pstm.setDouble(15, leg);
			pstm.setDouble(16, waist);
			
			
			
			
			ret=pstm.executeUpdate(); //ret는 0또는 1이 반환되는데.. 
									  // 0 - insert에 의해서 변경됨 테이블이 변경되지 않음.
									  // 1 - insert에 의해서 테이블에 줄이 1개 추가되었음.
			
			if(ret==1)
			{
				rs.close();
				pstm.close();
				con.close();
				return true;		
			}else
			{
				rs.close();
				pstm.close();
				con.close();
				return false;
			}
	}
	public boolean login(String id, String pw) throws SQLException
	{
		
		Connection con = DBCP.getConnection();
		String sql = "select * from member where id=? and pw=sha1(?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.setString(2, pw);
		
		rs=pstm.executeQuery();
		
		if(rs.next()==true)
		{
			System.out.println("로그인 성공");
			
			rs.close();
			pstm.close();
			con.close();
			return true;
		}else 
		{
			System.out.println("로그인 실패");
			rs.close();
			pstm.close();
			con.close();
			return false;
		}
		
		
	}
	public boolean idCheck(String id) throws SQLException
	{
		//System.out.println("idcheck dao");
		Connection con = DBCP.getConnection();
		String sql="select * from member where id=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, id);
		rs = pstm.executeQuery();
		
		if(rs.next() == true) //동일 아이디가 존재함
		{
			rs.close();
			pstm.close();
			con.close();
			return false; //사용할 수 없음
		}else //동일 아이디가 없음
		{
			rs.close();
			pstm.close();
			con.close();
			return true; // 사용할 수 있음
		}
	}
	public boolean pwCheck(String pw) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql="select * from member where pw= sha1(?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, pw);
		rs = pstm.executeQuery();
		
		if(rs.next() == true)
		{
			rs.close();
			pstm.close();
			con.close();
			return true;
		}else
		{
			rs.close();
			pstm.close();
			con.close();
			return false;
		}
		
	}
	public boolean del(String id) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql="delete from member where id=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, id);
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
	public InfoDTOOut info(String id) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql="select * from member where id=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, id);
		rs = pstm.executeQuery();
		
		if(rs.next() == true) //검색되어 읽어올 데이터가 있음
		{
			
			
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			//String pw = rs.getString("pw");
			
			System.out.println("전화번호: "+phone);
			System.out.println("이메일: "+email);
			//System.out.println("비밀번호: "+pw);
			
			InfoDTOOut dto = new InfoDTOOut(phone, email);
			rs.close();
			pstm.close();
			con.close();
			return dto;
			
			
		}else				//검색된 데이터가 없음 
		{
			rs.close();
			pstm.close();
			con.close();
			return null;
		}
		
	}
	public boolean mod(ModDTOIn dto) throws SQLException
	{
		int ret;
		Connection con = DBCP.getConnection();
		String sql = "update member set phone=?, email=?, pw=sha1(?) where id=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, dto.getPhone());	
		pstm.setString(2, dto.getEmail());
		pstm.setString(3, dto.getPw());
		pstm.setString(4, dto.getId());
		
		ret = pstm.executeUpdate(); 
		if(ret==1)
		{
			
			pstm.close();
			con.close();
			return true;
		}else
		{
			pstm.close();
			con.close();
			return true;
		}
	}
	
	
}
