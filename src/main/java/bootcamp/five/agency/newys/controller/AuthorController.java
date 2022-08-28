package bootcamp.five.agency.newys.controller;

import bootcamp.five.agency.newys.dto.request.author.CreateAuthorRequestDto;
import bootcamp.five.agency.newys.dto.request.author.UpdateAuthorRequestDto;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.DeleteAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import bootcamp.five.agency.newys.services.author.UpdateAuthorService;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//@Controller is used to mark classes as Spring MVC Controller and therefore ViewResolver should be set up
//@RestController is a convenience annotation that does nothing more than adding the @Controller and @ResponseBody annotations
//        So the following two controller definitions should do the same:
//
//@Controller
//@ResponseBody
//public class AuthorController { }
//
//@RestController
//public class AuthorController { }

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

    @RequestMapping (value = "/authors", method = RequestMethod.GET)
    public ResponseEntity<List<AuthorDetailsResponseDto>> getAuthors() {
        return ResponseEntity.ok(getAuthorService.getAll());
    }

    @Operation(summary = "Get an author by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the author",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthorDetailsResponseDto.class)) }) })
    @GetMapping  (value = "/author/{id}")
    public ResponseEntity<AuthorDetailsResponseDto> getAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(getAuthorService.getAuthorById(id));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid request body",
                    content = { @Content(mediaType = "application/json") }) })
    @PostMapping("/author/create")
    public ResponseEntity<AuthorDetailsResponseDto> createAuthor(@Valid @RequestBody CreateAuthorRequestDto author) {
        AuthorDetailsResponseDto createdAuthor = createAuthorService.createAuthor(author.getFirstName(), author.getLastName(), author.getEmail(), author.getType());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

    @PutMapping(value = "/author/{id}/update")
    public ResponseEntity<AuthorDetailsResponseDto> updateAuthor(@PathVariable Long id, @RequestBody UpdateAuthorRequestDto author) {
        AuthorDetailsResponseDto updatedAuthor = updateAuthorService.updateAuthor(id, author.getFirstName(), author.getLastName(), author.getEmail(), author.getType());
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping (value = "/author/{id}/delete")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        deleteAuthorService.deleteAuthorById(id);
        return ResponseEntity.noContent().build();
    }
}
