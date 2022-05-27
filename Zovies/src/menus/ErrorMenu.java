package menus;

import utils.ConsoleUtils;

public class ErrorMenu {

	public static void invalidInputError() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                   Please enter a valid option!                   |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		
		ConsoleUtils.write("Please choose: ");
	}
	
	public static void invalidDataError() {
			
			ConsoleUtils.writeLine("+------------------------------------------------------------------+");
			ConsoleUtils.writeLine("|                     Please enter a valid data!                   |");
			ConsoleUtils.writeLine("+------------------------------------------------------------------+");	
	}
	
	public static void invalidDomain() {
		
			ConsoleUtils.writeLine("+------------------------------------------------------------------+");
			ConsoleUtils.writeLine("|                       Invalid email domain                       |");
			ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
	
	public static void invalidUsername() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                      Username already exist                      |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}

	public static void invalidEmailUsername() {
		
			ConsoleUtils.writeLine("+------------------------------------------------------------------+");
			ConsoleUtils.writeLine("|                      Invalid email username                      |");
			ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
	
	public static void invalidMovieName() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                        Invalid movie name                        |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
}
