package controller;

import menus.*;
import utils.ConsoleUtils;

public class LoggedUserManagementController {

	public void run() {
		
		LoggedUserMenu menu = new LoggedUserMenu();
		
		ConsoleUtils.write(menu.LoggedUser());
		
		
	}

}

