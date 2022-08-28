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

}
