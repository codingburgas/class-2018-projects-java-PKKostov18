package controller;
import utils.ConsoleUtils;
import java.util.*;


public class MainController {
	
	
	
	public void run() {

		
		String optionForAccount;
		
		ConsoleUtils.writeConsoleLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeConsoleLine("|                                                                  |");
		ConsoleUtils.writeConsoleLine("|                        WELCOME TO ZOVIES                         |");
		ConsoleUtils.writeConsoleLine("|                                                                  |");
		ConsoleUtils.writeConsoleLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeConsoleLine("|                                                                  |");
		ConsoleUtils.writeConsoleLine("|                      DO YOU HAVE AN ACCOUNT?                     |");
		ConsoleUtils.writeConsoleLine("|        __________________________________________________        |");
		ConsoleUtils.writeConsoleLine("|                                                                  |");
		ConsoleUtils.writeConsoleLine("|                             1. Yes                               |");
		ConsoleUtils.writeConsoleLine("|                             2. No                                |");
		ConsoleUtils.writeConsoleLine("|                                                                  |");
		ConsoleUtils.writeConsoleLine("+------------------------------------------------------------------+");
		
		optionForAccount=ConsoleUtils.readConsoleLine();
		
		if(Integer.parseInt(optionForAccount)!=1 && Integer.parseInt(optionForAccount)!=2)
		{
			ConsoleUtils.writeConsoleLine("+------------------------------------------------------------------+");
			ConsoleUtils.writeConsoleLine("|                   Please enter a valid option!                   |");
			ConsoleUtils.writeConsoleLine("+------------------------------------------------------------------+");
		}
		






	}

}
