package bootcamp.five.agency.newys.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppUser {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) // don't use this :D
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  private String password;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppUser appUser = (AppUser) o;
    return id.equals(appUser.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
