package notice;

import java.sql.Date;
import java.sql.Timestamp;

public class notice {

	private int no_id;
	private String admin_id;
	private String no_title;
	private String no_content;
	private Date no_date;
	
	public notice() {
		
	}
	
	
	public notice(int no_id, String admin_id, String no_title,String no_content,Date no_date) {
	this.no_id=no_id;
	this.admin_id=admin_id;
	this.no_title=no_title;
	this.no_content=no_content;
	this.no_date=no_date;
	}
	
	
	public int getNo_id() {
		return no_id;
	}
	public void setNo_id(int no_id) {
		this.no_id = no_id;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getNo_title() {
		return no_title;
	}
	public void setNo_title(String no_title) {
		this.no_title = no_title;
	}
	public String getNo_content() {
		return no_content;
	}
	public void setNo_content(String no_content) {
		this.no_content = no_content;
	}


	public Date getNo_date() {
		return no_date;
	}


	public void setNo_date(Date no_date) {
		this.no_date = no_date;
	}

	
	
}
	
	
	
	
	
	
	
