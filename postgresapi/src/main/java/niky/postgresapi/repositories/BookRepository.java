package niky.postgresapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import niky.postgresapi.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String>{
  
}
