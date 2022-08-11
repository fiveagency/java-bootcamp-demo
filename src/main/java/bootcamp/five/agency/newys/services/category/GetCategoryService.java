package bootcamp.five.agency.newys.services.category;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.domain.Category;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCategoryService {

  private final CategoryRepository categoryRepository;
  private final AuthorRepository authorRepository;

  @Autowired
  public GetCategoryService(CategoryRepository categoryRepository, AuthorRepository authorRepository) {
    this.categoryRepository = categoryRepository;
    this.authorRepository = authorRepository;
  }

  public Category getCategoryById(Long id) {
    return categoryRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Category does not exists"));
  }

  public List<Category> getCategoriesByAuthor(Long authorId) {
    Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));

    return categoryRepository.findByAuthor(author);
  }

  public List<Category> getAll() {
    return categoryRepository.findAll();
  }

}
