package bootcamp.five.agency.newys.services.category;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.domain.Category;
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

    Category category = getCategoryService.getCategoryById(id);

    assertThat(category.getId().equals(id));
  }

  @Test
  public void getCategoriesByAuthor_AuthorCategoriesFetched_True() {
    final Long authorId = 1L;

    List<Category> categories = getCategoryService.getCategoriesByAuthor(authorId);

    assertThat(categories.stream().anyMatch(category -> category.getAuthor().getId().equals(authorId)));
  }

  @Test
  public void getAll_AllCategoriesFetched_True() {
    List<Category> categories = getCategoryService.getAll();

    assertThat(!categories.isEmpty());
  }

}
