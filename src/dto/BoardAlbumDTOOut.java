package dto;

public class BoardAlbumDTOOut 
{
	private int link;
	private String picPath;
	private int alNum;
	private String albumtype;
	public BoardAlbumDTOOut(int alNum,int link, String picPath,String albumtype) {
		super();
		this.link = link;
		this.picPath = picPath;
		this.alNum = alNum;
		this.albumtype=albumtype;
	}



	public String getAlbumtype() {
		return albumtype;
	}



	public void setAlbumtype(String albumtype) {
		this.albumtype = albumtype;
	}



	public int getAlNum() {
		return alNum;
	}

	public void setAlNum(int alNum) {
		this.alNum = alNum;
	}

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	

	
	
}
