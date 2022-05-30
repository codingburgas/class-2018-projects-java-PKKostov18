package controller;

import menus.*;
import models.Movie;
import utils.ConsoleUtils;
import services.AuthenticationService;
import services.MovieService;
import services.UserService;

public class MovieController{
	
	private final MovieService movieService;
	private final AuthenticationService authService;
	
	Movie movie = null;
	
	public MovieController() {
		this.movieService = MovieService.getInstance();
		this.authService = AuthenticationService.getInstance();
    }
	
	public void viewAllMovies() {
		
		ListMenu.allMoviesMenu();
		
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
		
		ConsoleUtils.writeLine("Choose what you want to do: ");  
		ConsoleUtils.writeLine("1 for see another movie info");
		ConsoleUtils.writeLine("2 for favourite"); 
		ConsoleUtils.writeLine("3 for back"); 
		ConsoleUtils.write("Choose: "); int option = ConsoleUtils.readInteger();
		System.out.println();
		
		while(true) {
			switch (option) {
				case 1: {
					viewAllMovies();
					break;
				}
				case 2: {
					movieService.insertFavouriteMovieOrSeries(movie.getMovieId(), authService.getLoggedUser().getUserId());
					ConsoleUtils.writeLine("Successfully added to your favourites!");
					ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
					
					while(option != 1) {
						ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
					}
					backToUserMenu();
					break;
				}
				case 3: {
					backToUserMenu();
					break;
				}
				default:
					ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
			}	
		}	
	}
	
	public void viewAllSeries() {
		
		ListMenu.allSeriesMenu();
		
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
		
		ConsoleUtils.writeLine("Choose what you want to do: "); 
		ConsoleUtils.writeLine("1 for see another series info");
		ConsoleUtils.writeLine("2 for favourite"); 
		ConsoleUtils.writeLine("3 for back"); 
		ConsoleUtils.write("Choose: "); int option = ConsoleUtils.readInteger();
		System.out.println();
		
		while(true) {
			switch (option) {
				case 1: {
					viewAllSeries();
					break;
				}
				case 2: {
					movieService.insertFavouriteMovieOrSeries(movie.getMovieId(), authService.getLoggedUser().getUserId());
					ConsoleUtils.writeLine("Successfully added to your favourites!");
					ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
					
					while(option != 1) {
						ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
					}
					backToUserMenu();
					break;
				}
				case 3: {
					backToUserMenu();
					break;
				}
				default:
					ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
			}	
		}	
	}
	
	public void viewAllActors() {
		
		ListMenu.allMoviesMenu();
		
		movieService.displayAllMovieNames();
		 
		ConsoleUtils.writeLine("Press 1 to go back:"); int option = ConsoleUtils.readInteger();
		System.out.println();
		
		while(true) {
			switch (option) {
				case 1: {
					backToUserMenu();
					break;
				}
				
				default:
					ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
			}	
		}	
	}
	
	public void viewFavourites() {
		
		ListMenu.allFavouritesMenu();
		
		movieService.displayAllFavouriteMoviesAndSeries(authService.getLoggedUser().getUserId());
		
		ConsoleUtils.write("Type 1 to go back: "); int option = ConsoleUtils.readInteger();
		
		while(option != 1) {
			ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
		}
		backToUserMenu();
	}
	
