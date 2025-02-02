package luis122448.movies.model;

import java.util.Objects;

public class MovieModel {

    private Integer id;
    private String title;
    private Integer minutes;
    private GenreEnum genre;

    public MovieModel(String title, Integer minutes, GenreEnum genre) {
        this.id = null;
        this.title = title;
        this.minutes = minutes;
        this.genre = genre;
    }
    public MovieModel(Integer id, String title, Integer minutes, GenreEnum genre) {
        this.id = id;
        this.title = title;
        this.minutes = minutes;
        this.genre = genre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieModel that = (MovieModel) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(minutes, that.minutes) && genre == that.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, minutes, genre);
    }
}
