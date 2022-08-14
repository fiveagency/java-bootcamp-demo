package bootcamp.five.agency.newys.services.category;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.CategoryResponseDto;
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

    CategoryResponseDto categoryResponseDto = createCategoryService.createCategory(name, description, authorId);

    assertThat(categoryResponseDto.getId() != null);
    assertThat(categoryResponseDto.getName().equals(name));
    assertThat(categoryResponseDto.getDescription().equals(description));
    assertThat(categoryResponseDto.getAuthorId().equals(authorId));
  }

}
