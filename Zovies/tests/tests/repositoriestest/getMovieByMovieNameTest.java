package tests.repositoriestest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import models.Movie;
import repositories.MovieRepository;

class getMovieByMovieNameTest {

	@Test
	void getMovieByMovieNameTests() {
		MovieRepository test= new MovieRepository();
		Movie tests=test.getMovieByMovieName("Rocky");
		assertNotNull(tests);
		
	}

	
}