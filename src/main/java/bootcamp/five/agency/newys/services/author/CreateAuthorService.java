package bootcamp.five.agency.newys.services.author;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.AuthorResponseDto;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import java.util.ArrayList;
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

  public AuthorResponseDto createAuthor(String firstName, String lastName, String email, String type) {
    return authorMapper.convertToAuthorResponseDto(authorRepository.save(new Author.AuthorBuilder()
        .firstName(firstName)
        .lastName(lastName)
        .email(email)
        .type(type)
        .articles(new ArrayList<>())
        .categories(new ArrayList<>())
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
