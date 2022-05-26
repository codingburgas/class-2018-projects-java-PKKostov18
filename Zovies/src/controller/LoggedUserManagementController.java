package controller;

import menus.*;
import utils.ConsoleUtils;
import controller.*;

public class LoggedUserManagementController {

	
	int choice;
	
	public void run() {
		LoggedUserMenu.loggedUser();
		
		choice = ConsoleUtils.readInteger();
		
		
		if(choice == 1) {
		ViewAllMoviesController.ViewAllMoviesController();
		}
	}
}

