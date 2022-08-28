package bootcamp.five.agency.newys.domain;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "article")
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "date_of_publication")
  private Date dateOfPublication;

  @Column(name = "content")
  private String content;

  @Column(name = "num_likes")
  private int numLikes;

  @ManyToOne
  @JoinColumn(name = "author_id", referencedColumnName = "id")
  private Author author;

  @ManyToMany(mappedBy = "addedArticles", fetch = FetchType.EAGER)
  private List<Category> categories;

  public Article() {
  }

  public Article(Long id, String title, String description, String imageUrl, Date dateOfPublication, String content, int numLikes, Author author,
      List<Category> categories) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.imageUrl = imageUrl;
    this.dateOfPublication = dateOfPublication;
    this.content = content;
    this.numLikes = numLikes;
    this.author = author;
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

  public void setNumLikes(int numLikes) {
    this.numLikes = numLikes;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public static ArticleBuilder builder() {
    return new ArticleBuilder();
  }

  public static class ArticleBuilder {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private Date dateOfPublication;
    private String content;
    private int numLikes;
    private Author author;
    private List<Category> categories;

    public ArticleBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public ArticleBuilder title(String title) {
      this.title = title;
      return this;
    }

    public ArticleBuilder description(String description) {
      this.description = description;
      return this;
    }

    public ArticleBuilder imageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
      return this;
    }

    public ArticleBuilder dateOfPublication(Date dateOfPublication) {
      this.dateOfPublication = dateOfPublication;
      return this;
    }

    public ArticleBuilder content(String content) {
      this.content = content;
      return this;
    }

    public ArticleBuilder numLikes(int numLikes) {
      this.numLikes = numLikes;
      return this;
    }

    public ArticleBuilder author(Author author) {
      this.author = author;
      return this;
    }

    public ArticleBuilder categories(List<Category> categories) {
      this.categories = categories;
      return this;
    }

    public Article build() {
      return new Article(id, title, description, imageUrl, dateOfPublication, content, numLikes, author, categories);
    }

  }
}
