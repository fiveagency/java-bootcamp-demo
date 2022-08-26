package bootcamp.five.agency.newys.services.article;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetAuthorArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetLatestArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetPopularArticlesResponseDto;

import java.util.List;
import java.util.Optional;

import bootcamp.five.agency.newys.mappers.ArticleMapper;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static bootcamp.five.agency.newys.Data.*;

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

    assertThat(response.getId().equals(articleId));
  }

  @Test
  public void getArticlesByAuthor_AuthorArticlesFetched_True() {
    when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
    when(articleRepository.findByAuthor(any(Author.class))).thenReturn(articlesByAuthor);
    when(articleMapper.convertToGetAuthorArticlesResponseDto(article, author)).thenReturn(authorArticleDto);
    when(articleMapper.convertToGetAuthorArticlesResponseDto(article2, author)).thenReturn(authorArticleDto2);

    List<GetAuthorArticlesResponseDto> response = getArticleService.getArticlesByAuthor(authorId);

    assertThat(response.stream().anyMatch(
            getAuthorArticlesResponseDto -> getAuthorArticlesResponseDto.getAuthorId().equals(authorId)));
  }

  @Test
  public void getLatestArticles_LatestArticlesFetched_True() {
    when(articleRepository.findByDateOfPublicationAfter(any(java.sql.Date.class))).thenReturn(latestArticles);
    when(articleMapper.convertToGetLatestArticlesResponseDto(article)).thenReturn(latestArticleDto);
    when(articleMapper.convertToGetLatestArticlesResponseDto(article2)).thenReturn(latestArticleDto2);

    List<GetLatestArticlesResponseDto> responseList = getArticleService.getLatestArticles();

    assertThat(!responseList.isEmpty());
    assertThat(responseList.size() == 2);
    assertThat(responseList.contains(latestArticleDto));
    assertThat(responseList.contains(latestArticleDto2));
  }

  @Test
  public void getPopularArticles_PopularArticlesFetched_True() {
    when(articleRepository.findByNumLikesGreaterThan(anyInt())).thenReturn(popularArticles);
    when(articleMapper.convertToGetPopularArticlesResponseDto(article)).thenReturn(popularArticleDto);
    when(articleMapper.convertToGetPopularArticlesResponseDto(article2)).thenReturn(popularArticleDto2);

    List<GetPopularArticlesResponseDto> responseList = getArticleService.getPopularArticles();

    assertThat(!responseList.isEmpty());
    assertThat(responseList.size() == 2);
    assertThat(responseList.contains(popularArticleDto));
    assertThat(responseList.contains(popularArticleDto2));
  }

  @Test
  public void getAll_AllArticlesFetched_True() {
    when(articleRepository.findAll()).thenReturn(allArticles);
    when(articleMapper.convertToGetArticleDetailsResponseDto(article)).thenReturn(articleDetailsDto);
    when(articleMapper.convertToGetArticleDetailsResponseDto(article2)).thenReturn(articleDetailsDto2);

    List<GetArticleDetailsResponseDto> responseList = getArticleService.getAll();

    assertThat(!responseList.isEmpty());
    assertThat(responseList.size() == 2);
    assertThat(responseList.contains(articleDetailsDto));
    assertThat(responseList.contains(articleDetailsDto2));
  }

}
