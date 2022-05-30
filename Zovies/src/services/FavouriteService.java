package services;

import repositories.FavouriteRepository;

public class FavouriteService {
	
	private static FavouriteService instance = null;
	private final FavouriteRepository favouriteRepository;
	
	private FavouriteService() {
		this.favouriteRepository = FavouriteRepository.getInstance();
    }
	
	public static FavouriteService getInstance() {

        if (FavouriteService.instance == null) {
        	FavouriteService.instance = new FavouriteService();
		}

        return FavouriteService.instance;
    }
	
	public void insertFavouriteMovieOrSeries(int movieId, int userId) {
		favouriteRepository.insertFavouriteMovieOrSeries(movieId, userId);
	}
	
	public void deleteFavouriteMovieOrSeries(String movieName, int userId) {
		favouriteRepository.deleteFavouriteMovieOrSeries(movieName, userId);
	}
	
	public boolean getFavouriteMovieOrSeries(int movieId, int userId) {
		boolean getFavouriteMovieOrSeries = favouriteRepository.getFavouriteMovieOrSeries(movieId, userId);
		return getFavouriteMovieOrSeries;
	}
	
	public boolean getFavouriteMovieOrSeriesByUserId(int userId, String movieName) {
		boolean getFavouriteMovieOrSeriesByUserId = favouriteRepository.getFavouriteMovieOrSeriesByUserId(userId, movieName);
		return getFavouriteMovieOrSeriesByUserId;
	}
}
