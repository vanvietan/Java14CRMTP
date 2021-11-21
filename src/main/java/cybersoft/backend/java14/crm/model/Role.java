package cybersoft.backend.java14.crm.model;

public class Role {
	//Attributes
	private int id;
	private String name;
	private String description;
	
	//Constructor
	public Role(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Role() {
		
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
