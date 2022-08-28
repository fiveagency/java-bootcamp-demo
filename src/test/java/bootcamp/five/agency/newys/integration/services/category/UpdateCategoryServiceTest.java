package bootcamp.five.agency.newys.integration.services.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetArticleInCategoryResponseDto;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetAuthorCategoriesResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
import bootcamp.five.agency.newys.services.article.CreateArticleService;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import bootcamp.five.agency.newys.services.category.CreateCategoryService;
import bootcamp.five.agency.newys.services.category.GetAddedArticlesService;
import bootcamp.five.agency.newys.services.category.GetCategoryService;
import bootcamp.five.agency.newys.services.category.UpdateCategoryService;
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
public class UpdateCategoryServiceTest {

  @Autowired
  private CreateAuthorService createAuthorService;
  @Autowired
  private GetAuthorService getAuthorService;
  @Autowired
  private CreateArticleService createArticleService;
  @Autowired
  private CreateCategoryService createCategoryService;
  @Autowired
  private GetCategoryService getCategoryService;
  @Autowired
  private UpdateCategoryService updateCategoryService;
  @Autowired
  private GetAddedArticlesService getAddedArticlesService;

  @BeforeAll
  public void initAuthor() {
    final String firstName = "Rocky";
    final String lastName = "Balboa";
    final String email = "rocky.balboa7@mail.com";
    final String type = "sport";

    createAuthorService.createAuthor(firstName, lastName, email, type);
  }

  @BeforeEach
  public void initCategory() {
    final String name = "Sports";
    final String description = "Sports category";

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa7@mail.com");

    createCategoryService.createCategory(name, description, authorDetailsResponseDto.getId());
  }

  @Test
  public void updateCategory_CategoryUpdated_True() {
    final String name = "Tech";
    final String description = "Tech category";

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa7@mail.com");

    List<GetAuthorCategoriesResponseDto> getAuthorCategoriesResponseDtoList = getCategoryService.getCategoriesByAuthor(
        authorDetailsResponseDto.getId());

    GetAuthorCategoriesResponseDto getAuthorCategoriesResponseDto = getAuthorCategoriesResponseDtoList.stream()
        .filter(response -> response.getName().equals("Sports"))
        .findAny()
        .orElseThrow(() -> new IllegalStateException("Author category does not exists"));

    GetCategoryDetailsResponseDto getCategoryDetailsResponseDto = updateCategoryService.updateCategory(getAuthorCategoriesResponseDto.getId(), name,
        description);

    assertEquals(getCategoryDetailsResponseDto.getId(), getAuthorCategoriesResponseDto.getId());
    assertEquals(getCategoryDetailsResponseDto.getName(), name);
    assertEquals(getCategoryDetailsResponseDto.getDescription(), description);
  }

  @Test
  public void changeCategoryAuthor_AuthorCategoryUpdated_True() {
    final String firstName = "John";
    final String lastName = "Doe";
    final String email = "john.doe3@mail.com";
    final String type = "tech";

    AuthorDetailsResponseDto updateAuthorDetailsResponseDto = createAuthorService.createAuthor(firstName, lastName, email, type);

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa7@mail.com");

    List<GetAuthorCategoriesResponseDto> getAuthorCategoriesResponseDtoList = getCategoryService.getCategoriesByAuthor(
        authorDetailsResponseDto.getId());

    GetAuthorCategoriesResponseDto getAuthorCategoriesResponseDto = getAuthorCategoriesResponseDtoList.stream()
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Author category does not exists"));

    GetCategoryDetailsResponseDto getCategoryDetailsResponseDto = updateCategoryService.changeCategoryAuthor(getAuthorCategoriesResponseDto.getId(),
        updateAuthorDetailsResponseDto.getId());

    assertEquals(getCategoryDetailsResponseDto.getAuthorId(), updateAuthorDetailsResponseDto.getId());
  }

  @Test
  public void addArticleToCategory_ArticleAddedToCategory_True() {
    final String title = "New iPhone 12 announced";
    final String description = "New iPhone 12 announced";
    final String imageUrl = "images/iphone12.png";
    final Date dateOfPublication = new Date();
    final String content = "New iPhone 12 announced";

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa7@mail.com");

    GetArticleDetailsResponseDto getArticleDetailsResponseDto = createArticleService.createArticle(title, description, imageUrl, dateOfPublication,
        content, authorDetailsResponseDto.getId());

    List<GetAuthorCategoriesResponseDto> getAuthorCategoriesResponseDtoList = getCategoryService.getCategoriesByAuthor(
        authorDetailsResponseDto.getId());

    GetAuthorCategoriesResponseDto getAuthorCategoriesResponseDto = getAuthorCategoriesResponseDtoList.stream()
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Author category does not exists"));

    updateCategoryService.addArticleToCategory(getAuthorCategoriesResponseDto.getId(), getArticleDetailsResponseDto.getId());
    List<GetArticleInCategoryResponseDto> getArticleInCategoryResponseDtoList = getAddedArticlesService.getAddedArticles(
        getAuthorCategoriesResponseDto.getId());

    assertFalse(getArticleInCategoryResponseDtoList.isEmpty());
  }

}
