package community;

import java.util.Date;

public class comu {
	private int comu_num;
	private String comu_title;
	private String stu_id;
	private String comu_contents;
	private Date comu_date;
	private String comu_replynum;
	
	public comu() {
		
	}
	
	public comu(int comu_num, String comu_title, String stu_id, String comu_contents, Date comu_date) {
		this.comu_num = comu_num;
		this.comu_title = comu_title;
		this.stu_id = stu_id;
		this.comu_contents = comu_contents;
		this.comu_date = comu_date;
	
	}
	
	
	public String getComu_title() {
		return comu_title;
	}
	public void setComu_title(String comu_title) {
		this.comu_title = comu_title;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getComu_contents() {
		return comu_contents;
	}
	public void setComu_contents(String comu_contents) {
		this.comu_contents = comu_contents;
	}
	public Date getComu_date() {
		return comu_date;
	}
	public void setComu_date(Date comu_date) {
		this.comu_date = comu_date;
	}
	public int getComu_num() {
		return comu_num;
	}
	public void setComu_num(int comu_num) {
		this.comu_num = comu_num;
	}

	public String getComu_replynum() {
		return comu_replynum;
	}

	public void setComu_replynum(String comu_replynum) {
		this.comu_replynum = comu_replynum;
	}
	
	
}
