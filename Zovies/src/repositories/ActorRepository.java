package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Actor;
import utils.DBConnection;

public class ActorRepository {
	
	private static ActorRepository instance = null;

	public static ActorRepository getInstance() {

		if (ActorRepository.instance == null) {
			ActorRepository.instance = new ActorRepository();
		}

		return ActorRepository.instance;
	}
	
	public List<Actor> getAllActors() {
		List<Actor> listOfActors = new ArrayList<>();
		String query = "SELECT * FROM actors;";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {

			while (resultSet.next()) {
				Actor actor = mapToActor(resultSet);
				listOfActors.add(actor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfActors;
	}
	
	private Actor mapToActor(ResultSet resultSet) throws SQLException {
		int actorId = resultSet.getInt("ActorId");
		String actorName = resultSet.getString("ActorName");
		Actor actor = new Actor(actorId, actorName);
		return actor;
	}
	
	public void insertActor(String actorName) {
		String query1 = "INSERT INTO actors (ActorName) VALUES (?)";
		try (Connection conn = DBConnection.getConnection(); 
				PreparedStatement pst1 = conn.prepareStatement(query1)) {
			
			pst1.setString(1, actorName);
							
			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteActorById(int actorId) {
		String query1 = "DELETE FROM actors WHERE ActorId = ?";
		try (Connection conn = DBConnection.getConnection(); 
				PreparedStatement pst1 = conn.prepareStatement(query1)) {
			
			pst1.setInt(1, actorId);
				
			int rs = pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
