package controller;

import java.util.List;
import java.util.stream.Collectors;

import menus.ErrorMenu;
import menus.ListMenu;
import models.User;
import services.AuthenticationService;
import services.UserService;
import utils.ConsoleUtils;

public class UserController {
	
	private final UserService userService;
	private final AuthenticationService authService;
	
	User user = null;
	
	public UserController() {
		this.userService = UserService.getInstance();
		this.authService = AuthenticationService.getInstance();	
    }
	
	public void viewAllUsers() {
		
		ListMenu.allGenresMenu();
		
		List<User> users = userService.getAllUsers();
		
		ConsoleUtils.writeLine("User names:");
		ConsoleUtils.writeNewLine();
		users.stream().forEach(user-> {
		
			ConsoleUtils.writeNewLine();
			ConsoleUtils.write("User Id: ");
			ConsoleUtils.writeInteger(user.getUserId());
			ConsoleUtils.write(" |  First name: ");
			ConsoleUtils.write(user.getFirstName());
			ConsoleUtils.write(" |  Last name: ");
			ConsoleUtils.write(user.getLastName());
			ConsoleUtils.write(" |  Email: ");
			ConsoleUtils.write(user.getEmail());
			ConsoleUtils.write(" |  Username: ");
			ConsoleUtils.write(user.getUsername());
			ConsoleUtils.write(" |  Password: ");
			ConsoleUtils.write(user.getPassword());
			ConsoleUtils.writeNewLine();
		
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
	
	public void deleteUserById() {
		
		ConsoleUtils.writeNewLine();
		ListMenu.deleteUserMenu();
		ConsoleUtils.writeNewLine();

		List<User> users = userService.getAllUsers();
		List<Integer> getAllIds = users.stream().map(id -> id.getUserId()).collect(Collectors.toList());

		ConsoleUtils.writeNewLine();
		users.stream().forEach(user -> {

			ConsoleUtils.write("User ID: ");
			ConsoleUtils.writeInteger(user.getUserId());
	
			ConsoleUtils.write(" | Username: ");
			ConsoleUtils.writeLine(user.getUsername());
		});
		ConsoleUtils.writeNewLine();

		ConsoleUtils.write("Type the id of the user you want to delete: "); int id = ConsoleUtils.readInteger();

		while(!getAllIds.contains(id)) {
			ConsoleUtils.writeNewLine();
			ErrorMenu.invalidDataError();
			ConsoleUtils.write("Type the id of the user you want to delete: "); id = ConsoleUtils.readInteger();
			ConsoleUtils.writeNewLine();
		}

		userService.deleteUserById(id);

		ConsoleUtils.writeNewLine();
		ConsoleUtils.writeLine("Successfully deleted!");
		ConsoleUtils.write("Type 1 to back: "); int option = ConsoleUtils.readInteger();
		ConsoleUtils.writeNewLine();

		while(option != 1) {
			ConsoleUtils.writeNewLine();
			ErrorMenu.invalidInputError();
			ConsoleUtils.write("Type 1 to back: "); option = ConsoleUtils.readInteger();
			ConsoleUtils.writeNewLine();
		}

		backToAdminMenu();
	}
	
	public void deletePersonalAccountById() {
		
		ConsoleUtils.writeNewLine();
		ListMenu.deletePersonalAccountMenu();
		ConsoleUtils.writeNewLine();
		
		ConsoleUtils.writeLine("All the data will be deleted!!!");
		ConsoleUtils.writeNewLine();
		ConsoleUtils.writeLine("Are you sure you want to delete your account?");
		ConsoleUtils.writeLine("Yes or No");
		ConsoleUtils.write("Choose: "); String optionYesOrNo = ConsoleUtils.read();
		
		while(true) {
			switch (optionYesOrNo) {
				case "Yes": {
					
					User user = authService.getLoggedUser();
					userService.deleteUserById(user.getUserId());
					
					ConsoleUtils.writeNewLine();
					ConsoleUtils.writeLine("Successfully deleted!");
					ConsoleUtils.write("Type 1 to back: "); int option = ConsoleUtils.readInteger();
					ConsoleUtils.writeNewLine();
					
					while(true) {
						switch (option) {
						case 1:
							authService.destroySession();
							backToMainMenu();
							break;
	
						default:
							ConsoleUtils.writeNewLine();
							ErrorMenu.invalidInputError();
							ConsoleUtils.write("Type 1 to back: "); option = ConsoleUtils.readInteger();
						}
					}
				}
				case "No": {
					
					ConsoleUtils.writeNewLine();
					ConsoleUtils.writeLine("You canceled the deletion!");
					ConsoleUtils.write("Type 1 to back: "); int option = ConsoleUtils.readInteger();
					ConsoleUtils.writeNewLine();
					
					while(true) {
						switch (option) {
						case 1:

						    user = authService.getLoggedUser();
							
							if(user.getAdmin()) {
								backToAdminMenu();
							}
							else {
								backToUserMenu();
							}
							break;
	
						default:
							ConsoleUtils.writeNewLine();
							ErrorMenu.invalidInputError();
							ConsoleUtils.write("Type 1 to back: "); option = ConsoleUtils.readInteger();
						}
					}
				}
				default:
					ErrorMenu.invalidDataError(); 
					ConsoleUtils.writeLine("Yes or No");
					ConsoleUtils.write("Choose: "); optionYesOrNo = ConsoleUtils.read();
			}
		}
	}
	
	public void makeUserAdminById() {
		
		ConsoleUtils.writeNewLine();
		ListMenu.makeUserAdmin();
		ConsoleUtils.writeNewLine();
		
		List<User> users = userService.getAllUsers();
		List<Integer> getAllIds = users.stream().map(id -> id.getUserId()).collect(Collectors.toList());
		
		ConsoleUtils.writeNewLine();
		users.stream().forEach(user -> {

			ConsoleUtils.write("User ID: ");
			ConsoleUtils.writeInteger(user.getUserId());
	
			ConsoleUtils.write(" | Username: ");
			ConsoleUtils.writeLine(user.getUsername());
		});
		ConsoleUtils.writeNewLine();
		
		ConsoleUtils.write("Type the id of the user you want to make admin: "); int id = ConsoleUtils.readInteger();
		
		while(!getAllIds.contains(id)) {
			ConsoleUtils.writeNewLine();
			ErrorMenu.invalidDataError();
			ConsoleUtils.write("Type the id of the user you want to make admin: "); id = ConsoleUtils.readInteger();
			ConsoleUtils.writeNewLine();
		}
			
		userService.makeUserAdmin(id);
		
		ConsoleUtils.writeNewLine();
		ConsoleUtils.writeLine("Successfully done!");
		ConsoleUtils.write("Type 1 to back: "); int option = ConsoleUtils.readInteger();
		ConsoleUtils.writeNewLine();

		while(option != 1) {
			ConsoleUtils.writeNewLine();
			ErrorMenu.invalidInputError();
			ConsoleUtils.write("Type 1 to back: "); option = ConsoleUtils.readInteger();
			ConsoleUtils.writeNewLine();
		}

		backToAdminMenu();
	}
	
	private void backToAdminMenu() {
		AdministrationController administrationController = new AdministrationController();
		administrationController.run();
    }
	
	private void backToMainMenu() {
		MainController mainMenu = new MainController();
		mainMenu.run();
    }
	
	private void backToUserMenu() {
		LoggedUserManagementController loggedUserManagementController = new LoggedUserManagementController();
		loggedUserManagementController.run();
    }
}
