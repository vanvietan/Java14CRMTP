package cybersoft.backend.java14.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.backend.java14.crm.datasource.DbQuery;
import cybersoft.backend.java14.crm.datasource.MySQLConnection;
import cybersoft.backend.java14.crm.model.Role;
import cybersoft.backend.java14.crm.model.User;

public class UserRepository {
	/* SHOW LIST */
	public List<User> getUsers() {
		List<User> users = new LinkedList<User>();
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.USER_WITH_ROLE;
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("user_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				
				Role role = new Role();
				role.setId(rs.getInt("role_id"));
				
				user.setRole(role);
				
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} 
		
		return users;
	}
	
	/* CREATE USER */
	public int addUser(User user) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.ADD_USER;
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, user.getAddress());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getName());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getPhone());

			statement.setInt(6, 3);						

			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/* DELETE USER */
	public int deleteUser(String userEmail) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.DELETE_USER;
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, userEmail);
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}

	/* FIND USER */
	public List<User> findUser(String emailSession) {
		List<User> users = new LinkedList<User>();
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.FIND_USER;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, emailSession);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				
				users.add(user);
			}
			
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		
		}
		
		return users;
	}
	/* USER CHANGE NAME */
	public int changeName(String changeName , String emailSession) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.CHANGE_NAME;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, changeName);
			statement.setString(2, emailSession);
			return statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return 0;
	}
	/* USER CHANGE EMAIL */
	public int changeEmail(String changeEmail, String emailSession) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.CHANGE_EMAIL;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, changeEmail);
			statement.setString(2, emailSession);
			return statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return 0;
	}
	/* USER CHANGE PASSWORD */
	public int changePassword(String changePassword, String emailSession) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.CHANGE_PASSWORD;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, changePassword);
			statement.setString(2, emailSession);
			return statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}		
		return 0;
	}
	/* USER CHANGE PHONE */
	public int changePhone(String changePhone, String emailSession) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.CHANGE_PHONE;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, changePhone);
			statement.setString(2, emailSession);
			return statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}		
		return 0;
	}
	/* USER CHANGE ADDRESS */
	public int changeAddress(String changeAddress, String emailSession) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.CHANGE_ADDRESS;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, changeAddress);
			statement.setString(2, emailSession);
			return statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}				
		return 0;
	}

	/* ROLE CHANGE TO ADMIN */
	public int changeToAdmin(String email) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.ROLE_TO_ADMIN;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			return statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
      e.printStackTrace();
    }
    return 0;
  }
	/* ROLE CHANGE TO MANAGER */
	public int changeToManager(String email) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.ROLE_TO_MANAGER;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			return statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}		
		return 0;
	}
	/* ROLE CHANGE TO USER */
	public int changeToUser(String email) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.ROLE_TO_USER;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			return statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}		
		return 0;
	}
	
	/* GET LOGIN USER NAME BY ID */
	public String getUserNameById(int userId) {
		String userName = null;
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.GET_USER_NAME_BY_ID;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			
			userName = rs.getString("name");	
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return userName;
	}	
	
	/* GET USER ID BY EMAIL */
	public int getUserIdByEmail(String userEmail) {
		int userId = 0;
		try {
			Connection connection = MySQLConnection.getConnection();
			
			String query = DbQuery.GET_USER_ID_BY_EMAIL;
			PreparedStatement statementIdByEmail = connection.prepareStatement(query);
			statementIdByEmail.setString(1, userEmail);
			ResultSet rsIdByEmail = statementIdByEmail.executeQuery();		
		
			userId = rsIdByEmail.getInt("id");	
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return userId;
	}	
}
