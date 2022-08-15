package bootcamp.five.agency.newys.services.category;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateCategoryServiceTest {

  @Autowired
  private CreateCategoryService createCategoryService;

  @Test
  public void createCategory_CategoryCreated_True() {
    final String name = "Sports";
    final String description = "Sports category";
    final Long authorId = 1L;

    GetCategoryDetailsResponseDto getCategoryDetailsResponseDto = createCategoryService.createCategory(name, description, authorId);

    assertThat(getCategoryDetailsResponseDto.getId() != null);
    assertThat(getCategoryDetailsResponseDto.getName().equals(name));
    assertThat(getCategoryDetailsResponseDto.getDescription().equals(description));
    assertThat(getCategoryDetailsResponseDto.getAuthorId().equals(authorId));
  }

}
