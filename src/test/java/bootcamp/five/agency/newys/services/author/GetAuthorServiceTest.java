package bootcamp.five.agency.newys.services.author;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.author.GetAuthorDetailsResponseDto;
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

    GetAuthorDetailsResponseDto getAuthorDetailsResponseDto = getAuthorService.getAuthorById(id);

    assertThat(getAuthorDetailsResponseDto.getId().equals(id));
  }

  @Test
  public void getAuthorByFirstNameAndLastName_AuthorFetched_True() {
    final String firstName = "John";
    final String lastName = "Doe";

    GetAuthorDetailsResponseDto getAuthorDetailsResponseDto = getAuthorService.getAuthorByFirstNameAndLastName(firstName, lastName);

    assertThat(getAuthorDetailsResponseDto.getFirstName().equals(firstName));
    assertThat(getAuthorDetailsResponseDto.getLastName().equals(lastName));
  }

  @Test
  public void getAuthorByEmail_AuthorFetched_True() {
    final String email = "john.doe@mail.com";

    GetAuthorDetailsResponseDto getAuthorDetailsResponseDto = getAuthorService.getAuthorByEmail(email);

    assertThat(getAuthorDetailsResponseDto.getEmail().equals(email));
  }

  @Test void getNumberOfArticles_NumberOfArticlesIsZero_True() {
    final Long id = 1L;

    Integer numberOfArticles = getAuthorService.getNumberOfArticles(id);

    assertThat(numberOfArticles == 0);
  }

  @Test
  public void getByType_TypeAuthorsFetched_True() {
    final String type = "tech";

    List<GetAuthorDetailsResponseDto> getAuthorDetailsResponseDtoList = getAuthorService.getByType(type);

    assertThat(!getAuthorDetailsResponseDtoList.isEmpty());
    assertThat(getAuthorDetailsResponseDtoList.stream().anyMatch(getAuthorDetailsResponseDto -> getAuthorDetailsResponseDto.getType().equals(type)));
  }

  @Test
  public void getAll_AllAuthorsFetched_True() {
    List<GetAuthorDetailsResponseDto> getAuthorDetailsResponseDtoList = getAuthorService.getAll();

    assertThat(!getAuthorDetailsResponseDtoList.isEmpty());
  }

}
