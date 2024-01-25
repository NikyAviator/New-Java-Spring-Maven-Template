package niky.postgresapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
  // Long, so it can be null, and we can use it as a primary key.
  private Long id;

  private String name;

  private Integer age;
  
}
