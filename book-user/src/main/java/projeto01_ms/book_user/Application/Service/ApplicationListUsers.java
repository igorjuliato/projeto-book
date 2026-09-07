package projeto01_ms.book_user.Application.Service;

import org.springframework.stereotype.Service;
import projeto01_ms.book_user.Application.InBound.ListUsersUseCase;
import projeto01_ms.book_user.Application.OutBound.UserOutPut;
import projeto01_ms.book_user.Application.OutBound.UserRepositoryPort;

import java.util.List;

@Service
public class ApplicationListUsers implements ListUsersUseCase {

    private final UserRepositoryPort userRepository;

    public ApplicationListUsers(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserOutPut> execute() {
        return userRepository.findAll().stream()
                .map(UserOutPutMapper::toOutput)
                .toList();
    }
}
