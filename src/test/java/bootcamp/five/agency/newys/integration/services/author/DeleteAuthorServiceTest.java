package bootcamp.five.agency.newys.integration.services.author;

import static org.assertj.core.api.Assertions.assertThatException;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.DeleteAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeleteAuthorServiceTest {

  @Autowired
  private CreateAuthorService createAuthorService;
  @Autowired
  private DeleteAuthorService deleteAuthorService;
  @Autowired
  private GetAuthorService getAuthorService;

  @BeforeEach
  public void init() {
    final String firstName = "Rocky";
    final String lastName = "Balboa";
    final String email = "rocky.balboa6@mail.com";
    final String type = "sport";

    createAuthorService.createAuthor(firstName, lastName, email, type);
  }

  @Test
  public void deleteAuthor_AuthorDeleted_True() {
    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa6@mail.com");

    deleteAuthorService.deleteAuthorById(authorDetailsResponseDto.getId());

    assertThatException().isThrownBy(() -> getAuthorService.getAuthorById(authorDetailsResponseDto.getId()));
  }

}
