package tests.repositoriestest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import models.Movie;
import repositories.MovieRepository;

class getAllSeriesTest {

	@Test
	void getAllSeriesTests() {
		MovieRepository test= new MovieRepository();
		List<Movie>tests=test.getAllSeries();
		assertNotNull(tests);
		
	}

	
}