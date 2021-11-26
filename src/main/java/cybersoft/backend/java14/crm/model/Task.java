package cybersoft.backend.java14.crm.model;

import java.util.Date;

public class Task {
	//Attribute
	public User assignee = new User();
	private int id;
	private String name;
	private String description;
	private Long start_date;
	private Long end_date;
	private Status status;
	private Project project;
	
	//Constructor
	public Task() {
		
	}
	
	public Task(int id, String name, String description, Long start_date, Long end_date, Status status, Project project, User assigne) {
		
	}

	//Getters & Setters
	public User getAssignee() {
		return assignee;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getStart_date() {
		return start_date;
	}

	public Long getEnd_date() {
		return end_date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStart_date(Long date) {
		this.start_date = date;
	}

	public void setEnd_date(Long date) {
		this.end_date = date;
	}

	
}
