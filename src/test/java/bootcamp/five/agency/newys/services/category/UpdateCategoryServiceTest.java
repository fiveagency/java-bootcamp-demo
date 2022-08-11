package bootcamp.five.agency.newys.services.category;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.domain.Category;
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

    Category category = updateCategoryService.updateCategory(id, name, description);

    assertThat(category.getId().equals(id));
    assertThat(category.getName().equals(name));
    assertThat(category.getDescription().equals(description));
  }

  @Test
  public void changeCategoryAuthor_AuthorCategoryUpdated_True() {
    final Long id = 1L;
    final Long authorId = 2L;

    Category category = updateCategoryService.changeCategoryAuthor(id, authorId);

    assertThat(category.getAuthor().getId().equals(authorId));
  }

  @Test
  public void addArticleToCategory_ArticleAddedToCategory_True() {
    final Long id = 1L;
    final Long articleId = 1L;

    Category category = updateCategoryService.addArticleToCategory(id, articleId);

    assertThat(category.getAddedArticles().stream().anyMatch(article -> article.getId().equals(articleId)));
  }

}
