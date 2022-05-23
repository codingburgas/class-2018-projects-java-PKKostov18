package controller;

import menus.AccountMenus;
import menus.ErrorMenus;
import services.AuthenticationService;
import utils.ConsoleUtils;

public class AuthenticationController {
	
	private ErrorMenus errorMenu = new ErrorMenus();
	private final AuthenticationService authService;
	
	private static AuthenticationController instance = null;

    public static AuthenticationController getInstance() {

        if (AuthenticationController.instance == null) {
        	AuthenticationController.instance = new AuthenticationController();
		}

        return AuthenticationController.instance;
    }
    
    public AuthenticationController() {
        this.authService = AuthenticationService.getInstance();
    }

    public void run() {

        while (authService.getLoggedUser() == null) { 

        	//ConsoleUtils.write(AccountMenus.Login());
        	
        	ConsoleUtils.write("USERNAME: ");
            String username = ConsoleUtils.read();

            ConsoleUtils.write("PASSWORD: ");
            String password = ConsoleUtils.read();

            authService.authenticateUser(username, password);
            
            if(authService.getLoggedUser() == null) {
            	ConsoleUtils.write(errorMenu.UnvalidDataError());
            }
        }

    }
}
