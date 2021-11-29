package cybersoft.backend.java14.crm.model;

import java.sql.Date;

public class Task {
	//Attribute
	public User assignee = new User();
	private int id;
	private String name;
	private String description;
	private Date start_date;
	private Date end_date;
	private Status status;
	private Project project;
	
	//Constructor
	public Task() {
		
	}
	
	//Getters & Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStart_date(Date startDate) {
		this.start_date = startDate;
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
	
	public Task(int id, String name, String description, Date start_date, Date end_date, Status status, Project project, User assigne) {

	}

	public User getAssignee() {
		return assignee;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Status getStatus() {
		return status;
	}
	
	
}
