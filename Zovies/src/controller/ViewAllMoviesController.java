package controller;
import repositories.*;
import utils.*;
import menus.*;
import models.Movie;
import utils.ConsoleUtils;
import services.AuthenticationService;
import services.UserService;

import java.util.*;

public class ViewAllMoviesController {
	
	
	private static final MovieRepository select = new MovieRepository();
	
	public static void ViewAllMoviesController() {
		
	ListMenu.AllMoviesMenu();
	
	List<Movie> movies = select.getAllMovies();
	
	movies.stream().forEach(movie->System.out.println(movie.getMovieName()));
	

	ConsoleUtils.write("Please type the name of the movie you want more info about: ");

	}
	
}
