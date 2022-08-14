package bootcamp.five.agency.newys.mappers;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.domain.Category;
import bootcamp.five.agency.newys.dto.response.ArticleResponseDto;
import bootcamp.five.agency.newys.dto.response.AuthorResponseDto;
import bootcamp.five.agency.newys.dto.response.CategoryResponseDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

  public AuthorResponseDto convertToAuthorResponseDto(Author author) {
    return new AuthorResponseDto.AuthorResponseDtoBuilder()
        .id(author.getId())
        .firstName(author.getFirstName())
        .lastName(author.getLastName())
        .email(author.getEmail())
        .type(author.getType())
        .articles(convertToArticleResponseDtoList(author.getArticles()))
        .categories(convertToCategoryResponseDtoList(author.getCategories()))
        .build();
  }

  private List<ArticleResponseDto> convertToArticleResponseDtoList(List<Article> articles) {
    return Optional.ofNullable(articles)
        .map(entities -> entities.stream().map(this::convertToArticleResponseDto).collect(Collectors.toList()))
        .orElse(new ArrayList<>());
  }

  private ArticleResponseDto convertToArticleResponseDto(Article article) {
    return new ArticleResponseDto.ArticleResponseDtoBuilder()
        .id(article.getId())
        .title(article.getTitle())
        .description(article.getDescription())
        .imageUrl(article.getImageUrl())
        .dateOfPublication(article.getDateOfPublication())
        .content(article.getContent())
        .numLikes(article.getNumLikes())
        .authorId(article.getAuthor().getId())
        .categories(null)
        .build();
  }

  public List<CategoryResponseDto> convertToCategoryResponseDtoList(List<Category> categories) {
    return Optional.ofNullable(categories)
        .map(entities -> entities.stream().map(this::convertToCategoryResponseDto).collect(Collectors.toList()))
        .orElse(new ArrayList<>());
  }

  public CategoryResponseDto convertToCategoryResponseDto(Category category) {
    return new CategoryResponseDto.CategoryResponseDtoBuilder()
        .id(category.getId())
        .name(category.getName())
        .description(category.getDescription())
        .authorId(category.getAuthor().getId())
        .addedArticles(null)
        .build();
  }

}
