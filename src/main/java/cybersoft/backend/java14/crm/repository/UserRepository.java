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
				role.setName(rs.getString("role_name"));
				role.setDescription(rs.getString("role_description"));
				
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
			statement.setInt(6, 1);						
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
	
	/* LOGIN */
	public int loginUser(String email, String password) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "SELECT * FROM crm_user WHERE email ='" + email + "' AND password ='" + password + "'" ;
			PreparedStatement statement = connection.prepareStatement(query);
			
			return statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Không thể kết nổi đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
}
