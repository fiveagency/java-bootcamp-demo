package bootcamp.five.agency.newys.repository;

import bootcamp.five.agency.newys.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {

  AppUser findByUsername(String username);
}
