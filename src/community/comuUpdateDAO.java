package community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class comuUpdateDAO {
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	//1. DB연결메서드
	public Connection getCon() throws Exception{
		Context init= new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/study_platform"); //Context.xml의 주소와 동일해야함
		con = ds.getConnection();
		return con;
	}//end of getCon()
	
	
	//2. 자원해제 메서드 구현
	public void closeDB(){
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}//closeDB()
	
	
	public void updateDate(String title, String content, int num, String id) {
		try {
			con= getCon();
			String sql="update community set comu_title = ?, comu_contents = ? where comu_num = ? and stu_id = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("업데이트 실패");
			}finally {
				closeDB();
			}
		
	}
}
