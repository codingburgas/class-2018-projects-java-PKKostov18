package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Movie;
import utils.DBConnection;

public class MovieRepository {
	
	private static MovieRepository instance = null;

	public static MovieRepository getInstance() {

		if (MovieRepository.instance == null) {
			MovieRepository.instance = new MovieRepository();
		}

		return MovieRepository.instance;
	}
	
	public List<Movie> getAllMovies() {
		List<Movie> listOfMovies = new ArrayList<>();
		String query = "SELECT * FROM movies WHERE MovieOrSeries = 'Movie'";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {

			while (resultSet.next()) {
				Movie movie = mapToMovie(resultSet);
				listOfMovies.add(movie);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfMovies;
	}
	
	public List<Movie> getAllSeries() {
		List<Movie> listOfMovies = new ArrayList<>();
		String query = "SELECT * FROM movies WHERE MovieOrSeries = 'Series'";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {

			while (resultSet.next()) {
				Movie movie = mapToMovie(resultSet);
				listOfMovies.add(movie);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfMovies;
	}
		
	public List<Movie> getAllMoviesAndSeriesByGenre(String genre) {
		List<Movie> listOfMovies = new ArrayList<>();
		String query = "SELECT * FROM movies JOIN genresmovies ON movies.MovieId = genresmovies.MovieId JOIN genres ON genres.GenreId = genresmovies.GenreId WHERE genres.Genre = ?";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
					
			ps.setString(1, genre);
			
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				Movie movie = mapToMovie(resultSet);
				listOfMovies.add(movie);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfMovies;
	}
	
	public List<Movie> getAllMoviesAndSeriesByActor(String genre) {
		List<Movie> listOfMovies = new ArrayList<>();
		String query = "SELECT * FROM movies JOIN actorsmovies ON movies.MovieId = actorsmovies.ActorId JOIN actors ON actors.ActorId = actorsmovies.ActorId WHERE actors.ActorName = ?";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
					
			ps.setString(1, genre);
			
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				Movie movie = mapToMovie(resultSet);
				listOfMovies.add(movie);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfMovies;
	}

	
	public List<Movie> getAllFavouriteMoviesAndSeries(int userId) {
		List<Movie> listOfMoviesSeries = new ArrayList<>();
		String query = "SELECT * FROM movies JOIN favourites ON movies.MovieId = favourites.MovieId JOIN users ON favourites.UserId = users.UserId WHERE users.UserId = ?";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {
					
			ps.setInt(1, userId);
			
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				Movie movie = mapToMovie(resultSet);
				listOfMoviesSeries.add(movie);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfMoviesSeries;
	}
	
	public void insertFavouriteMovieOrSeries(int movieId, int userId) {
		String query1 = "INSERT INTO favourites (MovieId, UserId) VALUES (?, ?)";
		try (Connection conn = DBConnection.getConnection(); 
				PreparedStatement pst1 = conn.prepareStatement(query1)) {
			
			pst1.setInt(1, movieId);
			pst1.setInt(2, userId);
				
			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Movie getMovieByMovieName(String movieName) {
		Movie movie = null;
		String query = "SELECT * FROM movies WHERE MovieName = ?";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = getPSWithMovieName(conn, query, movieName);
				ResultSet resultSet = ps.executeQuery()) {
			
			if(resultSet == null) {
				return null;
			}
			else {
				while (resultSet.next()) {
					movie = mapToMovie(resultSet);
				}
				return movie;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movie;
	}
	
	
	
	
	private Movie mapToMovie(ResultSet resultSet) throws SQLException {
		int movieId = resultSet.getInt("MovieId");
		String movieName = resultSet.getString("MovieName");
		String movieOrSeries = resultSet.getString("MovieOrSeries");
		int yearOfPublishing = resultSet.getInt("YearOfPublishing");
		String description = resultSet.getString("Description");
		String company = resultSet.getString("Company");
		int duration = resultSet.getInt("Duration");
		double IMDB_score = resultSet.getDouble("IMDB_Score");
		int numberOfSeasons = resultSet.getInt("numberOfSeasons");
		
		Movie movie = new Movie(movieId, movieName, movieOrSeries, 
				yearOfPublishing, description, company, duration, IMDB_score, numberOfSeasons);
		return movie;
	}
	
	private PreparedStatement getPSWithMovieName(Connection conn, String query, String movieName) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, movieName);
		return ps;
	}
}
