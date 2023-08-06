package comment;

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

public class CommentDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;
	String sql = "";
	String sql2 = "";

	// 1. DB연결메서드
	public Connection getCon() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/study_platform"); // Context.xml의 주소와 동일해야함
		con = ds.getConnection();
		return con;
	}// end of getCon()

	// 2. 자원해제 메서드 구현
	public void closeDB() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// closeDB()

	public void insertCo(int id, String text, String rating, String stu_id) {
		try {
			con = getCon();

			sql = "insert into comment(lec_id,stu_id, co_comment, co_rating, co_date) value(?,?,?,?,CURRENT_TIMESTAMP())";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, id);
			pstmt.setString(2, stu_id);
			pstmt.setString(3, text);
			pstmt.setString(4, rating);

			pstmt.executeUpdate();
			System.out.println("댓글등록 성공");
		} catch (SQLException e) {
			System.out.println("sql구문땜시 댓글등록 실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("댓글등록 실패");
			e.printStackTrace();
		} finally {
			// 자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
	}
	//댓글 개수 리스트에 받아오기
	public void updateReply(int id) {
		try {
			con = getCon();

			sql = "update lecture l set l.lec_replynum = (select count(co_num) from comment where lec_id = ?)"
					+ " where l.lec_id = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, id);
			pstmt.setInt(2, id);

			pstmt.executeUpdate();
			System.out.println("댓글 개수 가져오기 성공");
		} catch (SQLException e) {
			System.out.println("sql구문땜시 별 변경 실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("댓글 개수 가져오기 실패");
			e.printStackTrace();
		} finally {
			// 자원해제로 DB 효율성을 높일수있다.
			closeDB();
		}
	}

	// 댓글내용
//	public ArrayList<String> getComment(int id) {
//		ArrayList<String> comments = new ArrayList<String>();
//		ArrayList<String> stu_ids = new ArrayList<String>();
//		ArrayList<Integer> ratings = new ArrayList<Integer>();
//		ArrayList<String> dattes = new ArrayList<String>();
//		try {
//			con = getCon();
//			sql = "select * from comment where lec_id = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, id);
//			rs = pstmt.executeQuery();
//			
//			
//			while(rs.next()) {
//				comments.add(rs.getString("co_comment"));
//				stu_ids.add(rs.getString("stu_id"));
//				ratings.add(rs.getInt("co_rating"));
//				dattes.add(rs.getDate("co_date").toString());
//			}
//			Comment com = new Comment();
//			com.setStu_iid(stu_ids);
//			com.setRatting(ratings);	
//			com.setDatttes(dattes);
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("댓글 내용 불러오기 실패");
//		}finally {
//			closeDB();
//		}
//		
//		return comments;
//	}

	public ArrayList<Comment> getss(int id) {
		ArrayList<Comment> see = new ArrayList<>();
		try {
			con = getCon();
			sql = "select * from comment where lec_id = ?";
			System.out.println("매개변수 ID: " + id);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			int i = 0;
			while (rs.next()) {
				int co_num = rs.getInt("co_num");
				int lec_id = rs.getInt("lec_id");
				String stu_id = rs.getString("stu_id");
				String co_comment = rs.getString("co_comment");
				int co_rating = rs.getInt("co_rating");
				Timestamp co_date = rs.getTimestamp("co_date");

//				Comment cm = new Comment(lec_id, stu_id, co_comment, co_rating, co_date);
				see.add(new Comment(co_num, lec_id, stu_id, co_comment, co_rating, co_date));
				System.out.println("조회된 S :" + see.get(i));
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("댓글 내용 불러오기 실패");
		} finally {
			closeDB();
		}

		return see;
	}

	
	//수강평의 갯수
	public int getStarCount(int lec_id) {
		int count = 0; // 총 개수를 리턴하기 위한 변수
		try {
			con = getCon();
			String sql = "select count(*) as count from comment where lec_id=? ";// 총 개수를 조회하기 위한 쿼리

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, lec_id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
				System.out.println("수강평 총 개수" + count);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return count;
	}

	//2.별의 합계 
	public int getSumStar(int lec_id) {
		int sum = 0;
		try {
			con = getCon();
			String sql = "select sum(co_rating) as co_rating from comment where lec_id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, lec_id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				sum = rs.getInt("co_rating");
				System.out.println("별 합계" + sum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return sum;
	}

	//3.별 하나의 갯수 
	public int getPer(int lec_id, int tt) {
		int onesum = 0;
		try {
			con = getCon();
			String sql = "select count(co_rating) as co_rating from comment where lec_id =? and co_rating=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, lec_id);
			pstmt.setInt(2, tt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				onesum = rs.getInt("co_rating");
				System.out.println("별 하나의합계 " + onesum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return onesum;
	}
	
	//별 총 개수 리스트에 받아오기
	public void updateStar(int id) {
			try {
				con = getCon();

				sql = "update lecture l set l.lec_staravg = (select sum(co_rating) from comment where lec_id = ?)"
						+ " where l.lec_id = ?";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, id);
				pstmt.setInt(2, id);

				pstmt.executeUpdate();
				System.out.println("별 총 개수 가져오기 성공");
			} catch (SQLException e) {
				System.out.println("sql구문땜시 별 변경 실패");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("별 총 개수 가져오기 실패");
				e.printStackTrace();
			} finally {
				// 자원해제로 DB 효율성을 높일수있다.
				closeDB();
			}
		}

}
