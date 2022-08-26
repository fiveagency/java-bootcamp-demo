package bootcamp.five.agency.newys.dto.request.author;

public class CreateAuthorRequestDto {

  private String firstName;
  private String lastName;
  private String email;
  private String type;

  public CreateAuthorRequestDto() {
  }

  public CreateAuthorRequestDto(String firstName, String lastName, String email, String type) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.type = type;
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

  public static class CreateAuthorRequestDtoBuilder {

    private String firstName;
    private String lastName;
    private String email;
    private String type;

    public CreateAuthorRequestDtoBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public CreateAuthorRequestDtoBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public CreateAuthorRequestDtoBuilder email(String email) {
      this.email = email;
      return this;
    }

    public CreateAuthorRequestDtoBuilder type(String type) {
      this.type = type;
      return this;
    }

    public CreateAuthorRequestDto build() {
      return new CreateAuthorRequestDto(firstName, lastName, email, type);
    }
  }
}
