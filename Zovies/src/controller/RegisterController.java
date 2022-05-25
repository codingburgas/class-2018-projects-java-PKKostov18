package controller;

import utils.ConsoleUtils;
import services.RegisterService;
import menus.ErrorMenu;

public class RegisterController {
	
	LoggedUserManagementController loggedUserController = new LoggedUserManagementController();
	
	private final RegisterService regService;
	
	int option;
	
	public RegisterController() {
        this.regService = RegisterService.getInstance();
    }
	
	public void run(){
		
		while(regService.getCorrectUser() == false) {
			ConsoleUtils.writeLine("FIRST NAME: ");
	        String firstName = ConsoleUtils.read();
	
	        ConsoleUtils.writeLine("LAST NAME: ");
	        String lastName = ConsoleUtils.read();
	        
	        ConsoleUtils.writeLine("E-MAIL: ");
	        String email = ConsoleUtils.read();
	        
	        while(!email.endsWith("@gmail.com") ^ !email.endsWith("@yahoo.com") 
	        		^ !email.endsWith("@hotmail.com") ^ !email.endsWith("@codingburgas.com") 
	        		^ !email.endsWith("@abv.bg")) {
				ErrorMenu.invalidDomain();
				ConsoleUtils.writeLine("E-MAIL: ");
		        email = ConsoleUtils.read();
	        }
	        
	        ConsoleUtils.writeLine("USERNAME: ");
	        String username = ConsoleUtils.read();
	        
	        ConsoleUtils.writeLine("PASSWORD: ");
	        String password = ConsoleUtils.read();
	        
	        regService.insertUser(firstName, lastName, email, username, password);   
	        
	        if(regService.getCorrectUser() == false) {
	        	ErrorMenu.invalidUsername();
	        }
		}
		
		loggedUserController.run();
	}
}
