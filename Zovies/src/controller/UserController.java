package controller;

import java.util.List;

import menus.ErrorMenu;
import menus.ListMenu;
import models.Genre;
import models.User;
import services.GenreService;
import services.UserService;
import utils.ConsoleUtils;

public class UserController {
private final UserService userService;
	
	User user= null;
	
	public UserController() {
		this.userService = UserService.getInstance();
		
    }
	
	public void viewAllUsers() {
		
		ListMenu.allGenresMenu();
		
		List<User> users = userService.getAllUsers();
		
		ConsoleUtils.writeLine("User names:");
		ConsoleUtils.writeNewLine();
		users.stream().forEach(user-> {
		
			System.out.print("User Id: ");
		System.out.print(user.getUserId());
		System.out.print(" |  First name: ");
		System.out.print(user.getFirstName());
		System.out.print(" |  Last name: ");
		System.out.print(user.getLastName());
		System.out.print(" |  Email: ");
		System.out.print(user.getEmail());
		System.out.print(" |  Username: ");
		System.out.print(user.getUsername());
		System.out.print(" |  Password: ");
		System.out.print(user.getPassword());
		System.out.println();
		
		});
		
		
		ConsoleUtils.writeNewLine();
		 
		ConsoleUtils.writeLine("Press 1 to go back:"); int option = ConsoleUtils.readInteger();
		System.out.println();
		
		while(true) {
			switch (option) {
				case 1: {
					backToAdminMenu();
					break;
				}
				
				default:
					ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
			}	
		}	
	}
	
	public void viewAllAdmins() {
		
		ListMenu.allGenresMenu();
		
		List<User> admins = userService.getAllAdmins();
		
		ConsoleUtils.writeLine("User names:");
		ConsoleUtils.writeNewLine();
		
		admins.stream().forEach(admin-> { 
			
			System.out.print("User Id: ");
			System.out.print(admin.getUserId());
			System.out.print(" |  First name: ");
			System.out.print(admin.getFirstName());
			System.out.print(" |  Last name: ");
			System.out.print(admin.getLastName());
			System.out.print(" |  Email: ");
			System.out.print(admin.getEmail());
			System.out.print(" |  Username: ");
			System.out.print(admin.getUsername());
			System.out.print(" |  Password: ");
			System.out.print(admin.getPassword());
			System.out.println();

			
			});
		
		ConsoleUtils.writeNewLine();
		 
		ConsoleUtils.writeLine("Press 1 to go back:"); int option = ConsoleUtils.readInteger();
		System.out.println();
		
		while(true) {
			switch (option) {
				case 1: {
					backToAdminMenu();
					break;
				}
				
				default:
					ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
			}	
		}	
	}
	
	private void backToAdminMenu() {
		AdministrationController administrationController = new AdministrationController();
		administrationController.run();
    }
}
