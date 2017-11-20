package dto;

public class BoardAlbumDTOIn 
{
	private int link;
	private String picpath;
	private String albumtype;
	public BoardAlbumDTOIn(int link, String picpath, String albumtype) {
		super();
		this.link = link;
		this.picpath = picpath;
		this.albumtype = albumtype;
	}
	public String getAlbumType() {
		return albumtype;
	}
	public void setAlbumType(String albumtype) {
		this.albumtype = albumtype;
	}
	public int getLink() {
		return link;
	}
	public void setLink(int link) {
		this.link = link;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	
	
	
	
	
	
	

}
