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
	
	private Genre mapToGenre(ResultSet resultSet) throws SQLException {
		int genreId = resultSet.getInt("GenreId");
		String genreType = resultSet.getString("Genre");
		Genre genre = new Genre(genreId, genreType);
		return genre;
	}
}
