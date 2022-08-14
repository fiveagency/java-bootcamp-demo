package bootcamp.five.agency.newys.dto.response;

import java.util.List;

public class AuthorResponseDto {

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String type;
  private List<ArticleResponseDto> articles;
  private List<CategoryResponseDto> categories;

  public AuthorResponseDto() {
  }

  public AuthorResponseDto(Long id, String firstName, String lastName, String email, String type, List<ArticleResponseDto> articles,
      List<CategoryResponseDto> categories) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.type = type;
    this.articles = articles;
    this.categories = categories;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getType() {
    return type;
  }

  public List<ArticleResponseDto> getArticles() {
    return articles;
  }

  public List<CategoryResponseDto> getCategories() {
    return categories;
  }

  public static class AuthorResponseDtoBuilder {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String type;
    private List<ArticleResponseDto> articles;
    private List<CategoryResponseDto> categories;

    public AuthorResponseDtoBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public AuthorResponseDtoBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public AuthorResponseDtoBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public AuthorResponseDtoBuilder email(String email) {
      this.email = email;
      return this;
    }

    public AuthorResponseDtoBuilder type(String type) {
      this.type = type;
      return this;
    }

    public AuthorResponseDtoBuilder articles(List<ArticleResponseDto> articles) {
      this.articles = articles;
      return this;
    }

    public AuthorResponseDtoBuilder categories(List<CategoryResponseDto> categories) {
      this.categories = categories;
      return this;
    }

    public AuthorResponseDto build() {
      return new AuthorResponseDto(id, firstName, lastName, email, type, articles, categories);
    }
  }
}
