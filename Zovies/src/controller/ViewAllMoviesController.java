package controller;

import menus.*;
import models.Movie;
import utils.ConsoleUtils;
import services.MovieService;

public class ViewAllMoviesController{
	
	private final MovieService movieService;
	
	Movie movie = null;
	
	public ViewAllMoviesController() {
		this.movieService = MovieService.getInstance();
    }
	
	public void viewAllMovies() {
		
		ListMenu.AllMoviesMenu();
		
		movieService.displayAllMovieNames();
		
		ConsoleUtils.write("Please type the name of the movie you want more info about: "); String movieName = ConsoleUtils.read();
	    movie = movieService.displayMovieByMovieName(movieName);
		
		if(movie != null) {
			displayMovieSeriesInfo(movie);
		}

		while(movieService.displayMovieByMovieName(movieName) == null) {
			
			ErrorMenu.invalidMovieName();
			
			ConsoleUtils.write("Please type the name of the movie you want more info about: ");
			movieName = ConsoleUtils.read();
			
			movie = movieService.displayMovieByMovieName(movieName);

			if(movie != null) {
				displayMovieSeriesInfo(movie);
			}
		}
		
		ConsoleUtils.writeLine("Do you want to see another movie info or you want to go back: "); 
		ConsoleUtils.writeLine("1 for see another movie info");
		ConsoleUtils.writeLine("2 for back"); 
		ConsoleUtils.write("Choose: "); int option = ConsoleUtils.readInteger();
		System.out.println();
		
		while(true) {
			switch (option) {
				case 1: {
					viewAllMovies();
					break;
				}
				case 2: {
					backToUserMenu();
					break;
				}
				default:
					ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
			}	
		}	
	}
	
	public void viewAllSeries() {
		
		ListMenu.AllMoviesMenu();
		
		movieService.displayAllSeriesNames();
		
		ConsoleUtils.write("Please type the name of the series you want more info about: "); String seriesName = ConsoleUtils.read();
	    movie = movieService.displayMovieByMovieName(seriesName);
		
		if(movie != null) {
			displayMovieSeriesInfo(movie);
		}

		while(movieService.displayMovieByMovieName(seriesName) == null) {
			
			ErrorMenu.invalidMovieName();
			
			ConsoleUtils.write("Please type the name of the series you want more info about: ");
			seriesName = ConsoleUtils.read();
			
			movie = movieService.displayMovieByMovieName(seriesName);

			if(movie != null) {
				displayMovieSeriesInfo(movie);
			}
		}
		
		ConsoleUtils.writeLine("Do you want to see another series info or you want to go back: "); 
		ConsoleUtils.writeLine("1 for see another series info");
		ConsoleUtils.writeLine("2 for back"); 
		ConsoleUtils.write("Choose: "); int option = ConsoleUtils.readInteger();
		System.out.println();
		
		while(true) {
			switch (option) {
				case 1: {
					viewAllSeries();
					break;
				}
				case 2: {
					backToUserMenu();
					break;
				}
				default:
					ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
			}	
		}	
	}
	
	private void backToUserMenu() {
		LoggedUserManagementController loggedUserManagementController = new LoggedUserManagementController();
		loggedUserManagementController.run();
    }
	
	private void displayMovieSeriesInfo(Movie movie) {
		ConsoleUtils.writeNewLine();
		ConsoleUtils.writeLine("____________________________________________________________________________________________________________________________________");
		ConsoleUtils.writeLine("                                                                  ");
		ConsoleUtils.writeLine("                            " + this.movie.getMovieName() +"        ");
		ConsoleUtils.writeLine("____________________________________________________________________________________________________________________________________");
		ConsoleUtils.writeLine("                Type: " + this.movie.getMovieOrSeries() + "    |    " + "Number of seasons: " + this.movie.getNumberOfSeasons());
		ConsoleUtils.writeLine("____________________________________________________________________________________________________________________________________");

		ConsoleUtils.writeLine("                       Year of publishing: " + this.movie.getYearOfPublishing());
		ConsoleUtils.writeLine("____________________________________________________________________________________________________________________________________");
		ConsoleUtils.writeLine("                                                                  ");
		ConsoleUtils.writeLine("                            Description                           ");
		ConsoleUtils.writeLine("                                                                  ");
		ConsoleUtils.writeLine(this.movie.getDescription());
		ConsoleUtils.writeLine("____________________________________________________________________________________________________________________________________");
		ConsoleUtils.writeLine("                                                                  ");
		ConsoleUtils.writeLine("                       Production Company: " + this.movie.getCompany());
		ConsoleUtils.writeLine("                       Duration: " + this.movie.getDuration() + " min");
		ConsoleUtils.writeLine("                       IMDB_score: " + this.movie.getIMDB_score());
		ConsoleUtils.writeLine("____________________________________________________________________________________________________________________________________");
		ConsoleUtils.writeNewLine();
    }
}
