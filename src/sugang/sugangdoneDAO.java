package sugang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class sugangdoneDAO {
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
	
	public void insertDone(String stu_id, int lec_id, int checker){ //파라미터로 정보를 받아서 DB에 저장
		try {
			//3-1. DB연결메서드 불러오기
			con = getCon();
			//3-2. SQL & pstmt 생성 & 실행
			sql = "insert into sugangdone(stu_id, lec_id, checker) values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			pstmt.setInt(2, lec_id);
			pstmt.setInt(3, checker);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql구문 오류있음!!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("수강완료 실패!!");
			e.printStackTrace();
		} finally {
			//자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
	}//insertMember닫힘
	
	public boolean ischecksugangdone(String stu_id, int lec_id) {
		boolean ss = true;
		try {
			con = getCon();
			sql = "select stu_id from sugangdone where stu_id = ? and lec_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			pstmt.setInt(2, lec_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					ss = true;
				}while(rs.next());
			}else {
				ss=false;
			}
			
		} catch (SQLException e) {
			System.out.println("sql구문땜시 수강완료 체크 실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("수강완료 체크 실패");
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return ss;
	}
	
	public int getDoneCount(String stu_id) {
		int x = 0;
		try {
			con = getCon();
			sql = "select count(*) as count from sugangdone where stu_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				x = rs.getInt("count");
				System.out.println("내가 완료한 강의 수 : " + x);
			}
			
		} catch (Exception e) {
			System.out.println("최근 완료한 수강 수 가져오기 실패!");
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return x;
	}
}
