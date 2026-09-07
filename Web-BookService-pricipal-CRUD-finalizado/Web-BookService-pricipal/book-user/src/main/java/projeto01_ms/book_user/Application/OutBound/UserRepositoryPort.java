package projeto01_ms.book_user.Application.OutBound;

import projeto01_ms.book_user.Application.Entity.User;

import java.util.Optional;

public interface UserRepositoryPort {

    Optional<User> findBYEmail(String email);

    Boolean existsByEmail(String email);

    User save(User user);
}
