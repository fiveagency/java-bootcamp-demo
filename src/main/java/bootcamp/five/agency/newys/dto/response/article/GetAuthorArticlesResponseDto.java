package bootcamp.five.agency.newys.dto.response.article;

public class GetAuthorArticlesResponseDto {

  private Long id;
  private String title;
  private String description;
  private Long authorId;
  private String authorFirstName;
  private String authorLastName;

  public GetAuthorArticlesResponseDto() {
  }

  public GetAuthorArticlesResponseDto(Long id, String title, String description, Long authorId, String authorFirstName, String authorLastName) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.authorId = authorId;
    this.authorFirstName = authorFirstName;
    this.authorLastName = authorLastName;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
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

  public static class GetAuthorArticlesResponseDtoBuilder {

    private Long id;
    private String title;
    private String description;
    private Long authorId;
    private String authorFirstName;
    private String authorLastName;

    public GetAuthorArticlesResponseDtoBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public GetAuthorArticlesResponseDtoBuilder title(String title) {
      this.title = title;
      return this;
    }

    public GetAuthorArticlesResponseDtoBuilder description(String description) {
      this.description = description;
      return this;
    }

    public GetAuthorArticlesResponseDtoBuilder authorId(Long authorId) {
      this.authorId = authorId;
      return this;
    }

    public GetAuthorArticlesResponseDtoBuilder authorFirstName(String authorFirstName) {
      this.authorFirstName = authorFirstName;
      return this;
    }

    public GetAuthorArticlesResponseDtoBuilder authorLastName(String authorLastName) {
      this.authorLastName = authorLastName;
      return this;
    }

    public GetAuthorArticlesResponseDto build() {
      return new GetAuthorArticlesResponseDto(id, title, description, authorId, authorFirstName, authorLastName);
    }
  }
}
