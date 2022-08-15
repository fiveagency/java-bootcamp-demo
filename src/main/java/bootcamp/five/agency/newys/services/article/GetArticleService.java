package bootcamp.five.agency.newys.services.article;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetAuthorArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetLatestArticlesResponseDto;
import bootcamp.five.agency.newys.dto.response.article.GetPopularArticlesResponseDto;
import bootcamp.five.agency.newys.mappers.ArticleMapper;
import bootcamp.five.agency.newys.repository.ArticleRepository;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetArticleService {

  private final ArticleRepository articleRepository;
  private final AuthorRepository authorRepository;
  private final ArticleMapper articleMapper;

  @Autowired
  public GetArticleService(ArticleRepository articleRepository, AuthorRepository authorRepository, ArticleMapper articleMapper) {
    this.articleRepository = articleRepository;
    this.authorRepository = authorRepository;
    this.articleMapper = articleMapper;
  }

  public GetArticleDetailsResponseDto getArticleById(Long id) {
    return articleMapper.convertToGetArticleDetailsResponseDto(articleRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Article does not exists")));
  }

  public List<GetAuthorArticlesResponseDto> getArticlesByAuthor(Long authorId) {
    Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));

    return Optional.of(articleRepository.findByAuthor(author))
        .map(articles -> articles.stream().map(article ->
            articleMapper.convertToGetAuthorArticlesResponseDto(article, author)).collect(Collectors.toList()))
        .orElse(new ArrayList<>());
  }

  public List<GetLatestArticlesResponseDto> getLatestArticles() {
    return Optional.ofNullable(articleRepository.findByDateOfPublicationAfter(Date.valueOf(LocalDate.now().minusDays(7))))
        .map(entities -> entities.stream().map(articleMapper::convertToGetLatestArticlesResponseDto).collect(Collectors.toList()))
        .orElse(new ArrayList<>());
  }

  public List<GetPopularArticlesResponseDto> getPopularArticles() {
    return Optional.ofNullable(articleRepository.findByNumLikesGreaterThan(3))
        .map(entities -> entities.stream().map(articleMapper::convertToGetPopularArticlesResponseDto).collect(Collectors.toList()))
        .orElse(new ArrayList<>());
  }

  public List<GetArticleDetailsResponseDto> getAll() {
    return Optional.of(articleRepository.findAll())
        .map(entities -> entities.stream().map(articleMapper::convertToGetArticleDetailsResponseDto).collect(Collectors.toList()))
        .orElse(new ArrayList<>());
  }

}
