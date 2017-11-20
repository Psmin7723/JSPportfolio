package dto;

public class MemDTOIn 
{
	private String agree;
	private String agree2;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String phone;
	private String phone2;
	private String email;
	private String address;
	private String birth;
	private Double tall;
	private Double weight;
	private Double arm;
	private Double leg;
	private Double waist;
	public MemDTOIn(String agree, String agree2, String id, String pw, String name, String gender, String phone,
			String phone2, String email, String address, String birth, String tall, String weight, String arm,
			String leg, String waist) {
		super();
		this.agree = agree;
		this.agree2 = agree2;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.phone2 = phone2;
		this.email = email;
		this.address = address;
		this.birth = birth;
		
		if(tall.equals("")==true)
			{
				this.tall = Double.parseDouble(tall+0.0);	
			}else
			{
				this.tall = Double.parseDouble(tall);
			}
		if(weight.equals("")==true)	
			{
				this.weight = Double.parseDouble(weight+0.0);
			}else
			{
				this.weight = Double.parseDouble(weight);
			}
		if(arm.equals("")==true)	
			{
				this.arm = Double.parseDouble(arm+0.0);
		}else
			{
				this.arm = Double.parseDouble(arm);
			}
		if(leg.equals("")==true)	
			{
				this.leg = Double.parseDouble(leg+0.0);
		}else
			{
				this.leg = Double.parseDouble(leg);
			}
		if(waist.equals("")==true)	
			{
			this.waist = Double.parseDouble(waist+0.0);	
		}else
			{
			this.waist = Double.parseDouble(waist);
			}
		
		
		
		
	}
	public String getAgree() {
		
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	public String getAgree2() {
		return agree2;
	}
	public void setAgree2(String agree2) {
		this.agree2 = agree2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Double getTall() {
		return tall;
	}
	public void setTall(Double tall) {
		this.tall = tall;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getArm() {
		return arm;
	}
	public void setArm(Double arm) {
		this.arm = arm;
	}
	public Double getLeg() {
		return leg;
	}
	public void setLeg(Double leg) {
		this.leg = leg;
	}
	public Double getWaist() {
		return waist;
	}
	public void setWaist(Double waist) {
		this.waist = waist;
	}
	
	

}
