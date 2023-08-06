package notice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lecture.cm;
import lecture.leccm;
import lecture.lecture;

public class noticeDAO {
	Connection con =null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
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
	
	//3-1. 강의 전체 조회
	public ArrayList<notice> noClasslist(int page, int limit) {
		ArrayList<notice> nolist = new ArrayList<>();
		
		// 조회범위
		int startrow = (page-1) * 10;	// ex )  0, 16, 32 , 48 ...
		int endrow = limit;  			// ex ) limit 만큼 리스트에 나열
		
		try {
			con = getCon();
			sql = "select * from notice order by no_id desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no_id= rs.getInt("no_id");
				String admin_id=rs.getString("admin_id");
				String no_title =rs.getString("no_title");
				String no_content=rs.getString("no_content");
				Date no_date= rs.getDate("no_date");
				notice nodto=new notice(no_id,admin_id,no_title,no_content,no_date);
				
				nolist.add(nodto);
				System.out.println("공지 전체 조회 성공");
			}
			return nolist;
		} catch (SQLException e) {
			System.out.println("sql구문땜시 공지 조회 실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("공 전체 조회 실패");
			e.printStackTrace();
		} finally {
			//자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
		return null;
	}
	

	// 게시글 총 갯수
	public int getNoListCount() {
		int count = 0;  // 총 개수를 리턴하기 위한 변수
		try {
			con= getCon();
			String sql ="select count(*) from notice"; // 총 개수를 조회하기 위한 쿼리
			pstmt=con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return count;
	}
	
	//강의 검색 조회
	public ArrayList<notice> noticelistSearch(int page, int limit, String keyWord, String searchWord) {
		ArrayList<notice> nolist = new ArrayList<>();
		
		// 조회범위
		int startrow = (page-1) * 10;	// ex )  0, 16, 32 , 48 ...
		int endrow = limit;  			// ex ) limit 만큼 리스트에 나열
		
		try {
			con = getCon();
			sql = "select * from notice where " + keyWord+ " like ?";
			sql += "order by no_id desc limit ?, ?";
			System.out.println(keyWord +"/"+ searchWord); //값이 잘 넘어오는지 확인
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int no_id=rs.getInt("no_id");
				String admin_id = rs.getString("admin_id");
				String no_title = rs.getString("no_title");
				String no_content =rs.getString("no_content");
				Date no_date =rs.getDate("no_date");
				
				
				notice nodto = new notice(no_id,admin_id,no_title,no_content,no_date);
				nolist.add(nodto);
				System.out.println("강의 검색 조회 성공");
			}
			return nolist;
		} catch (SQLException e) {
			System.out.println("sql구문땜시 조회 실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("강의 검색 조회 실패");
			e.printStackTrace();
		} finally {
			//자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
		return null;
	}
	
	// 검색 게시글 총 갯수
	public int getnoListSearchCount(String keyWord, String searchWord) {
	int count = 0;  // 총 개수를 리턴하기 위한 변수
	try {
		con= getCon();
		String sql ="select count(*) as count from notice where " + keyWord + " like ?"; // 총 개수를 조회하기 위한 쿼리
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, "%" + searchWord + "%");
		rs= pstmt.executeQuery();
		
		if(rs.next()) {
			count = rs.getInt("count");
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		closeDB();
	}
	return count;
}

	//3. 강의등록 처리 (외부에서 접근가능해야하니까 public)
		public void insertnotice(notice no){ //파라미터로 정보를 받아서 DB에 저장
			try {

				con= getCon();
				sql ="insert into notice value (?,?,?,?,CURRENT_TIMESTAMP())";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no.getNo_id());
				pstmt.setString(2, no.getAdmin_id());
				pstmt.setString(3, no.getNo_title());
				pstmt.setString(4, no.getNo_content());
					
				pstmt.executeUpdate();
					
				
				System.out.println("공지 등 성공");
			} catch (SQLException e) {
				System.out.println("sql구문땜시 강의등록 실패");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("강의등록 실패");
				e.printStackTrace();
			} finally {
				//자원해제로 DB 효율성을 높일수있다.
				closeDB();
			}
		}//insertlecture닫힘

	
		//공지사항 세부 값 가져오기
		public notice getNoticePage(int no_id) throws Exception{
			notice noti= null;
			String sql="SELECT * FROM notice where no_id =?";	
			try {
				con = getCon();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no_id);
				rs = pstmt.executeQuery();

			
			while(rs.next()) {
				
					
					String admin_id=rs.getString("admin_id");
					String no_title= rs.getString("no_title");
					String no_content=rs.getString("no_content");
					Date no_date = rs.getDate("no_date");
					
					noti = new notice(no_id,admin_id,no_title,no_content,no_date);
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				closeDB();
			}
			return noti;
			}
		
		
		public int Updatenotice(notice no){ //파라미터로 정보를 받아서 DB에 저장
			int result=0;
			try {

				con= getCon();
				sql ="update notice set admin_id=?, no_title=?, no_content=?,no_date=? where no_id=?";
				pstmt = con.prepareStatement(sql);
			
				pstmt.setString(1, no.getAdmin_id());
				pstmt.setString(2, no.getNo_title());
				pstmt.setString(3, no.getNo_content());
				pstmt.setDate(4, no.getNo_date());
				pstmt.setInt(5, no.getNo_id());
				
				System.out.println("작성자 아이디 "+no.getAdmin_id());
				
				result= pstmt.executeUpdate();
				System.out.println("title: "+no.getNo_title());
				
				System.out.println("공지 등 성공");
			} catch (SQLException e) {
				System.out.println("sql구문땜시 강의등록 실패");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("강의등록 실패");
				e.printStackTrace();
			} finally {
				//자원해제로 DB 효율성을 높일수있다.
				closeDB();
			}
			return result;
			
		}
		
		public int Deletenotice(notice no){ //파라미터로 정보를 받아서 DB에 저장
			int result=0;
			try {

				con= getCon();
				sql ="delete from notice where no_id=?";
				pstmt = con.prepareStatement(sql);
			
				pstmt.setInt(1, no.getNo_id());
				result= pstmt.executeUpdate();
				
				
				System.out.println("공지 등 성공");
			} catch (SQLException e) {
				System.out.println("sql구문땜시 강의등록 실패");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("강의등록 실패");
				e.printStackTrace();
			} finally {
				//자원해제로 DB 효율성을 높일수있다.
				closeDB();
			}
			return result;
			
		}

		
	
}
