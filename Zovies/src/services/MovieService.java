package services;

import java.util.List;

import models.Movie;
import models.User;
import repositories.MovieRepository;
import utils.ConsoleUtils;

public class MovieService {
	
	private static MovieService instance = null;
	private final MovieRepository movieRepository;
	
	private Movie movie = null;
	
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
		System.out.println();
		movies.stream().forEach(movie -> System.out.println(movie.getMovieName()));
		System.out.println();
	}
	
	public Movie isMovieNameValid() {
        return movie;
    }
	
	public void displayMovieByMovieName(String movieName) {
		
		this.movie = movieRepository.getMovieByMovieName(movieName);
		
		if(movie != null) {
			System.out.println();
			ConsoleUtils.writeLine("Movie name: " + movie.getMovieName());
			ConsoleUtils.writeLine("Movie or Series: " + movie.getMovieOrSeries());
			ConsoleUtils.writeLine("Year of publishing: " + movie.getYearOfPublishing());
			ConsoleUtils.writeLine("Description: " + movie.getDescription());
			ConsoleUtils.writeLine("Company: " + movie.getCompany());
			ConsoleUtils.writeLine("Duration: " + movie.getDuration() + " mins");
			ConsoleUtils.writeLine("IMDB_score: " + movie.getIMDB_score());
			System.out.println();
		}
	}
}
