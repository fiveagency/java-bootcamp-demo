package bootcamp.five.agency.newys.services.author;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAuthorService {

  private final AuthorRepository authorRepository;

  @Autowired
  public GetAuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author getAuthorById(Long id) {
    return authorRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));
  }

  public Author getAuthorByFirstNameAndLastName(String firstName, String lastName) {
    return authorRepository.findAuthorByFirstNameAndLastName(firstName, lastName);
  }

  public Author getAuthorByEmail(String email) {
    return authorRepository.findAuthorByEmail(email);
  }

  public Integer getNumberOfArticles(Long id) {
    return authorRepository.findById(id)
        .map(author -> author.getArticles().size())
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));
  }

  public List<Author> getByType(String type) {
    return authorRepository.findByType(type);
  }

  public List<Author> getAll() {
    return authorRepository.findAll();
  }

}
