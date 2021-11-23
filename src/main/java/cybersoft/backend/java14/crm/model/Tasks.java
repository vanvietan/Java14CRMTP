package cybersoft.backend.java14.crm.model;

import java.sql.Date;

public class Tasks {
	//Attribute
	private int id;
	private String name;
	private Date start_date;
	private Date end_date;
	private Users user_id;
	private Jobs job_id;
	private Status status_id;
	
	//Constructor
	public Tasks() {
		
	}
	
	//Getters & Setters
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

	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}

	public void setJob_id(Jobs job_id) {
		this.job_id = job_id;
	}

	public void setStatus_id(Status status_id) {
		this.status_id = status_id;
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

	public Users getUser_id() {
		return user_id;
	}

	public Jobs getJob_id() {
		return job_id;
	}

	public Status getStatus_id() {
		return status_id;
	}
	
	
	
}
