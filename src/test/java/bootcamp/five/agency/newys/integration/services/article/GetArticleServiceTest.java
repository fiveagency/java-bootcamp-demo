package bootcamp.five.agency.newys.integration.services.article;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetAuthorArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetLatestArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetPopularArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.article.CreateArticleService;
import bootcamp.five.agency.newys.services.article.GetArticleService;
import bootcamp.five.agency.newys.services.article.UpdateArticleService;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetArticleServiceTest {

  @Autowired
  private CreateAuthorService createAuthorService;
  @Autowired
  private GetAuthorService getAuthorService;
  @Autowired
  private CreateArticleService createArticleService;
  @Autowired
  private UpdateArticleService updateArticleService;
  @Autowired
  private GetArticleService getArticleService;

  @BeforeAll
  public void initAuthor() {
    final String firstName = "Rocky";
    final String lastName = "Balboa";
    final String email = "rocky.balboa10@mail.com";
    final String type = "sport";

    AuthorDetailsResponseDto authorDetailsResponseDto = createAuthorService.createAuthor(firstName, lastName, email, type);

    final String title = "New iPhone announced";
    final String description = "New iPhone announced";
    final String imageUrl = "images/iphone.png";
    final Date dateOfPublication = new Date();
    final String content = "New iPhone announced";

    createArticleService.createArticle(title, description, imageUrl, dateOfPublication, content, authorDetailsResponseDto.getId());
  }

  @Test
  public void getArticleById_ArticleFetched_True() {
    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa10@mail.com");

    List<GetAuthorArticlesResponseDto> getAuthorArticlesResponseDtoList = getArticleService.getArticlesByAuthor(authorDetailsResponseDto.getId());

    GetAuthorArticlesResponseDto getAuthorArticlesResponseDto = getAuthorArticlesResponseDtoList.stream()
        .filter(response -> response.getTitle().equals("New iPhone announced"))
        .findAny()
        .orElseThrow(() -> new IllegalStateException("Author article does not exists"));

    GetArticleDetailsResponseDto getArticleDetailsResponseDto = getArticleService.getArticleById(getAuthorArticlesResponseDto.getId());

    assertEquals(getArticleDetailsResponseDto.getId(), getAuthorArticlesResponseDto.getId());
  }

  @Test
  public void getArticlesByAuthor_AuthorArticlesFetched_True() {
    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa10@mail.com");

    List<GetAuthorArticlesResponseDto> getAuthorArticlesResponseDtoList = getArticleService.getArticlesByAuthor(authorDetailsResponseDto.getId());

    assertTrue(getAuthorArticlesResponseDtoList.stream().anyMatch(getAuthorArticlesResponseDto ->
        getAuthorArticlesResponseDto.getAuthorId().equals(authorDetailsResponseDto.getId())));
  }

  @Test
  public void getLatestArticles_LatestArticlesFetched_True() {
    List<GetLatestArticlesResponseDto> getLatestArticlesResponseDtoList = getArticleService.getLatestArticles();

    assertFalse(getLatestArticlesResponseDtoList.isEmpty());
  }

  @Test
  public void getPopularArticles_PopularArticlesFetched_True() {
    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa10@mail.com");

    List<GetAuthorArticlesResponseDto> getAuthorArticlesResponseDtoList = getArticleService.getArticlesByAuthor(authorDetailsResponseDto.getId());

    GetAuthorArticlesResponseDto getAuthorArticlesResponseDto = getAuthorArticlesResponseDtoList.stream()
        .filter(response -> response.getTitle().equals("New iPhone announced"))
        .findAny()
        .orElseThrow(() -> new IllegalStateException("Author article does not exists"));

    for (int i = 0; i < 5; i++) {
      updateArticleService.likeArticle(getAuthorArticlesResponseDto.getId());
    }

    List<GetPopularArticlesResponseDto> getPopularArticlesResponseDtoList = getArticleService.getPopularArticles();

    assertFalse(getPopularArticlesResponseDtoList.isEmpty());
  }

  @Test
  public void getAll_AllArticlesFetched_True() {
    List<GetArticleDetailsResponseDto> getArticleDetailsResponseDtoList = getArticleService.getAll();

    assertFalse(getArticleDetailsResponseDtoList.isEmpty());
  }

}
