package bootcamp.five.agency.newys.services.author;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    final String email = "rocky.balboa1@mail.com";
    final String type = "sport";

    AuthorDetailsResponseDto authorDetailsResponseDto = createAuthorService.createAuthor(firstName, lastName, email, type);

    assertNotNull(authorDetailsResponseDto.getId());
    assertEquals(authorDetailsResponseDto.getFirstName(), firstName);
    assertEquals(authorDetailsResponseDto.getLastName(), lastName);
    assertEquals(authorDetailsResponseDto.getEmail(), email);
    assertEquals(authorDetailsResponseDto.getType(), type);
  }

}
