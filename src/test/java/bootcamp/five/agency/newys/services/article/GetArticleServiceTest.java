package bootcamp.five.agency.newys.services.article;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.domain.Article;
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

    Article article = getArticleService.getArticleById(id);

    assertThat(article.getId().equals(id));
  }

  @Test
  public void getArticlesByAuthor_AuthorArticlesFetched_True() {
    final Long authorId = 1L;

    List<Article> articles = getArticleService.getArticlesByAuthor(authorId);

    assertThat(articles.stream().anyMatch(article -> article.getAuthor().getId().equals(authorId)));
  }

  @Test
  public void getLatestArticles_LatestArticlesFetched_True() {
    List<Article> articles = getArticleService.getLatestArticles();

    assertThat(!articles.isEmpty());
  }

  @Test
  public void getPopularArticles_PopularArticlesFetched_True() {
    List<Article> articles = getArticleService.getPopularArticles();

    assertThat(!articles.isEmpty());
  }

  @Test
  public void getAll_AllArticlesFetched_True() {
    List<Article> articles = getArticleService.getAll();

    assertThat(!articles.isEmpty());
  }

}
