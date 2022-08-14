package bootcamp.five.agency.newys.controllers;

import bootcamp.five.agency.newys.dto.response.AuthorResponseDto;
import bootcamp.five.agency.newys.services.author.GetAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private final GetAuthorService getAuthorService;

    @Autowired
    public AuthorController(GetAuthorService getAuthorService) {
        this.getAuthorService = getAuthorService;
    }

    @GetMapping("/authors")
    public List<AuthorResponseDto> getAuthors() {
        List<AuthorResponseDto> authorList = getAuthorService.getAll();
        return authorList;
    }

    @GetMapping("/author/{id}")
    public AuthorResponseDto getAuthorById(@PathVariable Long id) {
        AuthorResponseDto author = getAuthorService.getAuthorById(id);
        return author;
    }
}
