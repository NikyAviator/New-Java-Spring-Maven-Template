package niky.postgresapi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import niky.postgresapi.dao.AuthorDao;
import niky.postgresapi.domain.Author;

public class AuthorDaoImpl implements AuthorDao {
  // we autowire the jdbctemplate to the class.
  // final = cannot be reinitialized after constructor. Easier to work with.
  private final JdbcTemplate jdbcTemplate;

  public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  // Create Method
  @Override
  public void create(Author author) {
    jdbcTemplate.update(
        "INSERT INTO authors (id, name, age) VALUES (?, ?, ?)",
        author.getId(), author.getName(), author.getAge());

  }
  
  // FindOne Method
  @Override
  public Optional<Author> findOne(long l) {
    return Optional.empty();
  }
  
  public static class AuthorRowMapper implements RowMapper<Author> {
      
      @Override
      public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Author.builder()
            .id(rs.getLong("id"))
            .name(rs.getString("name"))
            .age(rs.getInt("age"))
            .build();
      }
    
  }
  
}
