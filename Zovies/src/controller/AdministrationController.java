package controller;

import menus.AdminMenu;
import utils.ConsoleUtils;

public class AdministrationController {
	
	AdminMenu adminMenu = new AdminMenu();
	

	public void run() {
		
		ConsoleUtils.write(adminMenu.adminMenu());
		
	}

}
