package projeto01_ms.book_user.Domain;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(UUID id) {
        super("Usuario não encontrado: " + id);
    }
}
