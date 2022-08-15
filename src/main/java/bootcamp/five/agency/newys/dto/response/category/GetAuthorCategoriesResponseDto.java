package bootcamp.five.agency.newys.dto.response.category;

public class GetAuthorCategoriesResponseDto {

  private Long id;
  private String name;
  private String description;
  private Long authorId;
  private String authorFirstName;
  private String authorLastName;

  public GetAuthorCategoriesResponseDto() {
  }

  public GetAuthorCategoriesResponseDto(Long id, String name, String description, Long authorId, String authorFirstName, String authorLastName) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.authorId = authorId;
    this.authorFirstName = authorFirstName;
    this.authorLastName = authorLastName;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public String getAuthorFirstName() {
    return authorFirstName;
  }

  public String getAuthorLastName() {
    return authorLastName;
  }

  public static class GetAuthorCategoriesResponseDtoBuilder {

    private Long id;
    private String name;
    private String description;
    private Long authorId;
    private String authorFirstName;
    private String authorLastName;

    public GetAuthorCategoriesResponseDtoBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public GetAuthorCategoriesResponseDtoBuilder name(String name) {
      this.name = name;
      return this;
    }

    public GetAuthorCategoriesResponseDtoBuilder description(String description) {
      this.description = description;
      return this;
    }

    public GetAuthorCategoriesResponseDtoBuilder authorId(Long authorId) {
      this.authorId = authorId;
      return this;
    }

    public GetAuthorCategoriesResponseDtoBuilder authorFirstName(String authorFirstName) {
      this.authorFirstName = authorFirstName;
      return this;
    }

    public GetAuthorCategoriesResponseDtoBuilder authorLastName(String authorLastName) {
      this.authorLastName = authorLastName;
      return this;
    }

    public GetAuthorCategoriesResponseDto build() {
      return new GetAuthorCategoriesResponseDto(id, name, description, authorId, authorFirstName, authorLastName);
    }

  }
}
