package bootcamp.five.agency.newys.security;

import bootcamp.five.agency.newys.domain.AppUser;
import bootcamp.five.agency.newys.repository.UserRepository;
import bootcamp.five.agency.newys.repository.UserRoleRepository;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Step 4: finally something that makes sense
@Service
public class MyUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;
  private final UserRoleRepository userRoleRepository;

  public MyUserDetailsService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
    this.userRepository = userRepository;
    this.userRoleRepository = userRoleRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser appUser = userRepository.findByUsername(username);
    if (appUser == null) {
      throw new UsernameNotFoundException(username);
    }

    return new UserPrincipal(appUser, authorities(appUser));
  }

  private Collection<? extends GrantedAuthority> authorities(AppUser user) {
    return userRoleRepository.findByUserId(user).stream()
        .map(appUserRole -> new SimpleGrantedAuthority(appUserRole.getRole().getRole()))
        .collect(Collectors.toList());
  }
}
