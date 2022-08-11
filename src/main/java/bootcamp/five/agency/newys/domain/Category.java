package bootcamp.five.agency.newys.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "author_id", referencedColumnName = "id")
  private Author author;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "added_articles",
      joinColumns = @JoinColumn(name = "category_id"),
      inverseJoinColumns = @JoinColumn(name = "article_id")
  )
  private List<Article> addedArticles;

  public Category() {
  }

  public Category(Long id, String name, String description, Author author, List<Article> addedArticles) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.author = author;
    this.addedArticles = addedArticles;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public List<Article> getAddedArticles() {
    return addedArticles;
  }

  public void setAddedArticles(List<Article> addedArticles) {
    this.addedArticles = addedArticles;
  }

  public static class CategoryBuilder {

    private Long id;
    private String name;
    private String description;
    private Author author;
    private List<Article> addedArticles;

    public CategoryBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public CategoryBuilder name(String name) {
      this.name = name;
      return this;
    }

    public CategoryBuilder description(String description) {
      this.description = description;
      return this;
    }

    public CategoryBuilder author(Author author) {
      this.author = author;
      return this;
    }

    public CategoryBuilder addedArticles(List<Article> addedArticles) {
      this.addedArticles = addedArticles;
      return this;
    }

    public Category build() {
      return new Category(id, name, description, author, addedArticles);
    }

  }
}
