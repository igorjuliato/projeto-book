package projeto01_ms.book_user.Application.Service;

import org.springframework.stereotype.Service;
import projeto01_ms.book_user.Application.InBound.DeleteUserUseCase;
import projeto01_ms.book_user.Application.OutBound.UserRepositoryPort;
import projeto01_ms.book_user.Domain.UserNotFoundException;

import java.util.UUID;

@Service
public class ApplicationDeleteUser implements DeleteUserUseCase {

    private final UserRepositoryPort userRepository;

    public ApplicationDeleteUser(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }

        userRepository.deleteById(id);
    }
}
