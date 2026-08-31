package projeto01_ms.book_user.Adapter.InBound.Dto.Request;

import jakarta.validation.constraints.Email;

public record DtoUpdateUserResquest(
        String name,
        @Email
        String email,
        String password
) {
}
