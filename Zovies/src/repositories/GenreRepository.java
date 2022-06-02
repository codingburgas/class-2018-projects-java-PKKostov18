package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Genre;
import utils.DBConnection;

public class GenreRepository {
	
	private static GenreRepository instance = null;

	public static GenreRepository getInstance() {

		if (GenreRepository.instance == null) {
			GenreRepository.instance = new GenreRepository();
		}

		return GenreRepository.instance;
	}
	
	public List<Genre> getAllGenres() {
		List<Genre> listOfGenres = new ArrayList<>();
		String query = "SELECT * FROM genres;";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {

			while (resultSet.next()) {
				Genre genre = mapToGenre(resultSet);
				listOfGenres.add(genre);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfGenres;
	}
	
	public void insertGenre(String genre) {
		String query1 = "INSERT INTO genres (Genre) VALUES (?)";
		try (Connection conn = DBConnection.getConnection(); 
				PreparedStatement pst1 = conn.prepareStatement(query1)) {
			
			pst1.setString(1, genre);
							
			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteGenreById(int genreId) {
		String query1 = "DELETE FROM genres WHERE GenreId = ?";
		try (Connection conn = DBConnection.getConnection(); 
				PreparedStatement pst1 = conn.prepareStatement(query1)) {
			
			pst1.setInt(1, genreId);
				
			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Genre mapToGenre(ResultSet resultSet) throws SQLException {
		int genreId = resultSet.getInt("GenreId");
		String genreType = resultSet.getString("Genre");
		Genre genre = new Genre(genreId, genreType);
		return genre;
	}
}
