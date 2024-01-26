package niky.postgresapi.dao;

import java.util.Optional;

import niky.postgresapi.domain.Author;

public interface AuthorDao {

  void create(Author author);

  Optional<Author> findOne(long l);
  
}
