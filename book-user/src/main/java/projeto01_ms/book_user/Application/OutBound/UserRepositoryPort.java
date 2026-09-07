package projeto01_ms.book_user.Application.OutBound;

import projeto01_ms.book_user.Application.Entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {

    Optional<User> findBYEmail(String email);

    Boolean existsByEmail(String email);

    Optional<User> findById(UUID id);

    List<User> findAll();

    boolean existsById(UUID id);

    void deleteById(UUID id);

    User save(User user);
}
