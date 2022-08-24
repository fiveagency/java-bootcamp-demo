package bootcamp.five.agency.newys.services.author;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
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

    AuthorDetailsResponseDto authorDetailsResponseDto = updateAuthorService.updateAuthor(id, firstName, lastName, email, type);

    assertThat(authorDetailsResponseDto.getId().equals(id));
    assertThat(authorDetailsResponseDto.getFirstName().equals(firstName));
    assertThat(authorDetailsResponseDto.getLastName().equals(lastName));
    assertThat(authorDetailsResponseDto.getEmail().equals(email));
    assertThat(authorDetailsResponseDto.getType().equals(type));
  }

}
