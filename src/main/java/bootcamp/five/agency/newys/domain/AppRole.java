package bootcamp.five.agency.newys.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppRole {

  @Id
  private String role;

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppRole appRole = (AppRole) o;
    return role.equals(appRole.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(role);
  }
}
