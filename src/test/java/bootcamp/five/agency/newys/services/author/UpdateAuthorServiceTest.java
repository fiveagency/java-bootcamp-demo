package bootcamp.five.agency.newys.services.author;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.author.GetAuthorDetailsResponseDto;
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

    GetAuthorDetailsResponseDto getAuthorDetailsResponseDto = updateAuthorService.updateAuthor(id, firstName, lastName, email, type);

    assertThat(getAuthorDetailsResponseDto.getId().equals(id));
    assertThat(getAuthorDetailsResponseDto.getFirstName().equals(firstName));
    assertThat(getAuthorDetailsResponseDto.getLastName().equals(lastName));
    assertThat(getAuthorDetailsResponseDto.getEmail().equals(email));
    assertThat(getAuthorDetailsResponseDto.getType().equals(type));
  }

}
