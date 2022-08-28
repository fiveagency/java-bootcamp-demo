package bootcamp.five.agency.newys.unit.services.article;

import static bootcamp.five.agency.newys.unit.Data.article;
import static bootcamp.five.agency.newys.unit.Data.articleContent;
import static bootcamp.five.agency.newys.unit.Data.articleDateOfPublicationNow;
import static bootcamp.five.agency.newys.unit.Data.articleDescription;
import static bootcamp.five.agency.newys.unit.Data.articleDetailsDto;
import static bootcamp.five.agency.newys.unit.Data.articleImageUrl;
import static bootcamp.five.agency.newys.unit.Data.articleTitle;
import static bootcamp.five.agency.newys.unit.Data.author;
import static bootcamp.five.agency.newys.unit.Data.authorId;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.ArticleMapper;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.services.article.CreateArticleService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateArticleServiceTest {

  private CreateArticleService createArticleService;

  private ArticleRepository articleRepository;
  private AuthorRepository authorRepository;

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

    assertThat(response.getId()).isNotNull();
    assertThat(response.getTitle()).isEqualTo(articleTitle);
    assertThat(response.getDescription()).isEqualTo(articleDescription);
    assertThat(response.getImageUrl()).isEqualTo(articleImageUrl);
    assertThat(response.getDateOfPublication()).isEqualTo(articleDateOfPublicationNow);
    assertThat(response.getContent()).isEqualTo(articleContent);
    assertThat(response.getAuthorId()).isEqualTo(authorId);
  }

}
