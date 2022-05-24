package services;

import java.util.List;
import models.User;
import repositories.UserRepository;
import utils.PasswordManager;

public class UserService {
	
	private final UserRepository usersRepository;
    private static UserService instance = null;
    
	public static UserService getInstance(){

        if (UserService.instance == null) {
        	UserService.instance = new UserService();
        	createInitialUser();
		}

        return UserService.instance;
    }

    private UserService() {
        this.usersRepository = UserRepository.getInstance();
    }
    
    private static void createInitialUser(){
        String adminpass = "adminpass"; 
        User user = new User(999, "Administrator", "Administrator", "admin", "PKKostov18@codingburgas.bg", 
        		"adminpass", PasswordManager.getNextSalt(), 1);
        user.setUsername("admin");
        user.setUsername("admin");
        user.setFirstName("Administrator");
        user.setLastName("Administrator");
        user.setEmail("PKKostov18@codingburgas.bg");
        user.setAdmin(1);
        user.setPassword(PasswordManager.hash(adminpass.toCharArray(), user.getSalt()));
        
        //usersRepository.saveUser(user);
    }

	public List<User> getRegisteredUser(String username, String password){
				
		List<User> users = usersRepository.getRegisteredUser(username, password);
		boolean hashPassword = usersRepository.checkHashPassword(username, password);
		
		if(hashPassword == false) {
			return null;
		}
		
		if(users.isEmpty()) {
			return null;
		} 
		
		return users;
	}

	public boolean getAdminUser(String username) {
		
		boolean adminUser = usersRepository.getAdminUser(username);
		
		if(adminUser == false) {
			return false;
		}
		return true;
	}
}
