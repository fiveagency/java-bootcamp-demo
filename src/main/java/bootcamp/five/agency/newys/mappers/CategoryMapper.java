package bootcamp.five.agency.newys.mappers;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.domain.Category;
import bootcamp.five.agency.newys.dto.response.ArticleResponseDto;
import bootcamp.five.agency.newys.dto.response.CategoryResponseDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

  public CategoryResponseDto convertToCategoryResponseDto(Category category) {
    return new CategoryResponseDto.CategoryResponseDtoBuilder()
        .id(category.getId())
        .name(category.getName())
        .description(category.getDescription())
        .authorId(category.getAuthor().getId())
        .addedArticles(convertToArticleResponseDtoList(category.getAddedArticles()))
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

}
