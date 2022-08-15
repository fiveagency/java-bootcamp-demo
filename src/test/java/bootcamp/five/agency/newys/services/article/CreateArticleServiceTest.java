package bootcamp.five.agency.newys.services.article;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
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

    GetArticleDetailsResponseDto getArticleDetailsResponseDto = createArticleService.createArticle(title, description, imageUrl, dateOfPublication, content, authorId);

    assertThat(getArticleDetailsResponseDto.getId() != null);
    assertThat(getArticleDetailsResponseDto.getTitle().equals(title));
    assertThat(getArticleDetailsResponseDto.getDescription().equals(description));
    assertThat(getArticleDetailsResponseDto.getImageUrl().equals(imageUrl));
    assertThat(getArticleDetailsResponseDto.getDateOfPublication().equals(dateOfPublication));
    assertThat(getArticleDetailsResponseDto.getContent().equals(content));
    assertThat(getArticleDetailsResponseDto.getAuthorId().equals(authorId));
  }

}
