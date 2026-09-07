package projeto01_ms.book_user.Application.Service;

import org.springframework.stereotype.Service;
import projeto01_ms.book_user.Application.InBound.FindUserUseCase;
import projeto01_ms.book_user.Application.OutBound.UserOutPut;
import projeto01_ms.book_user.Application.OutBound.UserRepositoryPort;
import projeto01_ms.book_user.Domain.UserNotFoundException;

import java.util.UUID;

@Service
public class ApplicationFindUser implements FindUserUseCase {

    private final UserRepositoryPort userRepository;

    public ApplicationFindUser(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserOutPut execute(UUID id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return UserOutPutMapper.toOutput(user);
    }
}
