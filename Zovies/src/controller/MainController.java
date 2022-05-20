package controller;
import utils.ConsoleUtils;
import java.util.*;

public class MainController {
	
	private AuthenticationController auth = new AuthenticationController();
	
	public void run() {

		String optionForAccount;
		
		ConsoleUtils.write("+------------------------------------------------------------------+");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("|                        WELCOME TO ZOVIES                         |");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("+------------------------------------------------------------------+");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("|                      DO YOU HAVE AN ACCOUNT?                     |");
		ConsoleUtils.write("|        __________________________________________________        |");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("|                             1. Yes                               |");
		ConsoleUtils.write("|                             2. No                                |");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("+------------------------------------------------------------------+");
		
		System.out.print("Choose: "); optionForAccount=ConsoleUtils.read();
		
		while(Integer.parseInt(optionForAccount)!=1 && Integer.parseInt(optionForAccount)!=2)
		{
			ConsoleUtils.write("+------------------------------------------------------------------+");
			ConsoleUtils.write("|                   Please enter a valid option!                   |");
			ConsoleUtils.write("+------------------------------------------------------------------+");
			
			optionForAccount=ConsoleUtils.read();
		}
		
		if(Integer.parseInt(optionForAccount) == 1) {
			auth.run();
		} else if(Integer.parseInt(optionForAccount) == 1) {
			
		}
	}
}
