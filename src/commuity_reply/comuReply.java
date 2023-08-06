package commuity_reply;

import java.util.Date;

public class comuReply {
	private int reply_num;
	private int comu_num;
	private String stu_id;
	private String reply_contents;
	private int reply_level;
	private Date reply_date;
	
	public comuReply() {
		
	}
	
	public comuReply(int comu_num,String stu_id,String reply_contents, int reply_level, Date reply_date) {
		this.comu_num = comu_num;
		this.stu_id = stu_id;
		this.reply_contents = reply_contents;
		this.reply_level = reply_level;
		this.reply_date = reply_date;
	}
	
	public int getReply_num() {
		return reply_num;
	}
	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
	}
	public int getComu_num() {
		return comu_num;
	}
	public void setComu_num(int comu_num) {
		this.comu_num = comu_num;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getReply_contents() {
		return reply_contents;
	}
	public void setReply_contents(String reply_contents) {
		this.reply_contents = reply_contents;
	}
	public int getReply_level() {
		return reply_level;
	}
	public void setReply_level(int reply_level) {
		this.reply_level = reply_level;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	
}
