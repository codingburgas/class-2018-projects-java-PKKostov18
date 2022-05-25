package services;

import repositories.UserRepository;
import utils.PasswordManager;

public class RegisterService {
	
	private final UserRepository usersRepository;
	private static RegisterService instance = null;
	
	public static RegisterService getInstance() {

        if (RegisterService.instance == null) {
        	RegisterService.instance = new RegisterService();
		}

        return RegisterService.instance;
    }
	
	private RegisterService() {
        this.usersRepository = UserRepository.getInstance();
    }

	public void insertUser(String firstName, String lastName, String email, String username, String password) {
		
		String salt = PasswordManager.getNextSalt();
		password = PasswordManager.hash(password.toCharArray(), salt);
		
		usersRepository.insertUser(firstName, lastName, email, username, password, salt, false);
	}
}