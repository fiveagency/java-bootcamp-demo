package bootcamp.five.agency.newys.integration.services.author;

import static org.junit.jupiter.api.Assertions.assertEquals;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import bootcamp.five.agency.newys.services.author.UpdateAuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdateAuthorServiceTest {

  @Autowired
  private CreateAuthorService createAuthorService;
  @Autowired
  private GetAuthorService getAuthorService;
  @Autowired
  private UpdateAuthorService updateAuthorService;

  @BeforeEach
  public void init() {
    final String firstName = "Rocky";
    final String lastName = "Balboa";
    final String email = "rocky.balboa4@mail.com";
    final String type = "sport";

    createAuthorService.createAuthor(firstName, lastName, email, type);
  }

  @Test
  public void updateAuthor_AuthorUpdated_True() {
    final String firstName = "John";
    final String lastName = "Doe";
    final String email = "john.doe1@mail.com";
    final String type = "tech";

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa4@mail.com");

    AuthorDetailsResponseDto updatedAuthorDetailsResponseDto = updateAuthorService.updateAuthor(authorDetailsResponseDto.getId(), firstName,
        lastName, email, type);

    assertEquals(updatedAuthorDetailsResponseDto.getId(), authorDetailsResponseDto.getId());
    assertEquals(updatedAuthorDetailsResponseDto.getFirstName(), firstName);
    assertEquals(updatedAuthorDetailsResponseDto.getLastName(), lastName);
    assertEquals(updatedAuthorDetailsResponseDto.getEmail(), email);
    assertEquals(updatedAuthorDetailsResponseDto.getType(), type);
  }

}
