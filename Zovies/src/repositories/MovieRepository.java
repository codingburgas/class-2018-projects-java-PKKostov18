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
		String query = "SELECT * FROM movies;";
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
	
	private Movie mapToMovie(ResultSet resultSet) throws SQLException {
		int movieId = resultSet.getInt("MovieId");
		String movieName = resultSet.getString("MovieName");
		String movieOrSeries = resultSet.getString("MovieOrSeries");
		int yearOfPublishing = resultSet.getInt("YearOfPublishing");
		String description = resultSet.getString("Description");
		String company = resultSet.getString("Company");
		int duration = resultSet.getInt("Duration");
		double IMDB_score = resultSet.getDouble("IMDB_Score");
		
		Movie movie = new Movie(movieId, movieName, movieOrSeries, 
				yearOfPublishing, description, company, duration, IMDB_score);
		return movie;
	}
}
