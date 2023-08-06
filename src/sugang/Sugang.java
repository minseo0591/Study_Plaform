package sugang;

import java.util.Date;

public class Sugang {
	private int su_num;
	private String stu_id;
	private int lec_id;
	private String lec_title;
	private Date su_date;
	
	public Sugang() {
		
	}
	public Sugang(String stu_id, int lec_id, String lec_title) {
		this.stu_id = stu_id;
		this.lec_id = lec_id;
		this.lec_title = lec_title;
	}
	
	public Sugang(String lec_title, Date su_date) {
		this.lec_title = lec_title;
		this.su_date = su_date;
	}
	
	public Sugang(int lec_id, String lec_title, Date su_date) {
		this.lec_id = lec_id;
		this.lec_title = lec_title;
		this.su_date = su_date;
	}
	
	public Sugang(String stu_id, int lec_id, String lec_title, Date su_date) {
		this.stu_id = stu_id;
		this.lec_id = lec_id;
		this.lec_title = lec_title;
		this.su_date = su_date;
	}
	
	public int getSu_num() {
		return su_num;
	}
	public void setSu_num(int su_num) {
		this.su_num = su_num;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public int getLec_id() {
		return lec_id;
	}
	public void setLec_id(int lec_id) {
		this.lec_id = lec_id;
	}
	public String getLec_title() {
		return lec_title;
	}
	public void setLec_title(String lec_title) {
		this.lec_title = lec_title;
	}
	public Date getSu_date() {
		return su_date;
	}
	public void setSu_date(Date su_date) {
		this.su_date = su_date;
	}
	
	public int last_lecid;
	public String last_title;
	public Date last_date;

	public String getLast_title() {
		return last_title;
	}
	public void setLast_title(String last_title) {
		this.last_title = last_title;
		System.out.println("들어온 last_title :" + last_title);
		System.out.println("변경된 this last_title :" + this.last_title);
	}
	public Date getLast_date() {
		return last_date;
	}
	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}
	public int getLast_lecid() {
		return last_lecid;
	}
	public void setLast_lecid(int last_lecid) {
		this.last_lecid = last_lecid;
	}
	
}
