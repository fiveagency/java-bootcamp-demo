package bootcamp.five.agency.newys.unit.services.author;

import static bootcamp.five.agency.newys.unit.Data.author;
import static bootcamp.five.agency.newys.unit.Data.author2;
import static bootcamp.five.agency.newys.unit.Data.authorDetailsDto;
import static bootcamp.five.agency.newys.unit.Data.authorDetailsDto2;
import static bootcamp.five.agency.newys.unit.Data.authorEmail;
import static bootcamp.five.agency.newys.unit.Data.authorFirstName;
import static bootcamp.five.agency.newys.unit.Data.authorId;
import static bootcamp.five.agency.newys.unit.Data.authorLastName;
import static bootcamp.five.agency.newys.unit.Data.authorNoArticles;
import static bootcamp.five.agency.newys.unit.Data.authorType;
import static bootcamp.five.agency.newys.unit.Data.authorsAll;
import static bootcamp.five.agency.newys.unit.Data.authorsOfSameType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetAuthorServiceTest {

  private GetAuthorService getAuthorService;
  private AuthorRepository authorRepository;
  private AuthorMapper authorMapper;

  @BeforeEach
  public void setup() {
    authorRepository = mock(AuthorRepository.class);
    authorMapper = mock(AuthorMapper.class);
    getAuthorService = new GetAuthorService(authorRepository, authorMapper);
  }

  @Test
  public void getAuthorById_AuthorFetched_True() {
    when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author)).thenReturn(authorDetailsDto);

    AuthorDetailsResponseDto response = getAuthorService.getAuthorById(authorId);

    assertThat(response.getId()).isEqualTo(authorId);
  }

  @Test
  public void getAuthorByFirstNameAndLastName_AuthorFetched_True() {
    when(authorRepository.findAuthorByFirstNameAndLastName(authorFirstName, authorLastName)).thenReturn(author);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author)).thenReturn(authorDetailsDto);

    AuthorDetailsResponseDto response = getAuthorService.getAuthorByFirstNameAndLastName(authorFirstName, authorLastName);

    assertThat(response.getFirstName()).isEqualTo(authorFirstName);
    assertThat(response.getLastName()).isEqualTo(authorLastName);
  }

  @Test
  public void getAuthorByEmail_AuthorFetched_True() {
    when(authorRepository.findAuthorByEmail(authorEmail)).thenReturn(author);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author)).thenReturn(authorDetailsDto);

    AuthorDetailsResponseDto response = getAuthorService.getAuthorByEmail(authorEmail);

    assertThat(response.getEmail()).isEqualTo(authorEmail);
  }

  @Test void getNumberOfArticles_NumberOfArticlesIsZero_True() {
    when(authorRepository.findById(authorId)).thenReturn(Optional.of(authorNoArticles));

    Integer numberOfArticles = getAuthorService.getNumberOfArticles(authorId);

    assertThat(numberOfArticles).isEqualTo(0);
  }

  @Test
  public void getByType_TypeAuthorsFetched_True() {
    when(authorRepository.findByType(authorType)).thenReturn(authorsOfSameType);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author)).thenReturn(authorDetailsDto);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author2)).thenReturn(authorDetailsDto2);

    List<AuthorDetailsResponseDto> authorDetailsResponseDtoList = getAuthorService.getByType(authorType);

    assertThat(authorDetailsResponseDtoList).isNotEmpty();
    assertThat(authorDetailsResponseDtoList).allMatch(dto -> dto.getType().equals(authorType));
  }

  @Test
  public void getAll_AllAuthorsFetched_True() {
    when(authorRepository.findAll()).thenReturn(authorsAll);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author)).thenReturn(authorDetailsDto);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author2)).thenReturn(authorDetailsDto2);

    List<AuthorDetailsResponseDto> authorDetailsResponseDtoList = getAuthorService.getAll();

    assertThat(authorDetailsResponseDtoList).isNotEmpty();
  }

}
