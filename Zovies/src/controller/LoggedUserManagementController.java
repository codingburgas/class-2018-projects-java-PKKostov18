package controller;

import menus.ErrorMenu;
import menus.LoggedUserMenu;
import utils.ConsoleUtils;

public class LoggedUserManagementController {

	public void run() {
		
		LoggedUserMenu.loggedUser();
		
		int choice = ConsoleUtils.readInteger();
		
		while(true) {
			switch (choice) {
				case 1: {
					viewAllMovies();
					break;
				}
				case 2: {
					viewAllSeries();
					break;
				}
				case 3: {
					
					break;
				}
				case 4: {
					
					break;
				}
				case 5: {
					
					break;
				}
				case 6: {
					
					break;
				}
				case 7: {
					break;
				}
				case 8: {
					
					break;
				}
				case 9: {
					backToMainMenu();
					break;
				}
				default:
					ErrorMenu.invalidInputError();
					choice = ConsoleUtils.readInteger();
					break;
			}
		}
	}
	
	private void viewAllMovies() {
		ViewAllMoviesController viewAllMoviesController = new ViewAllMoviesController();
		viewAllMoviesController.viewAllMovies();
    }
	
	private void viewAllSeries() {
		ViewAllMoviesController viewAllMoviesController = new ViewAllMoviesController();
		viewAllMoviesController.viewAllSeries();
    }
	
	private void backToMainMenu() {
		MainController mainMenu = new MainController();
		mainMenu.run();
    }
}