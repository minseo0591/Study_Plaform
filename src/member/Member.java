package member;

public class Member {
	private String stu_id;
	private String stu_pwd;
	private String stu_name;
	
	public Member() {

	}
	
	public Member(String stu_id, String stu_pwd, String stu_name) {
		this.stu_id = stu_id;
		this.stu_pwd = stu_pwd;
		this.stu_name = stu_name;
	}
	
	
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_pwd() {
		return stu_pwd;
	}
	public void setStu_pwd(String stu_pwd) {
		this.stu_pwd = stu_pwd;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	
	@Override
	public String toString() {
		return "Member [stu_id=" + stu_id + ", stu_pwd=" + stu_pwd + ", stu_name=" + stu_name + "]";
	}	
	
}
