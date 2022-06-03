package menus;

import utils.ConsoleUtils;

public class LoggedUserMenu {

	public static void loggedUser() {
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                             ZOVIES                               |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                      Please choose a option                      |");
		ConsoleUtils.writeLine("|        __________________________________________________        |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                       1. View all movies                         |");
		ConsoleUtils.writeLine("|                       2. View all series                         |");
		ConsoleUtils.writeLine("|                       3. View favourites                         |");
		ConsoleUtils.writeLine("|                       4. View by genre                           |");
		ConsoleUtils.writeLine("|                       5. View by actor                           |");
		ConsoleUtils.writeLine("|                       6. View top actors                         |");
		ConsoleUtils.writeLine("|        __________________________________________________        |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                             ACCOUNT                              |");
		ConsoleUtils.writeLine("|              ______________________________________              |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                       7. DELETE account                          |");
		ConsoleUtils.writeLine("|                       8. Log out                                 |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		
		ConsoleUtils.write("Please choose: ");
	}
}
