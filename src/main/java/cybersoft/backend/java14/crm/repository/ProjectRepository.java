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
import cybersoft.backend.java14.crm.model.Role;
import cybersoft.backend.java14.crm.model.Status;

public class ProjectRepository {
		public List<Project> getProjects(){
			List<Project> projects = new LinkedList<Project>();
			try {
				Connection connection = MySQLConnection.getConnection();
				String query = DbQuery.PROJECT_WITH_ROLE;
				
				PreparedStatement statement = connection.prepareStatement(query);
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()) {
					Project project = new Project();
					project.setId(rs.getInt("project_id"));
					project.setName(rs.getString("project_name"));
					project.setStart_date(rs.getDate("project_start_date"));
					project.setEnd_date(rs.getDate("project_end_date"));
					
					Status status = new Status();
					status.setId(rs.getInt("status_id"));
					status.setName(rs.getString("status_name"));
					status.setDescription(rs.getString("status_description"));
					
//					project.setStatus(status);
					
					
					projects.add(project);
					
				}
			} catch (SQLException e) {
				System.out.println("Không thể kết nối đến cơ sở dữ liệu");
				e.printStackTrace();
			}
			return projects;
		}
			 
		public int addProject(Project project) {
			try {
				Connection connection = MySQLConnection.getConnection();
				String query = DbQuery.ADD_PROJECT;
				PreparedStatement statement = connection.prepareStatement(query);
				 
				statement.setString(1, project.getName());
				statement.setDate(2, project.getStart_date());
				statement.setDate(3, project.getEnd_date());
			
				return statement.executeUpdate();
			} catch(SQLException e) {
				System.out.println("Không thể kết nối đến cơ sở dữ liệu");
				e.printStackTrace();
			}
			return 0;
		}
		
		public int deleteProject(String projectId) {
			try {
				Connection connection = MySQLConnection.getConnection();
				String query = DbQuery.DELETE_PROJECT;
				
				PreparedStatement statement = connection.prepareStatement(query);
				
				statement.setString(1, projectId);
				return statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			}
			return 0;
		}
	}