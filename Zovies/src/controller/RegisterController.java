package controller;

import utils.ConsoleUtils;
import services.RegisterService;
import menus.ErrorMenus;

public class RegisterController {
	
	private ErrorMenus errMenu = new ErrorMenus();
	private final RegisterService regService;
	
	public RegisterController() {
        this.regService = RegisterService.getInstance();
    }
	
	public void run(){
		
		ConsoleUtils.write("FIRST NAME: ");
        String firstName = ConsoleUtils.read();

        ConsoleUtils.write("LAST NAME: ");
        String lastName = ConsoleUtils.read();
        
        ConsoleUtils.write("EMAIL: ");
        String email = ConsoleUtils.read();

        ConsoleUtils.write("USERNAME: ");
        String username = ConsoleUtils.read();
        
        ConsoleUtils.write("PASSWORD: ");
        String password = ConsoleUtils.read();
        
        regService.insertUser(firstName, lastName, email, username, password);
        
	}
}
