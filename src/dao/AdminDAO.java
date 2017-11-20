package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO 
{
	ResultSet rs;
	public boolean login(String id, String pw) throws SQLException
	{
		//(1)데이터 베이스 커넥션 풀(DBCP)에서 Connection 객체를 꺼내옴
		Connection con = DBCP.getConnection();
		String sql = "select * from admin where id=? and pw=sha1(?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.setString(2, pw);
		
		rs=pstm.executeQuery();
		
		boolean ret;
		
		if(rs.next()==true)
		{
			System.out.println("로그인 성공");
			ret = true;
			
		}else 
		{
			ret= false;
			System.out.println("로그인 실패");
	
		}
		rs.close();
		pstm.close();
		con.close();
		
		return ret;
	}
}
