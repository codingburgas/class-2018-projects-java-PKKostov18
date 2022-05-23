package services;

import java.util.List;

import models.User;
import repositories.UserRepository;

public class AuthenticationService {
	
	private final UserService userService;
    private static AuthenticationService instance = null;

    public static AuthenticationService getInstance() {

        if (AuthenticationService.instance == null) {
            AuthenticationService.instance = new AuthenticationService();
		}

        return AuthenticationService.instance;
    }

    public AuthenticationService() {
		this.userService = UserService.getInstance();
    }

    private List<User> authenticatedUser = null;

    public List<User> getLoggedUser() {
        return authenticatedUser;
    }

    public void authenticateUser(String username, String password) {
        this.authenticatedUser = userService.getRegisteredUser(username, password);
    }

    private boolean isAdmin;
    
    public boolean isAdmin() {
        return isAdmin;
    }
    
    public void getAdmin(String username, String password) {
        this.isAdmin = userService.getAdminUser(username, password);
    }
}
