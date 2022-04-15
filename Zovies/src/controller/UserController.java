package controller;

import services.UserService;
import utils.ConsoleUtils;

public class UserController {
	
	private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void displayUsersWithLongUsernames() {
        
        String someDataFromDatabase = userService.getUsersWithLongUsername();
        
        ConsoleUtils.writeConsoleLine("Displaying data from database: " + someDataFromDatabase);

        ConsoleUtils.writeConsoleLine("Write your name:");
        final String name = ConsoleUtils.readConsoleLine();
        ConsoleUtils.writeConsoleLine("Your name is:" + name);
    }
}
