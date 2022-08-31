package bootcamp.five.agency.newys.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

  // Step 3: we want more users!
  /*@Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user1 = User.withDefaultPasswordEncoder()
        .username("user1")
        .password("password1")
        .authorities("USER") // have to pass this also, otherwise exception happens
        .build();

    UserDetails user2 = User.withDefaultPasswordEncoder()
        .username("user2")
        .password("password2")
        .authorities("USER")
        .build();

    return new InMemoryUserDetailsManager(user1, user2);
  }*/

  /*@Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authz) -> authz
            // Step 5: permit some page without authentication
            .antMatchers("/h2-console/**").permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic(withDefaults())
        .headers().frameOptions().disable().and()
        .csrf().disable();
    return http.build();
  }*/

  // Step 6: can't do anything without this
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authz) -> authz
            .antMatchers("/h2-console/**").permitAll()
            // Step 7: what if we want to restrict by authority?
            .antMatchers("/authors/**").hasAuthority("ADMIN")
            .anyRequest().authenticated()
        )
        .httpBasic(withDefaults())
        .headers().frameOptions().disable().and()
        .csrf().disable();
    return http.build();
  }



}
