package projeto01_ms.book_user.Application.InBound;

import java.util.UUID;

public interface DeleteUserUseCase {
    void execute(UUID id);
}
