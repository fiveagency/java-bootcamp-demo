package bootcamp.five.agency.newys.services.category;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.category.GetAuthorCategoriesResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
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

    GetCategoryDetailsResponseDto getCategoryDetailsResponseDto = getCategoryService.getCategoryById(id);

    assertThat(getCategoryDetailsResponseDto.getId().equals(id));
  }

  @Test
  public void getCategoriesByAuthor_AuthorCategoriesFetched_True() {
    final Long authorId = 2L;

    List<GetAuthorCategoriesResponseDto> getAuthorCategoriesResponseDtoList = getCategoryService.getCategoriesByAuthor(authorId);

    assertThat(getAuthorCategoriesResponseDtoList.stream().anyMatch(getAuthorCategoriesResponseDto ->
        getAuthorCategoriesResponseDto.getAuthorId().equals(authorId)));
  }

  @Test
  public void getAll_AllCategoriesFetched_True() {
    List<GetCategoryDetailsResponseDto> getCategoryDetailsResponseDtoList = getCategoryService.getAll();

    assertThat(!getCategoryDetailsResponseDtoList.isEmpty());
  }

}
