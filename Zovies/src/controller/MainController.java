package controller;
import utils.ConsoleUtils;
import services.AuthenticationService;
import java.util.*;

public class MainController {
	
	private AuthenticationController authController  = new AuthenticationController();
	private RegisterController register = new RegisterController();
	
	private AuthenticationService authService;
	
	public MainController() {
        this.authService = AuthenticationService.getInstance();
    }

	public void run() {

		String optionForAccount;
		
		ConsoleUtils.write("+------------------------------------------------------------------+");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("|                        WELCOME TO ZOVIES                         |");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("+------------------------------------------------------------------+");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("|                      DO YOU HAVE AN ACCOUNT?                     |");
		ConsoleUtils.write("|        __________________________________________________        |");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("|                             1. Yes                               |");
		ConsoleUtils.write("|                             2. No                                |");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("+------------------------------------------------------------------+");
		
		System.out.print("Choose: "); optionForAccount=ConsoleUtils.read();
		
		while(Integer.parseInt(optionForAccount)!=1 && Integer.parseInt(optionForAccount)!=2)
		{
			ConsoleUtils.write("+------------------------------------------------------------------+");
			ConsoleUtils.write("|                   Please enter a valid option!                   |");
			ConsoleUtils.write("+------------------------------------------------------------------+");
			
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
