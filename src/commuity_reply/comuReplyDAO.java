package commuity_reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import community.comu;

public class comuReplyDAO {
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
	
	//댓글 리스트
	public ArrayList<comuReply> getComuReplyList(int number) {
		ArrayList<comuReply> ss = new ArrayList<>();
		try {
			con = getCon();
			sql = "select * from combd_reply where comu_num = ? order by reply_level desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				ss.add(new comuReply(rs.getInt("comu_num"), rs.getString("stu_id"), rs.getString("reply_contents"), rs.getInt("reply_level"),rs.getDate("reply_date")));
				
				i++;
				System.out.println("읽어드린 댓 수 : " + i);
			}
			
		}catch (SQLException e) {
			System.out.println("커뮤니티 게시판 댓글리스트 조회중, sql 오류!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("커뮤니티 게시판 댓글 리스트 조회중, 오류!");
			e.printStackTrace();
		} finally {
			//자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
		return ss;
	}
	//레벨 카운트
	public int getMaxLevel(int num) {
		int x = 0;
		try {
			con = getCon();
			sql = "select max(reply_level) as max from combd_reply where comu_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			System.out.println(num);
			while(rs.next()) {
				x = rs.getInt("max");
				x++;
				System.out.println("x의 값 : " + x);
			}
			
		}catch (SQLException e) {
			System.out.println("커뮤니티 게시판 맥스레벨 조회중, sql 오류!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("커뮤니티 게시판 맥스레벨 조회중, 오류!");
			e.printStackTrace();
		} finally {
			//자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
		return x;
	}
	//댓글 등록 
	public void InsertReply(int num, String stu_id, String contents, int level) {
		try {
			con = getCon();
			sql = "insert into combd_reply(comu_num, stu_id, reply_contents, reply_level, reply_date) values(?, ?, ?, ?, current_timestamp())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, stu_id);
			pstmt.setString(3, contents);
			pstmt.setInt(4, level);
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("커뮤니티 게시판 맥스레벨 조회중, sql 오류!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("커뮤니티 게시판 맥스레벨 조회중, 오류!");
			e.printStackTrace();
		} finally {
			//자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
	}
	//update댓글
	public void updateReply(String contents, int num,  String id, int level) {
		try {
			con= getCon();
			String sql="update combd_reply set reply_contents = ? where comu_num = ? and stu_id = ? and reply_level = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, contents);
			pstmt.setInt(2, num);
			pstmt.setString(3, id);
			pstmt.setInt(4, level);
			pstmt.executeUpdate();
			
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("업데이트 실패");
			}finally {
				closeDB();
			}
	}
	public void DeleteReply(int num,  String id, int level){ //파라미터로 정보를 받아서 DB에 저장
        try {
            con= getCon();
            sql ="delete from combd_reply where comu_num=? and stu_id = ? and reply_level= ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.setString(2, id);
            pstmt.setInt(3, level);
            pstmt.executeUpdate();


            System.out.println("댓글 삭제 성공");
        } catch (SQLException e) {
            System.out.println("댓글 삭제 sql 실패");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("댓글 삭제 실패");
            e.printStackTrace();
        } finally {
            //자원해제로 DB 효율성을 높일수있다.
            closeDB();
        }
        
    }
	
//		//댓글 개수 게시판 리스트에 받아오기
//		public void listupdateReply(int id) {
//			try {
//				con = getCon();
//
//				sql = "update community cm set cm.comu_replynum = (select count(reply_num) from combd_reply where comu_num = ?) where cm.comu_num = ?";
//				pstmt = con.prepareStatement(sql);
//
//				pstmt.setInt(1, id);
//				pstmt.setInt(2, id);
//
//				pstmt.executeUpdate();
//				System.out.println("댓글 개수 가져오기 성공");
//			} catch (SQLException e) {
//				System.out.println("sql구문땜시 별 변경 실패");
//				e.printStackTrace();
//			} catch (Exception e) {
//				System.out.println("댓글 개수 가져오기 실패");
//				e.printStackTrace();
//			} finally {
//				// 자원해제로 DB 효율성을 높일수있다.
//				closeDB();
//			}
//		}
}
