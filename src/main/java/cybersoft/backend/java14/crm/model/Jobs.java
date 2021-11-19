package cybersoft.backend.java14.crm.model;

import java.sql.Date;

public class Jobs {
	//Attribute
	private int id;
	private String name;
	private Date start_date;
	private Date end_date;
	
	//Constructor
	public Jobs() {
		
	}
	public Jobs(int id,String name, Date start, Date end) {
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
	
	
}
