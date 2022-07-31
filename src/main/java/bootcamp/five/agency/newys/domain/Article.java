package bootcamp.five.agency.newys.domain;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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

  @ManyToMany(mappedBy = "addedArticles")
  private List<Category> categories;

  public Article() {
  }

  public Article(Long id, String title, String description, String imageUrl, Date dateOfPublication, String content, int numLikes, Author author) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.imageUrl = imageUrl;
    this.dateOfPublication = dateOfPublication;
    this.content = content;
    this.numLikes = numLikes;
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Date getDateOfPublication() {
    return dateOfPublication;
  }

  public void setDateOfPublication(Date dateOfPublication) {
    this.dateOfPublication = dateOfPublication;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }
}
