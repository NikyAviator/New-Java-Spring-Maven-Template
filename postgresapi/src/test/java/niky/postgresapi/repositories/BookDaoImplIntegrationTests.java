// package niky.postgresapi.repositories;

// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.annotation.DirtiesContext;

// import niky.postgresapi.TestDataUtil;
// import niky.postgresapi.domain.Author;
// import niky.postgresapi.domain.Book;

// // Transactional: This will ensure that each test is run in a transaction, which is rolled back at the end of the test, keeping your database state clean for each test.
// @SpringBootTest
// @DirtiesContext (classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) 
// public class BookDaoImplIntegrationTests {

//   private BookDaoImpl underTest;
//   private AuthorDaoImpl authorDaoImpl;

//   // Tells Spring to inject the dependency/ies as declared in this constructor.
//   @Autowired
//   public BookDaoImplIntegrationTests(BookDaoImpl underTest, AuthorDaoImpl authorDaoImpl) {
//     this.underTest = underTest;
//     this.authorDaoImpl = authorDaoImpl;
//   }

//   @Test
//   public void testThatBookCanBeCreatedAndRecalled() {
//     Author author = TestDataUtil.createTestAuthorA();
//     authorDaoImpl.create(author);
//     // Assuming the create method or the Author object now has the generated ID
//     Long generatedAuthorId = author.getId();
//     Book book = TestDataUtil.createTestBookA();
//     book.setAuthorId(generatedAuthorId);
//     underTest.create(book);
//     Optional<Book> result = underTest.findOne(book.getIsbn());
//     assert (result).isPresent();
//     assert (result.get()).equals(book);

//   }
  
//   @Test
//   public void testThatMultipleBooksCanBeCreatedAndRecalled() {
//     Author author = TestDataUtil.createTestAuthorA();
//     authorDaoImpl.create(author);

//     Book bookA = TestDataUtil.createTestBookA();
//     bookA.setAuthorId(author.getId());
//     underTest.create(bookA);

//     Book bookB = TestDataUtil.createTestBookB();
//     bookB.setAuthorId(author.getId());
//     underTest.create(bookB);

//     Book bookC = TestDataUtil.createTestBookC();
//     bookC.setAuthorId(author.getId());
//     underTest.create(bookC);

//     List<Book> result = underTest.find();
//     assert (result).size() == 3;
//     assert (result).get(0).equals(bookA);
//     assert (result).get(1).equals(bookB);
//     assert (result).get(2).equals(bookC);

//   }
  
//   @Test
//   public void testThatBookCanBeUpdated() {
//     Author author = TestDataUtil.createTestAuthorA();
//     authorDaoImpl.create(author);

//     Book bookA = TestDataUtil.createTestBookA();
//     bookA.setAuthorId(author.getId());
//     underTest.create(bookA);

//     bookA.setTitle("UPDATED TITLE");
//     underTest.update(bookA.getIsbn(), bookA);

//     Optional<Book> result = underTest.findOne(bookA.getIsbn());
//     assert (result).isPresent();
//     assert (result.get()).equals(bookA);
//   }
  
//   @Test
//   public void testThatBookCanBeDeleted() {
//     Author author = TestDataUtil.createTestAuthorA();
//     authorDaoImpl.create(author);

//     Book bookA = TestDataUtil.createTestBookA();
//     bookA.setAuthorId(author.getId());
//     underTest.create(bookA);

//     underTest.delete(bookA.getIsbn());

//     Optional<Book> result = underTest.findOne(bookA.getIsbn());
//     assert (result).isEmpty();
//   }


// }
