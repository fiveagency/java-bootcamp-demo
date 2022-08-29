package bootcamp.five.agency.newys.repository;

import bootcamp.five.agency.newys.domain.AppUser;
import bootcamp.five.agency.newys.domain.AppUserRole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<AppUserRole, Long> {

  List<AppUserRole> findByUserId(AppUser userId);
}
