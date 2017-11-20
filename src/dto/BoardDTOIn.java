package dto;

public class BoardDTOIn 
{
	private String type; //글의 종류 (관광지, 맛집, 특산물)
	private String title;
	private String content;
	private String mainphoto;
	private String level;
	
	
	public BoardDTOIn(String type, String title, String content, String mainphoto, String level) {
		super();
		this.type = type;
		this.title = title;
		this.content = content;
		this.mainphoto = mainphoto;
		this.level = level;
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
