package projeto01_ms.book_user.Adapter.OutBound;

import java.time.Instant;

public record ErrorResponse(
        Instant timestamp,
        int status,
        String message
) {
}
