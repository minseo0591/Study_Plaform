package community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class comuAddDAO {
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
	
	public void comuAdd(String title, String stu_id, String content) {
		try {
			con = getCon();
			sql = "insert into community(comu_title, stu_id, comu_contents, comu_date) values(?, ?, ?, CURRENT_TIMESTAMP())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, stu_id);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			System.out.println(stu_id + "님이 커뮤니티 게시글 등록에 성공하셨습니다!!");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("커뮤니티 게시글 등록 실패!!");
		}
		finally {
			closeDB();
		}
	}
}
