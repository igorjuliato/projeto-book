package projeto01_ms.book_user.Config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception{
      http
              .csrf(csrf -> csrf.disable())

              .authorizeHttpRequests(a ->
                      a.requestMatchers("/user/register/**").permitAll()
                              .anyRequest().authenticated())

              .authorizeHttpRequests(a ->
                      a.requestMatchers("/user/fragile/**").
                              hasRole("ADMIN"))

              .sessionManagement(s ->
                      s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

      return http.build();
    }



}
