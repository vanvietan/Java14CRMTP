package cybersoft.backend.java14.crm.service;

import java.util.List;

import cybersoft.backend.java14.crm.model.Project;
import cybersoft.backend.java14.crm.model.User;
import cybersoft.backend.java14.crm.repository.ProjectRepository;

public class ProjectService {
	private ProjectRepository repository;

	public ProjectService() {
		repository = new ProjectRepository();
	}

	public List<Project> getProjects() {
		return repository.getProjects();
	}

	public boolean addProject(Project Project) {
		return repository.addProject(Project) == 1 ?true: false;
	}

	public boolean deleteProject(int ProjectId) {
		return true;
	}
	
	public int getUserId(User email) {
		return repository.getUserId(email);
	}
}