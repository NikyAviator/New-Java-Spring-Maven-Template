package niky.postgresapi.dao.impl;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import niky.postgresapi.TestDataUtil;
import niky.postgresapi.domain.Author;

@SpringBootTest
public class AuhtorDaoImplIntegrationTests {

  private AuthorDaoImpl underTest;

  // Tells Spring to inject the dependency/ies as declared in this constructor.
  @Autowired
  public AuhtorDaoImplIntegrationTests(AuthorDaoImpl underTest) {
    this.underTest = underTest;
  }


  @Test
  public void testThatAuthorCanBeCreatedAndRecalled() {
    Author author = TestDataUtil.createTestAuthor();
    underTest.create(author);
    Optional<Author> result = underTest.findOne(author.getId());
    assert (result.isPresent());
    assert (result.get()).equals(author);



  }
}
