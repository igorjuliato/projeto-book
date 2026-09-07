package projeto01_ms.book_user.Adapter.InBound;

import projeto01_ms.book_user.Application.Entity.ROLE;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record DtoUserResponse(
        UUID userId,
        String name,
        String email,
        Set<ROLE> roles,
        Instant createdAt,
        Instant updatedAt
) {
}
