package community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lecture.lecture;

public class comuDAO {
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
	
	// 게시글 총 갯수
	public int getComuCount() {
		int count = 0;  // 총 개수를 리턴하기 위한 변수
		try {
			con= getCon();
			String sql ="select count(*) from community"; // 총 개수를 조회하기 위한 쿼리
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
	
	public ArrayList<comu> ComuList(int page, int limit) {
		ArrayList<comu> ss = new ArrayList<>();
		
		// 조회범위
		int startrow = (page-1) * 10;	// ex )  0, 16, 32 , 48 ...
		int endrow = limit;  			// ex ) limit 만큼 리스트에 나열
		
		try {
			con = getCon();
			sql = "select * from community order by comu_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				ss.add(new comu(rs.getInt("comu_num"), rs.getString("comu_title"), rs.getString("stu_id"), rs.getString("comu_contents"), rs.getDate("comu_date")));
				System.out.println("커뮤니티 게시판 전체 조회 성공");

				i++;
				System.out.println("읽어드린 게시판 수 : " + i);
			}
		
		} catch (SQLException e) {
			System.out.println("커뮤니티 게시판 전체 조회중, sql 오류!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("커뮤니티 게시판 전체 조회중, 오류!");
			e.printStackTrace();
		} finally {
			//자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
		return ss;
	}
	
	public void Deletenotice(int num){ //파라미터로 정보를 받아서 DB에 저장
        try {

            con= getCon();
            sql ="delete from community where comu_num=?";
            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, num);
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
        

    }
				
}
