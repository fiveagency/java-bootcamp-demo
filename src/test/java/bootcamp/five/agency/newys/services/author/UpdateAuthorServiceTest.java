package bootcamp.five.agency.newys.services.author;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static bootcamp.five.agency.newys.Data.*;
import static org.mockito.Mockito.when;

public class UpdateAuthorServiceTest {

  private UpdateAuthorService updateAuthorService;
  private AuthorRepository authorRepository;
  private AuthorMapper authorMapper;

  @BeforeEach
  public void setup() {
    authorRepository = mock(AuthorRepository.class);
    authorMapper = mock(AuthorMapper.class);
    updateAuthorService = new UpdateAuthorService(authorRepository, authorMapper);
  }

  @Test
  public void updateAuthor_AuthorUpdated_True() {
    when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
    when(authorRepository.save(Mockito.any(Author.class))).thenReturn(authorUpdated);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(authorUpdated)).thenReturn(authorUpdatedDetailsDto);

    AuthorDetailsResponseDto authorDetailsResponseDto = updateAuthorService.updateAuthor(authorId, authorFirstName2,
            authorLastName2, authorEmail2, authorType2);

    assertThat(authorDetailsResponseDto.getId().equals(authorId));
    assertThat(authorDetailsResponseDto.getFirstName().equals(authorFirstName2));
    assertThat(authorDetailsResponseDto.getLastName().equals(authorLastName2));
    assertThat(authorDetailsResponseDto.getEmail().equals(authorEmail2));
    assertThat(authorDetailsResponseDto.getType().equals(authorType2));
  }

}
