package projeto01_ms.book_user.Application.InBound;

public record RegisterUserCommand(
        String name,
        String email,
        String password
) {
}
