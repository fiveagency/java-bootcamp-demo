package bootcamp.five.agency.newys.services.category;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.domain.Category;
import bootcamp.five.agency.newys.dto.response.CategoryResponseDto;
import bootcamp.five.agency.newys.mappers.CategoryMapper;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCategoryService {

  private final CategoryRepository categoryRepository;
  private final AuthorRepository authorRepository;
  private final ArticleRepository articleRepository;
  private final CategoryMapper categoryMapper;

  @Autowired
  public UpdateCategoryService(AuthorRepository authorRepository, CategoryRepository categoryRepository, ArticleRepository articleRepository,
      CategoryMapper categoryMapper) {
    this.categoryRepository = categoryRepository;
    this.authorRepository = authorRepository;
    this.articleRepository = articleRepository;
    this.categoryMapper = categoryMapper;
  }

  public CategoryResponseDto updateCategory(Long id, String name, String description) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Category does not exists"));

    category.setName(name);
    category.setDescription(description);

    return categoryMapper.convertToCategoryResponseDto(categoryRepository.save(category));
  }

  public CategoryResponseDto changeCategoryAuthor(Long id, Long authorId) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Category does not exists"));

    Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));

    category.setAuthor(author);

    return categoryMapper.convertToCategoryResponseDto(categoryRepository.save(category));
  }

  public CategoryResponseDto addArticleToCategory(Long id, Long articleId) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Category does not exists"));

    Article article = articleRepository.findById(articleId)
        .orElseThrow(() -> new IllegalStateException("Article does not exists"));

    article.getCategories().add(category);

    articleRepository.save(article);

    category.getAddedArticles().add(article);

    return categoryMapper.convertToCategoryResponseDto(categoryRepository.save(category));
  }

}
