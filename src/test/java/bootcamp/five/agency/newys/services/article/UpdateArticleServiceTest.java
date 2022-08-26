package bootcamp.five.agency.newys.services.article;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.ArticleMapper;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static bootcamp.five.agency.newys.Data.*;

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

    assertThat(response.getId().equals(articleId));
    assertThat(response.getTitle().equals(articleTitle2));
    assertThat(response.getDescription().equals(articleDescription2));
    assertThat(response.getImageUrl().equals(articleImageUrl2));
    assertThat(response.getContent().equals(articleContent2));
  }

  @Test
  public void changeArticleAuthor_ArticleAuthorChanged_True() {
    when(articleRepository.findById(articleId)).thenReturn(Optional.of(article));
    when(authorRepository.findById(authorId2)).thenReturn(Optional.of(author2));
    when(articleRepository.save(article)).thenReturn(updatedArticleAuthorChanged);
    when(articleMapper.convertToGetArticleDetailsResponseDto(updatedArticleAuthorChanged)).thenReturn(updatedArticleAuthorChangedDto);

    GetArticleDetailsResponseDto response = updateArticleService.changeArticleAuthor(articleId, authorId2);

    assertThat(response.getAuthorId().equals(authorId2));
  }

  @Test
  public void likeArticle_ArticleLiked_True() {
    when(articleRepository.findById(articleId)).thenReturn(Optional.of(article8Likes));
    when(articleMapper.convertToGetArticleDetailsResponseDto(article8Likes)).thenReturn(article8LikesDetailsDto);
    when(articleRepository.save(article8Likes)).thenReturn(article9Likes);
    when(articleMapper.convertToGetArticleDetailsResponseDto(article9Likes)).thenReturn(article9LikesDetailsDto);

    GetArticleDetailsResponseDto articleResponse = getArticleService.getArticleById(articleId);

    GetArticleDetailsResponseDto likedArticleResponse = updateArticleService.likeArticle(articleId);

    assertThat(articleResponse.getNumLikes() < likedArticleResponse.getNumLikes());
  }

  @Test
  public void unlikeArticle_ArticleUnlike_True() {
    when(articleRepository.findById(articleId)).thenReturn(Optional.of(article9Likes));
    when(articleMapper.convertToGetArticleDetailsResponseDto(article9Likes)).thenReturn(article9LikesDetailsDto);
    when(articleRepository.save(article9Likes)).thenReturn(article8Likes);
    when(articleMapper.convertToGetArticleDetailsResponseDto(article8Likes)).thenReturn(article8LikesDetailsDto);

    GetArticleDetailsResponseDto articleResponse = getArticleService.getArticleById(articleId);

    GetArticleDetailsResponseDto unlikedArticleResponse = updateArticleService.unlikeArticle(articleId);

    assertThat(articleResponse.getNumLikes() > unlikedArticleResponse.getNumLikes());
  }

}
