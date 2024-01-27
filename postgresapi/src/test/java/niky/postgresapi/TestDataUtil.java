package niky.postgresapi;

import niky.postgresapi.domain.Author;

public final class TestDataUtil {

  private TestDataUtil() {
    
  }

  public static Author createTestAuthor() {
    return Author.builder().id(1L).name("Abigail Rose").age(80).build();
  }
  
}
