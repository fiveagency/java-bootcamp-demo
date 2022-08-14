package bootcamp.five.agency.newys.services.article;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.ArticleResponseDto;
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

    ArticleResponseDto articleResponseDto = getArticleService.getArticleById(id);

    assertThat(articleResponseDto.getId().equals(id));
  }

  @Test
  public void getArticlesByAuthor_AuthorArticlesFetched_True() {
    final Long authorId = 1L;

    List<ArticleResponseDto> articleResponseDtos = getArticleService.getArticlesByAuthor(authorId);

    assertThat(articleResponseDtos.stream().anyMatch(articleResponseDto -> articleResponseDto.getAuthorId().equals(authorId)));
  }

  @Test
  public void getLatestArticles_LatestArticlesFetched_True() {
    List<ArticleResponseDto> articleResponseDtos = getArticleService.getLatestArticles();

    assertThat(!articleResponseDtos.isEmpty());
  }

  @Test
  public void getPopularArticles_PopularArticlesFetched_True() {
    List<ArticleResponseDto> articleResponseDtos = getArticleService.getPopularArticles();

    assertThat(!articleResponseDtos.isEmpty());
  }

  @Test
  public void getAll_AllArticlesFetched_True() {
    List<ArticleResponseDto> articleResponseDtos = getArticleService.getAll();

    assertThat(!articleResponseDtos.isEmpty());
  }

}
