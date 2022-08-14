package bootcamp.five.agency.newys.services.category;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.CategoryResponseDto;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetCategoryServiceTest {

  @Autowired
  private GetCategoryService getCategoryService;

  @Test
  public void getCategoryById_CategoryFetched_True() {
    final Long id = 1L;

    CategoryResponseDto categoryResponseDto = getCategoryService.getCategoryById(id);

    assertThat(categoryResponseDto.getId().equals(id));
  }

  @Test
  public void getCategoriesByAuthor_AuthorCategoriesFetched_True() {
    final Long authorId = 1L;

    List<CategoryResponseDto> categorieResponseDtos = getCategoryService.getCategoriesByAuthor(authorId);

    assertThat(categorieResponseDtos.stream().anyMatch(categoryResponseDto -> categoryResponseDto.getAuthorId().equals(authorId)));
  }

  @Test
  public void getAll_AllCategoriesFetched_True() {
    List<CategoryResponseDto> categorieResponseDtos = getCategoryService.getAll();

    assertThat(!categorieResponseDtos.isEmpty());
  }

}
