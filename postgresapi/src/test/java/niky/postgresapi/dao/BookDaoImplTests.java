package niky.postgresapi.dao;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import niky.postgresapi.dao.impl.BookDaoImpl;
import niky.postgresapi.domain.Book;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

  @Mock
  private JdbcTemplate jdbcTemplate;

  @InjectMocks
  private BookDaoImpl underTest;
  
  @Test
  public void testThatCreateBookGeneratesCorrectSql() {
    Book book = Book.builder().isbn("978-1-2345-6789-0").title("The Shadow in the Attic.").authorId(1L).build();

    underTest.create(book);

    verify(jdbcTemplate).update(
        eq("INSERT INTO books (isbn, title, authorId) VALUES (?, ?, ?)"),
        eq("978-1-2345-6789-0"),
        eq("The Shadow in the Attic."),
        eq(1L)
    );
  }
}