	private void backToUserMenu() {
		LoggedUserManagementController loggedUserManagementController = new LoggedUserManagementController();
		loggedUserManagementController.run();
    }
	
public void viewAllMoviesOrSeriesByGenre() {
		
		ListMenu.allMoviesByGenreMenu();
		
		ConsoleUtils.write("Genre name: "); String genre  = ConsoleUtils.read();
		
		movieService.displayAllMoviesByGenre(genre);
		
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
		
		ConsoleUtils.writeLine("Choose what you want to do: ");  
		ConsoleUtils.writeLine("1 for see another movie info");
		ConsoleUtils.writeLine("2 for favourite"); 
		ConsoleUtils.writeLine("3 for back"); 
		ConsoleUtils.write("Choose: "); int option = ConsoleUtils.readInteger();
		System.out.println();
		
		while(true) {
			switch (option) {
				case 1: {
					viewAllMovies();
					break;
				}
				case 2: {
					movieService.insertFavouriteMovieOrSeries(movie.getMovieId(), authService.getLoggedUser().getUserId());
					ConsoleUtils.writeLine("Successfully added to your favourites!");
					ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
					
					while(option != 1) {
						ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
					}
					backToUserMenu();
					break;
				}
				case 3: {
					backToUserMenu();
					break;
				}
				default:
					ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
			}	
		}	
	}
	
public void viewAllMoviesOrSeriesByActor() {
	
	ListMenu.allMoviesByGenreMenu();
	
	ConsoleUtils.write("Actor name: "); String genre  = ConsoleUtils.read();
	
	movieService.displayAllMoviesByGenre(genre);
	
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
	
	ConsoleUtils.writeLine("Choose what you want to do: ");  
	ConsoleUtils.writeLine("1 for see another movie info");
	ConsoleUtils.writeLine("2 for favourite"); 
	ConsoleUtils.writeLine("3 for back"); 
	ConsoleUtils.write("Choose: "); int option = ConsoleUtils.readInteger();
	System.out.println();
	
	while(true) {
		switch (option) {
			case 1: {
				viewAllMovies();
				break;
			}
			case 2: {
				movieService.insertFavouriteMovieOrSeries(movie.getMovieId(), authService.getLoggedUser().getUserId());
				ConsoleUtils.writeLine("Successfully added to your favourites!");
				ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
				
				while(option != 1) {
					ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
				}
				backToUserMenu();
				break;
			}
			case 3: {
				backToUserMenu();
				break;
			}
			default:
				ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
		}	
	}	
}
	
	
	private void displayMovieSeriesInfo(Movie movie) {
		ConsoleUtils.writeNewLine();
		ConsoleUtils.writeLine("____________________________________________________________________________________________________________________________________");
		ConsoleUtils.writeLine("                                                                  ");
		ConsoleUtils.writeLine("                                                        " + this.movie.getMovieName() +"        ");
		ConsoleUtils.writeLine("____________________________________________________________________________________________________________________________________");
		ConsoleUtils.writeLine("                                            Type: " + this.movie.getMovieOrSeries() + "    |    " + "Number of seasons: " + this.movie.getNumberOfSeasons());
		ConsoleUtils.writeLine("____________________________________________________________________________________________________________________________________");

		ConsoleUtils.writeLine("                                                   Year of publishing: " + this.movie.getYearOfPublishing());
		ConsoleUtils.writeLine("____________________________________________________________________________________________________________________________________");
		ConsoleUtils.writeLine("                                                                  ");
		ConsoleUtils.writeLine("                                                        Description                           ");
		ConsoleUtils.writeLine("                                                                  ");
		
		if(this.movie.getDescription().length() > 131) {
			
			ConsoleUtils.writeLine(this.movie.getDescription().substring(0, 131) + "- ");
			
			if(this.movie.getDescription().length() - 131 > 131) {
				ConsoleUtils.writeLine(this.movie.getDescription().substring(131, 262)  + "- ");
				ConsoleUtils.writeLine(this.movie.getDescription().substring(262, this.movie.getDescription().length()));
			}
			else {
				ConsoleUtils.writeLine(this.movie.getDescription().substring(131, this.movie.getDescription().length()));
			}	
		}
		else {
			ConsoleUtils.writeLine(this.movie.getDescription());
		}

		ConsoleUtils.writeLine("____________________________________________________________________________________________________________________________________");
		ConsoleUtils.writeLine("                                                                  ");
		ConsoleUtils.writeLine("                                                   Production Company: " + this.movie.getCompany());
		ConsoleUtils.writeLine("                                                   Duration: " + this.movie.getDuration() + " min");
		ConsoleUtils.writeLine("                                                   IMDB_score: " + this.movie.getIMDB_score());
		ConsoleUtils.writeLine("____________________________________________________________________________________________________________________________________");
		ConsoleUtils.writeNewLine();
    }
}
