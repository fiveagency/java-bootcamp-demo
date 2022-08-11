package bootcamp.five.agency.newys.services.author;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeleteAuthorServiceTest {

  @Autowired
  private DeleteAuthorService deleteAuthorService;
  @Autowired
  private GetAuthorService getAuthorService;

  @Test
  public void deleteAuthor_AuthorDeleted_True() {
    final Long id = 2L;

    deleteAuthorService.deleteAuthorById(id);

    assertThatIllegalStateException().isThrownBy(() -> getAuthorService.getAuthorById(id));
  }

}
