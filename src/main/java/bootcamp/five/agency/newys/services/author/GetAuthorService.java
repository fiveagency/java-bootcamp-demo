package bootcamp.five.agency.newys.services.author;

import bootcamp.five.agency.newys.dto.response.AuthorResponseDto;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import java.util.ArrayList;
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

  public AuthorResponseDto getAuthorById(Long id) {
    return authorMapper.convertToAuthorResponseDto(authorRepository.findById(id)
        .orElseThrow(() -> new IllegalStateException("Author does not exists")));
  }

  public AuthorResponseDto getAuthorByFirstNameAndLastName(String firstName, String lastName) {
    return authorMapper.convertToAuthorResponseDto(authorRepository.findAuthorByFirstNameAndLastName(firstName, lastName));
  }

  public AuthorResponseDto getAuthorByEmail(String email) {
    return authorMapper.convertToAuthorResponseDto(authorRepository.findAuthorByEmail(email));
  }

  public Integer getNumberOfArticles(Long id) {
    return authorRepository.findById(id)
        .map(author -> author.getArticles().size())
        .orElseThrow(() -> new IllegalStateException("Author does not exists"));
  }

  public List<AuthorResponseDto> getByType(String type) {
    return Optional.ofNullable(authorRepository.findByType(type))
        .map(entities -> entities.stream().map(authorMapper::convertToAuthorResponseDto).collect(Collectors.toList()))
        .orElse(new ArrayList<>());
  }

  public List<AuthorResponseDto> getAll() {
    return Optional.of(authorRepository.findAll())
        .map(entities -> entities.stream().map(authorMapper::convertToAuthorResponseDto).collect(Collectors.toList()))
        .orElse(new ArrayList<>());
  }

}
