package cybersoft.backend.java14.crm.service;

import java.util.List;

import cybersoft.backend.java14.crm.model.User;
import cybersoft.backend.java14.crm.repository.UserRepository;

public class UserService {
	private UserRepository repository;

	public UserService() {
		repository = new UserRepository();
	}

	public List<User> getUsers() {

		return repository.getUsers();
	}

	public boolean addUser(User user) {
		return repository.addUser(user) == 1 ? true : false;
	}

	public boolean removeUser(String email) {
		return repository.deleteUser(email) == 1 ? true : false;
		
	}

	public boolean loginUser(String email, String password) {
		List<User> users = repository.getUsers();
		for(User user : users) {
			if(email.equals(user.getEmail()) && password.equals(user.getPassword())) {
				return true;
			}
			break;
		}
		return false;
	}
}
