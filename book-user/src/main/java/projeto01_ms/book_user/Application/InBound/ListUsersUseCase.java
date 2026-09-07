package projeto01_ms.book_user.Application.InBound;

import projeto01_ms.book_user.Application.OutBound.UserOutPut;

import java.util.List;

public interface ListUsersUseCase {
    List<UserOutPut> execute();
}
