package bootcamp.five.agency.newys.services.article;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetArticleService {

  private final ArticleRepository articleRepository;
  private final AuthorRepository authorRepository;

  @Autowired
  public GetArticleService(ArticleRepository articleRepository, AuthorRepository authorRepository) {
    this.articleRepository = articleRepository;
    this.authorRepository = authorRepository;
  }

  public Article getArticleById(Long id) {
    return articleRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Article does not exists"));
  }

  public List<Article> getArticlesByAuthor(Long authorId) {
    Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));

    return articleRepository.findByAuthor(author);
  }

  public List<Article> getLatestArticles() {
    return articleRepository.findByDateOfPublicationAfter(Date.valueOf(LocalDate.now().minusDays(7)));
  }

  public List<Article> getPopularArticles() {
    return articleRepository.findByNumLikesGreaterThan(3);
  }

  public List<Article> getAll() {
    return articleRepository.findAll();
  }

}
