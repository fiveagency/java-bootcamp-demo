package bootcamp.five.agency.newys.services.author;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.AuthorResponseDto;
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

    AuthorResponseDto authorResponseDto = updateAuthorService.updateAuthor(id, firstName, lastName, email, type);

    assertThat(authorResponseDto.getId().equals(id));
    assertThat(authorResponseDto.getFirstName().equals(firstName));
    assertThat(authorResponseDto.getLastName().equals(lastName));
    assertThat(authorResponseDto.getEmail().equals(email));
    assertThat(authorResponseDto.getType().equals(type));
  }

}
