package cybersoft.backend.java14.crm.service;

import java.util.List;

import cybersoft.backend.java14.crm.model.User;
import cybersoft.backend.java14.crm.repository.UserRepository;

public class UserService {
	private UserRepository repository;

	public UserService() {
		repository = new UserRepository();
	}
	
	/* SHOW LIST*/
	public List<User> getUsers() {

		return repository.getUsers();
	}
	
	/* CREATE USER */
	public boolean addUser(User user) {
		return repository.addUser(user) == 1 ? true : false;
	}
	
	/* REMOVE USER */
	public boolean removeUser(String email) {
		return repository.deleteUser(email) == 1 ? true : false;
		
	}
	
	/* LOGIN USER */
	public boolean loginUser(String email, String password) {
		List<User> users = repository.getUsers();
		for(User user : users) {
			if(email.equals(user.getEmail()) && password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	/* FIND USER */
	public List<User> findUser(String emailSession) {
		
		return repository.findUser(emailSession);
	}
	
	/* CHANGE NAME */
	public boolean changeName(String changeName , String emailSession) {
		return repository.changeName(changeName , emailSession) == 1 ? true : false;	
	}
	/* CHANGE EMAIL */
	public boolean changeEmail(String changeEmail, String emailSession) {
		return repository.changeEmail(changeEmail , emailSession) == 1 ? true : false;	
		
	}
	/* CHANGE PASSWORD */
	public boolean changePassword(String changePassword, String emailSession) {
		return repository.changePassword(changePassword , emailSession) == 1 ? true : false;	
		
	}
	/* CHANGE PHONE */
	public boolean changePhone(String changePhone, String emailSession) {
		return repository.changePhone(changePhone , emailSession) == 1 ? true : false;	
		
	}

	public boolean changeAddress(String changeAddress, String emailSession) {
		return repository.changeAddress(changeAddress , emailSession) == 1 ? true : false;	
		
	}
}
