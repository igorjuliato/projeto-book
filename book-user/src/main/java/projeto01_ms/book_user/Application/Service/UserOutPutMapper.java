package projeto01_ms.book_user.Application.Service;

import projeto01_ms.book_user.Application.Entity.User;
import projeto01_ms.book_user.Application.OutBound.UserOutPut;

import java.util.EnumSet;

public final class UserOutPutMapper {

    private UserOutPutMapper() {
    }

    public static UserOutPut toOutput(User user) {
        return new UserOutPut(
                user.getID(),
                user.getName(),
                user.getEmail(),
                user.getRoles() == null ? EnumSet.noneOf(projeto01_ms.book_user.Application.Entity.ROLE.class) : EnumSet.copyOf(user.getRoles()),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
