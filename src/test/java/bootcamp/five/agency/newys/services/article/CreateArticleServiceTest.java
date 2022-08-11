package bootcamp.five.agency.newys.services.article;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.domain.Article;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateArticleServiceTest {

  @Autowired
  private CreateArticleService createArticleService;

  @Test
  public void createArticle_ArticleCreated_True() {
    final String title = "New iPhone announced";
    final String description = "New iPhone announced";
    final String imageUrl = "images/iphone.png";
    final Date dateOfPublication = new Date();
    final String content = "New iPhone announced";
    final Long authorId = 1L;

    Article article = createArticleService.createArticle(title, description, imageUrl, dateOfPublication, content, authorId);

    assertThat(article.getId() != null);
    assertThat(article.getTitle().equals(title));
    assertThat(article.getDescription().equals(description));
    assertThat(article.getImageUrl().equals(imageUrl));
    assertThat(article.getDateOfPublication().equals(dateOfPublication));
    assertThat(article.getContent().equals(content));
    assertThat(article.getAuthor().getId().equals(authorId));
  }

}
