package bootcamp.five.agency.newys.unit.services.author;

import static bootcamp.five.agency.newys.unit.Data.author;
import static bootcamp.five.agency.newys.unit.Data.authorDetailsDto;
import static bootcamp.five.agency.newys.unit.Data.authorEmail;
import static bootcamp.five.agency.newys.unit.Data.authorFirstName;
import static bootcamp.five.agency.newys.unit.Data.authorLastName;
import static bootcamp.five.agency.newys.unit.Data.authorType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CreateAuthorServiceTest {

  private CreateAuthorService createAuthorService;
  private AuthorRepository authorRepository;
  private AuthorMapper authorMapper;

  @BeforeEach
  public void setup() {
    authorRepository = mock(AuthorRepository.class);
    authorMapper = mock(AuthorMapper.class);
    createAuthorService = new CreateAuthorService(authorRepository, authorMapper);
  }

  @Test
  public void createAuthor_AuthorCreated_True() {
    when(authorRepository.save(Mockito.any(Author.class))).thenReturn(author);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author)).thenReturn(authorDetailsDto);

    AuthorDetailsResponseDto response = createAuthorService.createAuthor(authorFirstName, authorLastName, authorEmail, authorType);

    assertThat(response.getId()).isNotNull();
    assertThat(response.getFirstName()).isEqualTo(authorFirstName);
    assertThat(response.getLastName()).isEqualTo(authorLastName);
    assertThat(response.getEmail()).isEqualTo(authorEmail);
    assertThat(response.getType()).isEqualTo(authorType);
  }

}
