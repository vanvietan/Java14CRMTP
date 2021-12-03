package cybersoft.backend.java14.crm.model;

import java.sql.Date;

public class Project {
	//Attribute
	private int id;
	private String name;
	private Date start_date;
	private Date end_date;
	private String description;
	private int create_user;
	private int status;
	
	
	public Project() {
		
	}
	public Project(int id, String name, Date start_date, Date end_date, String description, int create_user, int status) {
		this.id = id;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
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
	public int getCreate_user() {
		return create_user;
	}
	public void setCreate_user(int userId) {
		this.create_user = userId;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
