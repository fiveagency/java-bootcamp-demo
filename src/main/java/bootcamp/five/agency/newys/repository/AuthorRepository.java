package bootcamp.five.agency.newys.repository;

import bootcamp.five.agency.newys.domain.Author;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author, Long> {

  // Native SQL Query example
  @Query(nativeQuery = true, value = "SELECT * FROM Author author WHERE author.first_name = :firstName AND author.last_name = :lastName")
  Author findAuthorByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

  /*
  // JPQL Query example
  @Query(value = "SELECT a FROM author a WHERE a.firstName = :firstName AND a.lastName = :lastName")
  Author findAuthorByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

  // Named Method Query example
  Author findAuthorByFirstNameAndLastName(String firstName, String lastName);
   */

  Author findAuthorByEmail(String email);

  Author findAuthorByType(String type);

  List<Author> findByType(String type);

}
