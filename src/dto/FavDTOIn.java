package dto;

public class FavDTOIn 
{
	private int num;
	private String type;
	public FavDTOIn(int num, String type) {
		super();
		this.num = num;
		this.type = type;
		
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
