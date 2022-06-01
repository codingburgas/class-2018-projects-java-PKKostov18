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
	
	public static void invalidGenre() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                          Invalid genre                           |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
	
	public static void invalidActorName() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|              Invalid actor name or don't have films              |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
	
	public static void invalidFavourite() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|            You already have it in your favourite list            |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
	
	public static void invalidFavouriteMovieOrSeris() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                Invalid favourite movie or series!                |");
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
