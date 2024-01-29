package niky.postgresapi;

import niky.postgresapi.domain.Author;
import niky.postgresapi.domain.Book;

public final class TestDataUtil {

  private TestDataUtil() {
    
  }

  public static Author createTestAuthorA() {
    return Author.builder().name("Abigail Rose").age(80).build();
  }

  public static Author createTestAuthorB() {
    return Author.builder().name("Thomas Cronin").age(44).build();
  }

  public static Author createTestAuthorC() {
    return Author.builder().name("Jesse Ventura").age(24).build();
  }

  public static Book createTestBook() {
    return Book.builder().isbn("978-1-2345-6789-0").title("The Shadow in the Attic.").authorId(1L).build();
  }
  
}
