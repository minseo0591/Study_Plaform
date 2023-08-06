package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lecture.lecture;

public class MemberDAO {
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
	
	//3. 회원가입처리 (외부에서 접근가능해야하니까 public)
		public void insertMember(Member mb){ //파라미터로 정보를 받아서 DB에 저장
			try {
				//3-1. DB연결메서드 불러오기
				con = getCon();
				//3-2. SQL & pstmt 생성 & 실행
				sql = "insert into members value(?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mb.getStu_id());
				pstmt.setString(2, mb.getStu_pwd());
				pstmt.setString(3, mb.getStu_name());
				
				pstmt.executeUpdate();
				System.out.println("회원가입성공");
			} catch (SQLException e) {
				System.out.println("sql구문땜시 회원가입실패");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("회원가입실패");
				e.printStackTrace();
			} finally {
				//자원해제로 DB 효율성을 높일수있다.
				closeDB();
			}
		}//insertMember닫힘
		
		//4. 로그인메서드
		// DB에서 해당 값이 있는지 체크하고 결과를 리턴
		// 정수형 데이터값 사용(1-정상처리, 0-비번오류, (-1)-아이디가없음)
		public int idCheack(Member mb){
			int result = -1;
			try {
				//4-1. 드라이브로드 디비연결
				con = getCon();
				//4-2. SQL & pstmt 생성
				sql = "select stu_pwd from members where stu_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mb.getStu_id());
				//4-3. 실행 -> rs저장
				rs = pstmt.executeQuery();
				//4-4. 데이터 처리
				//왜 while이 아닌 if인가? where절에서 id는 pk조건을 가지고 있으므로 중복이 없기때문 
				if(rs.next()){
					if(mb.getStu_pwd().equals(rs.getString("stu_pwd"))){
						result = 1;
					}else{
						result = 0;
					}
				}else{
					result = -1;
				}	
				System.out.println(" DAO : 로그인처리완료 "+result);
			} catch (Exception e) {
				e.printStackTrace();
			} finally { //4-6. 자원해제
				closeDB();
			}
			return result;
		}//idCheck닫힘
		
		//회원 전체 조회
		public ArrayList<Member> memberlist(int page, int limit) {
			ArrayList<Member> mblist = new ArrayList<>();
			
			// 조회범위
			int startrow = (page-1) * 10;	// ex )  0, 16, 32 , 48 ...
			int endrow = limit;  			// ex ) limit 만큼 리스트에 나열
			
			try {
				con = getCon();
				sql = "select * from members order by stu_id desc limit ?, ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String stu_id = rs.getString("stu_id");
					String stu_pwd = rs.getString("stu_pwd");
					String stu_name = rs.getString("stu_name");
					
					Member mbdto = new Member(stu_id,stu_pwd,stu_name);
					mblist.add(mbdto);
					System.out.println("강의 전체 조회 성공");
//					System.out.println("limit : " + limit);
//					System.out.println("startrow : " + startrow);
				}
				return mblist;
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
		
		// 회원 목록 총 갯수
		public int getListCount() {
			int count = 0;  // 총 개수를 리턴하기 위한 변수
			try {
				con= getCon();
				String sql ="select count(*) from members"; // 총 개수를 조회하기 위한 쿼리
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
		
}
