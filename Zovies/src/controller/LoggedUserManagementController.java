package controller;

import menus.LoggedUserMenu;
import utils.ConsoleUtils;

public class LoggedUserManagementController {

	private ViewAllMoviesController viewAllMoviesController = new ViewAllMoviesController();
	int choice;
	
	public void run() {
		LoggedUserMenu.loggedUser();
		
		choice = ConsoleUtils.readInteger();
		
		if(choice == 1) {
			viewAllMoviesController.viewAllMovies();
		}
	}
}

