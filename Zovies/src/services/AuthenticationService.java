package services;

import models.User;

public class AuthenticationService {
	
	private final UserService userService;
    private static AuthenticationService instance = null;

    public static AuthenticationService getInstance() {

        if (AuthenticationService.instance == null) {
            AuthenticationService.instance = new AuthenticationService();
		}

        return AuthenticationService.instance;
    }

    private AuthenticationService() {
		this.userService = UserService.getInstance();
    }

    private User authenticatedUser = null;

    public User getLoggedUser() {
        return authenticatedUser;
    }

    public void authenticateUser(String username, String password) {
        this.authenticatedUser = userService.getRegisteredUser(username, password);
    }
}
