package services;

import java.util.List;

import models.Movie;
import repositories.MovieRepository;
import utils.ConsoleUtils;

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
		
		ConsoleUtils.writeLine("Movie names:");
		ConsoleUtils.writeNewLine();
		series.stream().forEach(movie -> System.out.println(movie.getMovieName()));
		ConsoleUtils.writeNewLine();
	}

	public Movie displayMovieByMovieName(String movieName) {
		
		Movie movie = movieRepository.getMovieByMovieName(movieName);
		
		return movie;
	}
}
