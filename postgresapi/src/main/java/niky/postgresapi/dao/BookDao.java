package niky.postgresapi.dao;

import java.util.Optional;

import niky.postgresapi.domain.Book;

public interface BookDao {

  void create(Book book);

  Optional<Book> find(String isbn);
  
}
