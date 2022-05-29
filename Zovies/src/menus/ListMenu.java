package menus;

import utils.ConsoleUtils;

public class ListMenu {

	public static void allMoviesMenu() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                   List of all uploaded movies                    |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
	
	public static void allSeriesMenu() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                   List of all uploaded series                    |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
	
	public static void allFavouritesMenu() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                      List of all favourites                      |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
	
	public static void allMoviesByGenreMenu() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                        Type name of genre                        |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
}
