package bootcamp.five.agency.newys.services.author;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.AuthorResponseDto;
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

    AuthorResponseDto authorResponseDto = getAuthorService.getAuthorById(id);

    assertThat(authorResponseDto.getId().equals(id));
  }

  @Test
  public void getAuthorByFirstNameAndLastName_AuthorFetched_True() {
    final String firstName = "John";
    final String lastName = "Doe";

    AuthorResponseDto authorResponseDto = getAuthorService.getAuthorByFirstNameAndLastName(firstName, lastName);

    assertThat(authorResponseDto.getFirstName().equals(firstName));
    assertThat(authorResponseDto.getLastName().equals(lastName));
  }

  @Test
  public void getAuthorByEmail_AuthorFetched_True() {
    final String email = "john.doe@mail.com";

    AuthorResponseDto authorResponseDto = getAuthorService.getAuthorByEmail(email);

    assertThat(authorResponseDto.getEmail().equals(email));
  }

  @Test void getNumberOfArticles_NumberOfArticlesIsZero_True() {
    final Long id = 1L;

    Integer numberOfArticles = getAuthorService.getNumberOfArticles(id);

    assertThat(numberOfArticles == 0);
  }

  @Test
  public void getByType_TypeAuthorsFetched_True() {
    final String type = "tech";

    List<AuthorResponseDto> authorResponseDtos = getAuthorService.getByType(type);

    assertThat(!authorResponseDtos.isEmpty());
    assertThat(authorResponseDtos.stream().anyMatch(authorResponseDto -> authorResponseDto.getType().equals(type)));
  }

  @Test
  public void getAll_AllAuthorsFetched_True() {
    List<AuthorResponseDto> authorResponseDtos = getAuthorService.getAll();

    assertThat(!authorResponseDtos.isEmpty());
  }

}
