package bootcamp.five.agency.newys.unit.services.author;

import bootcamp.five.agency.newys.exceptions.AuthorNotFoundException;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.services.author.DeleteAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static bootcamp.five.agency.newys.unit.Data.*;

public class DeleteAuthorServiceTest {

  private DeleteAuthorService deleteAuthorService;
  private GetAuthorService getAuthorService;
  private AuthorRepository authorRepository;
  private AuthorMapper authorMapper;

  @BeforeEach
  public void setup() {
    authorRepository = mock(AuthorRepository.class);
    authorMapper = mock(AuthorMapper.class);
    deleteAuthorService = new DeleteAuthorService(authorRepository);
    getAuthorService = new GetAuthorService(authorRepository, authorMapper);
  }

  @Test
  public void deleteAuthor_AuthorDeleted_True() {
    when(authorRepository.findById(authorId)).thenReturn(Optional.empty());

    deleteAuthorService.deleteAuthorById(authorId);

    assertThatExceptionOfType(AuthorNotFoundException.class).isThrownBy(() -> getAuthorService.getAuthorById(authorId));
  }

}
