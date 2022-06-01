package services;

import java.util.List;

import models.Actor;
import models.Movie;
import repositories.ActorRepository;
import repositories.MovieRepository;
import utils.ConsoleUtils;
import utils.PasswordManager;


public class ActorService {
	
	private static ActorService instance = null;
	private final ActorRepository actorRepository;
	
	
	private ActorService() {
        this.actorRepository = ActorRepository.getInstance();
	}
		
	public static ActorService getInstance() {

        if (ActorService.instance == null) {
        	ActorService.instance = new ActorService();
		}

        return ActorService.instance;
    }
	
	public List<Actor> getAllActorNames() {
		
		List<Actor> actors = actorRepository.getAllActors();
		return actors;
	}
	
	public void insertActor(String actorName) {
		actorRepository.insertActor(actorName);
	}
	
	public void deleteActor(int actorId) {
		actorRepository.deleteActorById(actorId);
	}
}
