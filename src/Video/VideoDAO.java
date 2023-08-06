package Video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class VideoDAO {
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
	
	public ArrayList<VideoDTO> getAllCM(int lec_id) {
		ArrayList<VideoDTO> ss = new ArrayList<VideoDTO>();
		try {
			con = getCon();
			sql = "select lec_id, cm_chtitle, lec_url, lec_level from cm where lec_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, lec_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int lec_id1 = rs.getInt("lec_id");
				String cm_chtitle = rs.getString("cm_chtitle");
				String lec_url = rs.getString("lec_url");
				int lec_level = rs.getInt("lec_level");
				VideoDTO vd = new VideoDTO(lec_id1, cm_chtitle, lec_url, lec_level);
				ss.add(vd);
				System.out.println("조회한 동영상 CM테이블 값: " + ss);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("동영상 테이블 조회 실패");
		}finally {
			closeDB();
		}
		return ss;
	}
	
	public String getUrl(int id, int level) {
        String ss = null;
        try {
            con = getCon();
            sql = "select lec_url from cm where lec_id = ? and lec_level = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, level);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                String lec_url = rs.getString("lec_url");
                ss = lec_url;
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("url dao 검색 실패");
        }finally {
            closeDB();
        }
        return ss;
    }
	
	public int getLevelCount(int id) {
        int ss = 0;
        try {
            con = getCon();
            sql = "select max(lec_level) as level from cm where lec_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int level = rs.getInt("level");
                ss = level;
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("level max dao 검색 실패");
        }finally {
            closeDB();
        }
        return ss;
    }
	
	public String getTitle(int id, int level) {
        String ss = null;
        try {
            con = getCon();
            sql = "select cm_chtitle from cm where lec_id = ? and lec_level = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, level);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                String cm_chtitle = rs.getString("cm_chtitle");
                ss = cm_chtitle;
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("cm_chtitle dao 검색 실패");
        }finally {
            closeDB();
        }
        return ss;
    }
	
}
