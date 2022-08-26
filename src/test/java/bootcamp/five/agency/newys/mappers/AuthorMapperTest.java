package bootcamp.five.agency.newys.mappers;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static bootcamp.five.agency.newys.Data.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthorMapperTest {

    private AuthorMapper authorMapper;

    @BeforeEach
    public void setup() {
        authorMapper = new AuthorMapper();
    }

    @Test
    public void testConvertToGetAuthorDetailsResponseDto() {
        AuthorDetailsResponseDto authorDto = authorMapper.convertToGetAuthorDetailsResponseDto(author);

        assertThat(authorDto.getId() == author.getId());
        assertThat(authorDto.getFirstName().equals(author.getFirstName()));
        assertThat(authorDto.getLastName().equals(author.getLastName()));
        assertThat(authorDto.getEmail().equals(author.getEmail()));
        assertThat(authorDto.getType().equals(author.getType()));
    }
}
