package bootcamp.five.agency.newys.unit.mappers;

import static bootcamp.five.agency.newys.unit.Data.author;
import static bootcamp.five.agency.newys.unit.Data.category;
import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.category.GetAuthorCategoriesResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.CategoryMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryMapperTest {

    private CategoryMapper categoryMapper;

    @BeforeEach
    public void setup() {
        categoryMapper = new CategoryMapper();
    }

    @Test
    public void testConvertToGetCategoryDetailsResponseDto() {
        GetCategoryDetailsResponseDto categoryDto = categoryMapper.convertToGetCategoryDetailsResponseDto(category);

        assertThat(categoryDto.getId()).isEqualTo(category.getId());
        assertThat(categoryDto.getName()).isEqualTo(category.getName());
        assertThat(categoryDto.getDescription()).isEqualTo(category.getDescription());
        assertThat(categoryDto.getAuthorId()).isEqualTo(category.getAuthor().getId());
    }

    @Test
    public void testConvertToGetCategoryDetailsResponseDtoWithAuthor() {
        GetAuthorCategoriesResponseDto authorCategoryDto = categoryMapper.convertToGetCategoryDetailsResponseDto(category, author);

        assertThat(authorCategoryDto.getId()).isEqualTo(category.getId());
        assertThat(authorCategoryDto.getName()).isEqualTo(category.getName());
        assertThat(authorCategoryDto.getDescription()).isEqualTo(category.getDescription());
        assertThat(authorCategoryDto.getAuthorId()).isEqualTo(author.getId());
        assertThat(authorCategoryDto.getAuthorFirstName()).isEqualTo(author.getFirstName());
        assertThat(authorCategoryDto.getAuthorLastName()).isEqualTo(author.getLastName());
    }
}
