package bootcamp.five.agency.newys.services.author;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;

import java.util.List;
import java.util.Optional;

import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static bootcamp.five.agency.newys.Data.*;

public class GetAuthorServiceTest {

  private  GetAuthorService getAuthorService;
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

    assertThat(response.getId().equals(authorId));
  }

  @Test
  public void getAuthorByFirstNameAndLastName_AuthorFetched_True() {
    when(authorRepository.findAuthorByFirstNameAndLastName(authorFirstName, authorLastName)).thenReturn(author);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author)).thenReturn(authorDetailsDto);

    AuthorDetailsResponseDto response = getAuthorService.getAuthorByFirstNameAndLastName(authorFirstName, authorLastName);

    assertThat(response.getFirstName().equals(authorFirstName));
    assertThat(response.getLastName().equals(authorLastName));
  }

  @Test
  public void getAuthorByEmail_AuthorFetched_True() {
    when(authorRepository.findAuthorByEmail(authorEmail)).thenReturn(author);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author)).thenReturn(authorDetailsDto);

    AuthorDetailsResponseDto response = getAuthorService.getAuthorByEmail(authorEmail);

    assertThat(response.getEmail().equals(authorEmail));
  }

  @Test void getNumberOfArticles_NumberOfArticlesIsZero_True() {
    when(authorRepository.findById(authorId)).thenReturn(Optional.of(authorNoArticles));

    Integer numberOfArticles = getAuthorService.getNumberOfArticles(authorId);

    assertThat(numberOfArticles == 0);
  }

  @Test
  public void getByType_TypeAuthorsFetched_True() {
    when(authorRepository.findByType(authorType)).thenReturn(authorsOfSameType);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author)).thenReturn(authorDetailsDto);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author2)).thenReturn(authorDetailsDto2);

    List<AuthorDetailsResponseDto> authorDetailsResponseDtoList = getAuthorService.getByType(authorType);

    assertThat(!authorDetailsResponseDtoList.isEmpty());
    assertThat(authorDetailsResponseDtoList.stream().anyMatch(
            getAuthorDetailsResponseDto -> getAuthorDetailsResponseDto.getType().equals(authorType)));
  }

  @Test
  public void getAll_AllAuthorsFetched_True() {
    when(authorRepository.findAll()).thenReturn(authorsAll);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author)).thenReturn(authorDetailsDto);
    when(authorMapper.convertToGetAuthorDetailsResponseDto(author2)).thenReturn(authorDetailsDto2);

    List<AuthorDetailsResponseDto> authorDetailsResponseDtoList = getAuthorService.getAll();

    assertThat(!authorDetailsResponseDtoList.isEmpty());
  }

}
