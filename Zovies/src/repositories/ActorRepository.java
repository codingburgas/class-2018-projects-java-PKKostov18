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
}
