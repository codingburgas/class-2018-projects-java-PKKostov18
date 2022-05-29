package menus;

import utils.ConsoleUtils;

public class ListMenu {

	public static void AllMoviesMenu() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                   List of all uploaded movies                    |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
	
	public static void AllSeriesMenu() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                   List of all uploaded series                    |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
	
	public static void AllFavouritesMenu() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                      List of all favourites                      |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
}
