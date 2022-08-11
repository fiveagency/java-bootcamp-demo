package bootcamp.five.agency.newys.services.article;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.domain.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdateArticleServiceTest {

  @Autowired
  private UpdateArticleService updateArticleService;
  @Autowired
  private GetArticleService getArticleService;

  @Test
  public void updateArticle_ArticleUpdated_True() {
    final Long id = 1L;
    final String title = "New Samsung announced";
    final String description = "New Samsung announced";
    final String imageUrl = "images/samsung.png";
    final String content = "New Samsung announced";

    Article article = updateArticleService.updateArticle(id, title, description, imageUrl, content);

    assertThat(article.getId().equals(id));
    assertThat(article.getTitle().equals(title));
    assertThat(article.getDescription().equals(description));
    assertThat(article.getImageUrl().equals(imageUrl));
    assertThat(article.getContent().equals(content));
  }

  @Test
  public void changeArticleAuthor_ArticleAuthorChanged_True() {
    final Long id = 1L;
    final Long authorId = 2L;

    Article article = updateArticleService.changeArticleAuthor(id, authorId);

    assertThat(article.getAuthor().getId().equals(authorId));
  }

  @Test
  public void likeArticle_ArticleLiked_True() {
    final Long id = 1L;

    Article article = getArticleService.getArticleById(id);

    Article likedArticle = updateArticleService.likeArticle(id);

    assertThat(article.getNumLikes() < likedArticle.getNumLikes());
  }

  @Test
  public void unlikeArticle_ArticleUnlike_True() {
    final Long id = 1L;

    Article article = getArticleService.getArticleById(id);

    Article unlikedArticle = updateArticleService.unlikeArticle(id);

    assertThat(article.getNumLikes() < unlikedArticle.getNumLikes());
  }

}
