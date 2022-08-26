package bootcamp.five.agency.newys.controller;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.DeleteAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import bootcamp.five.agency.newys.services.author.UpdateAuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static bootcamp.five.agency.newys.Data.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthorControllerTest {

    private AuthorController authorController;
    private CreateAuthorService createAuthorService;
    private UpdateAuthorService updateAuthorService;
    private DeleteAuthorService deleteAuthorService;
    private GetAuthorService getAuthorService;

    @BeforeEach
    public void setup() {

        createAuthorService = mock(CreateAuthorService.class);
        updateAuthorService = mock(UpdateAuthorService.class);
        deleteAuthorService = mock(DeleteAuthorService.class);
        getAuthorService = mock(GetAuthorService.class);
        authorController = new AuthorController(getAuthorService, createAuthorService, updateAuthorService, deleteAuthorService);
    }

    @Test
    public void testGetAuthors() {
        when(getAuthorService.getAll()).thenReturn(allAuthorsDto);

        ResponseEntity<List<AuthorDetailsResponseDto>> response = authorController.getAuthors();

        assertThat(response.getStatusCode() == HttpStatus.OK);
        assertThat(response.getBody() != null);
        assertThat(!response.getBody().isEmpty());
    }

    @Test
    public  void testGetAuthor() {
        when(getAuthorService.getAuthorById(authorId)).thenReturn(authorDetailsDto);

        ResponseEntity<AuthorDetailsResponseDto> response = authorController.getAuthor(authorId);

        assertThat(response.getStatusCode() == HttpStatus.OK);
        assertThat(response.getBody() != null);
        assertThat(response.getBody().getId() == authorId);
    }

    @Test
    public void testCreateAuthor() {
        when(createAuthorService.createAuthor(anyString(), anyString(), anyString(), anyString())).thenReturn(authorDetailsDto);

        ResponseEntity<AuthorDetailsResponseDto> response = authorController.createAuthor(createAuthorRequestDto);

        assertThat(response.getStatusCode() == HttpStatus.CREATED);
        assertThat(response.getBody() != null);
        assertThat(response.getBody().getId() != null);
        assertThat(response.getBody().getFirstName().equals(createAuthorRequestDto.getFirstName()));
        assertThat(response.getBody().getLastName().equals(createAuthorRequestDto.getLastName()));
        assertThat(response.getBody().getEmail().equals(createAuthorRequestDto.getEmail()));
        assertThat(response.getBody().getType().equals(createAuthorRequestDto.getType()));
    }

    @Test
    public void testUpdateAuthor() {
        when(updateAuthorService.updateAuthor(any(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn(authorUpdatedDetailsDto);

        ResponseEntity<AuthorDetailsResponseDto> response = authorController.updateAuthor(authorId, updateAuthorRequestDto);

        assertThat(response.getStatusCode() == HttpStatus.OK);
        assertThat(response.getBody() != null);
        assertThat(response.getBody().getId().equals(authorId));
        assertThat(response.getBody().getFirstName().equals(updateAuthorRequestDto.getFirstName()));
        assertThat(response.getBody().getLastName().equals(updateAuthorRequestDto.getLastName()));
        assertThat(response.getBody().getEmail().equals(updateAuthorRequestDto.getEmail()));
        assertThat(response.getBody().getType().equals(updateAuthorRequestDto.getType()));
    }

    @Test
    public void testDeleteAuthor() {
        ResponseEntity<Void> response = authorController.deleteAuthor(authorId);

        assertThat(response.getStatusCode() == HttpStatus.NO_CONTENT);
    }
}
