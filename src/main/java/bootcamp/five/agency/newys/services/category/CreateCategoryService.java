package bootcamp.five.agency.newys.services.category;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.domain.Category;
import bootcamp.five.agency.newys.dto.response.CategoryResponseDto;
import bootcamp.five.agency.newys.mappers.CategoryMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.repository.CategoryRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService {

  private final CategoryRepository categoryRepository;
  private final AuthorRepository authorRepository;
  private final CategoryMapper categoryMapper;

  @Autowired
  public CreateCategoryService(CategoryRepository categoryRepository, AuthorRepository authorRepository, CategoryMapper categoryMapper) {
    this.categoryRepository = categoryRepository;
    this.authorRepository = authorRepository;
    this.categoryMapper = categoryMapper;
  }

  public CategoryResponseDto createCategory(String name, String description, Long authorId) {
    Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));

    return categoryMapper.convertToCategoryResponseDto(categoryRepository.save(new Category.CategoryBuilder()
        .name(name)
        .description(description)
        .author(author)
        .addedArticles(new ArrayList<>())
        .build()));
  }

}
