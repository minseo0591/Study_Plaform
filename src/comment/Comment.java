package comment;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Comment {
	private int co_num;
	private int lec_id;
	private String stu_id;
	private String co_comment;
	private int co_rating;
	private Timestamp co_date;
	
	public Comment(int co_num, int lec_id, String stu_id, String co_comment, int co_rating, Timestamp co_date) {
		this.co_num = co_num;
		this.lec_id = lec_id;
		this.stu_id = stu_id;
		this.co_comment = co_comment;
		this.co_rating = co_rating;
		this.co_date = co_date;
	}

	public int getCo_num() {
		return co_num;
	}

	public void setCo_num(int co_num) {
		this.co_num = co_num;
	}

	public int getLec_id() {
		return lec_id;
	}

	public void setLec_id(int lec_id) {
		this.lec_id = lec_id;
	}

	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getCo_comment() {
		return co_comment;
	}

	public void setCo_comment(String co_comment) {
		this.co_comment = co_comment;
	}

	public int getCo_rating() {
		return co_rating;
	}

	public void setCo_rating(int co_rating) {
		this.co_rating = co_rating;
	}

	public Timestamp getCo_date() {
		return co_date;
	}

	public void setCo_date(Timestamp co_date) {
		this.co_date = co_date;
	}
	
	
}
