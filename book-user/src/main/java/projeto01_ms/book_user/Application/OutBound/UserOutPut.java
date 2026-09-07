package projeto01_ms.book_user.Application.OutBound;

import projeto01_ms.book_user.Application.Entity.ROLE;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record UserOutPut(
        UUID userId,
        String name,
        String email,
        Set<ROLE> roles,
        Instant createdAt,
        Instant updatedAt
) {
}
