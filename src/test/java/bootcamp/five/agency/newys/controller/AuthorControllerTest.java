package bootcamp.five.agency.newys.controller;

import static bootcamp.five.agency.newys.Data.allAuthorsDto;
import static bootcamp.five.agency.newys.Data.authorDetailsDto;
import static bootcamp.five.agency.newys.Data.authorId;
import static bootcamp.five.agency.newys.Data.authorUpdatedDetailsDto;
import static bootcamp.five.agency.newys.Data.createAuthorRequestDto;
import static bootcamp.five.agency.newys.Data.updateAuthorRequestDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.DeleteAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import bootcamp.five.agency.newys.services.author.UpdateAuthorService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AuthorControllerTest {

    private AuthorController authorController;
    private CreateAuthorService createAuthorService;
    private UpdateAuthorService updateAuthorService;
    private GetAuthorService getAuthorService;

    @BeforeEach
    public void setup() {

        createAuthorService = mock(CreateAuthorService.class);
        updateAuthorService = mock(UpdateAuthorService.class);
        DeleteAuthorService deleteAuthorService = mock(DeleteAuthorService.class);
        getAuthorService = mock(GetAuthorService.class);
        authorController = new AuthorController(getAuthorService, createAuthorService, updateAuthorService, deleteAuthorService);
    }

    @Test
    public void testGetAuthors() {
        when(getAuthorService.getAll()).thenReturn(allAuthorsDto);

        ResponseEntity<List<AuthorDetailsResponseDto>> response = authorController.getAuthors();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    public  void testGetAuthor() {
        when(getAuthorService.getAuthorById(authorId)).thenReturn(authorDetailsDto);

        ResponseEntity<AuthorDetailsResponseDto> response = authorController.getAuthor(authorId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(authorId);
    }

    @Test
    public void testCreateAuthor() {
        when(createAuthorService.createAuthor(anyString(), anyString(), anyString(), anyString())).thenReturn(authorDetailsDto);

        ResponseEntity<AuthorDetailsResponseDto> response = authorController.createAuthor(createAuthorRequestDto);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getBody().getFirstName()).isEqualTo(createAuthorRequestDto.getFirstName());
        assertThat(response.getBody().getLastName()).isEqualTo(createAuthorRequestDto.getLastName());
        assertThat(response.getBody().getEmail()).isEqualTo(createAuthorRequestDto.getEmail());
        assertThat(response.getBody().getType()).isEqualTo(createAuthorRequestDto.getType());
    }

    @Test
    public void testUpdateAuthor() {
        when(updateAuthorService.updateAuthor(any(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn(authorUpdatedDetailsDto);

        ResponseEntity<AuthorDetailsResponseDto> response = authorController.updateAuthor(authorId, updateAuthorRequestDto);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(authorId);
        assertThat(response.getBody().getFirstName()).isEqualTo(updateAuthorRequestDto.getFirstName());
        assertThat(response.getBody().getLastName()).isEqualTo(updateAuthorRequestDto.getLastName());
        assertThat(response.getBody().getEmail()).isEqualTo(updateAuthorRequestDto.getEmail());
        assertThat(response.getBody().getType()).isEqualTo(updateAuthorRequestDto.getType());
    }

    @Test
    public void testDeleteAuthor() {
        ResponseEntity<Void> response = authorController.deleteAuthor(authorId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
