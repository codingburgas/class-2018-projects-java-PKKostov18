package controller;

import menus.AccountMenus;
import utils.ConsoleUtils;
import repositories.*;
import services.RegisterService;

public class RegisterController {
	

	public void run() {
		
		UserRepository logic = new UserRepository();
			
		int admin = 0;
		
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
        
        ConsoleUtils.write("SALT: ");
        String salt = ConsoleUtils.read();
        
        logic.insertUser(firstName, lastName, email, username, username, salt, admin);
        
		
	}

}
