package projeto01_ms.book_user.Application.InBound;

import projeto01_ms.book_user.Application.OutBound.UserOutPut;

import java.util.UUID;

public interface FindUserUseCase {
    UserOutPut execute(UUID id);
}
