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
	
public void displayAllActorNames() {
		
		List<Actor> actors = actorRepository.getAllActors();
		
		ConsoleUtils.writeLine("Actor names:");
		ConsoleUtils.writeNewLine();
		actors.stream().forEach(actor -> System.out.println(actor.getActorName()));
		ConsoleUtils.writeNewLine();
	}
}
