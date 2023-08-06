package community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class comuDetailDAO {
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
	
	//세부사항 제목, 날짜, 데이터 작성자 내용 뽑기
	public ArrayList<comu> getDetailList(int num) {
		ArrayList<comu> ss = new ArrayList<>();
		
		try {
			con = getCon();
			sql = "select * from community where comu_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ss.add(new comu(rs.getInt("comu_num"), rs.getString("comu_title"), rs.getString("stu_id"), rs.getString("comu_contents"), rs.getDate("comu_date")));
				System.out.println("커뮤니티 게시판 세부사항 조회 성공");
//				System.out.println("limit : " + limit);
//				System.out.println("startrow : " + startrow);
				
				
			}
			return ss;
		} catch (SQLException e) {
			System.out.println("커뮤니티 게시판 세부사항 조회중, sql 오류!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("커뮤니티 게시판 세부사항 조회중, 오류!");
			e.printStackTrace();
		} finally {
			//자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
		return null;
	}
	
	public String getStu_id(int num) {
		String ss = null;
		try {
			con = getCon();
			sql = "select stu_id from community where comu_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ss = rs.getString("stu_id");
			}
	
		} catch (SQLException e) {
			System.out.println("커뮤니티 게시판 작성자 조회중, sql 오류!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("커뮤니티 게시판 작성자 조회중, 오류!");
			e.printStackTrace();
		} finally {
			//자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
		return ss;
	}
	public int getNumber(int num) {
		int ss = 0;
		try {
			con = getCon();
			sql = "select comu_num from community where comu_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ss = rs.getInt("comu_num");
			}
		
		} catch (SQLException e) {
			System.out.println("커뮤니티 게시판 작성자 조회중, sql 오류!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("커뮤니티 게시판 작성자 조회중, 오류!");
			e.printStackTrace();
		} finally {
			//자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
		return ss;
	}
}
