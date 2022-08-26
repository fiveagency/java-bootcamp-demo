package bootcamp.five.agency.newys.services.author;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static bootcamp.five.agency.newys.Data.*;

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

    assertThat(response.getId() != null);
    assertThat(response.getFirstName().equals(authorFirstName));
    assertThat(response.getLastName().equals(authorLastName));
    assertThat(response.getEmail().equals(authorEmail));
    assertThat(response.getType().equals(authorType));
  }

}
