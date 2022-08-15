package bootcamp.five.agency.newys.dto.response.article;

public class GetPopularArticlesResponseDto {

  private Long id;
  private String title;
  private String description;
  private int numLikes;

  public GetPopularArticlesResponseDto() {
  }

  public GetPopularArticlesResponseDto(Long id, String title, String description, int numLikes) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.numLikes = numLikes;
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

  public int getNumLikes() {
    return numLikes;
  }

  public static class GetPopularArticlesResponseDtoBuilder {

    private Long id;
    private String title;
    private String description;
    private int numLikes;

    public GetPopularArticlesResponseDtoBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public GetPopularArticlesResponseDtoBuilder title(String title) {
      this.title = title;
      return this;
    }

    public GetPopularArticlesResponseDtoBuilder description(String description) {
      this.description = description;
      return this;
    }

    public GetPopularArticlesResponseDtoBuilder numLikes(int numLikes) {
      this.numLikes = numLikes;
      return this;
    }

    public GetPopularArticlesResponseDto build() {
      return new GetPopularArticlesResponseDto(id, title, description, numLikes);
    }
  }
}
