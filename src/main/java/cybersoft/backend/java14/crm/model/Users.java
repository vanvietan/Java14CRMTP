package cybersoft.backend.java14.crm.model;

public class Users {
	//Attributes
	private int id;
	private String email;
	private String password;
	private String fullname;
	private String avatar;
	private Roles role_id;
	
	//Constructor
	public Users() {
		
	}
	public Users(int id,String email, String password, String fullname, String avatar, Roles role_id) {
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.id = id;
		this.avatar = avatar;
		this.role_id = role_id;
	}
	
	//Getters & Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public void setRole_id(Roles role_id) {
		this.role_id = role_id;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getFullname() {
		return fullname;
	}
	public String getAvatar() {
		return avatar;
	}
	public Roles getRole_id() {
		return role_id;
	}
	
}
