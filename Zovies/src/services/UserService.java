package services;

import java.util.List;

import models.User;
import repositories.UserRepository;
import utils.PasswordManager;

public class UserService {
	
	private static UserService instance = null;
	private final UserRepository usersRepository;
	
	
    private UserService() {
        this.usersRepository = UserRepository.getInstance();
    }
    
	public static UserService getInstance(){

        if (UserService.instance == null) {
        	UserService.instance = new UserService();
		}

        return UserService.instance;
    }
    
	public List<User> getAllUsers() {
		List<User> users = usersRepository.getAllUsers();
		return users;
	}
	
	public List<User> getAllAdmins() {
		List<User> users = usersRepository.getAllAdmins();
		
		return users;
	}

	public void deleteUserById(int userId) {
		usersRepository.deleteUserById(userId);
	}
	
	public void makeUserAdmin(int userId) {
		usersRepository.makeUserAdminById(userId);
	}
	
	public User getRegisteredUser(String username, String password) {
				
		User user = usersRepository.getRegisteredUser(username);
		
		if(user != null) {
			boolean hashPassword = PasswordManager.isExpectedPassword(password.toCharArray(), user.getSalt(), user.getPassword().toCharArray());
			
			if(hashPassword == false) {
				return null;
			} 
		}
		
		return user;
	}
}
