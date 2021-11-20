package cybersoft.backend.java14.crm.service;

import java.util.ArrayList;
import java.util.List;

import cybersoft.backend.java14.crm.model.Users;
import cybersoft.backend.java14.crm.repository.UsersRepository;

public class UsersService {
	private UsersRepository repository;
	
	public UsersService() {
		repository = new UsersRepository();
	}
	
	public boolean addUsers(Users user) {
		return repository.addUsers(user) == 1? true: false;
	}
	
	public boolean removeUsers(int id) {
		return repository.removeUsers(id) == 1 ? true:false;
	}

	public List<Users> getUsers() {
		return repository.getUsers();
	}
	
}
