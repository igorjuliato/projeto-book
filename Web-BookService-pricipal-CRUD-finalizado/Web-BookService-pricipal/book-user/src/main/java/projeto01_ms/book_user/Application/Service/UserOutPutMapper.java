package projeto01_ms.book_user.Application.Service;

import projeto01_ms.book_user.Application.Entity.User;
import projeto01_ms.book_user.Application.OutBound.UserOutPut;

public final class UserOutPutMapper {

    private UserOutPutMapper() {
    }

    public static UserOutPut toOutput(User user) {
        return new UserOutPut(
                user.getID(),
                user.getName(),
                user.getEmail(),
                user.getRoles(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
