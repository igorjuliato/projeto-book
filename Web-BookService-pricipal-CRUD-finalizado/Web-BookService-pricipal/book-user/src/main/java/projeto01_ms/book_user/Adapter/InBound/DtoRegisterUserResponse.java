package projeto01_ms.book_user.Adapter.InBound;

import java.util.UUID;

public record DtoRegisterUserResponse(
        UUID userId,
        String email
) {
}
