package services;

import java.util.List;

import models.Genre;
import repositories.GenreRepository;

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
		

		
		return genres;
	}
	
	public void insertGenre(String genre) {
		genreRepository.insertGenre(genre);
	}
	
	public void deleteActor(int genreId) {
		genreRepository.deleteGenreById(genreId);;
	}
	
}
