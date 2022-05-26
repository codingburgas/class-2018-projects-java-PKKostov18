package models;

import java.util.Objects;

public class Genre {
	
	private int genreId;
	private String genre;
	
	public Genre(int genreId, String genre) {
		super();
		this.genreId = genreId;
		this.genre = genre;
	}
	
	public int getGenreId() {
		return genreId;
	}
	
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(genreId, genre.genreId);
    }
	
    @Override
    public String toString() {
        return "Genre{" +
                " genreId = " + genreId +
                ", genre = " + genre +
                '}';
    }
}
