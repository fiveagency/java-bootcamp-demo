package bootcamp.five.agency.newys.controller;

import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.DeleteAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import bootcamp.five.agency.newys.services.author.UpdateAuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static bootcamp.five.agency.newys.Data.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GetAuthorService getAuthorService;
    @MockBean
    private CreateAuthorService createAuthorService;
    @MockBean
    private UpdateAuthorService updateAuthorService;
    @MockBean
    private DeleteAuthorService deleteAuthorService;


    @Test
    public void testGetAuthors() throws Exception {
        when(getAuthorService.getAll()).thenReturn(allAuthorsDto);

        MvcResult result = mockMvc.perform(get("/authors"))
                .andExpect(status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertThat(response != null);
        final String jsonResponse = response.getContentAsString();
        List<AuthorDetailsResponseDto> content = objectMapper.readValue(jsonResponse, List.class);
        assertThat(content != null);
        assertThat(!content.isEmpty());
    }

    @Test
    public  void testGetAuthor() throws Exception {
        when(getAuthorService.getAuthorById(authorId)).thenReturn(authorDetailsDto);

        MvcResult result = mockMvc.perform(get("/author/" + authorId))
                .andExpect(status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertThat(response != null);
        final String jsonResponse = response.getContentAsString();
        AuthorDetailsResponseDto content = objectMapper.readValue(jsonResponse, AuthorDetailsResponseDto.class);
        assertThat(content != null);
        assertThat(content.getId().equals(authorId));

    }

    @Test
    public void testCreateAuthor() throws Exception {
        when(createAuthorService.createAuthor(anyString(), anyString(), anyString(), anyString())).thenReturn(authorDetailsDto);

        final String jsonRequest = objectMapper.writeValueAsString(createAuthorRequestDto);

        MvcResult result = mockMvc.perform(post("/author/create")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonRequest))
                .andExpect(status().isCreated()).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertThat(response != null);
        final String jsonResponse = response.getContentAsString();
        AuthorDetailsResponseDto content = objectMapper.readValue(jsonResponse, AuthorDetailsResponseDto.class);
        assertThat(content != null);
        assertThat(content.getId() != null);
        assertThat(content.getFirstName().equals(createAuthorRequestDto.getFirstName()));
        assertThat(content.getLastName().equals(createAuthorRequestDto.getLastName()));
        assertThat(content.getEmail().equals(createAuthorRequestDto.getEmail()));
        assertThat(content.getType().equals(createAuthorRequestDto.getType()));
    }

    @Test
    public void testUpdateAuthor() throws Exception {
        when(updateAuthorService.updateAuthor(any(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn(authorUpdatedDetailsDto);

        final String jsonRequest = objectMapper.writeValueAsString(updateAuthorRequestDto);

        MvcResult result = mockMvc.perform(put("/author/" + authorId + "/update")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonRequest))
                .andExpect(status().isOk()).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertThat(response != null);
        final String jsonResponse = response.getContentAsString();
        AuthorDetailsResponseDto content = objectMapper.readValue(jsonResponse, AuthorDetailsResponseDto.class);
        assertThat(content != null);
        assertThat(content.getId().equals(authorId));
        assertThat(content.getFirstName().equals(updateAuthorRequestDto.getFirstName()));
        assertThat(content.getLastName().equals(updateAuthorRequestDto.getLastName()));
        assertThat(content.getEmail().equals(updateAuthorRequestDto.getEmail()));
        assertThat(content.getType().equals(updateAuthorRequestDto.getType()));
    }

    @Test
    public void testDeleteAuthor() throws Exception {
        MvcResult result = mockMvc.perform(delete("/author/" + articleId + "/delete"))
                .andExpect(status().isNoContent()).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertThat(response != null);
    }
}
