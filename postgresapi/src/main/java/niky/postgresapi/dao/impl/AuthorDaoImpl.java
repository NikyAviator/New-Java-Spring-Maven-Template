package niky.postgresapi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import niky.postgresapi.dao.AuthorDao;
import niky.postgresapi.domain.Author;

@Repository
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
        "INSERT INTO authors (name, age) VALUES (?, ?)",
        author.getName(),
        author.getAge());

    Long generatedId = jdbcTemplate.queryForObject(
        "SELECT currval('authors_id_seq')", Long.class);
    author.setId(generatedId);
}

  
  // FindOne Method
  @Override
  public Optional<Author> findOne(long authorId) {
    List<Author> results = jdbcTemplate.query(
        "SELECT id, name, age FROM authors WHERE id = ? LIMIT 1",
        new AuthorRowMapper(),
        authorId);
    return results.stream().findFirst();

  }
  // Find Many Method
   @Override
   public List<Author> find() {
     return jdbcTemplate.query(
         "SELECT id, name, age FROM authors",
         new AuthorRowMapper());
   }
  
   // Update Method
  @Override
  public void update( Author author) {
    jdbcTemplate.update(
        "UPDATE authors SET name = ?, age = ? WHERE id = ?",
        author.getName(),
        author.getAge(),
        author.getId());
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
