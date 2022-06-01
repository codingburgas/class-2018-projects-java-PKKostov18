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
	
	public List<Movie> getAllMoviesAndSeries() {
		List<Movie> moviesAndSeries = movieRepository.getAllMoviesAndSeries();
		return moviesAndSeries;
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
	
	public List<Movie> getAllMoviesByActor(String actor) {
		
		List<Movie> movies = movieRepository.getAllMoviesAndSeriesByActor(actor);
		
		if(movies.isEmpty()) {
			return null;
		}
		return movies;
	}
	
	public Movie getMovieOrSeriesByGenreAndMovieName(String movieName, String genre) {
		
		Movie movie = movieRepository.getMovieOrSeriesByGenreAndMovieName(movieName, genre);
		return movie;
	}
	
	public Movie getMovieOrSeriesByActorAndMovieName(String actorName, String movieName) {
		
		Movie movie = movieRepository.getMovieOrSeriesByActorAndMovieName(actorName, movieName);
		return movie;
	}
	
	public void insertMovie(String movieName, String movieOrSeries, int yearOfPublishing, String desctiption, String company, int duration, double imdbScore) {
		movieRepository.insertMovie(movieName, movieOrSeries, yearOfPublishing, desctiption, company, duration, imdbScore);
	}
	
	public void insertSeries(String movieName, String movieOrSeries, int yearOfPublishing, String desctiption, String company, int duration, double imdbScore, int numberOfSeasons) {
		movieRepository.insertSeries(movieName, movieOrSeries, yearOfPublishing, desctiption, company, duration, imdbScore, numberOfSeasons);
	}
	
	public void deleteMovieOrSeriesById(int movieId) {
		movieRepository.deleteMovieOrSeriesById(movieId);
	}
}
