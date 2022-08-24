package bootcamp.five.agency.newys;

import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.services.author.CreateAuthorService;
import bootcamp.five.agency.newys.services.author.DeleteAuthorService;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import bootcamp.five.agency.newys.services.author.UpdateAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping (value = "/authors", method =RequestMethod.GET) //same as @GetMapping
    public List<AuthorDetailsResponseDto> getAuthors() {  //DTO: https://www.baeldung.com/java-dto-pattern
        return getAuthorService.getAll();
    }

//    ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response.
//    If we want to use it, we have to return it from the endpoint; Spring takes care of the rest.
//    ResponseEntity is a generic type. Consequently, we can use any type as the response body:
    @GetMapping  (value = "/author/{id}")
    public ResponseEntity<AuthorDetailsResponseDto> getAuthor(@PathVariable Long id) {
        return new ResponseEntity<>(getAuthorService.getAuthorById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/author/create")
    public ResponseEntity<HttpStatus> createAuthor(@RequestBody Author author) {
        createAuthorService.createAuthor(author.getFirstName(), author.getLastName(), author.getEmail(), author.getType());
        return new ResponseEntity<>(HttpStatus.CREATED);
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
    public ResponseEntity<HttpStatus> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        updateAuthorService.updateAuthor(id, author.getFirstName(), author.getLastName(), author.getEmail(), author.getType());
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    For each HTTP verb, there are expected status codes a server should return upon success:
//
//    GET — return 200 (OK)
//    POST — return 201 (CREATED)
//    PUT — return 200 (OK)
//    DELETE — return 204 (NO CONTENT) If the operation fails, return the most specific status code possible corresponding to the problem that was encountered.
    @DeleteMapping (value = "/author/{id}/delete")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable Long id) {
        deleteAuthorService.deleteAuthorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
