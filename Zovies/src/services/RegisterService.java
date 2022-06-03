package services;

import repositories.UserRepository;
import utils.PasswordManager;

public class RegisterService {
	
	private final UserRepository usersRepository;
	private static RegisterService instance = null;
	private boolean correctUser;
	
	private RegisterService() {
        this.usersRepository = UserRepository.getInstance();
    }
	
	public static RegisterService getInstance() {

        if (RegisterService.instance == null) {
        	RegisterService.instance = new RegisterService();
		}

        return RegisterService.instance;
    }
	
	public boolean getCorrectUser() {
        return correctUser;
    }

	public void insertUser(String firstName, String lastName, String email, String username, String password) {
		
		String salt = PasswordManager.getNextSalt();
		password = PasswordManager.hash(password.toCharArray(), salt);
		
		correctUser = usersRepository.insertUser(firstName, lastName, email, username, password, salt, false);
	}
}