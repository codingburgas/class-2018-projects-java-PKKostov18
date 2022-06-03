package controller;

import menus.ErrorMenu;
import services.AuthenticationService;
import utils.ConsoleUtils;

public class AuthenticationController {
	
	private final AuthenticationService authService;
    
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
