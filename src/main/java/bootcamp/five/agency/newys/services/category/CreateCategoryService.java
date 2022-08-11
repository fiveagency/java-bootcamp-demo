package bootcamp.five.agency.newys.services.category;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.domain.Category;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.repository.CategoryRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService {

  private final CategoryRepository categoryRepository;
  private final AuthorRepository authorRepository;

  @Autowired
  public CreateCategoryService(CategoryRepository categoryRepository, AuthorRepository authorRepository) {
    this.categoryRepository = categoryRepository;
    this.authorRepository = authorRepository;
  }

  public Category createCategory(String name, String description, Long authorId) {
    Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));

    return categoryRepository.save(new Category.CategoryBuilder()
        .name(name)
        .description(description)
        .author(author)
        .addedArticles(new ArrayList<>())
        .build());
  }

}
