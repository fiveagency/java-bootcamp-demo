package bootcamp.five.agency.newys.unit.mappers;

import static bootcamp.five.agency.newys.unit.Data.author;
import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.mappers.AuthorMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthorMapperTest {

    private AuthorMapper authorMapper;

    @BeforeEach
    public void setup() {
        authorMapper = new AuthorMapper();
    }

    @Test
    public void testConvertToGetAuthorDetailsResponseDto() {
        AuthorDetailsResponseDto authorDto = authorMapper.convertToGetAuthorDetailsResponseDto(author);

        assertThat(authorDto.getId()).isEqualTo(author.getId());
        assertThat(authorDto.getFirstName()).isEqualTo(author.getFirstName());
        assertThat(authorDto.getLastName()).isEqualTo(author.getLastName());
        assertThat(authorDto.getEmail()).isEqualTo(author.getEmail());
        assertThat(authorDto.getType()).isEqualTo(author.getType());
    }
}
