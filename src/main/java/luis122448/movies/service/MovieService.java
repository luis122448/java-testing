package luis122448.movies.service;

import luis122448.movies.data.MovieRepository;
import luis122448.movies.model.GenreEnum;
import luis122448.movies.model.MovieModel;

import java.util.List;

public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public List<MovieModel> findByGenre(GenreEnum genreEnum) {
        return movieRepository.findAll().stream()
                .filter(movieModel -> movieModel.getGenre().equals(genreEnum))
                .toList();
    }

    public List<MovieModel> findByLength(int i) {
        return movieRepository.findAll().stream()
                .filter(movieModel -> movieModel.getMinutes() <= i)
                .toList();
    }

    public MovieModel findById(int i) {
        return movieRepository.findById(i);
    }

    public List<MovieModel> findByIds(List<Integer> integers) {
        return movieRepository.findAll().stream()
                .filter(movieModel -> integers.contains(movieModel.getId()))
                .toList();
    }
}
