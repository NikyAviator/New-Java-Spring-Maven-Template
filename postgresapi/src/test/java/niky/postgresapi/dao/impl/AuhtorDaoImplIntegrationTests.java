package niky.postgresapi.dao.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import niky.postgresapi.TestDataUtil;
import niky.postgresapi.domain.Author;


@SpringBootTest
// @DirtiesContext (classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) Han la till detta (check syntax if using), men:
// Jag har redan löst med med att ha unique id för varje test, så jag behöver inte rensa databasen (the context) efter varje test. 
public class AuhtorDaoImplIntegrationTests {

  private AuthorDaoImpl underTest;

  // Tells Spring to inject the dependency/ies as declared in this constructor.
  @Autowired
  public AuhtorDaoImplIntegrationTests(AuthorDaoImpl underTest) {
    this.underTest = underTest;
  }


  @Test
  public void testThatAuthorCanBeCreatedAndRecalled() {
    Author author = TestDataUtil.createTestAuthorA();
    underTest.create(author);
    Optional<Author> result = underTest.findOne(author.getId());
    assert (result.isPresent());
    assert (result.get()).equals(author);
  }

  @Test
  public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
    Author authorA = TestDataUtil.createTestAuthorA();
    underTest.create(authorA);
    Author authorB = TestDataUtil.createTestAuthorB();
    underTest.create(authorB);
    Author authorC = TestDataUtil.createTestAuthorC();
    underTest.create(authorC);

    List<Author> result = underTest.find();
    //assert (result.size() == 3):(result.containsAll(Arrays.asList(authorA, authorB, authorC)));

    assert (result).size() == 3;
    assert (result).get(0).equals(authorA);
    assert (result).get(1).equals(authorB);
    assert (result).get(2).equals(authorC);
  }
}
