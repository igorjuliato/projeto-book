package projeto01_ms.book_user.Application.OutBound;

import java.util.UUID;

public record RegisterUserOutPut(
        UUID userId,
        String email
) {
}
