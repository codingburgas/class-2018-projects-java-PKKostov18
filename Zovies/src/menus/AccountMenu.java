package menus;

import utils.ConsoleUtils;

public class AccountMenu {

	public static void login() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                              Login                               |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|              Please type your username and password              |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");		
	}

	public static void register() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                         Create an account                        |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                       Please type your data                      |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");	
	}
}
