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

	public boolean deleteUser(int id) {
		return true;
		/* return repository.addUser(userId) == 1 ? true:false; */
	}
}
