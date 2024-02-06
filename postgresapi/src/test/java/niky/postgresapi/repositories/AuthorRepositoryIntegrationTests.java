package niky.postgresapi.repositories;

import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import niky.postgresapi.TestDataUtil;
import niky.postgresapi.domain.Author;

//Han la till detta (check syntax if using), men:
// Jag har redan löst med med att ha unique id för varje test, så jag behöver inte rensa databasen (the context) efter varje test. 
// När jag körde class testerna så bugga det, så jag la till DirtiesContext (classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) igen.
@SpringBootTest
@DirtiesContext (classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) 
public class AuthorRepositoryIntegrationTests {

  private AuthorRepository underTest;

  // Tells Spring to inject the dependency/ies as declared in this constructor.
  @Autowired
  public AuthorRepositoryIntegrationTests(AuthorRepository underTest) {
    this.underTest = underTest;
  }


  @Test
  public void testThatAuthorCanBeCreatedAndRecalled() {
    Author author = TestDataUtil.createTestAuthorA();
    underTest.save(author);
    Optional<Author> result = underTest.findById(author.getId());
    assert (result.isPresent());
    assert (result.get()).equals(author);
  }

  // @Test
  // public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
  //   Author authorA = TestDataUtil.createTestAuthorA();
  //   underTest.create(authorA);
  //   Author authorB = TestDataUtil.createTestAuthorB();
  //   underTest.create(authorB);
  //   Author authorC = TestDataUtil.createTestAuthorC();
  //   underTest.create(authorC);

  //   List<Author> result = underTest.find();
  //   //assert (result.size() == 3):(result.containsAll(Arrays.asList(authorA, authorB, authorC)));

  //   assert (result).size() == 3;
  //   assert (result).get(0).equals(authorA);
  //   assert (result).get(1).equals(authorB);
  //   assert (result).get(2).equals(authorC);
  // }

  // @Test
  // public void testThatAuthorCanBeUpdated() {
  //   Author authorA = TestDataUtil.createTestAuthorA();
  //   underTest.create(authorA);
  //   authorA.setName("UPDATED NAME");
  //   underTest.update(authorA);
  //   Optional<Author> result = underTest.findOne(authorA.getId());
  //   assert (result.isPresent());
  //   assert (result.get()).equals(authorA);
  // }

  // @Test
  // public void testThatAuthorCanBeDeleted() {
  //   Author authorA = TestDataUtil.createTestAuthorA();
  //   underTest.create(authorA);
  //   underTest.delete(authorA.getId());
  //   Optional<Author> result = underTest.findOne(authorA.getId());
  //   assert (result.isEmpty());
  // }
}
