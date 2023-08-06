package lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class lectureDAO {
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

	//3. 강의등록 처리 (외부에서 접근가능해야하니까 public)
	public void insertlecture(lecture lc ,cm cm,String[] url, String[] chti){ //파라미터로 정보를 받아서 DB에 저장
		try {
			int y;
			//3-1. DB연결메서드 불러오기
			con = getCon();
			//3-2. SQL & pstmt 생성 & 실행
			String max1 ="select max(lec_id) from lecture"; 
			PreparedStatement pstmt3 = con.prepareStatement(max1);
			rs= pstmt3.executeQuery();
			while(rs.next()) {
				
				int x=rs.getInt("max(lec_id)");
				y=x;
				
				sql = "insert into lecture value(?,?,?,?,?,CURRENT_TIMESTAMP(),?,?,?,?,?,?,?)";
				String sql2 ="insert into cm value(?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt2 = con.prepareStatement(sql2);
				
				pstmt.setInt(1, y+1);
				pstmt.setInt(2, lc.getLec_code());
				pstmt.setString(3, lc.getLec_title());
				pstmt.setString(4, lc.getLec_lecturer());
				pstmt.setString(5, lc.getLec_thum());
				pstmt.setString(6, lc.getLec_sectiona());
				pstmt.setString(7, lc.getLec_contenta());
				pstmt.setString(8, lc.getLec_sectionb());
				pstmt.setString(9, lc.getLec_contentb());
				pstmt.setString(10, lc.getLec_category());
				pstmt.setString(11, lc.getLec_replynum());
				pstmt.setString(12, lc.getLec_staravg());
				
				
				
				pstmt2.setInt(1, cm.getCm_id());
				pstmt2.setInt(2,y+1);
				pstmt2.setString(3, cm.getCm_chtitle());
				pstmt2.setString(4,	cm.getLec_url());
				pstmt2.setString(5, cm.getLec_level());
			
				
				int x1 = pstmt.executeUpdate();
				if(x1 == 1) {
					for(int i =0; i<1;i++) {
						for(int j=0; j<url.length; j++) {
							pstmt2.setInt(1, cm.getCm_id());
							pstmt2.setInt(2,y+1);
							pstmt2.setString(3, chti[j]);
							pstmt2.setString(4,	url[j]);
							pstmt2.setInt(5, j+1);
							System.out.println(url.length);
							pstmt2.executeUpdate();
						}
					}
					
				}
			}
			
			System.out.println("강의등록 성공");
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
			
			//3-1. 강의 전체 조회
//			public ArrayList<lecture> Classlist() {
//				ArrayList<lecture> lclist = new ArrayList<lecture>();
//				Connection connection = null;
//				PreparedStatement preparedStatement = null;
//				ResultSet resultSet = null;
//				
//				try {
//					con = getCon();
//					sql = "select * from lecture order by lec_id desc";
//					pstmt = con.prepareStatement(sql);
//					rs = pstmt.executeQuery();
//					
//					while(rs.next()) {
//						int lec_id = rs.getInt("lec_id");
//						int lec_code = rs.getInt("lec_code");
//						String lec_title = rs.getString("lec_title");
//						String lec_lecturer = rs.getString("lec_lecturer");
//						String lec_thum = rs.getString("lec_thum");
//						String lec_sectiona = rs.getString("lec_sectiona");
//						String lec_contenta = rs.getString("lec_contenta");
//						String lec_sectionb = rs.getString("lec_sectionb");
//						String lec_contentb = rs.getString("lec_contentb");
//						
//						lecture lcdto = new lecture(lec_id, lec_code, lec_title , lec_lecturer, lec_thum ,lec_sectiona,lec_contenta, lec_sectionb, lec_contentb);
//						lclist.add(lcdto);
//						System.out.println("강의 전체 조회 성공");
//					}
//				} catch (SQLException e) {
//					System.out.println("sql구문땜시 조회 실패");
//					e.printStackTrace();
//				} catch (Exception e) {
//					System.out.println("강의 전체 조회 실패");
//					e.printStackTrace();
//				} finally {
//					//자원해제로 DB 효율성을 높일수있다.
//					closeDB();
//				}
//				return lclist;
//			}
			
			
			//3-1. 강의 전체 조회
			public ArrayList<lecture> Classlist(int page, int limit) {
				ArrayList<lecture> lclist = new ArrayList<>();
				
				// 조회범위
				int startrow = (page-1) * 16;	// ex )  0, 16, 32 , 48 ...
				int endrow = limit;  			// ex ) limit 만큼 리스트에 나열
				
				try {
					con = getCon();
					sql = "select * from lecture order by lec_id desc limit ?, ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, startrow);
					pstmt.setInt(2, endrow);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						int lec_id = rs.getInt("lec_id");
						int lec_code = rs.getInt("lec_code");
						String lec_title = rs.getString("lec_title");
						String lec_lecturer = rs.getString("lec_lecturer");
						String lec_thum = rs.getString("lec_thum");
						String lec_sectiona = rs.getString("lec_sectiona");
						String lec_contenta = rs.getString("lec_contenta");
						String lec_sectionb = rs.getString("lec_sectionb");
						String lec_contentb = rs.getString("lec_contentb");
						String lec_category = rs.getString("lec_category");
						String lec_replynum = rs.getString("lec_replynum");
						String lec_staravg = rs.getString("lec_staravg");
						
						lecture lcdto = new lecture(lec_id, lec_code, lec_title , lec_lecturer, lec_thum ,lec_sectiona,lec_contenta, lec_sectionb, lec_contentb, lec_category, lec_replynum, lec_staravg);
						lclist.add(lcdto);
						System.out.println("강의 전체 조회 성공");
//						System.out.println("limit : " + limit);
//						System.out.println("startrow : " + startrow);
					}
					return lclist;
				} catch (SQLException e) {
					System.out.println("sql구문땜시 조회 실패");
					e.printStackTrace();
				} catch (Exception e) {
					System.out.println("강의 전체 조회 실패");
					e.printStackTrace();
				} finally {
					//자원해제로 DB 효율성을 높일수있다.
					closeDB();
				}
				return null;
			}
			
			// 게시글 총 갯수
			public int getListCount() {
				int count = 0;  // 총 개수를 리턴하기 위한 변수
				try {
					con= getCon();
					String sql ="select count(*) from lecture"; // 총 개수를 조회하기 위한 쿼리
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

			
			
			
			//강의 세부 값 가져오기
			public leccm getClassPage(int lec_id) throws Exception{
				leccm lccm= null;
				String sql="SELECT * FROM lecture LEFT outer JOIN cm ON lecture.lec_id = cm.lec_id where lecture.lec_id =?";	
				try {
					con = getCon();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, lec_id);
					rs = pstmt.executeQuery();

				ArrayList<String> x = new ArrayList<String>();
				while(rs.next()) {
						int lec_code= rs.getInt("lec_code");
						String lec_title = rs.getString("lec_title");
						String lec_lecturer = rs.getString("lec_lecturer");
						String lec_thum = rs.getString("lec_thum");
						String lec_sectiona = rs.getString("lec_sectiona");
						String lec_contenta = rs.getString("lec_contenta");
						String lec_sectionb = rs.getString("lec_sectionb");
						String lec_contentb = rs.getString("lec_contentb");
						String lec_category = rs.getString("lec_category");
						String lec_replynum = rs.getString("lec_replynum");
						String lec_staravg = rs.getString("lec_staravg");
						String cm_chtitle= rs.getString("cm_chtitle");	
						String lec_url =rs.getString("lec_url");
						String lec_level = rs.getString("lec_level");
						x.add(cm_chtitle);
						lccm = new leccm(lec_id, lec_code, lec_title , lec_lecturer, lec_thum ,lec_sectiona,lec_contenta, lec_sectionb, lec_contentb , lec_category,lec_replynum, lec_staravg, cm_chtitle,lec_url,lec_level,x);
					}
				
				for(int i=0; i<x.size(); i++) {
					System.out.println(x.get(i));
				}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					closeDB();
				}
				return lccm;
				}
			
			
			//강의 검색 조회
			public ArrayList<lecture> ClasslistSearch(int page, int limit, String keyWord, String searchWord) {
				ArrayList<lecture> lclist = new ArrayList<>();
				
				// 조회범위
				int startrow = (page-1) * 16;	// ex )  0, 16, 32 , 48 ...
				int endrow = limit;  			// ex ) limit 만큼 리스트에 나열
				
				try {
					con = getCon();
					sql = "select * from lecture where " + keyWord+ " like ?";
					sql += "order by lec_id desc limit ?, ?";
					System.out.println(keyWord +"/"+ searchWord); //값이 잘 넘어오는지 확인
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%"+searchWord+"%");
					pstmt.setInt(2, startrow);
					pstmt.setInt(3, endrow);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						int lec_id = rs.getInt("lec_id");
						int lec_code = rs.getInt("lec_code");
						String lec_title = rs.getString("lec_title");
						String lec_lecturer = rs.getString("lec_lecturer");
						String lec_thum = rs.getString("lec_thum");
						String lec_sectiona = rs.getString("lec_sectiona");
						String lec_contenta = rs.getString("lec_contenta");
						String lec_sectionb = rs.getString("lec_sectionb");
						String lec_contentb = rs.getString("lec_contentb");
						String lec_category = rs.getString("lec_category");
						String lec_replynum = rs.getString("lec_replynum");
						String lec_staravg = rs.getString("lec_staravg");
						
						lecture lcdto = new lecture(lec_id, lec_code, lec_title , lec_lecturer, lec_thum ,lec_sectiona,lec_contenta, lec_sectionb, lec_contentb, lec_category, lec_replynum, lec_staravg);
						lclist.add(lcdto);
						System.out.println("강의 검색 조회 성공");
					}
					return lclist;
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
			public int getListSearchCount(String keyWord, String searchWord) {
			int count = 0;  // 총 개수를 리턴하기 위한 변수
			try {
				con= getCon();
				String sql ="select count(*) as count from lecture where " + keyWord + " like ?"; // 총 개수를 조회하기 위한 쿼리
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
			
			//카테고리 검색 조회
			public ArrayList<lecture> ClasslistCategory(int page, int limit, String category) {
				ArrayList<lecture> lclist = new ArrayList<>();
				
				// 조회범위
				int startrow = (page-1) * 16;	// ex )  0, 16, 32 , 48 ...
				int endrow = limit;  			// ex ) limit 만큼 리스트에 나열
				
				try {
					con = getCon();
					sql = "select * from lecture where lec_category like ?";
					sql += "order by lec_id desc limit ?, ?";
					System.out.println("카테고리 값은 : " + category); //값이 잘 넘어오는지 확인
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%"+ category +"%");
					pstmt.setInt(2, startrow);
					pstmt.setInt(3, endrow);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						int lec_id = rs.getInt("lec_id");
						int lec_code = rs.getInt("lec_code");
						String lec_title = rs.getString("lec_title");
						String lec_lecturer = rs.getString("lec_lecturer");
						String lec_thum = rs.getString("lec_thum");
						String lec_sectiona = rs.getString("lec_sectiona");
						String lec_contenta = rs.getString("lec_contenta");
						String lec_sectionb = rs.getString("lec_sectionb");
						String lec_contentb = rs.getString("lec_contentb");
						String lec_category = rs.getString("lec_category");
						String lec_replynum = rs.getString("lec_replynum");
						String lec_staravg = rs.getString("lec_staravg");
						
						lecture lcdto = new lecture(lec_id, lec_code, lec_title , lec_lecturer, lec_thum ,lec_sectiona,lec_contenta, lec_sectionb, lec_contentb, lec_category, lec_replynum, lec_staravg);
						lclist.add(lcdto);
						System.out.println("강의 카테고리 조회 성공");
					}
					return lclist;
				} catch (SQLException e) {
					System.out.println("sql구문땜시 조회 실패");
					e.printStackTrace();
				} catch (Exception e) {
					System.out.println("강의 카테고리 조회 실패");
					e.printStackTrace();
				} finally {
					//자원해제로 DB 효율성을 높일수있다.
					closeDB();
				}
				return null;
			}
			
			// 검색 게시글 총 갯수
			public int ClasslistCategoryCount(String category) {
			int count = 0;  // 총 개수를 리턴하기 위한 변수
			try {
				con= getCon();
				String sql ="select count(*) as count from lecture where lec_category like ?"; // 총 개수를 조회하기 위한 쿼리
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, "%" + category + "%");
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
			
}
