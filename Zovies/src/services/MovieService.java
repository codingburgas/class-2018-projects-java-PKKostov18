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
	
	public List<Movie> getAllMovieNames() {
		
		List<Movie> movies = movieRepository.getAllMovies();	
		return movies;
	}
		
	public List<Movie> getAllSeriesNames() {
		List<Movie> series = movieRepository.getAllSeries();
		return series;
	}

	public Movie getMovieByMovieName(String movieName) {
		
		Movie movie = movieRepository.getMovieByMovieName(movieName);
		return movie;
	}
	
	public List<Movie> getAllFavouriteMoviesAndSeries(int userId) {
		
		List<Movie> movies = movieRepository.getAllFavouriteMoviesAndSeries(userId);
		return movies;
	}
	
	public List<Movie> getAllMoviesAndSeriesByGenre(String genre) {
		
		List<Movie> movies = movieRepository.getAllMoviesAndSeriesByGenre(genre);
		
		if(movies.isEmpty()) {
			return null;
		}
		return movies;
	}
	
	public Movie getMovieByMovieNameByGenre(String movieName, String genre) {
		
		Movie movie = movieRepository.getMovieOrSeriesByGenreAndMovieName(movieName, genre);
		return movie;
	}
}
