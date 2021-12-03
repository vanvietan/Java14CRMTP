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
import cybersoft.backend.java14.crm.model.User;


public class ProjectRepository {
	public List<Project> getProjects() {
		List<Project> projects = new LinkedList<Project>();
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.TASK_LIST;

			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				Project project = new Project();
				project.setId(rs.getInt("project_id"));
				project.setName(rs.getString("project_name"));
				project.setDescription(rs.getString("project_description"));
				project.setStart_date(rs.getDate("project_start_date"));
				project.setEnd_date(rs.getDate("project_end_date"));
				
				projects.add(project);
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} 
		
		return projects;
	}
	
	public int addProject(Project Project) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.ADD_PROJECT;
			PreparedStatement statement = connection.prepareStatement(query);
			User user = new User();
			statement.setString(1, Project.getName());
			statement.setString(2, Project.getDescription());
			statement.setDate(3, Project.getStart_date());				
			statement.setDate(4, Project.getEnd_date());
			statement.setInt(4, user.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}

		return 0;
	}

	public int removeProject(int ProjectId) {
		try {
			Connection connection = MySQLConnection.getConnection();
			String query = DbQuery.REMOVE_PROJECT;

			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, ProjectId);

			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		}

		return 0;
	}
}