package bootcamp.five.agency.newys.services.article;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeleteArticleServiceTest {

  @Autowired
  private DeleteArticleService deleteArticleService;
  @Autowired
  private GetArticleService getArticleService;

  @Test
  public void deleteArticleById_ArticleDeleted_True() {
    final Long id = 1L;

    deleteArticleService.deleteArticleById(id);

    assertThatIllegalStateException().isThrownBy(() -> getArticleService.getArticleById(id));
  }

}
