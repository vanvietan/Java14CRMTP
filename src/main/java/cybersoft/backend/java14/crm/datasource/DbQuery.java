package cybersoft.backend.java14.crm.datasource;

public class DbQuery {
	
	//User
	public static final String USER_WITH_ROLE = "SELECT u.id as user_id, u.name as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description FROM crm_user u LEFT JOIN crm_role r ON  u.role = r.id";
	public static final String ADD_USER = "INSERT INTO crm_user (address, email, name, password, phone) VALUES (?, ?, ?, ?, ?)";
	public static final String DELETE_USER= "DELETE FROM crm_user WHERE email = ?";
	/* INSERT INTO crm_roll (name) VALUES (?) */
	
	// Project
	public static final String PROJECT_WITH_ROLE = "SELECT p.id as project_id, p.name as project_name, stare_date, end_date, r.id as role_id, r.name as role_name, r.description as role_description FROM crm_user u LEFT JOIN crm_role r ON  u.role = r.id";
	public static final String ADD_PROJECT = "INSERT INTO crm_user (name, start, end) VALUES (?, ?, ?)";
	public static final String DELETE_PROJECT= "DELETE FROM crm_user WHERE id = ?";
}
