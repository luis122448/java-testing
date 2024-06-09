package luis122448.movies.data;

import luis122448.movies.model.MovieModel;

import java.util.List;

public interface MovieRepository {

    MovieModel findById(Integer id);
    List<MovieModel> findByTitle(String title);
    List<MovieModel> findAll();
    void save(MovieModel movie);
}
