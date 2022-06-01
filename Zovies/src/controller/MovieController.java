package controller;

import java.util.List;
import java.util.stream.Collectors;

import menus.*;
import models.Actor;
import models.Movie;
import utils.ConsoleUtils;
import services.ActorService;
import services.AuthenticationService;
import services.FavouriteService;
import services.MovieService;
import services.UserService;

public class MovieController{
	
	private final FavouriteService favouriteService;
	private final MovieService movieService;
	private final AuthenticationService authService;
	private final ActorService actorService;
	
	Movie movie = null;
	
	public MovieController() {
		this.favouriteService = FavouriteService.getInstance();
		this.movieService = MovieService.getInstance();
		this.authService = AuthenticationService.getInstance();
		this.actorService = ActorService.getInstance();
    }
	
	public void viewAllMovies() {
		
		ListMenu.allMoviesMenu();
		
		List<Movie> movies = movieService.getAllMovieNames();
		
		ConsoleUtils.writeLine("Movie names:");
		ConsoleUtils.writeNewLine();
		movies.stream().forEach(movie -> System.out.println(movie.getMovieName()));
		ConsoleUtils.writeNewLine();
		
		ConsoleUtils.write("Please type the name of the movie you want more info about: "); String movieName = ConsoleUtils.read();
	    movie = movieService.getMovieByMovieName(movieName);
		
		if(movie != null) {
			displayMovieSeriesInfo(movie);
		}

		while(movieService.getMovieByMovieName(movieName) == null) {
			
			ErrorMenu.invalidMovieName();
			
			ConsoleUtils.write("Please type the name of the movie you want more info about: ");
			movieName = ConsoleUtils.read();
			
			movie = movieService.getMovieByMovieName(movieName);

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
					if(favouriteService.getFavouriteMovieOrSeries(movie.getMovieId(), authService.getLoggedUser().getUserId()) == true) {
						favouriteService.insertFavouriteMovieOrSeries(movie.getMovieId(), authService.getLoggedUser().getUserId());
						ConsoleUtils.writeLine("Successfully added to your favourites!");
						ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
						
						while(option != 1) {
							ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
						}
					}
					else {
						ErrorMenu.invalidFavourite();
						ConsoleUtils.writeNewLine();
						ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
						
						while(option != 1) {
							ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
						}
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
		
		List<Movie> series = movieService.getAllSeriesNames();
		
		ConsoleUtils.writeLine("Series names:");
		ConsoleUtils.writeNewLine();
		series.stream().forEach(movie -> System.out.println(movie.getMovieName()));
		ConsoleUtils.writeNewLine();
		
		ConsoleUtils.write("Please type the name of the series you want more info about: "); String seriesName = ConsoleUtils.read();
	    movie = movieService.getMovieByMovieName(seriesName);
		
		if(movie != null) {
			displayMovieSeriesInfo(movie);
		}

		while(movieService.getMovieByMovieName(seriesName) == null) {
			
			ErrorMenu.invalidMovieName();
			
			ConsoleUtils.write("Please type the name of the series you want more info about: ");
			seriesName = ConsoleUtils.read();
			
			movie = movieService.getMovieByMovieName(seriesName);

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
					if(favouriteService.getFavouriteMovieOrSeries(movie.getMovieId(), authService.getLoggedUser().getUserId()) == true) {
						favouriteService.insertFavouriteMovieOrSeries(movie.getMovieId(), authService.getLoggedUser().getUserId());
						ConsoleUtils.writeLine("Successfully added to your favourites!");
						ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
						
						while(option != 1) {
							ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
						}
					}
					else {
						ErrorMenu.invalidFavourite();
						ConsoleUtils.writeNewLine();
						ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
						
						while(option != 1) {
							ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
						}
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
		
		ListMenu.allActorsMenu();
		
		List<Actor> actors = actorService.getAllActorNames();
		
		ConsoleUtils.writeLine("Actor names:");
		ConsoleUtils.writeNewLine();
		actors.stream().forEach(actor -> System.out.println(actor.getActorName()));
		ConsoleUtils.writeNewLine();
		 
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
		
		List<Movie> movies = movieService.getAllFavouriteMoviesAndSeries(authService.getLoggedUser().getUserId());
		
		ConsoleUtils.writeLine("Movie and series names:");
		ConsoleUtils.writeNewLine();
		movies.stream().forEach(movie -> System.out.println(movie.getMovieName()));
		ConsoleUtils.writeNewLine();
		
		ConsoleUtils.writeNewLine();
		ConsoleUtils.writeLine("Type 1 to remove: ");
		ConsoleUtils.writeLine("Type 2 to go back: "); 
		ConsoleUtils.write("Choose: "); int option = ConsoleUtils.readInteger();
		ConsoleUtils.writeNewLine();
		
		while(option != 1 && option != 2) {
			ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
		}
		
		if(option == 1) {
			
			ConsoleUtils.writeNewLine();
			ConsoleUtils.write("Type the name of the movie or series you want to remove: "); String movieName = ConsoleUtils.read();
			
			if(favouriteService.getFavouriteMovieOrSeriesByUserId(authService.getLoggedUser().getUserId(), movieName) == true) {
				favouriteService.deleteFavouriteMovieOrSeries(movieName, authService.getLoggedUser().getUserId());
				ConsoleUtils.writeNewLine();
				ConsoleUtils.writeLine("Succsessfully removed!");
				ConsoleUtils.writeNewLine();
				ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
				
				while(option != 1) {
					ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
				} 
				backToUserMenu();
			}
			else {
				ConsoleUtils.writeNewLine();
				ErrorMenu.invalidFavouriteMovieOrSeris();
				ConsoleUtils.writeNewLine();
				ConsoleUtils.writeLine("Type 1 to try again: ");
				ConsoleUtils.writeLine("Type 2 to go back: "); ConsoleUtils.write("Choose: "); option = ConsoleUtils.readInteger();
				ConsoleUtils.writeNewLine();
				
				while(option != 1 && option != 2) {
					ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
				}
				
				if(option == 1) {
					viewFavourites();
				}else {
					backToUserMenu();
				}
			}
	
			favouriteService.deleteFavouriteMovieOrSeries(movieName, authService.getLoggedUser().getUserId());
			ConsoleUtils.writeNewLine();
			
			
			ConsoleUtils.writeLine("Succsessfully removed!");
			
			
			ConsoleUtils.writeNewLine();
			ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
			
			while(option != 1) {
				ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
			} 
			backToUserMenu();
		}else {
			backToUserMenu();
		}
	}
	
	private void backToUserMenu() {
		LoggedUserManagementController loggedUserManagementController = new LoggedUserManagementController();
		loggedUserManagementController.run();
    }
	
	private void backToAdminMenu() {
		AdministrationController administrationController = new AdministrationController();
		administrationController.run();
    }
	
	public void insertMovieOrSeries() {
		
		ConsoleUtils.writeNewLine();
		ListMenu.insertMovieOrSeriesMenu();
		ConsoleUtils.writeNewLine();
		
		ConsoleUtils.write("Movie name: "); String movieName = ConsoleUtils.read();
		ConsoleUtils.write("Movie or Series: "); String movieOrSeries = ConsoleUtils.read();
		
		while(!movieOrSeries.equals("Movie") && !movieOrSeries.equals("Series")) {
			ErrorMenu.invalidDataError(); 
			
			System.out.println(movieOrSeries);
			
			ConsoleUtils.write("Movie or Series: "); movieOrSeries = ConsoleUtils.read();
		}
		
		System.out.println(movieOrSeries);

		if(movieOrSeries.equals("Movie")) {
			ConsoleUtils.write("Year of publishing: "); int yearOfPublishing = ConsoleUtils.readInteger();

			while(yearOfPublishing < 1000 || yearOfPublishing > 9999) {
				ErrorMenu.invalidDataError(); 
				ConsoleUtils.write("Year of publishing: "); yearOfPublishing = ConsoleUtils.readInteger();
			}
			
			ConsoleUtils.write("Description: "); String description = ConsoleUtils.read();
			ConsoleUtils.write("Company: "); String company = ConsoleUtils.read();
			ConsoleUtils.write("Duration: "); int duration = ConsoleUtils.readInteger();
			ConsoleUtils.write("IMDB score: "); double imdbScore = ConsoleUtils.readDouble();
			
			while(imdbScore < 0 || imdbScore > 10) {
				ErrorMenu.invalidDataError(); 
				ConsoleUtils.write("IMDB score: "); imdbScore = ConsoleUtils.readInteger();
			}
			
			movieService.insertMovie(movieName, movieOrSeries, yearOfPublishing, description, company, duration, imdbScore);
			
			ConsoleUtils.writeLine("Successfully added a movie!");
			ConsoleUtils.write("Type 1 to back: "); int option = ConsoleUtils.readInteger();
			
			while(option != 1) {
				ErrorMenu.invalidInputError();
				ConsoleUtils.write("Type 1 to back: "); option = ConsoleUtils.readInteger();
			}
			
			backToAdminMenu();
		} 
		else {
			ConsoleUtils.write("Year of publishing: "); int yearOfPublishing = ConsoleUtils.readInteger();
			while(yearOfPublishing < 1900 || yearOfPublishing > 2022) {
				ErrorMenu.invalidDataError(); 
				ConsoleUtils.write("Year of publishing: "); yearOfPublishing = ConsoleUtils.readInteger();
			}
			
			ConsoleUtils.write("Description: "); String description = ConsoleUtils.read();
			ConsoleUtils.write("Company: "); String company = ConsoleUtils.read();
			ConsoleUtils.write("Duration: "); int duration = ConsoleUtils.readInteger();
			ConsoleUtils.write("IMDB score: "); double imdbScore = ConsoleUtils.readDouble();
			
			while(imdbScore < 0 || imdbScore > 10) {
				ErrorMenu.invalidDataError(); 
				ConsoleUtils.write("IMDB score: "); imdbScore = ConsoleUtils.readInteger();
			}
			
			ConsoleUtils.write("Number of seasons: "); int numberOfSeasons = ConsoleUtils.readInteger();
			
			movieService.insertSeries(movieName, movieOrSeries, yearOfPublishing, description, company, duration, imdbScore, numberOfSeasons);
		
			ConsoleUtils.writeNewLine();
			ConsoleUtils.writeLine("Successfully added a series!");
			ConsoleUtils.write("Type 1 to back: "); int option = ConsoleUtils.readInteger();
			ConsoleUtils.writeNewLine();
			
			while(option != 1) {
				ConsoleUtils.writeNewLine();
				ErrorMenu.invalidInputError();
				ConsoleUtils.write("Type 1 to back: "); option = ConsoleUtils.readInteger();
				ConsoleUtils.writeNewLine();
			}
			
			backToAdminMenu();
		}
	}
	
	public void deleteMovieOrSeries() {
		
		ConsoleUtils.writeNewLine();
		ListMenu.deleteMovieOrSeriesMenu();
		ConsoleUtils.writeNewLine();
		
		List<Movie> moviesAndSeries = movieService.getAllMoviesAndSeries();
		List<Integer> getAllIds = moviesAndSeries.stream().map(id -> id.getMovieId()).collect(Collectors.toList());
		
		ConsoleUtils.writeNewLine();
		moviesAndSeries.stream().forEach(movie -> {
			
			ConsoleUtils.write("Movie ID: "); 
			ConsoleUtils.writeInteger(movie.getMovieId()); 
			
			ConsoleUtils.write(" Movie name: "); 
			ConsoleUtils.writeLine(movie.getMovieName());
		});
		ConsoleUtils.writeNewLine();
		
		ConsoleUtils.write("Type the id of the movie you want to delete: "); int id = ConsoleUtils.readInteger();
		
		while(!getAllIds.contains(id)) {
			ConsoleUtils.writeNewLine();
			ErrorMenu.invalidDataError();
			ConsoleUtils.write("Type the id of the movie you want to delete: "); id = ConsoleUtils.readInteger();
			ConsoleUtils.writeNewLine();
		}
		
		movieService.deleteMovieOrSeriesById(id);
		
		ConsoleUtils.writeNewLine();
		ConsoleUtils.writeLine("Successfully deleted!");
		ConsoleUtils.write("Type 1 to back: "); int option = ConsoleUtils.readInteger();
		ConsoleUtils.writeNewLine();
		
		while(option != 1) {
			ConsoleUtils.writeNewLine();
			ErrorMenu.invalidInputError();
			ConsoleUtils.write("Type 1 to back: "); option = ConsoleUtils.readInteger();
			ConsoleUtils.writeNewLine();
		}
		
		backToAdminMenu();
	}
	
	public void viewAllMoviesOrSeriesByGenre() {
		
		ConsoleUtils.writeNewLine();
		
		ListMenu.allMoviesByGenreMenu();
		
		ConsoleUtils.write("Genre name: "); String genre = ConsoleUtils.read();
		
		List<Movie> moviesByGenre = movieService.getAllMoviesAndSeriesByGenre(genre);
		
		while(movieService.getAllMoviesAndSeriesByGenre(genre) == null) {
			ErrorMenu.invalidGenre();
			ConsoleUtils.write("Genre name: "); genre = ConsoleUtils.read();	
			moviesByGenre = movieService.getAllMoviesAndSeriesByGenre(genre);
		}
		 
		ConsoleUtils.writeNewLine();
		ConsoleUtils.writeLine("Movie and series names:");
		ConsoleUtils.writeNewLine();
		moviesByGenre.stream().forEach(movie -> System.out.println(movie.getMovieName()));
		ConsoleUtils.writeNewLine();
		
		ConsoleUtils.write("Please type the name of the movie or series you want more info about: "); String movieName = ConsoleUtils.read();
		
	    movie = movieService.getMovieOrSeriesByGenreAndMovieName(movieName, genre);
	    
	    while(movieService.getMovieOrSeriesByGenreAndMovieName(movieName, genre) == null) {
	    	
	    	ErrorMenu.invalidMovieName();
	    	ConsoleUtils.write("Please type the name of the movie or series you want more info about: "); movieName = ConsoleUtils.read();	
		    movie = movieService.getMovieOrSeriesByGenreAndMovieName(movieName, genre);
		    
		    if(movie != null) {
		    	displayMovieSeriesInfo(movie);
		    }
	    }
	        
		ConsoleUtils.writeLine("Choose what you want to do: ");  
		ConsoleUtils.writeLine("1 for see another movie or series info");
		ConsoleUtils.writeLine("2 for favourite"); 
		ConsoleUtils.writeLine("3 for back"); 
		ConsoleUtils.write("Choose: "); int option = ConsoleUtils.readInteger();
		System.out.println();
		
		while(true) {
			switch (option) {
				case 1: {
					viewAllMoviesOrSeriesByGenre();
					break;
				}
				case 2: {
					if(favouriteService.getFavouriteMovieOrSeries(movie.getMovieId(), authService.getLoggedUser().getUserId()) == true) {
						favouriteService.insertFavouriteMovieOrSeries(movie.getMovieId(), authService.getLoggedUser().getUserId());
						ConsoleUtils.writeLine("Successfully added to your favourites!");
						ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
						
						while(option != 1) {
							ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
						}
					}
					else {
						ErrorMenu.invalidFavourite();
						ConsoleUtils.writeNewLine();
						ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
						
						while(option != 1) {
							ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
						}
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
		
		ConsoleUtils.writeNewLine();
	
		ListMenu.allMoviesByActorMenu();
		
		ConsoleUtils.write("Actor name: "); String actor  = ConsoleUtils.read();
		
		List<Movie> movies = movieService.getAllMoviesByActor(actor);
		
		while(movieService.getAllMoviesByActor(actor) == null) {
			
			
			ErrorMenu.invalidActorName();
			ConsoleUtils.write("Actor name: "); actor = ConsoleUtils.read();	
			movies = movieService.getAllMoviesByActor(actor);
		}
		
		ConsoleUtils.writeNewLine();
		ConsoleUtils.writeLine("Movies with this actor:");
		ConsoleUtils.writeNewLine();
		movies.stream().forEach(movie -> System.out.println(movie.getMovieName()));
		ConsoleUtils.writeNewLine();
		
		ConsoleUtils.write("Please type the name of the movie you want more info about: "); String movieName = ConsoleUtils.read();
		
	    movie = movieService.getMovieOrSeriesByActorAndMovieName(actor, movieName);
	    
	    while(movieService.getMovieOrSeriesByActorAndMovieName(actor, movieName) == null) {
	    	
	    	ErrorMenu.invalidMovieName();
	    	ConsoleUtils.write("Please type the name of the movie or series you want more info about: "); movieName = ConsoleUtils.read();	
		    movie = movieService.getMovieOrSeriesByActorAndMovieName(actor, movieName);
		    
		    if(movie != null) {
		    	displayMovieSeriesInfo(movie);
		    }
	    }
		
	    ConsoleUtils.writeNewLine();
		ConsoleUtils.writeLine("Choose what you want to do: ");  
		ConsoleUtils.writeLine("1 for see another movie info");
		ConsoleUtils.writeLine("2 for favourite"); 
		ConsoleUtils.writeLine("3 for back"); 
		ConsoleUtils.write("Choose: "); int option = ConsoleUtils.readInteger();
		ConsoleUtils.writeNewLine();
		
		while(true) {
			switch (option) {
				case 1: {
					viewAllMoviesOrSeriesByActor();
				}
				case 2: {
					if(favouriteService.getFavouriteMovieOrSeries(movie.getMovieId(), authService.getLoggedUser().getUserId()) == true) {
						favouriteService.insertFavouriteMovieOrSeries(movie.getMovieId(), authService.getLoggedUser().getUserId());
						ConsoleUtils.writeLine("Successfully added to your favourites!");
						ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
						
						while(option != 1) {
							ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
						}
					}
					else {
						ErrorMenu.invalidFavourite();
						ConsoleUtils.writeNewLine();
						ConsoleUtils.write("Type 1 to go back: "); option = ConsoleUtils.readInteger();
						
						while(option != 1) {
							ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
						}
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
