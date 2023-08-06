package lecture;

import java.sql.Date;

public class lecture {
	private int lec_id;
	private int lec_code;
	private String lec_title;
	private String lec_lecturer;
	private String lec_thum;
	private String lec_date;
	private String lec_sectiona;
	private String lec_contenta;
	private String lec_sectionb;
	private String lec_contentb;
	private String lec_category;
	private String lec_replynum;
	private String lec_staravg;
	
	public lecture(String lec_replynum) {
		this.lec_replynum = lec_replynum;
	}
	
	public lecture() {
	}
	
	public lecture(int lec_id, int lec_code, String lec_title, String lec_lecturer, String lec_thum, String lec_sectiona, String lec_contenta, String lec_sectionb, String lec_contentb, String lec_category, String lec_replynum , String lec_staravg) {
		this.lec_id = lec_id;
		this.lec_code = lec_code;
		this.lec_title = lec_title;
		this.lec_lecturer = lec_lecturer;
		this.lec_thum = lec_thum;
		this.lec_sectiona = lec_sectiona;
		this.lec_contenta = lec_contenta;
		this.lec_sectionb = lec_sectionb;
		this.lec_contentb = lec_contentb;
		this.lec_category = lec_category;
		this.lec_replynum = lec_replynum;
		this.lec_staravg = lec_staravg;
	}

	public int getLec_id() {
		return lec_id;
	}
	public void setLec_id(int lec_id) {
		this.lec_id = lec_id;
	}
	public int getLec_code() {
		return lec_code;
	}
	public void setLec_code(int lec_code) {
		this.lec_code = lec_code;
	}
	public String getLec_title() {
		return lec_title;
	}
	public void setLec_title(String lec_title) {
		this.lec_title = lec_title;
	}
	public String getLec_lecturer() {
		return lec_lecturer;
	}
	public void setLec_lecturer(String lec_lecturer) {
		this.lec_lecturer = lec_lecturer;
	}
	public String getLec_thum() {
		return lec_thum;
	}
	public void setLec_thum(String lec_thum) {
		this.lec_thum = lec_thum;
	}
	public String getLec_date() {
		return lec_date;
	}
	public void setLec_date(String lec_date) {
		this.lec_date = lec_date;
	}
	public String getLec_sectiona() {
		return lec_sectiona;
	}
	public void setLec_sectiona(String lec_sectiona) {
		this.lec_sectiona = lec_sectiona;
	}
	public String getLec_contenta() {
		return lec_contenta;
	}
	public void setLec_contenta(String lec_contenta) {
		this.lec_contenta = lec_contenta;
	}
	public String getLec_sectionb() {
		return lec_sectionb;
	}
	public void setLec_sectionb(String lec_sectionb) {
		this.lec_sectionb = lec_sectionb;
	}
	public String getLec_contentb() {
		return lec_contentb;
	}
	public void setLec_contentb(String lec_contentb) {
		this.lec_contentb = lec_contentb;
	}
	public String getLec_category() {
		return lec_category;
	}
	public void setLec_category(String lec_category) {
		this.lec_category = lec_category;
	}

	public String getLec_replynum() {
		return lec_replynum;
	}

	public void setLec_replynum(String lec_replynum) {
		this.lec_replynum = lec_replynum;
	}
	
	public String getLec_staravg() {
		return lec_staravg;
	}

	public void setLec_staravg(String lec_staravg) {
		this.lec_staravg = lec_staravg;
	}

	@Override
	public String toString() {
		return "lecture [lec_id=" + lec_id + ", lec_code=" + lec_code + ", lec_title=" + lec_title + ", lec_lecturer="
				+ lec_lecturer + ", lec_thum=" + lec_thum + ", lec_date=" + lec_date + ", lec_sectiona=" + lec_sectiona
				+ ", lec_contenta=" + lec_contenta + ", lec_sectionb=" + lec_sectionb + ", lec_contentb=" + lec_contentb
				+ ", lec_category=" + lec_category + ", lec_replynum=" + lec_replynum + ", lec_staravg=" + lec_staravg
				+ "]";
	}
	
}
