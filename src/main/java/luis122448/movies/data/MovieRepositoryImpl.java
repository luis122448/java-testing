package luis122448.movies.data;

import luis122448.movies.model.GenreEnum;
import luis122448.movies.model.MovieModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public MovieModel findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", rowMapper, id);
    }

    @Override
    public List<MovieModel> findByTitle(String title) {
        String sql = "SELECT * FROM movies WHERE UPPER(title) LIKE ?";
        String titleParam = "%" + title.toUpperCase() + "%";
        return jdbcTemplate.query(sql, rowMapper, titleParam);
    }

    @Override
    public List<MovieModel> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", rowMapper);
    }

    @Override
    public void save(MovieModel movie) {
        jdbcTemplate.update("INSERT INTO movies (title, minutes, genre) VALUES (?, ?, ?)",
                movie.getTitle(), movie.getMinutes(), movie.getGenre().name());
    }

    private static final RowMapper<MovieModel> rowMapper = (rs, rowNum) -> new MovieModel(
            rs.getInt("id"),
            rs.getString("title"),
            rs.getInt("minutes"),
            GenreEnum.valueOf(rs.getString("genre"))
    );

}
