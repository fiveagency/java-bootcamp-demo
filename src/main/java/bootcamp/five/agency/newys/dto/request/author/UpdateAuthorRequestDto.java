package bootcamp.five.agency.newys.dto.request.author;

public class UpdateAuthorRequestDto {

  private String firstName;
  private String lastName;
  private String email;
  private String type;

  public UpdateAuthorRequestDto() {
  }

  private UpdateAuthorRequestDto(String firstName, String lastName, String email, String type) {
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

  public static class UpdateAuthorRequestDtoBuilder {

    private String firstName;
    private String lastName;
    private String email;
    private String type;

    public UpdateAuthorRequestDtoBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public UpdateAuthorRequestDtoBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public UpdateAuthorRequestDtoBuilder email(String email) {
      this.email = email;
      return this;
    }

    public UpdateAuthorRequestDtoBuilder type(String type) {
      this.type = type;
      return this;
    }

    public UpdateAuthorRequestDto build() {
      return new UpdateAuthorRequestDto(firstName, lastName, email, type);
    }
  }
}
