package controller;

import menus.AccountMenus;
import utils.ConsoleUtils;

public class RegisterController {
	
	private AccountMenus accMenu = new AccountMenus();

	public void run() {
		
		ConsoleUtils.write(accMenu.Register());
		
	}

}
