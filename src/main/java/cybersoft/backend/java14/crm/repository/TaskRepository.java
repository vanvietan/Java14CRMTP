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
			String query = DbQuery.TASK_LIST;

			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("task_id"));
				task.setName(rs.getString("task_name"));
				task.setDescription(rs.getString("task_description"));
				task.setStart_date(rs.getDate("task_start_date"));
				task.setEnd_date(rs.getDate("task_end_date"));

				task.setAssignee(rs.getInt("task_assignee"));
				
				task.setProject(rs.getInt("task_project"));
				
				task.setStatus(rs.getInt("task_status"));
				tasks.add(task);
			}	
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} 

		return tasks;
	}
	
	public List<Task> getTaskInProject(int projectId) {
		List<Task> tasks = new LinkedList<Task>();
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.TASK_LIST_BY_PROJECT;
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, projectId);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("task_id"));
				task.setName(rs.getString("task_name"));
				task.setDescription(rs.getString("task_description"));
				task.setStart_date(rs.getDate("task_start_date"));
				task.setEnd_date(rs.getDate("task_end_date"));
					
				task.setAssignee(rs.getInt("task_assignee"));
				
				task.setProject(rs.getInt("task_project"));
				
				task.setStatus(rs.getInt("task_status"));
				
				
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
			/* ASSIGNEE */
			statement.setInt(5, 1);
			/* PROJECT */
			statement.setInt(6, task.getProject());
			
			statement.setInt(7, 3);
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
	
	public int updateAssignee(int userId, int taskId) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.UPDATE_ASSIGNEE;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, userId);
			statement.setInt(2, taskId);
			return statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}
		return 0;
	}
}