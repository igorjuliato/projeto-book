package projeto01_ms.book_user.Adapter.OutBound;

import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.stereotype.Component;
import projeto01_ms.book_user.Application.Entity.User;
import projeto01_ms.book_user.Application.InBound.UserRepositoryPort;

import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository repository;

    public UserRepositoryAdapter(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findBYEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Boolean existByEmail(String email){
        return repository.existByEmail(email);
    }

    @Override
    public User save(User user){
        return repository.save(user);
    }
}
