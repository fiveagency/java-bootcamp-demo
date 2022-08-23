package bootcamp.five.agency.newys.services.author;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetAuthorServiceTest {

  @Autowired
  public GetAuthorService getAuthorService;

  @Test
  public void getAuthorById_AuthorFetched_True() {
    final Long id = 1L;

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorById(id);

    assertThat(authorDetailsResponseDto.getId().equals(id));
  }

  @Test
  public void getAuthorByFirstNameAndLastName_AuthorFetched_True() {
    final String firstName = "John";
    final String lastName = "Doe";

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByFirstNameAndLastName(firstName, lastName);

    assertThat(authorDetailsResponseDto.getFirstName().equals(firstName));
    assertThat(authorDetailsResponseDto.getLastName().equals(lastName));
  }

  @Test
  public void getAuthorByEmail_AuthorFetched_True() {
    final String email = "john.doe@mail.com";

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail(email);

    assertThat(authorDetailsResponseDto.getEmail().equals(email));
  }

  @Test void getNumberOfArticles_NumberOfArticlesIsZero_True() {
    final Long id = 1L;

    Integer numberOfArticles = getAuthorService.getNumberOfArticles(id);

    assertThat(numberOfArticles == 0);
  }

  @Test
  public void getByType_TypeAuthorsFetched_True() {
    final String type = "tech";

    List<AuthorDetailsResponseDto> authorDetailsResponseDtoList = getAuthorService.getByType(type);

    assertThat(!authorDetailsResponseDtoList.isEmpty());
    assertThat(authorDetailsResponseDtoList.stream().anyMatch(getAuthorDetailsResponseDto -> getAuthorDetailsResponseDto.getType().equals(type)));
  }

  @Test
  public void getAll_AllAuthorsFetched_True() {
    List<AuthorDetailsResponseDto> authorDetailsResponseDtoList = getAuthorService.getAll();

    assertThat(!authorDetailsResponseDtoList.isEmpty());
  }

}
