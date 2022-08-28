package bootcamp.five.agency.newys.services.article;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.ArticleMapper;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateArticleService {

  private final ArticleRepository articleRepository;
  private final AuthorRepository authorRepository;
  private final ArticleMapper articleMapper;

  @Autowired
  public UpdateArticleService(ArticleRepository articleRepository, AuthorRepository authorRepository, ArticleMapper articleMapper) {
    this.articleRepository = articleRepository;
    this.authorRepository = authorRepository;
    this.articleMapper = articleMapper;
  }

  public GetArticleDetailsResponseDto updateArticle(Long id, String title, String description, String imageUrl, String content) {
    Article article = articleRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Article does not exists"));

    return articleMapper.convertToGetArticleDetailsResponseDto(articleRepository.save(Article.builder()
        .id(article.getId())
        .title(title)
        .description(description)
        .imageUrl(imageUrl)
        .dateOfPublication(article.getDateOfPublication())
        .content(content)
        .numLikes(article.getNumLikes())
        .author(article.getAuthor())
        .categories(article.getCategories())
        .build()));
  }

  public GetArticleDetailsResponseDto changeArticleAuthor(Long id, Long authorId) {
    Article article = articleRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Article does not exists"));

    Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));

    article.setAuthor(author);

    return articleMapper.convertToGetArticleDetailsResponseDto(articleRepository.save(article));
  }

  public GetArticleDetailsResponseDto likeArticle(Long id) {
    Article article = articleRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Article does not exists"));

    article.setNumLikes(article.getNumLikes() + 1);

    return articleMapper.convertToGetArticleDetailsResponseDto(articleRepository.save(article));
  }

  public GetArticleDetailsResponseDto unlikeArticle(Long id) {
    Article article = articleRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Article does not exists"));

    article.setNumLikes(article.getNumLikes() - 1);

    return articleMapper.convertToGetArticleDetailsResponseDto(articleRepository.save(article));
  }

}
