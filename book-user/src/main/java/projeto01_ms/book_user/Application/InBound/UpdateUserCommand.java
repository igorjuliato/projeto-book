package projeto01_ms.book_user.Application.InBound;

import java.util.UUID;

public record UpdateUserCommand(
        UUID id,
        String name,
        String email,
        String password
) {
}
