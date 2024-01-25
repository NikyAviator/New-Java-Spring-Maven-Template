package niky.postgresapi.dao.impl;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import niky.postgresapi.domain.Author;

// Unit tests with JUnit 5 and Mockito
@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {
  
  @Mock
  private JdbcTemplate jdbcTemplate;
  
  
  @InjectMocks
  private AuthorDaoImpl underTest;

  @Test
  public void testThatCreateAuthorGeneratesCorrectSql() {
    Author author = Author.builder().id(1L).name("Abigail Rose").age(80).build();

    underTest.create(author);

    verify(jdbcTemplate).update(
      eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
      eq(1L), eq("Abigail Rose"), eq(80)
    );

  }

}
