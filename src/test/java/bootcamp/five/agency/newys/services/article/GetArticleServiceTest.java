package bootcamp.five.agency.newys.services.article;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetAuthorArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetLatestArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetPopularArticlesResponseDto;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetArticleServiceTest {

  @Autowired
  private GetArticleService getArticleService;

  @Test
  public void getArticleById_ArticleFetched_True() {
    final Long id = 1L;

    GetArticleDetailsResponseDto getArticleDetailsResponseDto = getArticleService.getArticleById(id);

    assertThat(getArticleDetailsResponseDto.getId().equals(id));
  }

  @Test
  public void getArticlesByAuthor_AuthorArticlesFetched_True() {
    final Long authorId = 1L;

    List<GetAuthorArticlesResponseDto> getAuthorArticlesResponseDtoList = getArticleService.getArticlesByAuthor(authorId);

    assertThat(getAuthorArticlesResponseDtoList.stream().anyMatch(getAuthorArticlesResponseDto ->
        getAuthorArticlesResponseDto.getAuthorId().equals(authorId)));
  }

  @Test
  public void getLatestArticles_LatestArticlesFetched_True() {
    List<GetLatestArticlesResponseDto> getLatestArticlesResponseDtoList = getArticleService.getLatestArticles();

    assertThat(!getLatestArticlesResponseDtoList.isEmpty());
  }

  @Test
  public void getPopularArticles_PopularArticlesFetched_True() {
    List<GetPopularArticlesResponseDto> getPopularArticlesResponseDtoList = getArticleService.getPopularArticles();

    assertThat(!getPopularArticlesResponseDtoList.isEmpty());
  }

  @Test
  public void getAll_AllArticlesFetched_True() {
    List<GetArticleDetailsResponseDto> getArticleDetailsResponseDtoList = getArticleService.getAll();

    assertThat(!getArticleDetailsResponseDtoList.isEmpty());
  }

}
