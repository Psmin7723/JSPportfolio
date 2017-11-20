package dto;

public class ListMainDTOOut 
{
	private int num;
	private String title;
	private String content;
	private String mainphoto;
	private String type;
	public ListMainDTOOut(int num, String title, String content, String mainphoto,String type) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.mainphoto = mainphoto;
		this.type = type;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMainphoto() {
		return mainphoto;
	}
	public void setMainphoto(String mainphoto) {
		this.mainphoto = mainphoto;
	}
	
	
}
