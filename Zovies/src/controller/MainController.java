package controller;

import menus.WelcomePageMenu;
import menus.*;

import utils.ConsoleUtils;
import services.AuthenticationService;

public class MainController {
	
	private AuthenticationController authController = new AuthenticationController();
	private RegisterController registerController = new RegisterController();
	
	private AuthenticationService authService;
	
	public MainController() {
        this.authService = AuthenticationService.getInstance();
    }

	public void run() {

		int optionForAccount;
		
		WelcomePageMenu.welcomePage();
		
		optionForAccount = ConsoleUtils.readInteger();
		
		while(optionForAccount != 1 && optionForAccount != 2) {
			ErrorMenu.invalidInputError();
			optionForAccount = ConsoleUtils.readInteger();
		}
		
		if(optionForAccount == 1) {
			
			AccountMenu.login();
			authController.run();
			
            if (authService.getLoggedUser().getAdmin()) {

                AdministrationController administrationController = new AdministrationController();
                administrationController.run();
	        } else {
	            LoggedUserManagementController loggedUserController = new LoggedUserManagementController();
	            loggedUserController.run();
	        }  
	        
		} else if(optionForAccount == 2) {
			
			AccountMenu.register();
			registerController.run();
		}
	}
}
