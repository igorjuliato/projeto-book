package projeto01_ms.book_user.Adapter.OutBound;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto01_ms.book_user.Application.Entity.User;

import java.util.Optional;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
