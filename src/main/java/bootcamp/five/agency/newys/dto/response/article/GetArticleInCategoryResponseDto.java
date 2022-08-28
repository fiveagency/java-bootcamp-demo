package bootcamp.five.agency.newys.dto.response.article;

public class GetArticleInCategoryResponseDto {

  private Long id;
  private String title;
  private String description;
  private Long categoryId;
  private String categoryName;

  public GetArticleInCategoryResponseDto() {
  }

  public GetArticleInCategoryResponseDto(Long id, String title, String description, Long categoryId, String categoryName) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.categoryId = categoryId;
    this.categoryName = categoryName;
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

  public Long getCategoryId() {
    return categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public static GetArticleInCategoryResponseDtoBuilder builder() {
    return new GetArticleInCategoryResponseDtoBuilder();
  }

  public static class GetArticleInCategoryResponseDtoBuilder {

    private Long id;
    private String title;
    private String description;
    private Long categoryId;
    private String categoryName;

    public GetArticleInCategoryResponseDtoBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public GetArticleInCategoryResponseDtoBuilder title(String title) {
      this.title = title;
      return this;
    }

    public GetArticleInCategoryResponseDtoBuilder description(String description) {
      this.description = description;
      return this;
    }

    public GetArticleInCategoryResponseDtoBuilder categoryId(Long categoryId) {
      this.categoryId = categoryId;
      return this;
    }

    public GetArticleInCategoryResponseDtoBuilder categoryName(String categoryName) {
      this.categoryName = categoryName;
      return this;
    }

    public GetArticleInCategoryResponseDto build() {
      return new GetArticleInCategoryResponseDto(id, title, description, categoryId, categoryName);
    }
  }
}
