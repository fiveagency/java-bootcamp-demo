package bootcamp.five.agency.newys.services.author;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAuthorService {

  private final AuthorRepository authorRepository;
  private final AuthorMapper authorMapper;

  // Constructor-based Injection example
  @Autowired
  public CreateAuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
    this.authorRepository = authorRepository;
    this.authorMapper = authorMapper;
  }

  public AuthorDetailsResponseDto createAuthor(String firstName, String lastName, String email, String type) {
    return authorMapper.convertToGetAuthorDetailsResponseDto(authorRepository.save(Author.builder()
        .firstName(firstName)
        .lastName(lastName)
        .email(email)
        .type(type)
        .articles(Collections.emptyList())
        .categories(Collections.emptyList())
        .build()));
  }

  /*
  // Field-based Injection example
  @Autowired
  private final AuthorRepository authorRepository;
   */

  /*
  // Setter-based Injection example
  @Autowired
  private void setAuthorRepository(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }
   */

}
