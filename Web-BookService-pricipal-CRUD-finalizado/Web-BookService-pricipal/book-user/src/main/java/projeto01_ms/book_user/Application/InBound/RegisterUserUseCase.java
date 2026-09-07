package projeto01_ms.book_user.Application.InBound;

import projeto01_ms.book_user.Application.OutBound.RegisterUserOutPut;

public interface RegisterUserUseCase {
    RegisterUserOutPut execute(RegisterUserCommand command);
}
