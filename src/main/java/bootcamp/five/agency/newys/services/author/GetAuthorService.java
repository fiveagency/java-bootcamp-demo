package bootcamp.five.agency.newys.services.author;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.exceptions.AuthorNotFoundException;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAuthorService {

  private final AuthorRepository authorRepository;
  private final AuthorMapper authorMapper;

  @Autowired
  public GetAuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
    this.authorRepository = authorRepository;
    this.authorMapper = authorMapper;
  }

  public AuthorDetailsResponseDto getAuthorById(Long id) {
    return authorMapper.convertToGetAuthorDetailsResponseDto(authorRepository.findById(id)
        .orElseThrow(() -> new AuthorNotFoundException(id)));
  }

  public AuthorDetailsResponseDto getAuthorByFirstNameAndLastName(String firstName, String lastName) {
    return authorMapper.convertToGetAuthorDetailsResponseDto(authorRepository.findAuthorByFirstNameAndLastName(firstName, lastName));
  }

  public AuthorDetailsResponseDto getAuthorByEmail(String email) {
    return authorMapper.convertToGetAuthorDetailsResponseDto(authorRepository.findAuthorByEmail(email));
  }

  public Integer getNumberOfArticles(Long id) {
    return authorRepository.findById(id)
        .map(author -> author.getArticles().size())
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));
  }

  public List<AuthorDetailsResponseDto> getByType(String type) {
    return Optional.ofNullable(authorRepository.findByType(type))
        .map(entities -> entities.stream().map(authorMapper::convertToGetAuthorDetailsResponseDto).collect(Collectors.toList()))
        .orElse(Collections.emptyList());
  }

  public List<AuthorDetailsResponseDto> getAll() {
    return Optional.of(authorRepository.findAll())
        .map(entities -> entities.stream().map(authorMapper::convertToGetAuthorDetailsResponseDto).collect(Collectors.toList()))
        .orElse(Collections.emptyList());
  }

}
