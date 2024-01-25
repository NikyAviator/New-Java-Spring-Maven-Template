package niky.postgresapi.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import niky.postgresapi.dao.BookDao;
import niky.postgresapi.domain.Book;

public class BookDaoImpl implements BookDao {
  
  private final JdbcTemplate jdbcTemplate;

  public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void create(Book book) {
    jdbcTemplate.update(
        "INSERT INTO books (isbn, title, authorId) VALUES (?, ?, ?)",
        book.getIsbn(),
        book.getTitle(),
        book.getAuthorId()
    );
  }

 
  
}
