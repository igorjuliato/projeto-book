package projeto01_ms.book_user.Application.InBound;

import projeto01_ms.book_user.Application.OutBound.UserOutPut;

public interface UpdateUserUseCase {
    UserOutPut execute(UpdateUserCommand command);
}
