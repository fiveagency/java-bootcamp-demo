package bootcamp.five.agency.newys.services.author;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.exceptions.AuthorNotFoundException;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import bootcamp.five.agency.newys.repository.AuthorRepository;
import bootcamp.five.agency.newys.security.UserPrincipal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class GetAuthorService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private final AuthorRepository authorRepository;
  private final AuthorMapper authorMapper;

  @Autowired
  public GetAuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
    this.authorRepository = authorRepository;
    this.authorMapper = authorMapper;
  }

  // How you can secure this method:
  //@Secured("ROLE")
  //@PreAuthorize("ROLE")
  //@PostAuthorize()"ROLE")
  //@RolesAllowed("ROLE")
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

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    // if noone is logged in authentication will be null
    // if we're using multiple providers, authentication can be of different type so check for correct principal type
    if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
      logger.info("User {} requesting all users", ((UserPrincipal)authentication.getPrincipal()).getUsername());
    }

    return Optional.of(authorRepository.findAll())
        .map(entities -> entities.stream().map(authorMapper::convertToGetAuthorDetailsResponseDto).collect(Collectors.toList()))
        .orElse(Collections.emptyList());
  }

}
