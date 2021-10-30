package Acount;

public class acount {
	private String id;
	private String username;
	private String password;
	private String admin;
	private String tel;
	public acount(String id , String username , String password , String admin , String tel){
		this.id=id;
		this.username=username;
		this.password=password;
		this.admin=admin;
		this.tel=tel;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
