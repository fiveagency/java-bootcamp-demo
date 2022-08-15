package bootcamp.five.agency.newys.mappers;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.author.GetAuthorDetailsResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

  public GetAuthorDetailsResponseDto convertToGetAuthorDetailsResponseDto(Author author) {
    return new GetAuthorDetailsResponseDto.GetAuthorDetailsResponseDtoBuilder()
        .id(author.getId())
        .firstName(author.getFirstName())
        .lastName(author.getLastName())
        .email(author.getEmail())
        .type(author.getType())
        .build();
  }

}
