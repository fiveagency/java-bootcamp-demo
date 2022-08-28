package bootcamp.five.agency.newys.dto.response.author;

public class AuthorDetailsResponseDto {

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String type;

  public AuthorDetailsResponseDto() {
  }

  public AuthorDetailsResponseDto(Long id, String firstName, String lastName, String email, String type) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.type = type;
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

  public static GetAuthorDetailsResponseDtoBuilder builder() {
    return new GetAuthorDetailsResponseDtoBuilder();
  }

  public static class GetAuthorDetailsResponseDtoBuilder {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String type;

    public GetAuthorDetailsResponseDtoBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public GetAuthorDetailsResponseDtoBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public GetAuthorDetailsResponseDtoBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public GetAuthorDetailsResponseDtoBuilder email(String email) {
      this.email = email;
      return this;
    }

    public GetAuthorDetailsResponseDtoBuilder type(String type) {
      this.type = type;
      return this;
    }

    public AuthorDetailsResponseDto build() {
      return new AuthorDetailsResponseDto(id, firstName, lastName, email, type);
    }
  }
}
