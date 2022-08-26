package bootcamp.five.agency.newys.mappers;

import bootcamp.five.agency.newys.dto.response.article.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static bootcamp.five.agency.newys.Data.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ArticleMapperTest {

    private ArticleMapper articleMapper;

    @BeforeEach
    public void setup() {
        articleMapper = new ArticleMapper();
    }

    @Test
    public void testConvertToGetArticleDetailsResponseDto() {
        GetArticleDetailsResponseDto articleDetailsDto = articleMapper.convertToGetArticleDetailsResponseDto(article);

        assertThat(articleDetailsDto.getId() == article.getId());
        assertThat(articleDetailsDto.getTitle().equals(article.getTitle()));
        assertThat(articleDetailsDto.getDescription().equals(article.getDescription()));
        assertThat(articleDetailsDto.getImageUrl().equals(article.getImageUrl()));
        assertThat(articleDetailsDto.getDateOfPublication().equals(article.getDateOfPublication()));
        assertThat(articleDetailsDto.getContent().equals(article.getContent()));
        assertThat(articleDetailsDto.getNumLikes()== article.getNumLikes());
        assertThat(articleDetailsDto.getAuthorId() == article.getAuthor().getId());
    }

    @Test
    public void testConvertToGetAuthorArticlesResponseDto() {
        GetAuthorArticlesResponseDto authorArticleDto = articleMapper.convertToGetAuthorArticlesResponseDto(article, author);

        assertThat(authorArticleDto.getId() == article.getId());
        assertThat(authorArticleDto.getTitle().equals(article.getTitle()));
        assertThat(authorArticleDto.getDescription().equals(article.getDescription()));
        assertThat(authorArticleDto.getAuthorId() == author.getId());
        assertThat(authorArticleDto.getAuthorFirstName().equals(author.getFirstName()));
        assertThat(authorArticleDto.getAuthorLastName().equals(author.getLastName()));
    }

    @Test
    public void testConvertToGetLatestArticlesResponseDto() {
        GetLatestArticlesResponseDto latestArticleDto = articleMapper.convertToGetLatestArticlesResponseDto(article);

        assertThat(latestArticleDto.getId() == article.getId());
        assertThat(latestArticleDto.getTitle().equals(article.getTitle()));
        assertThat(latestArticleDto.getDescription().equals(article.getDescription()));
        assertThat(latestArticleDto.getDateOfPublication().equals(article.getDateOfPublication()));
    }

    @Test
    public void testConvertToGetPopularArticlesResponseDto() {
        GetPopularArticlesResponseDto popularArticleDto = articleMapper.convertToGetPopularArticlesResponseDto(article);

        assertThat(popularArticleDto.getId() == article.getId());
        assertThat(popularArticleDto.getTitle().equals(article.getTitle()));
        assertThat(popularArticleDto.getDescription().equals(article.getDescription()));
        assertThat(popularArticleDto.getNumLikes()== article.getNumLikes());
    }

    @Test
    public void testConvertToGetArticleInCategoryResponseDto() {
        GetArticleInCategoryResponseDto categoryArticleDto = articleMapper.convertToGetArticleInCategoryResponseDto(article, category);

        assertThat(categoryArticleDto.getId() == article.getId());
        assertThat(categoryArticleDto.getTitle().equals(article.getTitle()));
        assertThat(categoryArticleDto.getDescription().equals(article.getDescription()));
        assertThat(categoryArticleDto.getCategoryId() == category.getId());
        assertThat(categoryArticleDto.getCategoryName().equals(category.getName()));
    }
}
