package services;

import models.User;

public class AuthenticationService {
	
	private static AuthenticationService instance = null;
	private final UserService userService;
    
	private User authenticatedUser = null;
	
	private AuthenticationService() {
		this.userService = UserService.getInstance();
    }
	
    public static AuthenticationService getInstance() {

        if (AuthenticationService.instance == null) {
            AuthenticationService.instance = new AuthenticationService();
		}

        return AuthenticationService.instance;
    }

    public User getLoggedUser() {
        return authenticatedUser;
    }

    public void authenticateUser(String username, String password) {
        this.authenticatedUser = userService.getRegisteredUser(username, password);
    }
    
    public void destroySession() {
    	authenticatedUser = null;  	
    }
}
