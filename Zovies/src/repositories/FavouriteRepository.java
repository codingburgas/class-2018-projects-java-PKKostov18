package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBConnection;

public class FavouriteRepository {
	
	private static FavouriteRepository instance = null;

	public static FavouriteRepository getInstance() {

		if (FavouriteRepository.instance == null) {
			FavouriteRepository.instance = new FavouriteRepository();
		}

		return FavouriteRepository.instance;
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
	
	public boolean getFavouriteMovieOrSeries(int movieId, int userId) {
		String query1 = "SELECT * FROM favourites WHERE MovieId = ? AND UserId = ?";
		try (Connection conn = DBConnection.getConnection(); 
				PreparedStatement pst1 = conn.prepareStatement(query1)) {
			
			pst1.setInt(1, movieId);
			pst1.setInt(2, userId);
			
			ResultSet resultSet = pst1.executeQuery();
				
			if(resultSet.next() == false) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean getFavouriteMovieOrSeriesByUserId(int userId, String movieName) {
		String query1 = "SELECT * FROM favourites JOIN movies ON favourites.MovieId = favourites.MovieId JOIN users ON favourites.UserId = users.UserId WHERE users.UserId = ? AND movies.MovieName = ?";
		try (Connection conn = DBConnection.getConnection(); 
				PreparedStatement pst1 = conn.prepareStatement(query1)) {
			
			pst1.setInt(1, userId);
			pst1.setString(2, movieName);
			
			ResultSet resultSet = pst1.executeQuery();
				
			if(resultSet.next() == false) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void deleteFavouriteMovieOrSeries(String movieName, int userId) {
		String query1 = "DELETE favourites FROM favourites JOIN movies ON favourites.MovieId = movies.MovieId JOIN users ON favourites.UserId = users.UserId WHERE users.UserId = ? AND movies.MovieName = ?";
		try (Connection conn = DBConnection.getConnection(); 
				PreparedStatement pst1 = conn.prepareStatement(query1)) {
			
			pst1.setInt(1, userId);
			pst1.setString(2, movieName);
			
			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
