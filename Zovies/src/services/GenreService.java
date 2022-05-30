package services;

import java.util.List;

import models.Genre;
import repositories.GenreRepository;
import utils.ConsoleUtils;

public class GenreService {
	
	private static GenreService instance = null;
	private final GenreRepository genreRepository;
	
	private GenreService() {
        this.genreRepository = GenreRepository.getInstance();
    }
	
	public static GenreService getInstance() {

        if (GenreService.instance == null) {
        	GenreService.instance = new GenreService();
		}

        return GenreService.instance;
    }
	
	public List<Genre> getAllGenres() {
		List<Genre> genres = genreRepository.getAllGenres();
		
		ConsoleUtils.writeLine("Movie names:");
		ConsoleUtils.writeNewLine();
		genres.stream().forEach(genre -> System.out.println(genre.getGenre()));
		ConsoleUtils.writeNewLine();
		
		return genres;
	}
}
