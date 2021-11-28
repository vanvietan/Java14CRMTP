package cybersoft.backend.java14.crm.datasource;

public class DbQuery {
	
	//User
	public static final String USER_WITH_ROLE = "SELECT u.id as user_id, u.name as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description FROM crm_user u LEFT JOIN crm_role r ON  u.role = r.id";
	public static final String ADD_USER = "INSERT INTO crm_user (address, email, name, password, phone) VALUES (?, ?, ?, ?, ?)";
	public static final String DELETE_USER= "DELETE FROM crm_user WHERE email = ?";
	public static final String FIND_USER ="SELECT * FROM crm_user WHERE email = ?";
	
	/* USER UPDATE */
	public static final String CHANGE_NAME = "UPDATE crm_user SET name = ? WHERE email = ?";
	public static final String CHANGE_EMAIL = "UPDATE crm_user SET email = ? WHERE email = ?";
	public static final String CHANGE_PASSWORD = "UPDATE crm_user SET password = ? WHERE email = ?";
	public static final String CHANGE_PHONE = "UPDATE crm_user SET phone = ? WHERE email = ?";
	public static final String CHANGE_ADDRESS = "UPDATE crm_user SET address = ? WHERE email = ?";

}
