package cybersoft.backend.java14.crm.model;

import cybersoft.backend.java14.crm.model.Roles;

public class Users {
	//Attributes
	private int id;
	private String email;
	private String password;
	private String fullname;
	private String avatar;
	private int role_id;
	private Roles role;
	
	//Constructor
	public Users() {
		role = new Roles();
		id = role.getId();
	}
	public Users(int id,String email, String password, String fullname, String avatar, int role_id) {
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
	public void setRole_id(int role_id) {
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
	public int getRole_id() {
		return role_id;
	}
	
}
