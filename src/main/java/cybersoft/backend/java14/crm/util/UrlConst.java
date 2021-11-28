package cybersoft.backend.java14.crm.util;

public class UrlConst {

	

	//Url Connection
	final public static String HEALTH="/health";
	final public static String DB_CHECK="/db-check";
	
	final public static String ROOT = "/*";
	final public static String USER_LIST = "/userlist";
	final public static String HOME = "/home";
	final public static String LOGIN = "/login";
	final public static String SIGNUP = "/signup";
	
	//Auth Connection
	public static final String AUTH_LOGIN = "/log-in";
	public static final String AUTH_LOGOUT = "/log-out";
	
	//User
	public static final String USER_DASHBOARD = "/user";
	public static final String USER_ADD = "/user/add";
	public static final String USER_DELETE = "/user/delete";
	
	//User Update
	public static final String USER_UPDATE = "/user-update";
	public static final String USER_UPDATE_NAME ="/user-update/name";
	public static final String USER_UPDATE_EMAIL ="/user-update/email";
	public static final String USER_UPDATE_PASSWORD ="/user-update/password";
	public static final String USER_UPDATE_PHONE ="/user-update/phone";
	public static final String USER_UPDATE_ADDRESS ="/user-update/address";
	
	//User Management
	public static final String USER_MANAGEMENT="/management";
	public static final String USER_MANAGEMENT_ROLE_EDIT = "/management/role-edit";
	
	//Role
	public static final String ROLE_EDIT ="/role-edit";
}
