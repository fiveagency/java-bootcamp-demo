package bootcamp.five.agency.newys.services.category;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeleteCategoryServiceTest {

  @Autowired
  private DeleteCategoryService deleteCategoryService;
  @Autowired
  private GetCategoryService getCategoryService;

  @Test
  public void deleteCategoryById_CategoryDeleted_True() {
    final Long id = 1L;

    deleteCategoryService.deleteCategoryById(id);

    assertThatIllegalStateException().isThrownBy(() -> getCategoryService.getCategoryById(id));
  }

}
