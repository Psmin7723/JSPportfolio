package dto;

public class ListContentDTOOut 
{
	private int num;
	private String mainphoto; 
	private String title;
	private String content;
	private int nice;
	private int count;
	private String reg_date;
	public ListContentDTOOut(int num, String mainphoto, String title, String content, int nice, int count,
			String reg_date) {
		super();
		this.num = num;
		this.mainphoto = mainphoto;
		this.title = title;
		this.content = content;
		this.nice = nice;
		this.count = count;
		this.reg_date = reg_date;
		
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMainPhoto() {
		return mainphoto;
	}
	public void setMainPhoto(String photo) {
		this.mainphoto = photo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNice() {
		return nice;
	}
	public void setNice(int nice) {
		this.nice = nice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
}
