package menus;

import utils.ConsoleUtils;

public class LoggedUserMenu {

	public String LoggedUser() {
		ConsoleUtils.write("+------------------------------------------------------------------+");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("|                             ZOVIES                               |");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("+------------------------------------------------------------------+");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("|                      Please choose a option                      |");
		ConsoleUtils.write("|        __________________________________________________        |");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("|                       1. View all movies                         |");
		ConsoleUtils.write("|                       2. View all series                         |");
		ConsoleUtils.write("|                       3. View favourites                         |");
		ConsoleUtils.write("|                       4. View by genre                           |");
		ConsoleUtils.write("|                       5. View by actor                           |");
		ConsoleUtils.write("|                       6. View top 50 actors                      |");
		ConsoleUtils.write("|        __________________________________________________        |");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("|                             ACCOUNT                              |");
		ConsoleUtils.write("|              ______________________________________              |");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("|                       7. Edit account                            |");
		ConsoleUtils.write("|                       8. DELETE account                          |");
		ConsoleUtils.write("|                                                                  |");
		ConsoleUtils.write("+------------------------------------------------------------------+");
		
		System.out.print("Please choose: ");
		
		return "";
		
	}

}
