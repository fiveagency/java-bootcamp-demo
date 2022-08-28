package bootcamp.five.agency.newys.dto.response.article;

import java.util.Date;

public class GetLatestArticlesResponseDto {

  private Long id;
  private String title;
  private String description;
  private Date dateOfPublication;

  public GetLatestArticlesResponseDto() {
  }

  public GetLatestArticlesResponseDto(Long id, String title, String description, Date dateOfPublication) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.dateOfPublication = dateOfPublication;
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

  public Date getDateOfPublication() {
    return dateOfPublication;
  }

  public static GetLatestArticlesResponseDtoBuilder builder() {
    return new GetLatestArticlesResponseDtoBuilder();
  }

  public static class GetLatestArticlesResponseDtoBuilder {

    private Long id;
    private String title;
    private String description;
    private Date dateOfPublication;

    public GetLatestArticlesResponseDtoBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public GetLatestArticlesResponseDtoBuilder title(String title) {
      this.title = title;
      return this;
    }

    public GetLatestArticlesResponseDtoBuilder description(String description) {
      this.description = description;
      return this;
    }

    public GetLatestArticlesResponseDtoBuilder dateOfPublication(Date dateOfPublication) {
      this.dateOfPublication = dateOfPublication;
      return this;
    }

    public GetLatestArticlesResponseDto build() {
      return new GetLatestArticlesResponseDto(id, title, description, dateOfPublication);
    }
  }
}
