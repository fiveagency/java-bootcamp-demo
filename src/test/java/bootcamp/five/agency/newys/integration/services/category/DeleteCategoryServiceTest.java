package bootcamp.five.agency.newys.integration.services.category;

import static org.assertj.core.api.Assertions.assertThatException;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetAuthorCategoriesResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import bootcamp.five.agency.newys.services.category.CreateCategoryService;
import bootcamp.five.agency.newys.services.category.DeleteCategoryService;
import bootcamp.five.agency.newys.services.category.GetCategoryService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeleteCategoryServiceTest {

  @Autowired
  private CreateAuthorService createAuthorService;
  @Autowired
  private GetAuthorService getAuthorService;
  @Autowired
  private CreateCategoryService createCategoryService;
  @Autowired
  private DeleteCategoryService deleteCategoryService;
  @Autowired
  private GetCategoryService getCategoryService;

  @BeforeEach
  public void init() {
    final String firstName = "Rocky";
    final String lastName = "Balboa";
    final String email = "rocky.balboa9@mail.com";
    final String type = "sport";

    AuthorDetailsResponseDto authorDetailsResponseDto = createAuthorService.createAuthor(firstName, lastName, email, type);

    final String name = "Sports";
    final String description = "Sports category";

    createCategoryService.createCategory(name, description, authorDetailsResponseDto.getId());
  }

  @Test
  public void deleteCategoryById_CategoryDeleted_True() {
    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa9@mail.com");

    List<GetAuthorCategoriesResponseDto> getAuthorCategoriesResponseDtoList = getCategoryService.getCategoriesByAuthor(
        authorDetailsResponseDto.getId());

    GetAuthorCategoriesResponseDto getAuthorCategoriesResponseDto = getAuthorCategoriesResponseDtoList.stream()
        .filter(response -> response.getName().equals("Sports"))
        .findAny()
        .orElseThrow(() -> new IllegalStateException("Author category does not exists"));

    deleteCategoryService.deleteCategoryById(getAuthorCategoriesResponseDto.getId());

    assertThatException().isThrownBy(() -> getCategoryService.getCategoryById(getAuthorCategoriesResponseDto.getId()));
  }

}
