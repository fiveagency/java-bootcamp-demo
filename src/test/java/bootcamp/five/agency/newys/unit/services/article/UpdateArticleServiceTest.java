package bootcamp.five.agency.newys.unit.services.article;

import static bootcamp.five.agency.newys.unit.Data.article;
import static bootcamp.five.agency.newys.unit.Data.article8Likes;
import static bootcamp.five.agency.newys.unit.Data.article8LikesDetailsDto;
import static bootcamp.five.agency.newys.unit.Data.article9Likes;
import static bootcamp.five.agency.newys.unit.Data.article9LikesDetailsDto;
import static bootcamp.five.agency.newys.unit.Data.articleContent2;
import static bootcamp.five.agency.newys.unit.Data.articleDescription2;
import static bootcamp.five.agency.newys.unit.Data.articleId;
import static bootcamp.five.agency.newys.unit.Data.articleImageUrl2;
import static bootcamp.five.agency.newys.unit.Data.articleTitle2;
import static bootcamp.five.agency.newys.unit.Data.author2;
import static bootcamp.five.agency.newys.unit.Data.authorId2;
import static bootcamp.five.agency.newys.unit.Data.updatedArticle;
import static bootcamp.five.agency.newys.unit.Data.updatedArticleAuthorChanged;
import static bootcamp.five.agency.newys.unit.Data.updatedArticleAuthorChangedDto;
import static bootcamp.five.agency.newys.unit.Data.updatedArticleDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.ArticleMapper;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.services.article.GetArticleService;
import bootcamp.five.agency.newys.services.article.UpdateArticleService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UpdateArticleServiceTest {

  private UpdateArticleService updateArticleService;
  private GetArticleService getArticleService;

  private ArticleRepository articleRepository;
  private AuthorRepository authorRepository;
  private ArticleMapper articleMapper;

  @BeforeEach
  public void setup() {
    articleRepository = mock(ArticleRepository.class);
    authorRepository = mock(AuthorRepository.class);
    articleMapper = mock(ArticleMapper.class);
    updateArticleService = new UpdateArticleService(articleRepository, authorRepository, articleMapper);
    getArticleService = new GetArticleService(articleRepository, authorRepository, articleMapper);
  }

  @Test
  public void updateArticle_ArticleUpdated_True() {
    when(articleRepository.findById(anyLong())).thenReturn(Optional.of(article));
    when(articleRepository.save(any(Article.class))).thenReturn(updatedArticle);
    when(articleMapper.convertToGetArticleDetailsResponseDto(updatedArticle)).thenReturn(updatedArticleDto);

    GetArticleDetailsResponseDto response = updateArticleService.updateArticle(articleId, articleTitle2,
            articleDescription2, articleImageUrl2, articleContent2);

    assertThat(response.getId()).isEqualTo(articleId);
    assertThat(response.getTitle()).isEqualTo(articleTitle2);
    assertThat(response.getDescription()).isEqualTo(articleDescription2);
    assertThat(response.getImageUrl()).isEqualTo(articleImageUrl2);
    assertThat(response.getContent()).isEqualTo(articleContent2);
  }

  @Test
  public void changeArticleAuthor_ArticleAuthorChanged_True() {
    when(articleRepository.findById(articleId)).thenReturn(Optional.of(article));
    when(authorRepository.findById(authorId2)).thenReturn(Optional.of(author2));
    when(articleRepository.save(article)).thenReturn(updatedArticleAuthorChanged);
    when(articleMapper.convertToGetArticleDetailsResponseDto(updatedArticleAuthorChanged)).thenReturn(updatedArticleAuthorChangedDto);

    GetArticleDetailsResponseDto response = updateArticleService.changeArticleAuthor(articleId, authorId2);

    assertThat(response.getAuthorId()).isEqualTo(authorId2);
  }

  @Test
  public void likeArticle_ArticleLiked_True() {
    when(articleRepository.findById(articleId)).thenReturn(Optional.of(article8Likes));
    when(articleMapper.convertToGetArticleDetailsResponseDto(article8Likes)).thenReturn(article8LikesDetailsDto);
    when(articleRepository.save(article8Likes)).thenReturn(article9Likes);
    when(articleMapper.convertToGetArticleDetailsResponseDto(article9Likes)).thenReturn(article9LikesDetailsDto);

    GetArticleDetailsResponseDto articleResponse = getArticleService.getArticleById(articleId);

    GetArticleDetailsResponseDto likedArticleResponse = updateArticleService.likeArticle(articleId);

    assertThat(articleResponse.getNumLikes()).isLessThan(likedArticleResponse.getNumLikes());
  }

  @Test
  public void unlikeArticle_ArticleUnlike_True() {
    when(articleRepository.findById(articleId)).thenReturn(Optional.of(article9Likes));
    when(articleMapper.convertToGetArticleDetailsResponseDto(article9Likes)).thenReturn(article9LikesDetailsDto);
    when(articleRepository.save(article9Likes)).thenReturn(article8Likes);
    when(articleMapper.convertToGetArticleDetailsResponseDto(article8Likes)).thenReturn(article8LikesDetailsDto);

    GetArticleDetailsResponseDto articleResponse = getArticleService.getArticleById(articleId);

    GetArticleDetailsResponseDto unlikedArticleResponse = updateArticleService.unlikeArticle(articleId);

    assertThat(articleResponse.getNumLikes()).isGreaterThan(unlikedArticleResponse.getNumLikes());
  }

}
