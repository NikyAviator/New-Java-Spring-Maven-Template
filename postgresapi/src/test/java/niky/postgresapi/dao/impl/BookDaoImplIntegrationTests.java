package niky.postgresapi.dao.impl;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import niky.postgresapi.TestDataUtil;
import niky.postgresapi.domain.Author;
import niky.postgresapi.domain.Book;

// Transactional: This will ensure that each test is run in a transaction, which is rolled back at the end of the test, keeping your database state clean for each test.
@SpringBootTest
public class BookDaoImplIntegrationTests {

  private BookDaoImpl underTest;
  private AuthorDaoImpl authorDaoImpl;

  // Tells Spring to inject the dependency/ies as declared in this constructor.
  @Autowired
  public BookDaoImplIntegrationTests(BookDaoImpl underTest, AuthorDaoImpl authorDaoImpl) {
    this.underTest = underTest;
    this.authorDaoImpl = authorDaoImpl;
  }

  @Test
  public void testThatBookCanBeCreatedAndRecalled() {
    Author author = TestDataUtil.createTestAuthor();
    authorDaoImpl.create(author);
    // Assuming the create method or the Author object now has the generated ID
    Long generatedAuthorId = author.getId();
    Book book = TestDataUtil.createTestBook();
    book.setAuthorId(generatedAuthorId);
    underTest.create(book);
    Optional<Book> result = underTest.find(book.getIsbn());
    assert (result).isPresent();
    assert (result.get()).equals(book);
    
  }


}
