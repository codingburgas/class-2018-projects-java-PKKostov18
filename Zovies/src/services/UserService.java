package services;

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
        	//User user = createInitialUser();
        	//usersRepository.save(user);
		}

        return UserService.instance;
    }

    private static User createInitialUser(){
        String adminpass = "adminpass"; 
        String salt = PasswordManager.getNextSalt();
        User user = new User(999, "Administrator", "Administrator", "admin", "admin@codingburgas.bg", 
        		PasswordManager.hash(adminpass.toCharArray(), salt), salt, true);

        return user;
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
