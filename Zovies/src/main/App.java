package main;
import controller.MainController;
import repositories.UserRepository;
import services.AuthenticationService;
public class App {

	public static void main(String[] args){
		
		MainController main = new MainController();
		main.run();
	}
}
