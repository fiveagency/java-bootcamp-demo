package bootcamp.five.agency.newys.services.author;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdateAuthorServiceTest {

  @Autowired
  private UpdateAuthorService updateAuthorService;

  @Test
  public void updateAuthor_AuthorUpdated_True() {
    final Long id = 1L;
    final String firstName = "John";
    final String lastName = "Doe";
    final String email = "john.doe@mail.com";
    final String type = "tech";

    Author author = updateAuthorService.updateAuthor(id, firstName, lastName, email, type);

    assertThat(author.getId().equals(id));
    assertThat(author.getFirstName().equals(firstName));
    assertThat(author.getLastName().equals(lastName));
    assertThat(author.getEmail().equals(email));
    assertThat(author.getType().equals(type));
  }

}
