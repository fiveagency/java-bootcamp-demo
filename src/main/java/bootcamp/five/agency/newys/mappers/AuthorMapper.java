package bootcamp.five.agency.newys.mappers;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

  public AuthorDetailsResponseDto convertToGetAuthorDetailsResponseDto(Author author) {
    return new AuthorDetailsResponseDto.GetAuthorDetailsResponseDtoBuilder()
        .id(author.getId())
        .firstName(author.getFirstName())
        .lastName(author.getLastName())
        .email(author.getEmail())
        .type(author.getType())
        .build();
  }

}
