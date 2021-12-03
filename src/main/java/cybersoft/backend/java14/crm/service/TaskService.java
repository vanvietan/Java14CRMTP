package cybersoft.backend.java14.crm.service;

import java.util.List;

import cybersoft.backend.java14.crm.model.Task;
import cybersoft.backend.java14.crm.repository.TaskRepository;

public class TaskService {
	private TaskRepository repository;

	public TaskService() {
		repository = new TaskRepository();
	}

	public List<Task> getTasks() {
		return repository.getTasks();
	}

	public boolean addTask(Task task) {
		return repository.addTask(task) == 1 ?true: false;
	}

	public boolean deleteTask(int taskId) {
		return true;
	}
	
	public boolean updateAssignee(int taskId, int userId) {
		return repository.updateAssignee(taskId , userId) == 1 ? true : false;	
	}
}