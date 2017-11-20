package dto;

public class BoardDTOOut2 
{
	private int num;
	private String type;
	private String mainphoto;
	
	public BoardDTOOut2(int num, String type, String mainphoto) {
		super();
		this.num = num;
		this.type = type;
		this.mainphoto = mainphoto;
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

	public String getMainphoto() {
		return mainphoto;
	}

	public void setMainphoto(String mainphoto) {
		this.mainphoto = mainphoto;
	}

	
	
	
}
