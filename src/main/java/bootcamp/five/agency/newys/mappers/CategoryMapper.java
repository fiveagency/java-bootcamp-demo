package bootcamp.five.agency.newys.mappers;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.domain.Category;
import bootcamp.five.agency.newys.dto.response.category.GetAuthorCategoriesResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

  public GetCategoryDetailsResponseDto convertToGetCategoryDetailsResponseDto(Category category) {
    return GetCategoryDetailsResponseDto.builder()
        .id(category.getId())
        .name(category.getName())
        .description(category.getDescription())
        .authorId(category.getAuthor().getId())
        .build();
  }

  public GetAuthorCategoriesResponseDto convertToGetCategoryDetailsResponseDto(Category category, Author author) {
    return GetAuthorCategoriesResponseDto.builder()
        .id(category.getId())
        .name(category.getName())
        .description(category.getDescription())
        .authorId(author.getId())
        .authorFirstName(author.getFirstName())
        .authorLastName(author.getLastName())
        .build();
  }

}
