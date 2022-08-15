package bootcamp.five.agency.newys.services.article;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.ArticleMapper;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateArticleService {

  private final ArticleRepository articleRepository;
  private final AuthorRepository authorRepository;
  private final ArticleMapper articleMapper;

  @Autowired
  public CreateArticleService(ArticleRepository articleRepository, AuthorRepository authorRepository, ArticleMapper articleMapper) {
    this.articleRepository = articleRepository;
    this.authorRepository = authorRepository;
    this.articleMapper = articleMapper;
  }

  public GetArticleDetailsResponseDto createArticle(String title, String description, String imageUrl, Date dateOfPublication, String content, Long authorId) {
    Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));

    return articleMapper.convertToGetArticleDetailsResponseDto(articleRepository.save(new Article.ArticleBuilder()
        .title(title)
        .description(description)
        .imageUrl(imageUrl)
        .dateOfPublication(new java.sql.Date(dateOfPublication.getTime()))
        .content(content)
        .numLikes(0)
        .author(author)
        .categories(new ArrayList<>())
        .build()));
  }

}
