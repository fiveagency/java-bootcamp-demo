package bootcamp.five.agency.newys.services.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetAuthorCategoriesResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetCategoryServiceTest {

  @Autowired
  private CreateAuthorService createAuthorService;
  @Autowired
  private GetAuthorService getAuthorService;
  @Autowired
  private CreateCategoryService createCategoryService;
  @Autowired
  private GetCategoryService getCategoryService;

  @BeforeAll
  public void initAuthor() {
    final String firstName = "Rocky";
    final String lastName = "Balboa";
    final String email = "rocky.balboa11@mail.com";
    final String type = "sport";

    AuthorDetailsResponseDto authorDetailsResponseDto = createAuthorService.createAuthor(firstName, lastName, email, type);

    final String name = "Sports";
    final String description = "Sports category";

    createCategoryService.createCategory(name, description, authorDetailsResponseDto.getId());
  }

  @Test
  public void getCategoryById_CategoryFetched_True() {
    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa11@mail.com");

    List<GetAuthorCategoriesResponseDto> getAuthorCategoriesResponseDtoList = getCategoryService.getCategoriesByAuthor(
        authorDetailsResponseDto.getId());

    GetAuthorCategoriesResponseDto getAuthorCategoriesResponseDto = getAuthorCategoriesResponseDtoList.stream()
        .filter(response -> response.getName().equals("Sports"))
        .findAny()
        .orElseThrow(() -> new IllegalStateException("Author category does not exists"));

    GetCategoryDetailsResponseDto getCategoryDetailsResponseDto = getCategoryService.getCategoryById(getAuthorCategoriesResponseDto.getId());

    assertEquals(getCategoryDetailsResponseDto.getId(), getAuthorCategoriesResponseDto.getId());
  }

  @Test
  public void getCategoriesByAuthor_AuthorCategoriesFetched_True() {
    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa11@mail.com");

    List<GetAuthorCategoriesResponseDto> getAuthorCategoriesResponseDtoList = getCategoryService.getCategoriesByAuthor(
        authorDetailsResponseDto.getId());

    assertTrue(getAuthorCategoriesResponseDtoList.stream().anyMatch(getAuthorCategoriesResponseDto ->
        getAuthorCategoriesResponseDto.getAuthorId().equals(authorDetailsResponseDto.getId())));
  }

  @Test
  public void getAll_AllCategoriesFetched_True() {
    List<GetCategoryDetailsResponseDto> getCategoryDetailsResponseDtoList = getCategoryService.getAll();

    assertFalse(getCategoryDetailsResponseDtoList.isEmpty());
  }

}
