package controller;

import menus.AdminMenu;
import menus.ErrorMenu;
import services.AuthenticationService;
import utils.ConsoleUtils;

public class AdministrationController {
	
	private final AuthenticationService authenticationService;
	
	public AdministrationController() {
		this.authenticationService = AuthenticationService.getInstance();
		
	}
	
	public void run() {		
		
		ConsoleUtils.writeNewLine();
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
				case 6: {
					insertMovieOrSeries();
					break;
				}
				case 7: {
					deleteMovieOrSeries();
					break;
				}
				case 8: {
					
					break;
				}
				case 9: {
					
					break;
				}
				case 21: {
					authenticationService.destroySession();
					backToMainMenu();
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
	
	private void insertMovieOrSeries() {
		MovieController insertMovieOrSeries = new MovieController();
		insertMovieOrSeries.insertMovieOrSeries();
    }
	
	private void deleteMovieOrSeries() {
		MovieController deleteMovieOrSeries = new MovieController();
		deleteMovieOrSeries.deleteMovieOrSeries();
    }
	
	private void backToMainMenu() {
		MainController mainController = new MainController();
		mainController.run();
    }
}
