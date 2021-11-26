package cybersoft.backend.java14.crm.model;

import java.sql.Date;

public class Project {
	//Attribute
	private int id;
	private String name;
	private Date start_date;
	private Date end_date;
	private String description;
	private User create_user = new User();
	//Constructor
	public Project() {
		
	}
	public Project(int id, String name, Date start, Date end, String description, User create_user) {
		this.id = id;
		this.name = name;
		this.start_date = start;
		this.end_date = end;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getStart_date() {
		return start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getCreate_user() {
		return create_user;
	}
	public void setCreate_user(User create_user) {
		this.create_user = create_user;
	}
	
	
}
