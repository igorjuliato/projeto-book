package projeto01_ms.book_user.Adapter.OutBound;

import org.springframework.stereotype.Component;
import projeto01_ms.book_user.Application.Entity.User;
import projeto01_ms.book_user.Application.OutBound.UserRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public Boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
