package projeto01_ms.book_user.Application.InBound;

import projeto01_ms.book_user.Application.Entity.User;

import java.util.Optional;

public interface UserRepositoryPort {

    Optional<User> findBYEmail(String email);

    Boolean existByEmail(String email);

    User save(User user);
}
