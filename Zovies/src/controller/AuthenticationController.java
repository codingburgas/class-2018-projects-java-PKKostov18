package controller;

import menus.ErrorMenu;
import services.AuthenticationService;
import utils.ConsoleUtils;

public class AuthenticationController {
	
	private final AuthenticationService authService;
	private static AuthenticationController instance = null;

    public static AuthenticationController getInstance(){

        if (AuthenticationController.instance == null) {
        	AuthenticationController.instance = new AuthenticationController();
		}

        return AuthenticationController.instance;
    }
    
    public AuthenticationController(){
        this.authService = AuthenticationService.getInstance();
    }

    public void run(){
    
        while (authService.getLoggedUser() == null) { 

        	ConsoleUtils.writeLine("USERNAME: ");
            String username = ConsoleUtils.read();

            ConsoleUtils.writeLine("PASSWORD: ");
            String password = ConsoleUtils.read();
 
            authService.authenticateUser(username, password);
            
            if(authService.getLoggedUser() == null) {
            	ErrorMenu.invalidDataError();
            }
        }
    }
}
