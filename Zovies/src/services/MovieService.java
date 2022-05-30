package services;

import java.util.List;

import models.Movie;
import repositories.ActorRepository;
import repositories.MovieRepository;
import utils.ConsoleUtils;
import utils.PasswordManager;

public class MovieService {
	
	private static MovieService instance = null;
	private final MovieRepository movieRepository;
	

	
    private MovieService() {
        this.movieRepository = MovieRepository.getInstance();
    }
	
	public static MovieService getInstance() {

        if (MovieService.instance == null) {
        	MovieService.instance = new MovieService();
		}

        return MovieService.instance;
    }
	
	public void displayAllMovieNames() {
		
		List<Movie> movies = movieRepository.getAllMovies();
		
		ConsoleUtils.writeLine("Movie names:");
		ConsoleUtils.writeNewLine();
		movies.stream().forEach(movie -> System.out.println(movie.getMovieName()));
		ConsoleUtils.writeNewLine();
	}
	

	
	public void displayAllSeriesNames() {
		List<Movie> series = movieRepository.getAllSeries();
		
		ConsoleUtils.writeLine("Series names:");
		ConsoleUtils.writeNewLine();
		series.stream().forEach(movie -> System.out.println(movie.getMovieName()));
		ConsoleUtils.writeNewLine();
	}
	
	public void insertFavouriteMovieOrSeries(int movieId, int userId) {
		movieRepository.insertFavouriteMovieOrSeries(movieId, userId);
	}

	public Movie displayMovieByMovieName(String movieName) {
		
		Movie movie = movieRepository.getMovieByMovieName(movieName);
		return movie;
	}
	
	public void displayAllFavouriteMoviesAndSeries(int userId) {
		
		List<Movie> movies = movieRepository.getAllFavouriteMoviesAndSeries(userId);
		
		ConsoleUtils.writeLine("Movie and series names:");
		ConsoleUtils.writeNewLine();
		movies.stream().forEach(movie -> System.out.println(movie.getMovieName()));
		ConsoleUtils.writeNewLine();
	}
	
	public void displayAllMoviesByGenre(String genre) {
		
		List<Movie> movies = movieRepository.getAllMoviesAndSeriesByGenre(genre);
		
		ConsoleUtils.writeLine("Movie and series names:");
		ConsoleUtils.writeNewLine();
		movies.stream().forEach(movie -> System.out.println(movie.getMovieName()));
		ConsoleUtils.writeNewLine();
	}
}
