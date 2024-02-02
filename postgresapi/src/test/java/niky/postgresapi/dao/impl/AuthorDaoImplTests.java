package niky.postgresapi.dao.impl;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import niky.postgresapi.TestDataUtil;
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
    Author author = TestDataUtil.createTestAuthorA();

    underTest.create(author);

    verify(jdbcTemplate).update(
        eq("INSERT INTO authors (name, age) VALUES (?, ?)"), // Removed 'id'
        eq("Abigail Rose"),
        eq(80));
}

  @Test
  public void testThatFindOneGeneratesCorrectSql() {
    underTest.findOne(1L);
    verify(jdbcTemplate).query(
        eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
        ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
        eq(1L));
  }
  
  @Test
  public void testThatFindManyGeneratesCorrectSql() {
    underTest.find();
    verify(jdbcTemplate).query(
        eq("SELECT id, name, age FROM authors"),
        ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any());
  }

  @Test
  public void testThatUpdateGeneratesCorrectSql() {
    Author author = TestDataUtil.createTestAuthorA();
    underTest.update(author);
    verify(jdbcTemplate).update(
        eq("UPDATE authors SET name = ?, age = ? WHERE id = ?"),
        eq("Abigail Rose"),
        eq(80),
        eq(null));
  }

  @Test
  public void testThatDeleteGeneratesCorrectSql() {
    underTest.delete(1L);
    verify(jdbcTemplate).update(
        eq("DELETE FROM authors WHERE id = ?"),
        eq(1L));
  }


}
