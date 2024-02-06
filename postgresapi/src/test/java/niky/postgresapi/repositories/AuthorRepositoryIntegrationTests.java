package niky.postgresapi.repositories;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import jakarta.transaction.Transactional;
import niky.postgresapi.TestDataUtil;
import niky.postgresapi.domain.Author;

//Han la till detta (check syntax if using), men:
// Jag har redan löst med med att ha unique id för varje test, så jag behöver inte rensa databasen (the context) efter varje test. 
// När jag körde class testerna så bugga det, så jag la till DirtiesContext (classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) igen.
// @DirtiesContext (classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) 
@SpringBootTest
@Transactional
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

  @Test
  public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
    Author authorA = TestDataUtil.createTestAuthorA();
    underTest.save(authorA);
    Author authorB = TestDataUtil.createTestAuthorB();
    underTest.save(authorB);
    Author authorC = TestDataUtil.createTestAuthorC();
    underTest.save(authorC);

    Iterable<Author> result = underTest.findAll();
    //assert (result.size() == 3):(result.containsAll(Arrays.asList(authorA, authorB, authorC)));

    assertThat(result).hasSize(3).containsExactly(authorA, authorB, authorC);
  }

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
