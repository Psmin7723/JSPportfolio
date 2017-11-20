package dto;

public class ReplyDTOOut {

	private int num;
	private String id;
	
	private String content;
	private String reg_date;
	
	public ReplyDTOOut(int num,String id,String content, String reg_date) {
		super();
		
		this.id = id;
		this.content = content;
		this.reg_date = reg_date;
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
