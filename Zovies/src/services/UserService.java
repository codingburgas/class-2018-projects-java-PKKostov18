package services;

import java.util.List;
import java.util.stream.Collectors;

import models.User;
import repositories.UserRepository;
import utils.PasswordManager;

public class UserService {
	
	private final UserRepository usersRepository;
    private static UserService instance = null;
    
	public static UserService getInstance() {

        if (UserService.instance == null) {
        	UserService.instance = new UserService();
        	createInitialUser();
		}

        return UserService.instance;
    }

    private UserService() {
        this.usersRepository = UserRepository.getInstance();
    }
    
    private static void createInitialUser() {
        String adminpass = "adminpass"; 
        User user = new User("Administrator", "Administrator", "admin", "PKKostov18@codingburgas.bg", 
        		"adminpass", PasswordManager.getNextSalt(), 1);
        user.setUsername("admin");
        user.setSalt(PasswordManager.getNextSalt()); 
        user.setFirstName("Administrator");
        user.setLastName("Administrator");
        user.setEmail("PKKostov18@codingburgas.bg");
        user.setAdmin(1);
        user.setPassword(PasswordManager.hash(adminpass.toCharArray(), user.getSalt()));
        
        //usersRepository.saveUser(user);
    }

	public User getRegisteredUser(String username, String password) {
		List<User> users = usersRepository.getRegisteredUser(username, password);
		return (User) users;
	}
}
