package bootcamp.five.agency.newys.services.article;

import bootcamp.five.agency.newys.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteArticleService {

  private final ArticleRepository articleRepository;

  @Autowired
  public DeleteArticleService(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  public void deleteArticleById(Long id) {
    articleRepository.deleteById(id);
  }

}
