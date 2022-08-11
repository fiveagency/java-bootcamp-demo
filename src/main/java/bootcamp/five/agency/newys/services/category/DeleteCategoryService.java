package bootcamp.five.agency.newys.services.category;

import bootcamp.five.agency.newys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryService {

  private final CategoryRepository categoryRepository;

  @Autowired
  public DeleteCategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public void deleteCategoryById(Long id) {
    categoryRepository.deleteById(id);
  }

}
