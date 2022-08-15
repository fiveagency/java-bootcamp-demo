package bootcamp.five.agency.newys.services.category;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.article.GetArticleInCategoryResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdateCategoryServiceTest {

  @Autowired
  private UpdateCategoryService updateCategoryService;
  @Autowired
  private GetAddedArticlesService getAddedArticlesService;

  @Test
  public void updateCategory_CategoryUpdated_True() {
    final Long id = 1L;
    final String name = "Tech";
    final String description = "Tech category";

    GetCategoryDetailsResponseDto getCategoryDetailsResponseDto = updateCategoryService.updateCategory(id, name, description);

    assertThat(getCategoryDetailsResponseDto.getId().equals(id));
    assertThat(getCategoryDetailsResponseDto.getName().equals(name));
    assertThat(getCategoryDetailsResponseDto.getDescription().equals(description));
  }

  @Test
  public void changeCategoryAuthor_AuthorCategoryUpdated_True() {
    final Long id = 1L;
    final Long authorId = 2L;

    GetCategoryDetailsResponseDto getCategoryDetailsResponseDto = updateCategoryService.changeCategoryAuthor(id, authorId);

    assertThat(getCategoryDetailsResponseDto.getAuthorId().equals(authorId));
  }

  @Test
  public void addArticleToCategory_ArticleAddedToCategory_True() {
    final Long id = 1L;
    final Long articleId = 1L;

    updateCategoryService.addArticleToCategory(id, articleId);
    List<GetArticleInCategoryResponseDto> getArticleInCategoryResponseDtoList = getAddedArticlesService.getAddedArticles(id);

    assertThat(!getArticleInCategoryResponseDtoList.isEmpty());
  }

}
