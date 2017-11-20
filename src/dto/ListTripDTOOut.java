package dto;

public class ListTripDTOOut 
{
	private int num;
	private String title;
	private int count;
	private String reg_date;
	private String type;
	private String level;
	public ListTripDTOOut(int num, String title, int count, String reg_date, String type, String level) {
		super();
		this.num = num;
		this.title = title;
		this.count = count;
		this.reg_date = reg_date;
		this.type= type;
		this.level=level;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
