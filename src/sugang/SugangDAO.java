package sugang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import member.Member;

public class SugangDAO {
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
	
	public void insertMember(Sugang sa){ //파라미터로 정보를 받아서 DB에 저장
		try {
			//3-1. DB연결메서드 불러오기
			con = getCon();
			//3-2. SQL & pstmt 생성 & 실행
			sql = "insert into sugang(stu_id, lec_id, lec_title, su_date) values(?,?,?,CURRENT_TIMESTAMP())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sa.getStu_id());
			pstmt.setInt(2, sa.getLec_id());
			pstmt.setString(3, sa.getLec_title());
			int x1 = pstmt.executeUpdate();
			System.out.println("수강신청 성공!" + x1);
		} catch (SQLException e) {
			System.out.println("sql구문땜시 회원가입실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("수강신청 실패!!");
			e.printStackTrace();
		} finally {
			//자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
	}//insertMember닫힘
	
	public boolean ischecksugang(String stu_id, int lec_id) {
		boolean ss = true;
		try {
			con = getCon();
			sql = "select stu_id from sugang where stu_id = ? and lec_id = ?";
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
			System.out.println("sql구문땜시 회원가입실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("수강신청 실패!!");
			e.printStackTrace();
		} finally {
			closeDB();
		}
		System.out.println("return 하기 전 ss값: " + ss);
		return ss;
	}
	
	public ArrayList<Sugang> getleclist(String stu_id){
		ArrayList<Sugang> ss = new ArrayList<Sugang>();
		try {
			con = getCon();
//			sql = "select lec_title, su_date from sugang where stu_id = ?";
			sql = "select stu_id, lec_id, lec_title, su_date from sugang where stu_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String stu_ids = rs.getString("stu_id");
				int lec_id = rs.getInt("lec_id");
				String lec_title = rs.getString("lec_title");
				Date su_date = rs.getDate("su_date");
//				Sugang sg = new Sugang(stu_ids, lec_id, lec_title, su_date);
				ss.add(new Sugang(stu_ids, lec_id, lec_title, su_date));
				System.out.println("조회한 수강 겟 리스트" + ss);
				
			}
			
		} catch (Exception e) {
			System.out.println("수강신청 목록 불러오기 실패!!");
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return ss;
	}
	//최근 시청한 강의 3종 세트. dto getter stter로 값 전송 후, 읽기 안됨.그래서 이 방법 사용
	public String getLastTitle(String stu_id) {
		String ss = null;
		try {
			con = getCon();
			sql = "select lec_id, lec_title, su_date from sugang where stu_id = ? order by su_date desc limit 1";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String lec_title = rs.getString("lec_title");
				ss = lec_title;
				System.out.println("최근 수강 타이틀 가져오기 성공!!");
			}
			
		} catch (Exception e) {
			System.out.println("최근 수강 데이터 가져오기 실패!");
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return ss;
	}
	
	public int getLastId(String stu_id) {
		int ss = 0;
		try {
			con = getCon();
			sql = "select lec_id, lec_title, su_date from sugang where stu_id = ? order by su_date desc limit 1";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int lec_id = rs.getInt("lec_id");
				ss = lec_id;
				
				System.out.println("최근 수강 강의번호 가져오기 성공!!");
			}
			
		} catch (Exception e) {
			System.out.println("최근 수강 데이터 가져오기 실패!");
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return ss;
	}
	
	public String getLastDate(String stu_id) {
		String ss = null;
		try {
			con = getCon();
			sql = "select lec_id, lec_title, su_date from sugang where stu_id = ? order by su_date desc limit 1";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Date su_date = rs.getDate("su_date");
				ss = su_date.toString();
				System.out.println("최근 수강한 날짜 가져오기 성공!!");
			}
			
		} catch (Exception e) {
			System.out.println("최근 수강 데이터 가져오기 실패!");
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return ss;
	}
	
	//수강신청한 강의의 총 수
	public int getmylecturecount(String stu_id) {
		int x= 0;
		try {
			con = getCon();
			sql = "select count(*) as count from sugang where stu_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				x = rs.getInt("count");
				System.out.println("수강 신청한 총 강의의 수");
			}
			
		} catch (Exception e) {
			System.out.println("최근 수강 데이터 가져오기 실패!");
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return x;
	}
	//내가 등록한 리뷰 수
	public int getmycommentcount(String stu_id) {
		int x = 0;
		try {
			con = getCon();
			sql = "select count(*) as count from comment where stu_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				x = rs.getInt("count");
				System.out.println("내가 등록한 리뷰 수");
			}
			
		} catch (Exception e) {
			System.out.println("최근 수강 데이터 가져오기 실패!");
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return x;
	}
	
}
