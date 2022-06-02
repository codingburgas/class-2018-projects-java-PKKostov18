package controller;

import java.util.List;
import java.util.stream.Collectors;

import menus.ErrorMenu;
import menus.ListMenu;
import models.Genre;
import services.GenreService;
import utils.ConsoleUtils;

public class GenreController {

	
	private final GenreService genreService;
	
	Genre genre = null;
	
	public GenreController() {
		this.genreService = GenreService.getInstance();
		
    }
	
	public void viewAllGenres() {
		
		ListMenu.allGenresMenu();
		
		List<Genre> genres = genreService.getAllGenres();
		
		ConsoleUtils.writeLine("Genre names:");
		ConsoleUtils.writeNewLine();
		genres.stream().forEach(genre-> System.out.println(genre.getGenre()));
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
	
	public void insertGenre() {
		
		ConsoleUtils.writeNewLine();
		ListMenu.insertGenreMenu();
		ConsoleUtils.writeNewLine();
		
		ConsoleUtils.write("Genre name: "); String genre = ConsoleUtils.read();
		
			
			genreService.insertGenre(genre);
			
			ConsoleUtils.writeLine("Successfully added the genre!");
			ConsoleUtils.write("Type 1 to back: "); int option = ConsoleUtils.readInteger();
			
			while(option != 1) {
				ErrorMenu.invalidInputError();
				ConsoleUtils.write("Type 1 to back: "); option = ConsoleUtils.readInteger();
			}
			
			backToAdminMenu();
		} 	

	public void deleteGenre() {
		
		ConsoleUtils.writeNewLine();
		ListMenu.deleteMovieOrSeriesMenu();
		ConsoleUtils.writeNewLine();
		
		List<Genre> genres = genreService.getAllGenres();
		List<Integer> getAllIds = genres.stream().map(id -> id.getGenreId()).collect(Collectors.toList());
		
		ConsoleUtils.writeNewLine();
		
		genres.stream().forEach(genre -> {
			
			ConsoleUtils.write("Genre ID: "); 
			ConsoleUtils.writeInteger(genre.getGenreId()); 
			
			ConsoleUtils.write(" |  genre name: "); 
			ConsoleUtils.writeLine(genre.getGenre());
		});
		
		ConsoleUtils.writeNewLine();
		
		ConsoleUtils.write("Type the id of the genre you want to delete: "); int id = ConsoleUtils.readInteger();
		
		while(!getAllIds.contains(id)) {
			ConsoleUtils.writeNewLine();
			ErrorMenu.invalidDataError();
			ConsoleUtils.write("Type the id of the genre you want to delete: "); id = ConsoleUtils.readInteger();
			ConsoleUtils.writeNewLine();
		}
		
		genreService.deleteActor(id);
		
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
	
	
}
