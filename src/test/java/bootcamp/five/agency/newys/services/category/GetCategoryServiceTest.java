package bootcamp.five.agency.newys.services.category;

import static bootcamp.five.agency.newys.Data.author;
import static bootcamp.five.agency.newys.Data.authorCategoryDto;
import static bootcamp.five.agency.newys.Data.authorCategoryDto2;
import static bootcamp.five.agency.newys.Data.authorId;
import static bootcamp.five.agency.newys.Data.categoriesAll;
import static bootcamp.five.agency.newys.Data.categoriesByAuthor;
import static bootcamp.five.agency.newys.Data.category;
import static bootcamp.five.agency.newys.Data.category2;
import static bootcamp.five.agency.newys.Data.categoryDto;
import static bootcamp.five.agency.newys.Data.categoryDto2;
import static bootcamp.five.agency.newys.Data.categoryId;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.category.GetAuthorCategoriesResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.CategoryMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetCategoryServiceTest {

  private GetCategoryService getCategoryService;
  private CategoryRepository categoryRepository;
  private AuthorRepository authorRepository;
  private CategoryMapper categoryMapper;

  @BeforeEach
  public void setup() {
    categoryRepository = mock(CategoryRepository.class);
    authorRepository = mock(AuthorRepository.class);
    categoryMapper = mock(CategoryMapper.class);
    getCategoryService = new GetCategoryService(categoryRepository, authorRepository, categoryMapper);
  }

  @Test
  public void getCategoryById_CategoryFetched_True() {
    when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));
    when(categoryMapper.convertToGetCategoryDetailsResponseDto(category)).thenReturn(categoryDto);

    GetCategoryDetailsResponseDto getCategoryDetailsResponseDto = getCategoryService.getCategoryById(categoryId);

    assertThat(getCategoryDetailsResponseDto.getId()).isEqualTo(categoryId);
  }

  @Test
  public void getCategoriesByAuthor_AuthorCategoriesFetched_True() {
    when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
    when(categoryRepository.findByAuthor(any(Author.class))).thenReturn(categoriesByAuthor);
    when(categoryMapper.convertToGetCategoryDetailsResponseDto(category, author)).thenReturn(authorCategoryDto);
    when(categoryMapper.convertToGetCategoryDetailsResponseDto(category2, author)).thenReturn(authorCategoryDto2);

    List<GetAuthorCategoriesResponseDto> getAuthorCategoriesResponseDtoList = getCategoryService.getCategoriesByAuthor(authorId);

    assertThat(getAuthorCategoriesResponseDtoList).allMatch(dto -> dto.getAuthorId().equals(authorId));
  }

  @Test
  public void getAll_AllCategoriesFetched_True() {
    when(categoryRepository.findAll()).thenReturn(categoriesAll);
    when(categoryMapper.convertToGetCategoryDetailsResponseDto(category)).thenReturn(categoryDto);
    when(categoryMapper.convertToGetCategoryDetailsResponseDto(category2)).thenReturn(categoryDto2);

    List<GetCategoryDetailsResponseDto> getCategoryDetailsResponseDtoList = getCategoryService.getAll();

    assertThat(getCategoryDetailsResponseDtoList.size()).isEqualTo(2);
    assertThat(getCategoryDetailsResponseDtoList).contains(categoryDto);
    assertThat(getCategoryDetailsResponseDtoList).contains(categoryDto2);
  }

}
