package niky.postgresapi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import niky.postgresapi.dao.BookDao;
import niky.postgresapi.domain.Book;

public class BookDaoImpl implements BookDao {
  
  private final JdbcTemplate jdbcTemplate;

  public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  // Create Method
  @Override
  public void create(Book book) {
    jdbcTemplate.update(
        "INSERT INTO books (isbn, title, authorId) VALUES (?, ?, ?)",
        book.getIsbn(),
        book.getTitle(),
        book.getAuthorId()
    );
  }

  // Find Method
  @Override
  public Optional<Book> find(String isbn) {
    List<Book>results =  jdbcTemplate.query(
      "SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1",
      new BookRowMapper(),
      isbn

    );
    return results.stream().findFirst();
  }

  public static class BookRowMapper implements RowMapper<Book> {
    
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
      return Book.builder()
        .isbn(rs.getString("isbn"))
        .title(rs.getString("title"))
        .authorId(rs.getLong("author_id"))
        .build();
    }
  }
 
  
}
