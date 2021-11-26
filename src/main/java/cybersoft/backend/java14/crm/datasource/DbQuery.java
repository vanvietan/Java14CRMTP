package cybersoft.backend.java14.crm.datasource;

public class DbQuery {
	
	//User
	public static final String USER_WITH_ROLE = "SELECT u.id as user_id, u.name as user_name, email, password, phone, address, r.id as role_id, r.name as role_name, r.description as role_description FROM crm_user u LEFT JOIN crm_role r ON  u.role = r.id";
	public static final String ADD_USER = "INSERT INTO crm_user (address, email, name, password, phone) VALUES (?, ?, ?, ?, ?)";
	public static final String DELETE_USER= "DELETE FROM crm_user WHERE email = ?";
	public static final String TASK = "SELECT t.id as task_id, assignee, t.name as task_name, t.description as task_description, t.start_date as task_start_date, t.end_date as task_end_date,\r\n"
			+ " prj.id as project_id, prj.name as project_name, prj.description as project_description, prj.start_date as project_start_date, prj.end_date as project_end_date, prj.create_user as project_create_user, \r\n"
			+ " stt.id as status_id, stt.name as status_name, stt.description as status_description\r\n"
			+ " FROM crm_task t LEFT JOIN crm_status stt ON t.status = stt.id LEFT JOIN crm_project prj ON t.project = prj.id";
	public static final String ADD_TASK = "INSERT INTO crm_task (name, description, start_date, end_date) VALUES (?, ?, ?, ?)";
	public static final String REMOVE_TASK = "DELETE FROM crm_task WHERE id = ?";
	/* INSERT INTO crm_roll (name) VALUES (?) */
}
