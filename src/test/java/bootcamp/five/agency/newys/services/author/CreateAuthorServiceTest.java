package bootcamp.five.agency.newys.services.author;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.author.GetAuthorDetailsResponseDto;
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

    GetAuthorDetailsResponseDto getAuthorDetailsResponseDto = createAuthorService.createAuthor(firstName, lastName, email, type);

    assertThat(getAuthorDetailsResponseDto.getId() != null);
    assertThat(getAuthorDetailsResponseDto.getFirstName().equals(firstName));
    assertThat(getAuthorDetailsResponseDto.getLastName().equals(lastName));
    assertThat(getAuthorDetailsResponseDto.getEmail().equals(email));
    assertThat(getAuthorDetailsResponseDto.getType().equals(type));
  }

}
