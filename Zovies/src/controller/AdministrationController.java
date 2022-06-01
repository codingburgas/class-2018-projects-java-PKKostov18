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
					viewAllMoviesOrSeriesByGenre();
					break;
				}
				case 5: {
					viewAllMoviesOrSeriesByActor();
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
	
	private void viewAllMoviesOrSeriesByGenre() {
		MovieController viewAllMoviesOrSeriesByGenre = new MovieController();
		viewAllMoviesOrSeriesByGenre.viewAllMoviesOrSeriesByGenre();
    }
	
	private void viewAllMoviesOrSeriesByActor() {
		MovieController viewAllMoviesOrSeriesByActor = new MovieController();
		viewAllMoviesOrSeriesByActor.viewAllMoviesOrSeriesByActor();
    }
}
