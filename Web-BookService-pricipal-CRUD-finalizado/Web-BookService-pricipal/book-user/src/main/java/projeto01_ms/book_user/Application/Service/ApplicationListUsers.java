package projeto01_ms.book_user.Application.Service;

import org.springframework.stereotype.Service;
import projeto01_ms.book_user.Adapter.OutBound.UserRepositoryAdapter;
import projeto01_ms.book_user.Application.InBound.ListUsersUseCase;
import projeto01_ms.book_user.Application.OutBound.UserOutPut;

import java.util.List;

@Service
public class ApplicationListUsers implements ListUsersUseCase {

    private final UserRepositoryAdapter userRepository;

    public ApplicationListUsers(UserRepositoryAdapter userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserOutPut> execute() {
        return userRepository.findAll().stream()
                .map(UserOutPutMapper::toOutput)
                .toList();
    }
}
