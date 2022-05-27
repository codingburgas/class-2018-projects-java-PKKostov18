package controller;

import menus.*;
import utils.ConsoleUtils;
import services.MovieService;

public class ViewAllMoviesController{
	
	//private LoggedUserManagementController loggedUserManagementController = new LoggedUserManagementController();
	
	private static ViewAllMoviesController instance = null;
	private final MovieService movieService;
	
	public ViewAllMoviesController() {
		this.movieService = MovieService.getInstance();
    }
	
	public static ViewAllMoviesController getInstance(){

        if (ViewAllMoviesController.instance == null) {
        	ViewAllMoviesController.instance = new ViewAllMoviesController();
		}

        return ViewAllMoviesController.instance;
    }
	
	public void viewAllMovies() {
		
		ListMenu.AllMoviesMenu();
		
		System.out.println();
		
		movieService.displayAllMovieNames();
		
		ConsoleUtils.write("Please type the name of the movie you want more info about: ");
		String movieName = ConsoleUtils.read();
		movieService.displayMovieByMovieName(movieName);

		while(movieService.isMovieNameValid() == null) {
			
			System.out.println();
			
			ErrorMenu.invalidMovieName();
			
			ConsoleUtils.write("Please type the name of the movie you want more info about: ");
			movieName = ConsoleUtils.read();
			
			movieService.displayMovieByMovieName(movieName);
		}
		
		ConsoleUtils.writeLine("Do you want to see another movie info or you want to go back: "); 
		ConsoleUtils.writeLine("1 for see another movie info");
		ConsoleUtils.writeLine("2 for back"); 
		ConsoleUtils.write("Choose: "); int option = ConsoleUtils.readInteger();
		System.out.println();
		
		while(option != 1) {
			ErrorMenu.invalidDataError();
			ConsoleUtils.writeLine("Do you want to see another movie info or you want to go back: "); 
			ConsoleUtils.writeLine("1 for see another movie info");
			ConsoleUtils.writeLine("2 for back"); 
			ConsoleUtils.write("Choose: "); option = ConsoleUtils.readInteger();
			System.out.println();
		}
		
		if(option == 1) {
			viewAllMovies();
		} 
		else if(option == 2) {
			//loggedUserManagementController.run();
		}	
	}
}
