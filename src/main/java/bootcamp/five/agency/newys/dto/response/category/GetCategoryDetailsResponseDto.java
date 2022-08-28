package bootcamp.five.agency.newys.dto.response.category;

public class GetCategoryDetailsResponseDto {

  private Long id;
  private String name;
  private String description;
  private Long authorId;

  public GetCategoryDetailsResponseDto() {
  }

  public GetCategoryDetailsResponseDto(Long id, String name, String description, Long authorId) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.authorId = authorId;
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

  public static GetCategoryDetailsResponseDtoBuilder builder() {
    return new GetCategoryDetailsResponseDtoBuilder();
  }

  public static class GetCategoryDetailsResponseDtoBuilder {

    private Long id;
    private String name;
    private String description;
    private Long authorId;

    public GetCategoryDetailsResponseDtoBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public GetCategoryDetailsResponseDtoBuilder name(String name) {
      this.name = name;
      return this;
    }

    public GetCategoryDetailsResponseDtoBuilder description(String description) {
      this.description = description;
      return this;
    }

    public GetCategoryDetailsResponseDtoBuilder authorId(Long authorId) {
      this.authorId = authorId;
      return this;
    }

    public GetCategoryDetailsResponseDto build() {
      return new GetCategoryDetailsResponseDto(id, name, description, authorId);
    }

  }
}
