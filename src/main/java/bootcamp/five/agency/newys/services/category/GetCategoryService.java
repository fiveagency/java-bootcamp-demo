package bootcamp.five.agency.newys.services.category;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.category.GetAuthorCategoriesResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.CategoryMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.repository.CategoryRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCategoryService {

  private final CategoryRepository categoryRepository;
  private final AuthorRepository authorRepository;
  private final CategoryMapper categoryMapper;

  @Autowired
  public GetCategoryService(CategoryRepository categoryRepository, AuthorRepository authorRepository, CategoryMapper categoryMapper) {
    this.categoryRepository = categoryRepository;
    this.authorRepository = authorRepository;
    this.categoryMapper = categoryMapper;
  }

  public GetCategoryDetailsResponseDto getCategoryById(Long id) {
    return categoryMapper.convertToGetCategoryDetailsResponseDto(categoryRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Category does not exists")));
  }

  public List<GetAuthorCategoriesResponseDto> getCategoriesByAuthor(Long authorId) {
    Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));

    return Optional.of(categoryRepository.findByAuthor(author))
        .map(categories -> categories.stream().map(category ->
            categoryMapper.convertToGetCategoryDetailsResponseDto(category, author)).collect(Collectors.toList()))
        .orElse(Collections.emptyList());
  }

  public List<GetCategoryDetailsResponseDto> getAll() {
    return Optional.of(categoryRepository.findAll())
        .map(entities -> entities.stream().map(categoryMapper::convertToGetCategoryDetailsResponseDto).collect(Collectors.toList()))
        .orElse(Collections.emptyList());
  }

}
