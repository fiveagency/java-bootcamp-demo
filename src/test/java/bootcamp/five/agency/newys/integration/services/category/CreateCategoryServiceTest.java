package bootcamp.five.agency.newys.integration.services.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import bootcamp.five.agency.newys.services.category.CreateCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateCategoryServiceTest {

  @Autowired
  private CreateAuthorService createAuthorService;
  @Autowired
  private GetAuthorService getAuthorService;
  @Autowired
  private CreateCategoryService createCategoryService;

  @BeforeEach
  public void init() {
    final String firstName = "Rocky";
    final String lastName = "Balboa";
    final String email = "rocky.balboa3@mail.com";
    final String type = "sport";

    createAuthorService.createAuthor(firstName, lastName, email, type);
  }

  @Test
  public void createCategory_CategoryCreated_True() {
    final String name = "Sports";
    final String description = "Sports category";

    AuthorDetailsResponseDto authorDetailsResponseDto = getAuthorService.getAuthorByEmail("rocky.balboa3@mail.com");

    GetCategoryDetailsResponseDto getCategoryDetailsResponseDto = createCategoryService.createCategory(name, description,
        authorDetailsResponseDto.getId());

    assertNotNull(getCategoryDetailsResponseDto.getId());
    assertEquals(getCategoryDetailsResponseDto.getName(), name);
    assertEquals(getCategoryDetailsResponseDto.getDescription(), description);
    assertEquals(getCategoryDetailsResponseDto.getAuthorId(), authorDetailsResponseDto.getId());
  }

}
