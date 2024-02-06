package niky.postgresapi.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "books")
public class Book {

  @Id
  // we will provide the isbn at creation (design choice), so no generated sequence is needed.
  private String isbn;

  private String title;
  
  // cascade means: if we get a book back, take that author on the book and make some changes, those changes will be reflected in the database.
  // cascade = CascadeType.ALL means that if we delete a book, the author will be deleted as well.
  // JoinColumn is used to specify the foreign key column in the database.
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "author_id")
  private Author author;
  
}
