package bootcamp.five.agency.newys.services.article;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import java.util.Optional;

import bootcamp.five.agency.newys.mappers.ArticleMapper;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.any;
import static bootcamp.five.agency.newys.Data.*;

//@ExtendWith(MockitoExtension.class)
public class CreateArticleServiceTest {

  //@InjectMocks
  private CreateArticleService createArticleService;

  //@Mock
  private ArticleRepository articleRepository;
  //@Mock
  private AuthorRepository authorRepository;

  //@Mock
  private ArticleMapper articleMapper;

  @BeforeEach
  public void setup() {
    articleRepository = mock(ArticleRepository.class);
    authorRepository = mock(AuthorRepository.class);
    articleMapper = mock(ArticleMapper.class);
    createArticleService = new CreateArticleService(articleRepository, authorRepository, articleMapper);
  }

  @Test
  public void createArticle_ArticleCreated_True() {
    when(authorRepository.findById(anyLong())).thenReturn(Optional.of(author));
    when(articleRepository.save(any(Article.class))).thenReturn(article);
    when(articleMapper.convertToGetArticleDetailsResponseDto(article)).thenReturn(articleDetailsDto);

    GetArticleDetailsResponseDto response = createArticleService.createArticle(articleTitle, articleDescription,
            articleImageUrl, articleDateOfPublicationNow, articleContent, authorId);

    assertThat(response.getId() != null);
    assertThat(response.getTitle().equals(articleTitle));
    assertThat(response.getDescription().equals(articleDescription));
    assertThat(response.getImageUrl().equals(articleImageUrl));
    assertThat(response.getDateOfPublication().equals(articleDateOfPublicationNow));
    assertThat(response.getContent().equals(articleContent));
    assertThat(response.getAuthorId().equals(authorId));
  }

}
