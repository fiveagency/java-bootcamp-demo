package bootcamp.five.agency.newys.services.author;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateAuthorService {

  private final AuthorRepository authorRepository;
  private final AuthorMapper authorMapper;

  @Autowired
  public UpdateAuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
    this.authorRepository = authorRepository;
    this.authorMapper = authorMapper;
  }

  public AuthorDetailsResponseDto updateAuthor(Long id, String firstName, String lastName, String email, String type) {
    Author author = authorRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));

    return authorMapper.convertToGetAuthorDetailsResponseDto(authorRepository.save(new Author.AuthorBuilder()
        .id(author.getId())
        .firstName(firstName)
        .lastName(lastName)
        .email(email)
        .type(type)
        .articles(author.getArticles())
        .categories(author.getCategories())
        .build()));
  }

}
