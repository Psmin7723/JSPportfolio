package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ReplyDTOIn;
import dto.ReplyDTOOut;

public class ReplyDAO 
{
	public ArrayList<ReplyDTOOut> readRep(int num, String type) throws SQLException
	{
		
		Connection con = DBCP.getConnection();
		
		String sql="select  * from reply where link=? and type=? order by num desc";
		
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setInt(1,num);
		pstm.setString(2, type);
		ResultSet rs = pstm.executeQuery();
		
		ArrayList<ReplyDTOOut> RepList = new ArrayList<ReplyDTOOut>();
		while(rs.next()==true)
		{
			int repNum = rs.getInt("num");
			String id = rs.getString("id");
			String content = rs.getString("content");
			String reg_date = rs.getString("reg_date");
			ReplyDTOOut dto= new ReplyDTOOut(repNum,id,content,reg_date);
			
			RepList.add(dto);
		}
			rs.close();
			pstm.close();
			
			con.close();
			return RepList;
		
	}
	public boolean modReply(int num, String content) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql="update reply set content=? where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, content);
		pstm.setInt(2, num);
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
	public boolean delReply(int repNum) throws SQLException
	{
		Connection con = DBCP.getConnection();
		String sql="delete from reply where num=?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, repNum);
		
		int ret = pstm.executeUpdate();
		
		if(ret==1)
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
	public void writeRep(ReplyDTOIn dto) throws SQLException
	{
		int link = dto.getLink();
		String content = dto.getContent();
		String type = dto.getType();
		String id = dto.getId();
		
		Connection con = DBCP.getConnection();
		
		String sql="insert into reply set link=?, content=?, type=?, id=?";
		
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setInt(1, link);
		pstm.setString(2, content);
		pstm.setString(3, type);
		pstm.setString(4, id);
		
		
		pstm.executeUpdate();
		
		pstm.close();
		con.close();
	}
	
}
