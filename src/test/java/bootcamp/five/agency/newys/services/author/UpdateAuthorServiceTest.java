package bootcamp.five.agency.newys.services.author;

import static bootcamp.five.agency.newys.Data.author;
import static bootcamp.five.agency.newys.Data.authorEmail;
import static bootcamp.five.agency.newys.Data.authorEmail2;
import static bootcamp.five.agency.newys.Data.authorFirstName;
import static bootcamp.five.agency.newys.Data.authorFirstName2;
import static bootcamp.five.agency.newys.Data.authorId;
import static bootcamp.five.agency.newys.Data.authorLastName;
import static bootcamp.five.agency.newys.Data.authorLastName2;
import static bootcamp.five.agency.newys.Data.authorType;
import static bootcamp.five.agency.newys.Data.authorType2;
import static bootcamp.five.agency.newys.Data.authorUpdated;
import static bootcamp.five.agency.newys.Data.authorUpdatedDetailsDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

    assertThat(authorDetailsResponseDto.getId()).isEqualTo(authorId);
    assertThat(authorDetailsResponseDto.getFirstName()).isEqualTo(authorFirstName);
    assertThat(authorDetailsResponseDto.getLastName()).isEqualTo(authorLastName);
    assertThat(authorDetailsResponseDto.getEmail()).isEqualTo(authorEmail);
    assertThat(authorDetailsResponseDto.getType()).isEqualTo(authorType);
  }

}
