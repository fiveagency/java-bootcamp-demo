package bootcamp.five.agency.newys.services.article;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.ArticleResponseDto;
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

    ArticleResponseDto articleResponseDto = createArticleService.createArticle(title, description, imageUrl, dateOfPublication, content, authorId);

    assertThat(articleResponseDto.getId() != null);
    assertThat(articleResponseDto.getTitle().equals(title));
    assertThat(articleResponseDto.getDescription().equals(description));
    assertThat(articleResponseDto.getImageUrl().equals(imageUrl));
    assertThat(articleResponseDto.getDateOfPublication().equals(dateOfPublication));
    assertThat(articleResponseDto.getContent().equals(content));
    assertThat(articleResponseDto.getAuthorId().equals(authorId));
  }

}
