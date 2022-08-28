package bootcamp.five.agency.newys.unit.services.article;

import static bootcamp.five.agency.newys.unit.Data.allArticles;
import static bootcamp.five.agency.newys.unit.Data.article;
import static bootcamp.five.agency.newys.unit.Data.article2;
import static bootcamp.five.agency.newys.unit.Data.article8Likes;
import static bootcamp.five.agency.newys.unit.Data.article9Likes;
import static bootcamp.five.agency.newys.unit.Data.articleDetailsDto;
import static bootcamp.five.agency.newys.unit.Data.articleDetailsDto2;
import static bootcamp.five.agency.newys.unit.Data.articleFrom3Days;
import static bootcamp.five.agency.newys.unit.Data.articleFrom5Days;
import static bootcamp.five.agency.newys.unit.Data.articleId;
import static bootcamp.five.agency.newys.unit.Data.articlesByAuthor;
import static bootcamp.five.agency.newys.unit.Data.author;
import static bootcamp.five.agency.newys.unit.Data.authorArticleDto;
import static bootcamp.five.agency.newys.unit.Data.authorArticleDto2;
import static bootcamp.five.agency.newys.unit.Data.authorId;
import static bootcamp.five.agency.newys.unit.Data.latestArticleDto;
import static bootcamp.five.agency.newys.unit.Data.latestArticleDto2;
import static bootcamp.five.agency.newys.unit.Data.latestArticles;
import static bootcamp.five.agency.newys.unit.Data.popularArticleDto;
import static bootcamp.five.agency.newys.unit.Data.popularArticleDto2;
import static bootcamp.five.agency.newys.unit.Data.popularArticles;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetAuthorArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetLatestArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetPopularArticlesResponseDto;
import bootcamp.five.agency.newys.mappers.ArticleMapper;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.services.article.GetArticleService;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetArticleServiceTest {

  private GetArticleService getArticleService;
  private ArticleRepository articleRepository;
  private AuthorRepository authorRepository;
  private ArticleMapper articleMapper;

  @BeforeEach
  public void setup() {
    articleRepository = mock(ArticleRepository.class);
    authorRepository = mock(AuthorRepository.class);
    articleMapper = mock(ArticleMapper.class);
    getArticleService = new GetArticleService(articleRepository, authorRepository, articleMapper);
  }

  @Test
  public void getArticleById_ArticleFetched_True() {
    when(articleRepository.findById(articleId)).thenReturn(Optional.of(article));
    when(articleMapper.convertToGetArticleDetailsResponseDto(article)).thenReturn(articleDetailsDto);

    GetArticleDetailsResponseDto response = getArticleService.getArticleById(articleId);

    assertThat(response.getId()).isEqualTo(articleId);
  }

  @Test
  public void getArticlesByAuthor_AuthorArticlesFetched_True() {
    when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
    when(articleRepository.findByAuthor(any(Author.class))).thenReturn(articlesByAuthor);
    when(articleMapper.convertToGetAuthorArticlesResponseDto(article, author)).thenReturn(authorArticleDto);
    when(articleMapper.convertToGetAuthorArticlesResponseDto(article2, author)).thenReturn(authorArticleDto2);

    List<GetAuthorArticlesResponseDto> response = getArticleService.getArticlesByAuthor(authorId);

    assertThat(response).allMatch(dto -> dto.getAuthorId().equals(authorId));
  }

  @Test
  public void getLatestArticles_LatestArticlesFetched_True() {
    when(articleRepository.findByDateOfPublicationAfter(any(java.sql.Date.class))).thenReturn(latestArticles);
    when(articleMapper.convertToGetLatestArticlesResponseDto(articleFrom3Days)).thenReturn(latestArticleDto);
    when(articleMapper.convertToGetLatestArticlesResponseDto(articleFrom5Days)).thenReturn(latestArticleDto2);

    List<GetLatestArticlesResponseDto> responseList = getArticleService.getLatestArticles();

    assertThat(responseList).isNotEmpty();
    assertThat(responseList.size()).isEqualTo(2);
    assertThat(responseList).contains(latestArticleDto);
    assertThat(responseList).contains(latestArticleDto2);
  }

  @Test
  public void getPopularArticles_PopularArticlesFetched_True() {
    when(articleRepository.findByNumLikesGreaterThan(anyInt())).thenReturn(popularArticles);
    when(articleMapper.convertToGetPopularArticlesResponseDto(article8Likes)).thenReturn(popularArticleDto);
    when(articleMapper.convertToGetPopularArticlesResponseDto(article9Likes)).thenReturn(popularArticleDto2);

    List<GetPopularArticlesResponseDto> responseList = getArticleService.getPopularArticles();

    assertThat(responseList).isNotEmpty();
    assertThat(responseList.size()).isEqualTo(2);
    assertThat(responseList).contains(popularArticleDto);
    assertThat(responseList).contains(popularArticleDto2);
  }

  @Test
  public void getAll_AllArticlesFetched_True() {
    when(articleRepository.findAll()).thenReturn(allArticles);
    when(articleMapper.convertToGetArticleDetailsResponseDto(article)).thenReturn(articleDetailsDto);
    when(articleMapper.convertToGetArticleDetailsResponseDto(article2)).thenReturn(articleDetailsDto2);

    List<GetArticleDetailsResponseDto> responseList = getArticleService.getAll();

    assertThat(responseList).isNotEmpty();
    assertThat(responseList.size()).isEqualTo(2);
    assertThat(responseList).contains(articleDetailsDto);
    assertThat(responseList).contains(articleDetailsDto2);
  }

}
