package niky.postgresapi.dao;

import java.util.List;
import java.util.Optional;

import niky.postgresapi.domain.Author;

public interface AuthorDao {

  void create(Author author);

  Optional<Author> findOne(long l);

  List<Author> find();

  void update(Author author);
  
  void delete(long authorId);
  
}
