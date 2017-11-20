package dto;

public class BoardAlbumModDTOIn 
{
	private String[] subphoto;
	private int[] alNum;
	private String type;
	private String level;
	
	public BoardAlbumModDTOIn(int[] alNum,String[] subphoto,String type,String level ) {
		super();
		this.subphoto = subphoto;
		this.alNum= alNum;
		this.type=type;
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

	public int[] getAlNum() {
		return alNum;
	}

	public void setAlNum(int[] alNum) {
		this.alNum = alNum;
	}

	public String[] getSubphoto() {
		return subphoto;
	}

	public void setSubphoto(String[] subphoto) {
		this.subphoto = subphoto;
	}
}
