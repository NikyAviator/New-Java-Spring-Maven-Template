package niky.postgresapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import niky.postgresapi.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{
  
}
