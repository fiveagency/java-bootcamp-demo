package bootcamp.five.agency.newys.mappers;

import static bootcamp.five.agency.newys.Data.article;
import static bootcamp.five.agency.newys.Data.author;
import static bootcamp.five.agency.newys.Data.category;
import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetArticleInCategoryResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetAuthorArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetLatestArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetPopularArticlesResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArticleMapperTest {

    private ArticleMapper articleMapper;

    @BeforeEach
    public void setup() {
        articleMapper = new ArticleMapper();
    }

    @Test
    public void testConvertToGetArticleDetailsResponseDto() {
        GetArticleDetailsResponseDto articleDetailsDto = articleMapper.convertToGetArticleDetailsResponseDto(article);

        assertThat(articleDetailsDto.getId()).isEqualTo(article.getId());
        assertThat(articleDetailsDto.getTitle()).isEqualTo(article.getTitle());
        assertThat(articleDetailsDto.getDescription()).isEqualTo(article.getDescription());
        assertThat(articleDetailsDto.getImageUrl()).isEqualTo(article.getImageUrl());
        assertThat(articleDetailsDto.getDateOfPublication()).isEqualTo(article.getDateOfPublication());
        assertThat(articleDetailsDto.getContent()).isEqualTo(article.getContent());
        assertThat(articleDetailsDto.getNumLikes()).isEqualTo(article.getNumLikes());
        assertThat(articleDetailsDto.getAuthorId()).isEqualTo(article.getAuthor().getId());
    }

    @Test
    public void testConvertToGetAuthorArticlesResponseDto() {
        GetAuthorArticlesResponseDto authorArticleDto = articleMapper.convertToGetAuthorArticlesResponseDto(article, author);

        assertThat(authorArticleDto.getId()).isEqualTo(article.getId());
        assertThat(authorArticleDto.getTitle()).isEqualTo(article.getTitle());
        assertThat(authorArticleDto.getDescription()).isEqualTo(article.getDescription());
        assertThat(authorArticleDto.getAuthorId()).isEqualTo(author.getId());
        assertThat(authorArticleDto.getAuthorFirstName()).isEqualTo(author.getFirstName());
        assertThat(authorArticleDto.getAuthorLastName()).isEqualTo(author.getLastName());
    }

    @Test
    public void testConvertToGetLatestArticlesResponseDto() {
        GetLatestArticlesResponseDto latestArticleDto = articleMapper.convertToGetLatestArticlesResponseDto(article);

        assertThat(latestArticleDto.getId()).isEqualTo(article.getId());
        assertThat(latestArticleDto.getTitle()).isEqualTo(article.getTitle());
        assertThat(latestArticleDto.getDescription()).isEqualTo(article.getDescription());
        assertThat(latestArticleDto.getDateOfPublication()).isEqualTo(article.getDateOfPublication());
    }

    @Test
    public void testConvertToGetPopularArticlesResponseDto() {
        GetPopularArticlesResponseDto popularArticleDto = articleMapper.convertToGetPopularArticlesResponseDto(article);

        assertThat(popularArticleDto.getId()).isEqualTo(article.getId());
        assertThat(popularArticleDto.getTitle()).isEqualTo(article.getTitle());
        assertThat(popularArticleDto.getDescription()).isEqualTo(article.getDescription());
        assertThat(popularArticleDto.getNumLikes()).isEqualTo(article.getNumLikes());
    }

    @Test
    public void testConvertToGetArticleInCategoryResponseDto() {
        GetArticleInCategoryResponseDto categoryArticleDto = articleMapper.convertToGetArticleInCategoryResponseDto(article, category);

        assertThat(categoryArticleDto.getId()).isEqualTo(article.getId());
        assertThat(categoryArticleDto.getTitle()).isEqualTo(article.getTitle());
        assertThat(categoryArticleDto.getDescription()).isEqualTo(article.getDescription());
        assertThat(categoryArticleDto.getCategoryId()).isEqualTo(category.getId());
        assertThat(categoryArticleDto.getCategoryName()).isEqualTo(category.getName());
    }
}
