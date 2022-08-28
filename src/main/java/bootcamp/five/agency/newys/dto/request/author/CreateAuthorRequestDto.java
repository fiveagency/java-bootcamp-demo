package bootcamp.five.agency.newys.dto.request.author;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateAuthorRequestDto {

  @NotBlank(message = "First name can't be blank")
  @Size(min = 0, max = 20, message = "First name can't be longer than 20 characters")
  private String firstName;
  @NotBlank(message = "Last name name can't be blank")
  private String lastName;
  private String email;
  private String type;

  public CreateAuthorRequestDto() {
  }

  private CreateAuthorRequestDto(String firstName, String lastName, String email, String type) {
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
