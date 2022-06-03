package menus;

import utils.ConsoleUtils;

public class AdminMenu {
	
	public static void adminMenu() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                              ADMIN                               |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                 Please choose what you want to do:               |");
		ConsoleUtils.writeLine("|        __________________________________________________        |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                        MOVIES AND SERIES                         |");
		ConsoleUtils.writeLine("|              ______________________________________              |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                       1. View all movies                         |");
		ConsoleUtils.writeLine("|                       2. View all series                         |");
		ConsoleUtils.writeLine("|                       3. View favourites                         |");
		ConsoleUtils.writeLine("|                       4. View by genre                           |");
		ConsoleUtils.writeLine("|                       5. View by actor                           |");
		ConsoleUtils.writeLine("|                       6. Add new movie or series                 |");
		ConsoleUtils.writeLine("|                       7. Delete movie or series                  |");
		ConsoleUtils.writeLine("|                       8. Add actor                               |");
		ConsoleUtils.writeLine("|                       9. Delete actor                            |");
		ConsoleUtils.writeLine("|                       10. View all actors                        |");
		ConsoleUtils.writeLine("|                       11. Add genre                              |");
		ConsoleUtils.writeLine("|                       12. Delete genre                           |");
		ConsoleUtils.writeLine("|                       13. View all genres                        |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|        __________________________________________________        |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                         USER ACCOUNTS                            |");
		ConsoleUtils.writeLine("|              ______________________________________              |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                       14. Delete personal account                |");
		ConsoleUtils.writeLine("|                       15. Delete user account                    |");
		ConsoleUtils.writeLine("|                       16. Make a user admin                      |");
		ConsoleUtils.writeLine("|                       17. View all users                         |");
		ConsoleUtils.writeLine("|                       18. View all admins                        |");
		ConsoleUtils.writeLine("|                       19. LOG OUT                                |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");		
		
		ConsoleUtils.write("Please choose: ");
	}
}
