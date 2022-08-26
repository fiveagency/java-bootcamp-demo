package bootcamp.five.agency.newys.services.category;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.domain.Category;
import bootcamp.five.agency.newys.dto.response.article.GetArticleInCategoryResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
import java.util.List;
import java.util.Optional;

import bootcamp.five.agency.newys.mappers.ArticleMapper;
import bootcamp.five.agency.newys.mappers.CategoryMapper;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static bootcamp.five.agency.newys.Data.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

public class UpdateCategoryServiceTest {

  private UpdateCategoryService updateCategoryService;
  private GetAddedArticlesService getAddedArticlesService;
  private CategoryRepository categoryRepository;
  private AuthorRepository authorRepository;
  private ArticleRepository articleRepository;
  private CategoryMapper categoryMapper;
  private ArticleMapper articleMapper;

  @BeforeEach
  public void setup() {
    categoryRepository = mock(CategoryRepository.class);
    authorRepository = mock(AuthorRepository.class);
    articleRepository = mock(ArticleRepository.class);
    categoryMapper = mock(CategoryMapper.class);
    articleMapper = mock(ArticleMapper.class);
    updateCategoryService = new UpdateCategoryService(authorRepository, categoryRepository, articleRepository, categoryMapper);
    getAddedArticlesService = new GetAddedArticlesService(categoryRepository, articleMapper);
  }

  @Test
  public void updateCategory_CategoryUpdated_True() {
    when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));
    when(categoryRepository.save(any(Category.class))).thenReturn(categoryUpdated);
    when(categoryMapper.convertToGetCategoryDetailsResponseDto(categoryUpdated)).thenReturn(categoryUpdatedDto);

    GetCategoryDetailsResponseDto getCategoryDetailsResponseDto = updateCategoryService.updateCategory(categoryId,
            categoryName2, categoryDescription2);

    assertThat(getCategoryDetailsResponseDto.getId().equals(categoryId));
    assertThat(getCategoryDetailsResponseDto.getName().equals(categoryName2));
    assertThat(getCategoryDetailsResponseDto.getDescription().equals(categoryDescription2));
  }

  @Test
  public void changeCategoryAuthor_AuthorCategoryUpdated_True() {
    when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));
    when(authorRepository.findById(authorId2)).thenReturn(Optional.of(author2));
    when(categoryRepository.save(any(Category.class))).thenReturn(categoryAuthorChanged);
    when(categoryMapper.convertToGetCategoryDetailsResponseDto(categoryAuthorChanged)).thenReturn(categoryAuhtorChangedDto);

    GetCategoryDetailsResponseDto getCategoryDetailsResponseDto = updateCategoryService.changeCategoryAuthor(categoryId, authorId2);

    assertThat(getCategoryDetailsResponseDto.getAuthorId().equals(authorId2));
  }

  @Test
  public void addArticleToCategory_ArticleAddedToCategory_True() {
    when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));
    when(articleRepository.findById(articleId)).thenReturn(Optional.of(article));
    when(articleRepository.save(any(Article.class))).thenReturn(articleWithCategory);
    when(articleMapper.convertToGetArticleInCategoryResponseDto(articleWithCategory, category)).thenReturn(articleInCategoryDto);

    updateCategoryService.addArticleToCategory(categoryId, articleId);
    List<GetArticleInCategoryResponseDto> getArticleInCategoryResponseDtoList = getAddedArticlesService.getAddedArticles(categoryId);

    assertThat(!getArticleInCategoryResponseDtoList.isEmpty());
  }

}
