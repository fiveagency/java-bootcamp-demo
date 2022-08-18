package bootcamp.five.agency.newys.domain;

import java.util.List;
import javax.persistence.*;

@Entity(name = "author")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "type")
  private String type;

  @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true )
  private List<Article> articles;

  @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE, orphanRemoval = true )
  private List<Category> categories;

  public Author() {
  }

  private Author(Long id, String firstName, String lastName, String email, String type, List<Article> articles, List<Category> categories) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.type = type;
    this.articles = articles;
    this.categories = categories;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getType() {
    return type;
  }

  public List<Article> getArticles() {
    return articles;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public static class AuthorBuilder {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String type;
    private List<Article> articles;
    private List<Category> categories;

    public AuthorBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public AuthorBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public AuthorBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public AuthorBuilder email(String email) {
      this.email = email;
      return this;
    }

    public AuthorBuilder type(String type) {
      this.type = type;
      return this;
    }

    public AuthorBuilder articles(List<Article> articles) {
      this.articles = articles;
      return this;
    }

    public AuthorBuilder categories(List<Category> categories) {
      this.categories = categories;
      return this;
    }

    public Author build() {
      return new Author(id, firstName, lastName, email, type, articles, categories);
    }
  }

}
