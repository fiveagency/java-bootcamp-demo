package bootcamp.five.agency.newys.services.category;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.CategoryResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdateCategoryServiceTest {

  @Autowired
  private UpdateCategoryService updateCategoryService;

  @Test
  public void updateCategory_CategoryUpdated_True() {
    final Long id = 1L;
    final String name = "Tech";
    final String description = "Tech category";

    CategoryResponseDto categoryResponseDto = updateCategoryService.updateCategory(id, name, description);

    assertThat(categoryResponseDto.getId().equals(id));
    assertThat(categoryResponseDto.getName().equals(name));
    assertThat(categoryResponseDto.getDescription().equals(description));
  }

  @Test
  public void changeCategoryAuthor_AuthorCategoryUpdated_True() {
    final Long id = 1L;
    final Long authorId = 2L;

    CategoryResponseDto categoryResponseDto = updateCategoryService.changeCategoryAuthor(id, authorId);

    assertThat(categoryResponseDto.getAuthorId().equals(authorId));
  }

  @Test
  public void addArticleToCategory_ArticleAddedToCategory_True() {
    final Long id = 1L;
    final Long articleId = 1L;

    CategoryResponseDto categoryResponseDto = updateCategoryService.addArticleToCategory(id, articleId);

    assertThat(categoryResponseDto.getAddedArticles().stream().anyMatch(article -> article.getId().equals(articleId)));
  }

}
