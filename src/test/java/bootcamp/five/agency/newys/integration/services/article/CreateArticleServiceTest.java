package bootcamp.five.agency.newys.integration.services.article;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.article.CreateArticleService;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateArticleServiceTest {

  @Autowired
  private CreateAuthorService createAuthorService;
  @Autowired
  private GetAuthorService getAuthorService;
  @Autowired
  private CreateArticleService createArticleService;

  @BeforeEach
  public void init() {
    final String firstName = "Rocky";
    final String lastName = "Balboa";
    final String email = "rocky.balboa2@mail.com";
    final String type = "sport";

    createAuthorService.createAuthor(firstName, lastName, email, type);
  }

  @Test
  public void createArticle_ArticleCreated_True() {
    final String title = "New iPhone announced";
    final String description = "New iPhone announced";
    final String imageUrl = "images/iphone.png";
    final Date dateOfPublication = new Date();
    final String content = "New iPhone announced";

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa2@mail.com");

    GetArticleDetailsResponseDto getArticleDetailsResponseDto = createArticleService.createArticle(title, description, imageUrl, dateOfPublication,
        content, authorDetailsResponseDto.getId());

    assertNotNull(getArticleDetailsResponseDto.getId());
    assertEquals(getArticleDetailsResponseDto.getTitle(), title);
    assertEquals(getArticleDetailsResponseDto.getDescription(), description);
    assertEquals(getArticleDetailsResponseDto.getImageUrl(), imageUrl);
    assertEquals(getArticleDetailsResponseDto.getDateOfPublication(), dateOfPublication);
    assertEquals(getArticleDetailsResponseDto.getContent(), content);
    assertEquals(getArticleDetailsResponseDto.getAuthorId(), authorDetailsResponseDto.getId());
  }

}
