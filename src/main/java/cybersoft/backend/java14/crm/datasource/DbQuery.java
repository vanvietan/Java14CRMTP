package cybersoft.backend.java14.crm.datasource;

public class DbQuery {
	
	/* USER */
	public static final String USER_WITH_ROLE = "SELECT u.id as user_id, u.name as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description FROM crm_user u LEFT JOIN crm_role r ON  u.role = r.id";

	public static final String ADD_USER = "INSERT INTO crm_user (address, email, name, password, phone, role) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String DELETE_USER= "DELETE FROM crm_user WHERE email = ?";
	public static final String FIND_USER ="SELECT * FROM crm_user WHERE email = ?";
	public static final String GET_USER_NAME_BY_ID = "SELECT name FROM crm_user WHERE id = ?";
	public static final String GET_USER_ID_BY_EMAIL = "SELECT id FROM crm_user WHERE email = ?";
	/* USER UPDATE */
	public static final String CHANGE_NAME = "UPDATE crm_user SET name = ? WHERE email = ?";
	public static final String CHANGE_EMAIL = "UPDATE crm_user SET email = ? WHERE email = ?";
	public static final String CHANGE_PASSWORD = "UPDATE crm_user SET password = ? WHERE email = ?";
	public static final String CHANGE_PHONE = "UPDATE crm_user SET phone = ? WHERE email = ?";
	public static final String CHANGE_ADDRESS = "UPDATE crm_user SET address = ? WHERE email = ?";


	
	/* ROLE CHANGE */
	public static final String ROLE_TO_ADMIN = "UPDATE crm_user SET role = 1 WHERE email = ?";
	public static final String ROLE_TO_MANAGER = "UPDATE crm_user SET role = 2 WHERE email = ?";
	public static final String ROLE_TO_USER = "UPDATE crm_user SET role = 3 WHERE email = ?";



  
	/* TASK */
	public static final String TASK_LIST = "SELECT t.id as task_id, t.assignee as task_assignee, t.name as task_name, t.description as task_description, t.start_date as task_start_date, t.end_date as task_end_date, t.project as task_project, t.status as task_status, prj.id as project_id, prj.name as project_name, prj.description as project_description, prj.start_date as project_start_date, prj.end_date as project_end_date, prj.create_user as project_create_user, stt.id as status_id, stt.name as status_name, stt.description as status_description, u.id as user_id, u.name as user_name, u.email as user_email, u.password as user_password, u.phone as user_phone, u.address as user_address, u.role as user_role FROM crm_task t LEFT JOIN crm_status stt ON t.status = stt.id LEFT JOIN crm_project prj ON t.project = prj.id LEFT JOIN crm_user u ON t.assignee = u.id";
	public static final String ADD_TASK = "INSERT INTO crm_task (name, description, start_date, end_date, assignee, project, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String REMOVE_TASK = "DELETE FROM crm_task WHERE id = ?";
	public static final String UPDATE_ASSIGNEE = "UPDATE crm_task SET assignee = ? WHERE id = ?";

	/* PROJECT */
	public static final String ADD_PROJECT = "INSERT INTO crm_project (name, description, start_date, end_date) VALUES (?, ?, ?, ?)";
	public static final String REMOVE_PROJECT = "DELETE FROM crm_task WHERE id = ?";
}
