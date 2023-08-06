package Video;

public class VideoDTO {
	private int lec_id;
	private String cm_chtitle;
	private String lec_url;
	private int lec_level;
	
	public int getLec_id() {
		return lec_id;
	}
	public void setLec_id(int lec_id) {
		this.lec_id = lec_id;
	}
	public String getCm_chtitle() {
		return cm_chtitle;
	}
	public void setCm_chtitle(String cm_chtitle) {
		this.cm_chtitle = cm_chtitle;
	}
	public String getLec_url() {
		return lec_url;
	}
	public void setLec_url(String lec_url) {
		this.lec_url = lec_url;
	}
	public int getLec_level() {
		return lec_level;
	}
	public void setLec_level(int lec_level) {
		this.lec_level = lec_level;
	}
	
	public VideoDTO(int lec_id, String cm_chtitle, String lec_url, int lec_level) {
		this.lec_id = lec_id;
		this.cm_chtitle = cm_chtitle;
		this.lec_url = lec_url;
		this.lec_level = lec_level;
	}
}
