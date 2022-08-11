package bootcamp.five.agency.newys.services.author;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateAuthorServiceTest {

  @Autowired
  private CreateAuthorService createAuthorService;

  @Test
  public void createAuthor_AuthorCreated_True() {
    final String firstName = "Rocky";
    final String lastName = "Balboa";
    final String email = "rocky.balboa@mail.com";
    final String type = "sport";

    Author author = createAuthorService.createAuthor(firstName, lastName, email, type);

    assertThat(author.getId() != null);
    assertThat(author.getFirstName().equals(firstName));
    assertThat(author.getLastName().equals(lastName));
    assertThat(author.getEmail().equals(email));
    assertThat(author.getType().equals(type));
  }

}
