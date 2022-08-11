package bootcamp.five.agency.newys.services.author;

import bootcamp.five.agency.newys.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAuthorService {

  private final AuthorRepository authorRepository;

  @Autowired
  public DeleteAuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public void deleteAuthorById(Long id) {
    authorRepository.deleteById(id);
  }

}
