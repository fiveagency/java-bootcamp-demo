package bootcamp.five.agency.newys.mappers;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.domain.Category;
import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetArticleInCategoryResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetAuthorArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetLatestArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetPopularArticlesResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

  public GetArticleDetailsResponseDto convertToGetArticleDetailsResponseDto(Article article) {
    return new GetArticleDetailsResponseDto.GetArticleDetailsResponseDtoBuilder()
        .id(article.getId())
        .title(article.getTitle())
        .description(article.getDescription())
        .imageUrl(article.getImageUrl())
        .dateOfPublication(article.getDateOfPublication())
        .content(article.getContent())
        .numLikes(article.getNumLikes())
        .authorId(article.getAuthor().getId())
        .build();
  }

  public GetAuthorArticlesResponseDto convertToGetAuthorArticlesResponseDto(Article article, Author author) {
    return new GetAuthorArticlesResponseDto.GetAuthorArticlesResponseDtoBuilder()
        .id(article.getId())
        .title(article.getTitle())
        .description(article.getDescription())
        .authorId(author.getId())
        .authorFirstName(author.getFirstName())
        .authorLastName(author.getLastName())
        .build();
  }

  public GetLatestArticlesResponseDto convertToGetLatestArticlesResponseDto(Article article) {
    return new GetLatestArticlesResponseDto.GetLatestArticlesResponseDtoBuilder()
        .id(article.getId())
        .title(article.getTitle())
        .description(article.getDescription())
        .dateOfPublication(article.getDateOfPublication())
        .build();
  }

  public GetPopularArticlesResponseDto convertToGetPopularArticlesResponseDto(Article article) {
    return new GetPopularArticlesResponseDto.GetPopularArticlesResponseDtoBuilder()
        .id(article.getId())
        .title(article.getTitle())
        .description(article.getDescription())
        .numLikes(article.getNumLikes())
        .build();
  }

  public GetArticleInCategoryResponseDto convertToGetArticleInCategoryResponseDto(Article article, Category category) {
    return new GetArticleInCategoryResponseDto.GetArticleInCategoryResponseDtoBuilder()
        .id(article.getId())
        .title(article.getTitle())
        .description(article.getDescription())
        .categoryId(category.getId())
        .categoryName(category.getName())
        .build();
  }

}
