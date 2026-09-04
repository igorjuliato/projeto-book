package projeto01_ms.book_user.Adapter.OutBound;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import projeto01_ms.book_user.Application.Entity.ROLE;
import projeto01_ms.book_user.Application.OutBound.UserRepositoryPort;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

   private final UserRepositoryPort repositoryPort;

    public UserDetailsService(UserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
       return repositoryPort.findBYEmail(email)
               .map(user -> org.springframework.security.core.userdetails.User
                       .withUsername(user.getEmail())
                       .password(user.getPassword())
                       .authorities(mapAuthorities(user.getRoles()))
                       .build())
               .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado " + email));
   }

    private Collection<GrantedAuthority> mapAuthorities(Set<ROLE> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(Collectors.toList());
    }
}

