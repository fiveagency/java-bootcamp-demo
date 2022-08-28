package bootcamp.five.agency.newys.integration.services.article;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetAuthorArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.article.CreateArticleService;
import bootcamp.five.agency.newys.services.article.GetArticleService;
import bootcamp.five.agency.newys.services.article.UpdateArticleService;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UpdateArticleServiceTest {

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
    final String email = "rocky.balboa5@mail.com";
    final String type = "sport";

    createAuthorService.createAuthor(firstName, lastName, email, type);
  }

  @BeforeEach
  public void initArticle() {
    final String title = "New iPhone 11 announced";
    final String description = "New iPhone 11 announced";
    final String imageUrl = "images/iphone11.png";
    final Date dateOfPublication = new Date();
    final String content = "New iPhone 11 announced";

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa5@mail.com");

    createArticleService.createArticle(title, description, imageUrl, dateOfPublication, content, authorDetailsResponseDto.getId());
  }

  @Test
  public void updateArticle_ArticleUpdated_True() {
    final String title = "New Samsung announced";
    final String description = "New Samsung announced";
    final String imageUrl = "images/samsung.png";
    final String content = "New Samsung announced";

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa5@mail.com");

    List<GetAuthorArticlesResponseDto> getAuthorArticlesResponseDtoList = getArticleService.getArticlesByAuthor(authorDetailsResponseDto.getId());

    GetAuthorArticlesResponseDto getAuthorArticlesResponseDto = getAuthorArticlesResponseDtoList.stream()
        .filter(response -> response.getTitle().equals("New iPhone 11 announced"))
        .findAny()
        .orElseThrow(() -> new IllegalStateException("Author article does not exists"));

    GetArticleDetailsResponseDto updatedGetArticleDetailsResponseDto = updateArticleService.updateArticle(getAuthorArticlesResponseDto.getId(), title,
        description, imageUrl, content);

    assertEquals(updatedGetArticleDetailsResponseDto.getId(), getAuthorArticlesResponseDto.getId());
    assertEquals(updatedGetArticleDetailsResponseDto.getTitle(), title);
    assertEquals(updatedGetArticleDetailsResponseDto.getDescription(), description);
    assertEquals(updatedGetArticleDetailsResponseDto.getImageUrl(), imageUrl);
    assertEquals(updatedGetArticleDetailsResponseDto.getContent(), content);
  }

  @Test
  public void changeArticleAuthor_ArticleAuthorChanged_True() {
    final String firstName = "John";
    final String lastName = "Doe";
    final String email = "john.doe2@mail.com";
    final String type = "tech";

    AuthorDetailsResponseDto updateAuthorDetailsResponseDto = createAuthorService.createAuthor(firstName, lastName, email, type);

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa5@mail.com");

    List<GetAuthorArticlesResponseDto> getAuthorArticlesResponseDtoList = getArticleService.getArticlesByAuthor(authorDetailsResponseDto.getId());

    GetAuthorArticlesResponseDto getAuthorArticlesResponseDto = getAuthorArticlesResponseDtoList.stream()
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Author article does not exists"));

    GetArticleDetailsResponseDto updatedGetArticleDetailsResponseDto = updateArticleService.changeArticleAuthor(getAuthorArticlesResponseDto.getId(),
        updateAuthorDetailsResponseDto.getId());

    assertEquals(updatedGetArticleDetailsResponseDto.getAuthorId(), updateAuthorDetailsResponseDto.getId());
  }

  @Test
  public void likeArticle_ArticleLiked_True() {
    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa5@mail.com");

    List<GetAuthorArticlesResponseDto> getAuthorArticlesResponseDtoList = getArticleService.getArticlesByAuthor(authorDetailsResponseDto.getId());

    GetAuthorArticlesResponseDto getAuthorArticlesResponseDto = getAuthorArticlesResponseDtoList.stream()
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Author article does not exists"));

    GetArticleDetailsResponseDto getArticleDetailsResponseDto = getArticleService.getArticleById(getAuthorArticlesResponseDto.getId());

    GetArticleDetailsResponseDto likedGetArticleDetailsResponseDto = updateArticleService.likeArticle(getAuthorArticlesResponseDto.getId());

    assertTrue(getArticleDetailsResponseDto.getNumLikes() < likedGetArticleDetailsResponseDto.getNumLikes());
  }

  @Test
  public void unlikeArticle_ArticleUnlike_True() {
    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa5@mail.com");

    List<GetAuthorArticlesResponseDto> getAuthorArticlesResponseDtoList = getArticleService.getArticlesByAuthor(authorDetailsResponseDto.getId());

    GetAuthorArticlesResponseDto getAuthorArticlesResponseDto = getAuthorArticlesResponseDtoList.stream()
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Author article does not exists"));

    GetArticleDetailsResponseDto getArticleDetailsResponseDto = getArticleService.getArticleById(getAuthorArticlesResponseDto.getId());

    GetArticleDetailsResponseDto unlikedGetArticleDetailsResponseDto = updateArticleService.unlikeArticle(getAuthorArticlesResponseDto.getId());

    assertTrue(getArticleDetailsResponseDto.getNumLikes() > unlikedGetArticleDetailsResponseDto.getNumLikes());
  }

}
