package dto;

public class BoardDTOOut 
{
	private int num;
	private String type;
	private String title; 
	private String content; 
	private String mainphoto;
	private String map;
	private int nice;
	private int count;
	private String reg_date;
	private String level;
	public BoardDTOOut(int num, String type, String title, String content, String mainphoto, String map, int nice,
			int count, String reg_date,String level) 
	{
		super();
		this.num = num;
		this.type = type;
		this.title = title;
		this.content = content;
		this.mainphoto = mainphoto;
		this.map = map;
		this.nice = nice;
		this.count = count;
		this.reg_date = reg_date;
		this.level= level;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
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
