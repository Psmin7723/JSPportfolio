package dto;

public class FavDTOOut 
{
	private String title;
	private String reg_date;
	private int num;
	
	public FavDTOOut(String title, String reg_date, int num) {
		super();
		this.title = title;
		this.reg_date = reg_date;
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
}
