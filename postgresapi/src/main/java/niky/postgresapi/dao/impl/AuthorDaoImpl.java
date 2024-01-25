package niky.postgresapi.dao.impl;

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

  @Override
  public void create(Author author) {
    jdbcTemplate.update(
      "INSERT INTO authors (id, name, age) VALUES (?, ?, ?)",
      author.getId(), author.getName(), author.getAge()
    );
    
  }
  
  
}
