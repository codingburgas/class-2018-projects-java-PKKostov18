package controller;

import menus.AdminMenu;
import menus.ErrorMenu;
import utils.ConsoleUtils;

public class AdministrationController {
	
	public void run() {		
		
		AdminMenu.adminMenu();
		
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
					viewAllFavourites();
					break;
				}
				case 4: {
					
					break;
				}
				case 5: {
					
					break;
				}
	
				default:
					ErrorMenu.invalidInputError(); choice = ConsoleUtils.readInteger();
			}
		}	
	}
	
	private void viewAllMovies() {
		MovieController viewAllMoviesController = new MovieController();
		viewAllMoviesController.viewAllMovies();
    }
	
	private void viewAllSeries() {
		MovieController viewAllSeriesController = new MovieController();
		viewAllSeriesController.viewAllSeries();
    }
	
	private void viewAllFavourites() {
		MovieController viewAllFavouritesController = new MovieController();
		viewAllFavouritesController.viewFavourites();
    }
}
