package cybersoft.backend.java14.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.backend.java14.crm.datasource.DbQuery;
import cybersoft.backend.java14.crm.datasource.MySQLConnection;
import cybersoft.backend.java14.crm.model.Project;
import cybersoft.backend.java14.crm.model.Status;
import cybersoft.backend.java14.crm.model.Task;
import cybersoft.backend.java14.crm.model.User;

public class TaskRepository {
	public List<Task> getTasks() {
		List<Task> tasks = new LinkedList<Task>();
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.TASK;

			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("task_id"));
				task.setName(rs.getString("task_name"));
				task.setDescription(rs.getString("task_description"));
				task.setStart_date(rs.getDate("task_start_date"));
				task.setEnd_date(rs.getDate("task_end_date"));

				Status status = new Status();
				status.setId(rs.getInt("status_id"));;
				status.setName(rs.getString("status_name"));;
				status.setDescription(rs.getString("status_description"));;

				Project project = new Project();
				project.setId(rs.getInt("project_id"));
				project.setName(rs.getString("project_name"));
				project.setDescription(rs.getString("project_description"));
				project.setStart_date(rs.getDate("project_start_date"));
				project.setEnd_date(rs.getDate("project_end_date"));

				User create_user = new User();
				create_user.setId(rs.getInt("user_id"));
				create_user.setName(rs.getString("user_name"));
				create_user.setEmail(rs.getString("email"));
				create_user.setPassword(rs.getString("password"));
				create_user.setPhone(rs.getString("phone"));
				create_user.setAddress(rs.getString("address"));

				tasks.add(task);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} 

		return tasks;
	}

	public int addTask(Task task) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.ADD_TASK;
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, task.getName());
			statement.setString(2, task.getDescription());
			statement.setDate(3, task.getStart_date());				
			statement.setDate(4, task.getEnd_date());

			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}

		return 0;
	}

	public int removeTask(int TaskId) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.REMOVE_TASK;

			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, TaskId);

			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}

		return 0;
	}

}