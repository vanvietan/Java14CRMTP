package cybersoft.backend.java14.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.backend.java14.crm.datasource.MySQLConnection;
import cybersoft.backend.java14.crm.model.Users;

public class UsersRepository {
	
	public static List<Users> getUsers(){
		List<Users> Users = new LinkedList<Users>();
		Connection connection = null;
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT id, email, password, fullname, avatar, role_id FROM Users";
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				// lấy Users ra từ result set là thêm vào list Users
				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setAvatar(rs.getString("avatar"));
				user.setRole_id(rs.getInt("role_id"));
				
				Users.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return Users;
	}
	
	public int addUsers(Users Users) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "INSERT Users VALUE (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, Users.getId());
			statement.setString(2, Users.getEmail());
			statement.setString(3, Users.getPassword());
			statement.setString(4, Users.getFullname());
			statement.setString(5, Users.getAvatar());
			statement.setInt(6, Users.getRole_id());
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int removeUsers(int UsersId) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = "DELETE FROM Users WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, UsersId);
			
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
}
