package bootcamp.five.agency.newys.repository;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.domain.Author;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

  List<Article> findByAuthor(Author author);

  List<Article> findByDateOfPublicationAfter(Date dateOfPublication);

  List<Article> findByNumLikesGreaterThan(int numLikes);

}
