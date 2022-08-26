package bootcamp.five.agency.newys.mappers;

import bootcamp.five.agency.newys.dto.response.category.GetAuthorCategoriesResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static bootcamp.five.agency.newys.Data.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CategoryMapperTest {

    private CategoryMapper categoryMapper;

    @BeforeEach
    public void setup() {
        categoryMapper = new CategoryMapper();
    }

    @Test
    public void testConvertToGetCategoryDetailsResponseDto() {
        GetCategoryDetailsResponseDto categoryDto = categoryMapper.convertToGetCategoryDetailsResponseDto(category);

        assertThat(categoryDto.getId() == category.getId());
        assertThat(categoryDto.getName().equals(category.getName()));
        assertThat(categoryDto.getDescription().equals(category.getDescription()));
        assertThat(categoryDto.getAuthorId().equals(category.getAuthor().getId()));
    }

    @Test
    public void testConvertToGetCategoryDetailsResponseDtoWithAuthor() {
        GetAuthorCategoriesResponseDto authorCategoryDto = categoryMapper.convertToGetCategoryDetailsResponseDto(category, author);

        assertThat(authorCategoryDto.getId() == category.getId());
        assertThat(authorCategoryDto.getName().equals(category.getName()));
        assertThat(authorCategoryDto.getDescription().equals(category.getDescription()));
        assertThat(authorCategoryDto.getAuthorId() == author.getId());
        assertThat(authorCategoryDto.getAuthorFirstName().equals(author.getFirstName()));
        assertThat(authorCategoryDto.getAuthorLastName().equals(author.getLastName()));
    }
}
