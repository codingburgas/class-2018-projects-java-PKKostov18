package models;

import java.util.Objects;

public class Movie {
	
    private int movieId;
    private String movieName;
    private String movieOrSeries;
    private int yearOfPublishing;
    private String description;
    private String company;
    private int duration;
    private double IMDB_score;
    private int numberOfSeasons;

    public Movie(int movieId, String movieName, String movieOrSeries, int yearOfPublishing, String description,
			String company, int duration, double IMDB_score, int numberOfSeasons) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieOrSeries = movieOrSeries;
		this.yearOfPublishing = yearOfPublishing;
		this.description = description;
		this.company = company;
		this.duration = duration;
		this.IMDB_score = IMDB_score;
		this.numberOfSeasons = numberOfSeasons;
	}
    
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieOrSeries() {
		return movieOrSeries;
	}

	public void setMovieOrSeries(String movieOrSeries) {
		this.movieOrSeries = movieOrSeries;
	}

	public int getYearOfPublishing() {
		return yearOfPublishing;
	}

	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getIMDB_score() {
		return IMDB_score;
	}

	public void setIMDB_score(double iMDB_score) {
		IMDB_score = iMDB_score;
	}
	
	public int getNumberOfSeasons() {
		return numberOfSeasons;
	}

	public void setNumberOfSeasons(int numberOfSeasons) {
		this.numberOfSeasons = numberOfSeasons;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieId, movie.movieId);
    }
	
    @Override
    public String toString() {
        return "Movie{" +
                " movieId = " + movieId + 
                ", movieName = " + movieName + '\'' +
                ", movieOrSeries = " + movieOrSeries + '\'' +
                ", yearOfPublishing = " + yearOfPublishing + '\'' +
                ", description = " + description + '\'' +
                ", company = " + company + '\'' +
                ", duration = " + duration + '\'' +
                ", IMDB_score = " + IMDB_score + '\'' +
                ", numberOfSeasons = " + numberOfSeasons +
                '}';
    }
}