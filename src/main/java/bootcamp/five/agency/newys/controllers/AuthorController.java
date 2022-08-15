package bootcamp.five.agency.newys.controllers;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.author.GetAuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.DeleteAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import bootcamp.five.agency.newys.services.author.UpdateAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    private final GetAuthorService getAuthorService;
    private final CreateAuthorService createAuthorService;

    private final UpdateAuthorService updateAuthorService;

    private final DeleteAuthorService deleteAuthorService;

    @Autowired
    public AuthorController(GetAuthorService getAuthorService, CreateAuthorService createAuthorService,
                            UpdateAuthorService updateAuthorService, DeleteAuthorService deleteAuthorService) {
        this.getAuthorService = getAuthorService;
        this.createAuthorService = createAuthorService;
        this.updateAuthorService = updateAuthorService;
        this.deleteAuthorService = deleteAuthorService;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<GetAuthorDetailsResponseDto>> getAuthors() {
        List<GetAuthorDetailsResponseDto> authorList = getAuthorService.getAll();
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<GetAuthorDetailsResponseDto> getAuthorById(@PathVariable Long id) {
        GetAuthorDetailsResponseDto author = getAuthorService.getAuthorById(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping("/author/create")
    public ResponseEntity<HttpStatus> createAuthor(@RequestBody Author author) {
        createAuthorService.createAuthor(author.getFirstName(), author.getLastName(), author.getEmail(), author.getType());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/author/{id}/update")
    public ResponseEntity<HttpStatus> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        updateAuthorService.updateAuthor(id, author.getFirstName(), author.getLastName(), author.getEmail(), author.getType());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/author/{id}/delete")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable Long id) {
        deleteAuthorService.deleteAuthorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
