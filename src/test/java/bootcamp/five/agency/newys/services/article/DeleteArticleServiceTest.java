package bootcamp.five.agency.newys.services.article;

import static org.assertj.core.api.Assertions.assertThatException;

import bootcamp.five.agency.newys.dto.response.article.GetAuthorArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeleteArticleServiceTest {

  @Autowired
  private CreateAuthorService createAuthorService;
  @Autowired
  private GetAuthorService getAuthorService;
  @Autowired
  private CreateArticleService createArticleService;
  @Autowired
  private DeleteArticleService deleteArticleService;
  @Autowired
  private GetArticleService getArticleService;

  @BeforeEach
  public void init() {
    final String firstName = "Rocky";
    final String lastName = "Balboa";
    final String email = "rocky.balboa8@mail.com";
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
  public void deleteArticleById_ArticleDeleted_True() {
    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa8@mail.com");

    List<GetAuthorArticlesResponseDto> getAuthorArticlesResponseDtoList = getArticleService.getArticlesByAuthor(authorDetailsResponseDto.getId());

    GetAuthorArticlesResponseDto getAuthorArticlesResponseDto = getAuthorArticlesResponseDtoList.stream()
        .filter(response -> response.getTitle().equals("New iPhone announced"))
        .findAny()
        .orElseThrow(() -> new IllegalStateException("Author article does not exists"));

    deleteArticleService.deleteArticleById(getAuthorArticlesResponseDto.getId());

    assertThatException().isThrownBy(() -> getArticleService.getArticleById(getAuthorArticlesResponseDto.getId()));
  }

}
