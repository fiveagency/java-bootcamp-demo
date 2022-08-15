package bootcamp.five.agency.newys.dto.response.article;

import java.util.Date;

public class GetArticleDetailsResponseDto {

  private Long id;
  private String title;
  private String description;
  private String imageUrl;
  private Date dateOfPublication;
  private String content;
  private int numLikes;
  private Long authorId;

  public GetArticleDetailsResponseDto() {
  }

  public GetArticleDetailsResponseDto(Long id, String title, String description, String imageUrl, Date dateOfPublication, String content, int numLikes,
      Long authorId) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.imageUrl = imageUrl;
    this.dateOfPublication = dateOfPublication;
    this.content = content;
    this.numLikes = numLikes;
    this.authorId = authorId;
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

  public String getImageUrl() {
    return imageUrl;
  }

  public Date getDateOfPublication() {
    return dateOfPublication;
  }

  public String getContent() {
    return content;
  }

  public int getNumLikes() {
    return numLikes;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public static class GetArticleDetailsResponseDtoBuilder {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private Date dateOfPublication;
    private String content;
    private int numLikes;
    private Long authorId;

    public GetArticleDetailsResponseDtoBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public GetArticleDetailsResponseDtoBuilder title(String title) {
      this.title = title;
      return this;
    }

    public GetArticleDetailsResponseDtoBuilder description(String description) {
      this.description = description;
      return this;
    }

    public GetArticleDetailsResponseDtoBuilder imageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
      return this;
    }

    public GetArticleDetailsResponseDtoBuilder dateOfPublication(Date dateOfPublication) {
      this.dateOfPublication = dateOfPublication;
      return this;
    }

    public GetArticleDetailsResponseDtoBuilder content(String content) {
      this.content = content;
      return this;
    }

    public GetArticleDetailsResponseDtoBuilder numLikes(int numLikes) {
      this.numLikes = numLikes;
      return this;
    }

    public GetArticleDetailsResponseDtoBuilder authorId(Long authorId) {
      this.authorId = authorId;
      return this;
    }

    public GetArticleDetailsResponseDto build() {
      return new GetArticleDetailsResponseDto(id, title, description, imageUrl, dateOfPublication, content, numLikes, authorId);
    }

  }
}
