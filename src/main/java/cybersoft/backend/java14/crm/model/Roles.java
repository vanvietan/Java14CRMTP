package cybersoft.backend.java14.crm.model;

public class Roles {
	//Attributes
	private int id;
	private String name;
	private String description;
	
	//Constructor
	public Roles() {
		
	}
	
	//Getters & Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
}
