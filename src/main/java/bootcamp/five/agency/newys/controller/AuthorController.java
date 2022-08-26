package bootcamp.five.agency.newys.controller;

import bootcamp.five.agency.newys.dto.request.author.CreateAuthorRequestDto;
import bootcamp.five.agency.newys.dto.request.author.UpdateAuthorRequestDto;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.DeleteAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import bootcamp.five.agency.newys.services.author.UpdateAuthorService;
import java.util.List;
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

//    DTO stands for Data Transfer Object, which is a design pattern.
//    It is one of the EPA patterns which we call when we need to use such objects that encapsulate and aggregate data for transfer.
//    A DTO is similar to a data structure, but like a data structure, it doesn't contain any business logic.
//    It contains mechanisms of serialization and de-serialization.
//    In DTO, we can store data from a single source or from multiple resources.
//    We can either store complete data or can store a small amount of data from a source.
    @RequestMapping (value = "/authors", method = RequestMethod.GET) //same as @GetMapping
    public ResponseEntity<List<AuthorDetailsResponseDto>> getAuthors() {  //DTO: https://www.baeldung.com/java-dto-pattern
        return ResponseEntity.ok(getAuthorService.getAll());
    }

//    ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response.
//    If we want to use it, we have to return it from the endpoint; Spring takes care of the rest.
//    ResponseEntity is a generic type. Consequently, we can use any type as the response body:
    @GetMapping  (value = "/author/{id}")
    public ResponseEntity<AuthorDetailsResponseDto> getAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(getAuthorService.getAuthorById(id));
    }

    @PostMapping(value = "/author/create")
    public ResponseEntity<AuthorDetailsResponseDto> createAuthor(@RequestBody CreateAuthorRequestDto author) {
        AuthorDetailsResponseDto createdAuthor = createAuthorService.createAuthor(author.getFirstName(), author.getLastName(), author.getEmail(), author.getType());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

//    A request method is considered "idempotent" if the intended effect on the server of multiple identical requests with that method is the same as the effect for a single such request.
//
//    the idempotent property only applies to what has been requested by the user;
//      a server is free to log each request separately, retain a revision control history, or implement other non-idempotent side effects for each idempotent request.
//
//    Idempotent methods are distinguished because the request can be repeated automatically if a communication failure occurs before the client is able to read the server's response.
//    For example, if a client sends a PUT request and the underlying connection is closed before any response is received, then the client can establish a new connection and retry the idempotent request.
//    It knows that repeating the request will have the same intended effect, even if the original request succeeded, though the response might differ.
    @PutMapping(value = "/author/{id}/update")
    public ResponseEntity<AuthorDetailsResponseDto> updateAuthor(@PathVariable Long id, @RequestBody UpdateAuthorRequestDto author) {
        AuthorDetailsResponseDto updatedAuthor = updateAuthorService.updateAuthor(id, author.getFirstName(), author.getLastName(), author.getEmail(), author.getType());
        return ResponseEntity.ok(updatedAuthor);
    }

//    For each HTTP verb, there are expected status codes a server should return upon success:
//
//    GET — return 200 (OK)
//    POST — return 201 (CREATED)
//    PUT — return 200 (OK)
//    DELETE — return 204 (NO CONTENT) If the operation fails, return the most specific status code possible corresponding to the problem that was encountered.
    @DeleteMapping (value = "/author/{id}/delete")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        deleteAuthorService.deleteAuthorById(id);
        return ResponseEntity.noContent().build();
    }
}
