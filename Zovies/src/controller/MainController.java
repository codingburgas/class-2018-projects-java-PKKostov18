package controller;

import menus.WelcomePageMenu;
import menus.UnvalidInputErrorMenu;

import utils.ConsoleUtils;
import services.AuthenticationService;
import java.util.*;

public class MainController {
	
	private AuthenticationController authController  = new AuthenticationController();
	private RegisterController register = new RegisterController();
	private WelcomePageMenu welcomeMenu = new WelcomePageMenu();
	private UnvalidInputErrorMenu errorMenu = new UnvalidInputErrorMenu();
	
	private AuthenticationService authService;
	
	public MainController() {
        this.authService = AuthenticationService.getInstance();
    }

	public void run() {

		String optionForAccount;
		
		ConsoleUtils.write(welcomeMenu.WelcomePage());
		
		 optionForAccount=ConsoleUtils.read();
		
		while(Integer.parseInt(optionForAccount)!=1 && Integer.parseInt(optionForAccount)!=2)
		{
			
			ConsoleUtils.write(errorMenu.UnvalidInputError());
			
			optionForAccount=ConsoleUtils.read();
		}
		
		if(Integer.parseInt(optionForAccount) == 1) {
			authController .run();
			
			if (authService.getLoggedUser() != null) {

	            /*if (authService.getLoggedUser().isAdmin()) {

	                AdministrationController administrationController = new AdministrationController();
	                administrationController.run();
	            } else {

	                
	            }*/
				
				System.out.println(authService.getLoggedUser());
	            LoggedUserManagementController loggedUserController = 	new LoggedUserManagementController();
	            loggedUserController.run();
	        }
			
		} else if(Integer.parseInt(optionForAccount) == 2) {
			register.run();
		}
	}
}
