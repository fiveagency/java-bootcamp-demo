package bootcamp.five.agency.newys.services.category;

import bootcamp.five.agency.newys.mappers.CategoryMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.mockito.Mockito.mock;
import static bootcamp.five.agency.newys.Data.*;
import static org.mockito.Mockito.when;

public class DeleteCategoryServiceTest {

  private DeleteCategoryService deleteCategoryService;
  private GetCategoryService getCategoryService;
  private CategoryRepository categoryRepository;
  private AuthorRepository authorRepository;
  private CategoryMapper categoryMapper;

  @BeforeEach
  public void setup() {
    categoryRepository = mock(CategoryRepository.class);
    authorRepository = mock(AuthorRepository.class);
    categoryMapper = mock(CategoryMapper.class);
    deleteCategoryService = new DeleteCategoryService(categoryRepository);
    getCategoryService = new GetCategoryService(categoryRepository, authorRepository, categoryMapper);
  }

  @Test
  public void deleteCategoryById_CategoryDeleted_True() {
    when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

    deleteCategoryService.deleteCategoryById(categoryId);

    assertThatIllegalStateException().isThrownBy(() -> getCategoryService.getCategoryById(categoryId));
  }

}
