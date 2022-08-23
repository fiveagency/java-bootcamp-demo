package bootcamp.five.agency.newys.services.author;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
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

    AuthorDetailsResponseDto authorDetailsResponseDto = createAuthorService.createAuthor(firstName, lastName, email, type);

    assertThat(authorDetailsResponseDto.getId() != null);
    assertThat(authorDetailsResponseDto.getFirstName().equals(firstName));
    assertThat(authorDetailsResponseDto.getLastName().equals(lastName));
    assertThat(authorDetailsResponseDto.getEmail().equals(email));
    assertThat(authorDetailsResponseDto.getType().equals(type));
  }

}
