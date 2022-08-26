package bootcamp.five.agency.newys.services.category;

import bootcamp.five.agency.newys.domain.Category;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.CategoryMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static bootcamp.five.agency.newys.Data.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

public class CreateCategoryServiceTest {

  private CreateCategoryService createCategoryService;
  private CategoryRepository categoryRepository;
  private AuthorRepository authorRepository;
  private CategoryMapper categoryMapper;

  @BeforeEach
  public void setup() {
    categoryRepository = mock(CategoryRepository.class);
    authorRepository = mock(AuthorRepository.class);
    categoryMapper = mock(CategoryMapper.class);
    createCategoryService = new CreateCategoryService(categoryRepository, authorRepository, categoryMapper);
  }

  @Test
  public void createCategory_CategoryCreated_True() {
    when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
    when(categoryRepository.save(any(Category.class))).thenReturn(category);
    when(categoryMapper.convertToGetCategoryDetailsResponseDto(category)).thenReturn(categoryDto);

    GetCategoryDetailsResponseDto getCategoryDetailsResponseDto = createCategoryService.createCategory(categoryName,
            categoryDescription, authorId);

    assertThat(getCategoryDetailsResponseDto.getId() != null);
    assertThat(getCategoryDetailsResponseDto.getName().equals(categoryName));
    assertThat(getCategoryDetailsResponseDto.getDescription().equals(categoryDescription));
    assertThat(getCategoryDetailsResponseDto.getAuthorId().equals(authorId));
  }

}
