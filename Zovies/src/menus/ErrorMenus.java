package menus;

import utils.ConsoleUtils;

public class ErrorMenus {

	public String UnvalidInputError() {
		
		ConsoleUtils.write("+------------------------------------------------------------------+");
		ConsoleUtils.write("|                   Please enter a valid option!                   |");
		ConsoleUtils.write("+------------------------------------------------------------------+");
		
		System.out.print("Please choose: ");
		
		return "";
		
	}
	
	public String UnvalidDataError() {
			
			ConsoleUtils.write("+------------------------------------------------------------------+");
			ConsoleUtils.write("|                     Please enter a valid data!                   |");
			ConsoleUtils.write("+------------------------------------------------------------------+");
			
			return "";
			
	}

}
