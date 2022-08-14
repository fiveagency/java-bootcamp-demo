package bootcamp.five.agency.newys.dto.response;

import java.util.List;

public class CategoryResponseDto {

  private Long id;
  private String name;
  private String description;
  private Long authorId;
  private List<ArticleResponseDto> addedArticles;

  public CategoryResponseDto() {
  }

  public CategoryResponseDto(Long id, String name, String description, Long authorId, List<ArticleResponseDto> addedArticles) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.authorId = authorId;
    this.addedArticles = addedArticles;
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

  public List<ArticleResponseDto> getAddedArticles() {
    return addedArticles;
  }

  public static class CategoryResponseDtoBuilder {

    private Long id;
    private String name;
    private String description;
    private Long authorId;
    private List<ArticleResponseDto> addedArticles;

    public CategoryResponseDtoBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public CategoryResponseDtoBuilder name(String name) {
      this.name = name;
      return this;
    }

    public CategoryResponseDtoBuilder description(String description) {
      this.description = description;
      return this;
    }

    public CategoryResponseDtoBuilder authorId(Long authorId) {
      this.authorId = authorId;
      return this;
    }

    public CategoryResponseDtoBuilder addedArticles(List<ArticleResponseDto> addedArticles) {
      this.addedArticles = addedArticles;
      return this;
    }

    public CategoryResponseDto build() {
      return new CategoryResponseDto(id, name, description, authorId, addedArticles);
    }

  }
}
