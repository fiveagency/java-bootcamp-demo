package bootcamp.five.agency.newys.services.author;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.domain.Author;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetAuthorServiceTest {

  @Autowired
  public GetAuthorService getAuthorService;

  @Test
  public void getAuthorById_AuthorFetched_True() {
    final Long id = 1L;

    Author author = getAuthorService.getAuthorById(id);

    assertThat(author.getId().equals(id));
  }

  @Test
  public void getAuthorByFirstNameAndLastName_AuthorFetched_True() {
    final String firstName = "John";
    final String lastName = "Doe";

    Author author = getAuthorService.getAuthorByFirstNameAndLastName(firstName, lastName);

    assertThat(author.getFirstName().equals(firstName));
    assertThat(author.getLastName().equals(lastName));
  }

  @Test
  public void getAuthorByEmail_AuthorFetched_True() {
    final String email = "john.doe@mail.com";

    Author author = getAuthorService.getAuthorByEmail(email);

    assertThat(author.getEmail().equals(email));
  }

  @Test void getNumberOfArticles_NumberOfArticlesIsZero_True() {
    final Long id = 1L;

    Integer numberOfArticles = getAuthorService.getNumberOfArticles(id);

    assertThat(numberOfArticles == 0);
  }

  @Test
  public void getByType_TypeAuthorsFetched_True() {
    final String type = "tech";

    List<Author> authors = getAuthorService.getByType(type);

    assertThat(!authors.isEmpty());
    assertThat(authors.stream().anyMatch(author -> author.getType().equals(type)));
  }

  @Test
  public void getAll_AllAuthorsFetched_True() {
    List<Author> authors = getAuthorService.getAll();

    assertThat(!authors.isEmpty());
  }

}
