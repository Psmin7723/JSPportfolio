package dto;

public class ModDTOIn 
{
	private String id; //정보를 수정할 회원의 아이디
	
	private String phone; //새로운 전화번호
	private String email;
	private String pw;
	public ModDTOIn(String id, String phone, String email, String pw) {
		super();
		this.id = id;
		this.phone = phone;
		this.email = email;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}public String getPw() {
		return pw;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} public void setPw(String pw) {
		this.pw = pw;
	} 
}
