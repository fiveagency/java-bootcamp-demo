package bootcamp.five.agency.newys.integration.services.author;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetAuthorServiceTest {

  @Autowired
  public CreateAuthorService createAuthorService;
  @Autowired
  public GetAuthorService getAuthorService;

  @BeforeAll
  public void init() {
    final String firstName = "Jane";
    final String lastName = "Doe";
    final String email = "jane.doe@mail.com";
    final String type = "tech";

    createAuthorService.createAuthor(firstName, lastName, email, type);
  }

  @Test
  public void getAuthorById_AuthorFetched_True() {
    AuthorDetailsResponseDto createAuthorDetailsResponseDto = getAuthorService.getAuthorByEmail("jane.doe@mail.com");

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorById(createAuthorDetailsResponseDto.getId());

    assertEquals(authorDetailsResponseDto.getId(), createAuthorDetailsResponseDto.getId());
  }

  @Test
  public void getAuthorByFirstNameAndLastName_AuthorFetched_True() {
    final String firstName = "Jane";
    final String lastName = "Doe";

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByFirstNameAndLastName(firstName, lastName);

    assertEquals(authorDetailsResponseDto.getFirstName(), firstName);
    assertEquals(authorDetailsResponseDto.getLastName(), lastName);
  }

  @Test
  public void getAuthorByEmail_AuthorFetched_True() {
    final String email = "jane.doe@mail.com";

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail(email);

    assertEquals(authorDetailsResponseDto.getEmail(), email);
  }

  @Test void getNumberOfArticles_NumberOfArticlesIsZero_True() {
    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("jane.doe@mail.com");

    Integer numberOfArticles = getAuthorService.getNumberOfArticles(authorDetailsResponseDto.getId());

    assertEquals(numberOfArticles, 0);
  }

  @Test
  public void getByType_TypeAuthorsFetched_True() {
    final String type = "tech";

    List<AuthorDetailsResponseDto> authorDetailsResponseDtoList = getAuthorService.getByType(type);

    assertFalse(authorDetailsResponseDtoList.isEmpty());
    assertTrue(authorDetailsResponseDtoList.stream().anyMatch(getAuthorDetailsResponseDto -> getAuthorDetailsResponseDto.getType().equals(type)));
  }

  @Test
  public void getAll_AllAuthorsFetched_True() {
    List<AuthorDetailsResponseDto> authorDetailsResponseDtoList = getAuthorService.getAll();

    assertFalse(authorDetailsResponseDtoList.isEmpty());
  }

}
