package projeto01_ms.book_user.Adapter.InBound;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DtoRegisterUserRequest(
        @NotBlank
        String nome,
        @Email
        @NotBlank
        String Email,
        @NotBlank
        @Size(min = 8)
        String password
){

}
