package dto;

public class PageDTOIn 
{
	private int pageNo;  //출력 페이지 번호
	private int pageSize; //페이지의 글 개수 
	private int mode;  //검색 모드
	private String word;  //검색어
	private String type;  //검색 컨텐츠
	
	public PageDTOIn(int pageNo, int pageSize, int mode, String word, String type) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.mode = mode;
		this.word = word;
		this.type = type;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PageDTOIn [pageNo=" + pageNo + ", pageSize=" + pageSize + ", mode=" + mode + ", word=" + word
				+ ", type=" + type + "]";
	}
	
	
}
