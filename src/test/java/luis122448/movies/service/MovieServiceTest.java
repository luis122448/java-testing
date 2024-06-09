package luis122448.movies.service;

import luis122448.movies.data.MovieRepository;
import luis122448.movies.model.GenreEnum;
import luis122448.movies.model.MovieModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    private static MovieRepository movieRepository;
    private static MovieService movieService;
    @BeforeAll
    static void beforeAll() {
        movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                List.of(
                        new MovieModel(1, "The Godfather",152, GenreEnum.DRAMA),
                        new MovieModel(2, "The Hangover",113, GenreEnum.COMEDY),
                        new MovieModel(3, "The Godfather II",154, GenreEnum.DRAMA),
                        new MovieModel(4, "The Godfather III",162, GenreEnum.DRAMA),
                        new MovieModel(5, "The Hangover II",102, GenreEnum.COMEDY),
                        new MovieModel(6, "The Hangover III",100, GenreEnum.COMEDY)
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre(){
        List<MovieModel> movieModels = movieService.findByGenre(GenreEnum.COMEDY);
        List<Integer> movieIds = movieModels.stream().map(MovieModel::getId).toList();
        assertEquals(List.of(2,5,6), movieIds);
    }

    @Test
    public void return_movies_by_length(){
        List<MovieModel> movieModels = movieService.findByLength(102);
        List<Integer> movieIds = movieModels.stream().map(MovieModel::getId).toList();
        assertEquals(List.of(5,6), movieIds);
    }

    @Test
    public void return_movies_by_ids(){
        List<MovieModel> movieModels = movieService.findByIds(List.of(1,5,6));
        List<Integer> movieIds = movieModels.stream().map(MovieModel::getId).toList();
        assertEquals(List.of(1,5,6), movieIds);
    }

}