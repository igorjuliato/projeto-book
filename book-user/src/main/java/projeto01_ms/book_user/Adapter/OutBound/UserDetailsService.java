package projeto01_ms.book_user.Adapter.OutBound;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projeto01_ms.book_user.Application.OutBound.UserRepositoryPort;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepositoryPort repositoryPort;

    public UserDetailsService(UserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repositoryPort.findBYEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado: " + email));
    }


}
