package luis122448.movies.data;

import luis122448.movies.model.GenreEnum;
import luis122448.movies.model.MovieModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryImplTest {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void data_base_connect() throws SQLException {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;MODE=MYSQL", "sa", "sa");
        jdbcTemplate = new JdbcTemplate(dataSource);
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
    }

    @Test
    public void load_all_movies(){
        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl(jdbcTemplate);
        Collection<MovieModel> movies = movieRepository.findAll();
        assertEquals(movies, Arrays.asList(
                new MovieModel(1, "The Shawshank Redemption",142, GenreEnum.DRAMA),
                new MovieModel(2, "The Godfather",175, GenreEnum.DRAMA),
                new MovieModel(3, "The Dark Knight",152, GenreEnum.ACTION)
        ));
    }

    @Test
    public void load_movie_by_title(){
        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl(jdbcTemplate);
        Collection<MovieModel> movies = movieRepository.findByTitle("Godfather");
        assertEquals(movies, Arrays.asList(
                new MovieModel(2, "The Godfather",175, GenreEnum.DRAMA)
        ));
    }

    @Test
    public void load_movie_by_id(){
        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl(jdbcTemplate);
        MovieModel movie = movieRepository.findById(1);
        assertEquals(movie, new MovieModel(1, "The Shawshank Redemption",142, GenreEnum.DRAMA));
    }

    @Test
    public void save_movie(){
        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl(jdbcTemplate);
        movieRepository.save(new MovieModel(4, "The Godfather II",202, GenreEnum.DRAMA));
        Collection<MovieModel> movies = movieRepository.findAll();
        assertEquals(movies, Arrays.asList(
                new MovieModel(1, "The Shawshank Redemption",142, GenreEnum.DRAMA),
                new MovieModel(2, "The Godfather",175, GenreEnum.DRAMA),
                new MovieModel(3, "The Dark Knight",152, GenreEnum.ACTION),
                new MovieModel(4, "The Godfather II",202, GenreEnum.DRAMA)
        ));
    }

}