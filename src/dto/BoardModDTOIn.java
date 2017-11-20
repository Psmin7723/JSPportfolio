package dto;

public class BoardModDTOIn 
{
	private String title;
	private String content;
	private String mainphoto;
	private String[] subphoto;
	
	public BoardModDTOIn(String title, String content, String mainphoto) {
		super();
		this.title = title;
		this.content = content;
		this.mainphoto = mainphoto;
		
		
		
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
