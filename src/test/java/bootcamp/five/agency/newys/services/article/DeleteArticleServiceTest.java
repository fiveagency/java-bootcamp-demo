package bootcamp.five.agency.newys.services.article;

import bootcamp.five.agency.newys.mappers.ArticleMapper;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static bootcamp.five.agency.newys.Data.*;

public class DeleteArticleServiceTest {

  private ArticleRepository articleRepository;
  private AuthorRepository authorRepository;
  private ArticleMapper articleMapper;
  private DeleteArticleService deleteArticleService;
  private GetArticleService getArticleService;

  @BeforeEach
  public void setup() {
    articleRepository = mock(ArticleRepository.class);
    authorRepository = mock(AuthorRepository.class);
    articleMapper = mock(ArticleMapper.class);
    deleteArticleService = new DeleteArticleService(articleRepository);
    getArticleService = new GetArticleService(articleRepository, authorRepository, articleMapper);
  }

  @Test
  public void deleteArticleById_ArticleDeleted_True() {
    when(articleRepository.findById(articleId)).thenReturn(Optional.empty());

    deleteArticleService.deleteArticleById(articleId);

    assertThatIllegalStateException().isThrownBy(() -> getArticleService.getArticleById(articleId));
  }

}
