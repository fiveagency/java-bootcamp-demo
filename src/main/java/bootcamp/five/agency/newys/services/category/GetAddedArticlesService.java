package bootcamp.five.agency.newys.services.category;

import bootcamp.five.agency.newys.domain.Category;
import bootcamp.five.agency.newys.dto.response.article.GetArticleInCategoryResponseDto;
import bootcamp.five.agency.newys.mappers.ArticleMapper;
import bootcamp.five.agency.newys.repository.CategoryRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class GetAddedArticlesService {

  private final CategoryRepository categoryRepository;
  private final ArticleMapper articleMapper;

  public GetAddedArticlesService(CategoryRepository categoryRepository, ArticleMapper articleMapper) {
    this.categoryRepository = categoryRepository;
    this.articleMapper = articleMapper;
  }

  public List<GetArticleInCategoryResponseDto> getAddedArticles(Long id) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Category does not exists"));

    return Optional.of(category.getAddedArticles())
        .map(articles -> articles.stream().map(article ->
            articleMapper.convertToGetArticleInCategoryResponseDto(article, category)).collect(Collectors.toList()))
        .orElse(Collections.emptyList());
  }

}
