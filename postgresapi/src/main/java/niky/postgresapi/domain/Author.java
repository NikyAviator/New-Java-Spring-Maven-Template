package niky.postgresapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {
  // Long, so it can be null, and we can use it as a primary key.
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
  private Long id;

  private String name;

  private Integer age;
  
}
