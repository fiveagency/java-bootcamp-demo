package bootcamp.five.agency.newys.dto.response;

import java.util.Date;
import java.util.List;

public class ArticleResponseDto {

  private Long id;
  private String title;
  private String description;
  private String imageUrl;
  private Date dateOfPublication;
  private String content;
  private int numLikes;
  private Long authorId;
  private List<CategoryResponseDto> categories;

  public ArticleResponseDto() {
  }

  public ArticleResponseDto(Long id, String title, String description, String imageUrl, Date dateOfPublication, String content, int numLikes,
      Long authorId, List<CategoryResponseDto> categories) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.imageUrl = imageUrl;
    this.dateOfPublication = dateOfPublication;
    this.content = content;
    this.numLikes = numLikes;
    this.authorId = authorId;
    this.categories = categories;
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

  public List<CategoryResponseDto> getCategories() {
    return categories;
  }

  public static class ArticleResponseDtoBuilder {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private Date dateOfPublication;
    private String content;
    private int numLikes;
    private Long authorId;
    private List<CategoryResponseDto> categories;

    public ArticleResponseDtoBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public ArticleResponseDtoBuilder title(String title) {
      this.title = title;
      return this;
    }

    public ArticleResponseDtoBuilder description(String description) {
      this.description = description;
      return this;
    }

    public ArticleResponseDtoBuilder imageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
      return this;
    }

    public ArticleResponseDtoBuilder dateOfPublication(Date dateOfPublication) {
      this.dateOfPublication = dateOfPublication;
      return this;
    }

    public ArticleResponseDtoBuilder content(String content) {
      this.content = content;
      return this;
    }

    public ArticleResponseDtoBuilder numLikes(int numLikes) {
      this.numLikes = numLikes;
      return this;
    }

    public ArticleResponseDtoBuilder authorId(Long authorId) {
      this.authorId = authorId;
      return this;
    }

    public ArticleResponseDtoBuilder categories(List<CategoryResponseDto> categories) {
      this.categories = categories;
      return this;
    }

    public ArticleResponseDto build() {
      return new ArticleResponseDto(id, title, description, imageUrl, dateOfPublication, content, numLikes, authorId, categories);
    }

  }
}
